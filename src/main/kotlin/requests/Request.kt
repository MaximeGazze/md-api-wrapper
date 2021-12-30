package requests

import MangaResponse
import com.beust.klaxon.JsonObject
import io.ktor.client.call.receive
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import requests.RequestClient.Companion.client

open class Request(
    val url: String,
    val httpMethod: HttpMethod,
    val reqQuery: Map<String, Any?>? = null,
    val reqHeaders: Map<String, String>? = null,
    val reqBody: String? = null,
    val onSuccess: ((res: HttpResponse, data: Any?) -> Unit)? = null,
    val onError: ((res: HttpResponse, data: Any?) -> Unit)? = null,
) {
    fun queryParamsToString(): String = reqQuery?.map { "${it.key}=${it.value}" }?.joinToString("&", "?") ?: ""

    suspend inline fun <reified T> call(): T {
        val res: HttpResponse = client.request("$url${queryParamsToString()}") {
            method = httpMethod
            reqHeaders?.forEach { headers.append(it.key, it.value) }
            if (reqBody != null) body = reqBody
        }
        val data: T = res.receive()
        if (res.status.isSuccess()) {
            onSuccess?.let { it(res, data) }
        } else {
            onError?.let { it(res, data) }
        }
        return data
    }
}

class MangaSearchOptionBuilder {
    var title: String? = null
    var limit: Int? = null
    var offset: Int? = null
    var authors: List<String>? = null
    var artists: List<String>? = null
    var year: Int? = null
    // val includedTags: List<Tag>? = null,
    var includedTagsMode: String? = null // enum: "AND" "OR"
    // val excludedTags: List<Tag>? = null,
    var excludedTagsMode: String? = null // enum: "AND" "OR"
    var status: List<String>? = null // enum: "ongoing" "completed" "hiatus" "cancelled"
    var originalLanguage: List<String>? = null
    var excludedoriginalLanguage: List<String>? = null
    var availableTranslatedLanguage: List<String>? = null
    var publicationDemographic: List<String>? = null // enum: "shounen" "shoujo" "josei" "seinen" "none"
    var ids: List<String>? = null
    var contentRating: List<String>? = null // enum: "safe" "suggestive" "erotica" "pornographic"
    var createdAtSince: String? = null
    var updatedAtSince: String? = null
    var order: Map<String, String>? = null
    var includes: List<String>? = null
    var hasAvailableChapters: Boolean? = null // needs conversion to String
    var group: String? = null
}

class MangaSearchRequest(options: MangaSearchOptionBuilder.() -> Unit = {}) : Request("https://api.mangadex.org/manga", HttpMethod.Get)

suspend fun main(args: Array<String>) {
    val lol: MangaResponse = Request(
        "https://api.mangadex.org/manga",
        HttpMethod.Get,
        mapOf("limit" to 1),
        mapOf("contentType" to "application/json"),
        JsonObject(mapOf()).toString(),
        { res, data ->
            println("ok: $data")
        },
        { res, data ->
            println("err")
        }
    ).call()
    println("lol $lol")

    val manga: MangaResponse = MangaSearchRequest {
        title = "lol"
    }.call()
}

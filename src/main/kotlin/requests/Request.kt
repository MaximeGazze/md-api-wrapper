package requests

import builders.MangaSearchOptions
import io.ktor.client.request.request
import models.MangaListResponse
import models.MangaResponse
import requests.RequestClient.Companion.baseUrl
import requests.RequestClient.Companion.client


// StatusCodes: 200, 400
suspend fun mangaSearch(options: MangaSearchOptions.() -> Unit = {}): MangaListResponse {
    val mangaOptions = MangaSearchOptions().apply(options)
    val query = mangaOptions.getQuery()
    return client.request("$baseUrl/manga${query?.map { "${it.key}=${it.value}" }?.joinToString("&", "?") ?: ""}")
}

// StatusCodes: 200, 403, 404
suspend fun mangaSearchById(id: String): MangaResponse = client.request("$baseUrl/manga/$id")





/*
open class Request(
    val url: String,
    val httpMethod: HttpMethod,
    val reqQuery: Map<String, Any?>? = null,
    val reqHeaders: Map<String, String>? = null,
    val reqBody: String? = null,
    val onSuccess: ((res: HttpResponse, data: Any?) -> Unit)? = null,
    val onError: ((res: HttpResponse, data: Any?) -> Unit)? = null,
) {
    suspend inline fun <reified T> call(): T {
        val res: HttpResponse = client.request(
            "$url${reqQuery?.map { "${it.key}=${it.value}" }?.joinToString("&", "?") ?: ""}",
        ) {
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

/*
For the tags I want to make an enum class with all tags corresponding to their uuid string value ex:
enum class Tags {
    Adventure("uuidString")
}
or whatever...
 */

// typealias searchOptionBuilder = MangaSearchOptionBuilder.() -> Unit

class MangaSearchRequest(
    // val options: MangaSearchOption.() -> MangaSearchOption.build(this)
    val options: MangaSearchOptions.() -> Unit
    // val options: build(block: MangaSearchOption.Builder.() -> Unit) = MangaSearchOption.Builder().apply(block).build()
) : Request(
    "https://api.mangadex.org/manga",
    HttpMethod.Get,
) {
    val lol = MangaSearchOptions().apply {
        options
    }

    override fun toString(): String {
        return lol.toString()
    }
}

suspend fun main(args: Array<String>) {
//    val lol: MangaResponse = Request(
//        "https://api.mangadex.org/manga",
//        HttpMethod.Get,
//        mapOf("limit" to 1),
//        mapOf("contentType" to "application/json"),
//        JsonObject(mapOf()).toString(),
//        { res, data ->
//            println("ok: $data")
//        },
//        { res, data ->
//            println("err")
//        }
//    ).call()
//    println("lol $lol")

    val manga: MangaResponse = MangaSearchRequest() {
        title = "lmao"
    }.call()
    val manga2 = MangaSearchRequest() {
        title = "lmao"
    }
    println(manga2)
}
*/

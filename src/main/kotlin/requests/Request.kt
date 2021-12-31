package requests

import builders.MangaSearchOptionBuilder
import io.ktor.client.call.receive
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import models.MangaResponse
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

class MangaSearchRequest(
    options: MangaSearchOptionBuilder.() -> Unit = {}
) : Request(
    "https://api.mangadex.org/manga",
    HttpMethod.Get,
) // Implement some way of building the query params from the options builder

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

    val manga: MangaResponse = MangaSearchRequest {
        title = "classroom"
    }.call()
    println(manga)
}

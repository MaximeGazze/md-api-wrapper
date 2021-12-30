package requests

import MangaResponse
import io.ktor.client.call.receive
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import requests.RequestClient.Companion.client

open class Request(
    val url: String,
    val httpMethod: HttpMethod,
    val reqQuery: Map<String, String>? = null,
    val reqHeaders: Map<String, String>? = null,
    val reqBody: Any? = null,
    val onSuccess: (it: Any?) -> Unit,
    val onError: (it: Any?) -> Unit,
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
            onSuccess(data)
        } else {
            onError(data)
        }
        return data
    }
}

suspend fun main(args: Array<String>) {
    val lol = Request(
        "https://api.mangadex.org/manga",
        HttpMethod.Get,
        onSuccess = { res ->
            println("ok: $res")
        },
        onError = {
            println("err")
        },
    ).call<MangaResponse>()
    println("lol $lol")
}

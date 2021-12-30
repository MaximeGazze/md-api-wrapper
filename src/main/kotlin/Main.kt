import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.lang.reflect.Method
import java.net.http.HttpResponse

//class Main {
//
//
//    fun main(args: Array<String>) {
//        suspend fun mangaSearch(
//
//        ) {
//            val response: MangaResponse = client.request("https://api.mangadex.org/manga") {
//                method = HttpMethod.Get
//                parameter("limit", limit)
//                parameter("offset", 0)
//                parameter("title", "Reincarnated")
//                parameter("authors")
//                parameter()
//            }
//        }
//
//        response.data.forEach {
//            println(it)
//        }
//
//        fun <T> requestCall(
//            url: String,
//            query: Map<String, String>,
//            body: Map<String, String>,
//            method: HttpMethod,
//        ) {
//            val response: T = client.request("$url${query.map { "?${it.key}=${it.value}" }}") {
//                method = method
//            }
//        }
//    }
//}

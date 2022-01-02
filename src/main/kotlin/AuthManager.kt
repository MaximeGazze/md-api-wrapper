import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import models.auth.CheckResponse
import models.auth.LoginResponse
import models.auth.LogoutResponse
import models.auth.RefreshResponse
import requests.RequestClient

class AuthManager {
    companion object {
        private var session: String? = null
        private var refresh: String? = null
        private var authenticated: Boolean = false

        // StatusCodes: 200, 400
        suspend fun login(username: String, password: String): LoginResponse {
            val route = "/auth/login"
            val res: HttpResponse = RequestClient.client.request("${RequestClient.baseUrl}$route") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = mapOf("username" to username, "email" to username, "password" to password)
            }
            val data: LoginResponse = res.receive()
            if (res.status.isSuccess()) {
                session = data.token.session
                refresh = data.token.refresh
                authenticated = true
            } else {
                throw ApiException(res.status.value, route, "Failed to login")
            }
            return data
        }

        // StatusCodes: 200
        suspend fun check(): CheckResponse {
            val route = "/auth/check"
            val res: HttpResponse = RequestClient.client.request("${RequestClient.baseUrl}$route") {
                headers.append("Authorization", "Bearer $session")
            }
            val data: CheckResponse = res.receive()
            if (!res.status.isSuccess()) {
                throw ApiException(res.status.value, route, "Failed to check authentication")
            }
            return data
        }

        // StatusCodes: 200, 503
        suspend fun logout(): LogoutResponse {
            val route = "/auth/logout"
            val res: HttpResponse = RequestClient.client.request("${RequestClient.baseUrl}$route") {
                method = HttpMethod.Post
                headers.append("Authorization", "Bearer $session")
            }
            val data: LogoutResponse = res.receive()
            if (res.status.value == 503 && authenticated) {
                refresh()
                return logout()
            } else {
                session = null
                refresh = null
                authenticated = false
            }
            return data
        }

        // StatusCodes: 200, 400, 401, 403
        suspend fun refresh(): RefreshResponse {
            val route = "/auth/refresh"
            val res: HttpResponse = RequestClient.client.request("${RequestClient.baseUrl}$route") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = mapOf("token" to refresh)
            }
            val data: RefreshResponse = res.receive()
            if (res.status.isSuccess()) {
                session = data.token.session
                refresh = data.token.refresh
                authenticated = true
            } else {
                authenticated = false
                throw ApiException(res.status.value, route, "Failed to refresh")
            }
            return data
        }
    }
}

suspend fun main() {
//    val manga = mangaSearch {
//        title = ""
//        limit = 1
//        offset = 1
//    }
//    println(manga.data[0].id)
//
//    val manga2 = mangaSearchById("333f4d22-7753-4e3b-b0da-0a69b2cdce4f")
//    println(manga2.data.attributes.altTitles[0]["en"])

    try {
        val token = AuthManager.login("usernameOrEmail", "password")
        println(token)
    } catch (err: ApiException) {
        println(err.statusCode)
    }

    val refresh = AuthManager.refresh()
    println(refresh)

    val check = AuthManager.check()
    println(check)

    val logout = AuthManager.logout()
    println(logout)
}

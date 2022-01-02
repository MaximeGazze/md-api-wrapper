package requests

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature

class RequestClient {
    companion object {
        val baseUrl = "https://api.mangadex.org"

        val client = HttpClient(CIO) {
            expectSuccess = false
            install(JsonFeature) {
                serializer = GsonSerializer() {
                    setPrettyPrinting()
                    disableHtmlEscaping()
                }
            }
//            install(Auth) {
//                bearer {
//                    loadTokens {
//                        BearerTokens(session, refresh)
//                    }
//                }
//            }
        }
    }
}

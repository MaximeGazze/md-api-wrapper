package requests

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.statement.*

class RequestClient {
    companion object {
        val client = HttpClient(CIO) {
            expectSuccess = false
            install(JsonFeature) {
                serializer = GsonSerializer() {
                    setPrettyPrinting()
                    disableHtmlEscaping()
                }
            }
//            HttpResponseValidator {
//                validateResponse { response: HttpResponse ->
//                    when (response.status.value) {
//                        in 300..399 -> throw RedirectResponseException(response, "")
//                        in 400..499 -> throw ClientRequestException(response, "")
//                        in 500..599 -> throw ServerResponseException(response, "")
//                    }
//                }
//            }
        }
    }
}

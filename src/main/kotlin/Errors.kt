class ApiException(val statusCode: Int, route: String, message: String, cause: Throwable? = null) : Exception("ERROR $statusCode on $route: $message", cause)

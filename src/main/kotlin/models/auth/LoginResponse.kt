package models.auth

import models.common.ApiError

data class LoginResponse(
    val result: String,
    val errors: List<ApiError>,
    val token: Token,
)

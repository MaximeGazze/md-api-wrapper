package models.auth

import models.common.ApiError

data class LogoutResponse(
    val result: String,
    val errors: List<ApiError>
)

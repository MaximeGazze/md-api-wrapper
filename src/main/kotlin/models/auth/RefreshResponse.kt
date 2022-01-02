package models.auth

import models.common.ApiError

data class RefreshResponse(
    val result: String,
    val errors: List<ApiError>,
    val token: Token,
    val message: String,
)

package models

data class AuthResponse(
    val result: String,
    val token: Token,
)

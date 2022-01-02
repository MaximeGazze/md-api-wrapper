package models.auth

data class Token(
    val session: String,
    val refresh: String,
)

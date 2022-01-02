package models.common

data class ApiError(
    val id: String,
    val status: Int,
    val title: String,
    val details: String,
)

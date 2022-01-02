package models.auth

data class CheckResponse(
    val result: String,
    val isAuthenticated: Boolean,
    val roles: List<String>,
    val permissions: List<String>,
)

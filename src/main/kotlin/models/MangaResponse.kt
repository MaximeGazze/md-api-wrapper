package models

data class MangaResponse(
    val result: String,
    val response: String,
    val data: List<Manga>,
)

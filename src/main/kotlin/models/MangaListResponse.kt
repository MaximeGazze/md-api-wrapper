package models

data class MangaListResponse(
    val result: String,
    val response: String,
    val data: List<Manga>,
)

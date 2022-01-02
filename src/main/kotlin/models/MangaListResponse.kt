package models

import models.common.ApiError

data class MangaListResponse(
    val result: String,
    val response: String,
    val errors: List<ApiError>,
    val data: List<Manga>,
)

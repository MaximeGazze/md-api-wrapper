package models

import models.common.ApiError

data class MangaResponse(
    val result: String,
    val response: String,
    val errors: List<ApiError>,
    val data: Manga,
)

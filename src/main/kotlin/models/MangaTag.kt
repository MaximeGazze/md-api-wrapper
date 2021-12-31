package models

data class MangaTag(
    val id: String,
    val type: String,
    val attributes: MangaTagAttributes,
    val relationships: List<Any>,
)

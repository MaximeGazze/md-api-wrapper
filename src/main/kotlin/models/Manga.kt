package models

data class Manga(
    val id: String,
    val type: String,
    val attributes: MangaAttributes,
    val relationships: List<MangaRelationship>,
)

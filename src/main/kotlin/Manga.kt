data class MangaResponse(
    val result: String,
    val response: String,
    val data: List<Manga>,
)

data class Manga(
    val id: String,
    val type: String,
    val attributes: Attributes,
    val relationships: List<Relationship>,
)

data class Attributes(
    val title: Map<String, String>,
    val altTitles: List<Map<String, String>>,
    val description: Map<String, String>,
    val isLocked: Boolean,
    val links: Map<String, String>,
    val originalLanguage: String,
    val lastVolume: String?,
    val lastChapter: String?,
    val publicationDemographic: String?,
    val status: String,
    val year: Int?,
    val contentRating: String,
    val tags: List<Tag>,
    val state: String,
    val createdAt: String?,
    val updatedAt: String?,
    val version: Int,
)

data class Relationship(
    val id: String,
    val type: String,
)

data class Tag(
    val id: String,
    val type: String,
    val attributes: TagAttributes,
    val relationships: List<Any>,
)

data class TagAttributes(
    val name: Map<String, String>,
    val description: List<Any>,
    val group: String,
    val version: Int,
)

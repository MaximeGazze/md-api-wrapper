import models.MangaTag

class SearchMangaOptions(
    title: String? = null,
    limit: Int? = null,
    offset: Int? = null,
    authors: List<String>? = null,
    artists: List<String>? = null,
    year: Int? = null,
    includedTags: List<MangaTag>? = null,
    includedTagsMode: String? = null, // enum: "AND" "OR"
    excludedTags: List<MangaTag>? = null,
    excludedTagsMode: String? = null, // enum: "AND" "OR"
    status: List<String>? = null, // enum: "ongoing" "completed" "hiatus" "cancelled"
    originalLanguage: List<String>? = null,
    excludedoriginalLanguage: List<String>? = null,
    availableTranslatedLanguage: List<String>? = null,
    publicationDemographic: List<String>? = null, // enum: "shounen" "shoujo" "josei" "seinen" "none"
    ids: List<String>? = null,
    contentRating: List<String>? = null, // enum: "safe" "suggestive" "erotica" "pornographic"
    createdAtSince: String? = null,
    updatedAtSince: String? = null,
    order: Map<String, String>? = null,
    includes: List<String>? = null,
    hasAvailableChapters: Boolean? = null, // needs conversion to String
    group: String? = null,
)

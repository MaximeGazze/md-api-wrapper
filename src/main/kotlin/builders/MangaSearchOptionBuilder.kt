package builders

class MangaSearchOptionBuilder {
    var title: String? = null
    var limit: Int? = null
    var offset: Int? = null
    var authors: List<String>? = null
    var artists: List<String>? = null
    var year: Int? = null
    // val includedTags: List<Tag>? = null,
    var includedTagsMode: String? = null // enum: "AND" "OR"
    // val excludedTags: List<Tag>? = null,
    var excludedTagsMode: String? = null // enum: "AND" "OR"
    var status: List<String>? = null // enum: "ongoing" "completed" "hiatus" "cancelled"
    var originalLanguage: List<String>? = null
    var excludedoriginalLanguage: List<String>? = null
    var availableTranslatedLanguage: List<String>? = null
    var publicationDemographic: List<String>? = null // enum: "shounen" "shoujo" "josei" "seinen" "none"
    var ids: List<String>? = null
    var contentRating: List<String>? = null // enum: "safe" "suggestive" "erotica" "pornographic"
    var createdAtSince: String? = null
    var updatedAtSince: String? = null
    var order: Map<String, String>? = null
    var includes: List<String>? = null
    var hasAvailableChapters: Boolean? = null // needs conversion to String
    var group: String? = null
}

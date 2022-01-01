package builders

import models.MangaTag
import kotlin.reflect.full.memberProperties

class MangaSearchOptions {
    var title: String? = null
    var limit: Int? = null
    var offset: Int? = null
    var authors: List<String>? = null
    var artists: List<String>? = null
    var year: Int? = null
    val includedTags: List<MangaTag>? = null
    var includedTagsMode: String? = null // enum: "AND" "OR"
    val excludedTags: List<MangaTag>? = null
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

    fun getQuery(): (Map<String, Any>)? {
        val map = mutableMapOf<String, Any>()
        MangaSearchOptions::class.memberProperties.forEach {
            if (it.get(this) != null) {
                map[it.name] = it.get(this)!!
            }
        }
        return map.ifEmpty { null }
    }

    override fun toString(): String = title ?: "null"
}

/*
class MangaSearchOptions(
    var title: String?,
    var limit: Int?,
    var offset: Int?,
    var authors: List<String>?,
    var artists: List<String>?,
    var year: Int?,
    var includedTags: List<MangaTag>?,
    var includedTagsMode: String?, // enum: "AND" "OR"
    var excludedTags: List<MangaTag>?,
    var excludedTagsMode: String?, // enum: "AND" "OR"
    var status: List<String>?, // enum: "ongoing" "completed" "hiatus" "cancelled"
    var originalLanguage: List<String>?,
    var excludedoriginalLanguage: List<String>?,
    var availableTranslatedLanguage: List<String>?,
    var publicationDemographic: List<String>?, // enum: "shounen" "shoujo" "josei" "seinen" "none"
    var ids: List<String>?,
    var contentRating: List<String>?, // enum: "safe" "suggestive" "erotica" "pornographic"
    var createdAtSince: String?,
    var updatedAtSince: String?,
    var order: Map<String, String>?,
    var includes: List<String>?,
    var hasAvailableChapters: Boolean?, // needs conversion to String
    var group: String?,
) {
    private constructor(builder: Builder) : this(
        builder.title,
        builder.limit,
        builder.offset,
        builder.authors,
        builder.artists,
        builder.year,
        builder.includedTags,
        builder.includedTagsMode,
        builder.excludedTags,
        builder.excludedTagsMode,
        builder.status,
        builder.originalLanguage,
        builder.excludedoriginalLanguage,
        builder.availableTranslatedLanguage,
        builder.publicationDemographic,
        builder.ids,
        builder.contentRating,
        builder.createdAtSince,
        builder.updatedAtSince,
        builder.order,
        builder.includes,
        builder.hasAvailableChapters,
        builder.group
    )

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    override fun toString(): String {
        return "$title $limit"
    }

    class Builder {
        var title: String? = null
        var limit: Int? = null
        var offset: Int? = null
        var authors: List<String>? = null
        var artists: List<String>? = null
        var year: Int? = null
        val includedTags: List<MangaTag>? = null
        var includedTagsMode: String? = null // enum: "AND" "OR"
        val excludedTags: List<MangaTag>? = null
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

        fun build() = MangaSearchOption(this)
    }
}
*/




//
//fun mangaSearchOptionBuilder(init: MangaSearchOption.() -> Unit): MangaSearchOption = MangaSearchOption().init()
//
////        var title: String? = null,
////        var limit: Int? = null,
////        var offset: Int? = null,
////        var authors: List<String>? = null,
////        var artists: List<String>? = null,
////        var year: Int? = null,
////        var includedTags: List<MangaTag>? = null,
////        var includedTagsMode: String? = null, // enum: "AND" "OR"
////        var excludedTags: List<MangaTag>? = null,
////        var excludedTagsMode: String? = null, // enum: "AND" "OR"
////        var status: List<String>? = null, // enum: "ongoing" "completed" "hiatus" "cancelled"
////        var originalLanguage: List<String>? = null,
////        var excludedoriginalLanguage: List<String>? = null,
////        var availableTranslatedLanguage: List<String>? = null,
////        var publicationDemographic: List<String>? = null, // enum: "shounen" "shoujo" "josei" "seinen" "none"
////        var ids: List<String>? = null,
////        var contentRating: List<String>? = null, // enum: "safe" "suggestive" "erotica" "pornographic"
////        var createdAtSince: String? = null,
////        var updatedAtSince: String? = null,
////        var order: Map<String, String>? = null,
////        var includes: List<String>? = null,
////        var hasAvailableChapters: Boolean? = null, // needs conversion to String
////        var group: String? = null,
//
////        fun title(title: String?) = apply { this.title = title }
////        fun limit(limit: Int?) = apply { this.limit = limit }
////        fun offset(offset: Int?) = apply { this.offset = offset }
////        fun authors(authors: List<String>?) = apply { this.authors = authors }
////        fun artists(artists: List<String>?) = apply { this.artists = artists }
////        fun year(year: Int?) = apply { this.year = year }
////        fun includedTags(includedTags: List<MangaTag>?) = apply { this.includedTags = includedTags }
////        fun includedTagsMode(includedTagsMode: String?) = apply { this.includedTagsMode = includedTagsMode } // enum: "AND" "OR"
////        fun excludedTags(excludedTags: List<MangaTag>?) = apply { this.excludedTags = excludedTags }
////        fun excludedTagsMode(excludedTagsMode: String?) = apply { this.excludedTagsMode = excludedTagsMode } // enum: "AND" "OR"
////        fun status(status: List<String>?) = apply { this.status = status } // enum: "ongoing" "completed" "hiatus" "cancelled"
////        fun originalLanguage(originalLanguage: List<String>?) = apply { this.originalLanguage = originalLanguage }
////        fun excludedoriginalLanguage(excludedoriginalLanguage: List<String>?) = apply { this.excludedoriginalLanguage = excludedoriginalLanguage }
////        fun availableTranslatedLanguage(availableTranslatedLanguage: List<String>?) = apply { this.availableTranslatedLanguage = availableTranslatedLanguage }
////        fun publicationDemographic(publicationDemographic: List<String>?) = apply { this.publicationDemographic = publicationDemographic } // enum: "shounen" "shoujo" "josei" "seinen" "none"
////        fun ids(ids: List<String>?) = apply { this.ids = ids }
////        fun contentRating(contentRating: List<String>?) = apply { this.contentRating = contentRating } // enum: "safe" "suggestive" "erotica" "pornographic"
////        fun createdAtSince(createdAtSince: String?) = apply { this.createdAtSince = createdAtSince }
////        fun updatedAtSince(updatedAtSince: String?) = apply { this.updatedAtSince = updatedAtSince }
////        fun order(order: Map<String, String>?) = apply { this.order = order }
////        fun includes(includes: List<String>?) = apply { this.includes = includes }
////        fun hasAvailableChapters(hasAvailableChapters: Boolean?) = apply { this.hasAvailableChapters = hasAvailableChapters } // needs conversion to String
////        fun group(group: String?) = apply { this.group = group }
//

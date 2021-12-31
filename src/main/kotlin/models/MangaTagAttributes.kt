package models

data class MangaTagAttributes(
    val name: Map<String, String>,
    val description: List<Any>,
    val group: String,
    val version: Int,
)

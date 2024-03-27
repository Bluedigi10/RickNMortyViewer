package com.bluedigi.ricknmortyviewer.model

data class Character (
    val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String,
    val origin: Origin,
    val location: Location
) {
    data class Origin(
        val name: String,
        val url: String
    )

    data class Location(
        val name: String,
        val url: String
    )
}
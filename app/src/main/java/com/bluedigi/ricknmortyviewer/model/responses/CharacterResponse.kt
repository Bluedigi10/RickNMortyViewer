package com.bluedigi.ricknmortyviewer.model.responses

data class CharacterResponse<T>(
    val info: Info,
    val results: List<T>
)
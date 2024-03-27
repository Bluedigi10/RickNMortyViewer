package com.bluedigi.ricknmortyviewer.model.responses

import com.bluedigi.ricknmortyviewer.model.Character

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)
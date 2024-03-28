package com.bluedigi.ricknmortyviewer.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bluedigi.ricknmortyviewer.model.CharacterDetail

@Composable
fun CharacterDetail(characterDetail: CharacterDetail) {
    Column {
        Text(text = "Status: ${characterDetail.status}")
        Text(text = "Species: ${characterDetail.species}")
        Text(text = "Type: ${characterDetail.type}")
        Text(text = "Gender: ${characterDetail.gender}")
        Text(text = "Origin: ${characterDetail.origin.name}")
        Text(text = "Location: ${characterDetail.location.name}")
    }
}

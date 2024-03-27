package com.bluedigi.ricknmortyviewer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bluedigi.ricknmortyviewer.configs.ApiService
import com.bluedigi.ricknmortyviewer.interfaces.RickAndMortyApiService
import com.bluedigi.ricknmortyviewer.ui.theme.CharacterViewModel

@Composable
fun CharacterListView(apiService: RickAndMortyApiService = ApiService.create()) {
    val characterViewModel: CharacterViewModel = viewModel()

    LaunchedEffect(true) {
        characterViewModel.loadCharacters(apiService)
    }

    val characters = remember(characterViewModel.characters.value) {
        characterViewModel.characters.value
    }

    LazyColumn {
        items(characters.size) { index ->
            Text(text = characters[index].name)
        }
    }

}
package com.bluedigi.ricknmortyviewer.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluedigi.ricknmortyviewer.model.Character
import com.bluedigi.ricknmortyviewer.interfaces.RickAndMortyApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    fun loadCharacters(apiService: RickAndMortyApiService) {
        viewModelScope.launch {
            try {
                val response = apiService.getCharacters()
                _characters.value = response.results
            } catch (e: Exception) {
                // Manejar errores
                e.printStackTrace()
            }
        }
    }
}
package com.bluedigi.ricknmortyviewer.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluedigi.ricknmortyviewer.model.Character
import com.bluedigi.ricknmortyviewer.interfaces.RickAndMortyApiService
import com.bluedigi.ricknmortyviewer.model.CharacterDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RickAndMortyApiService::class.java)

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _characterDetail = MutableStateFlow<CharacterDetail?>(null)
    val characterDetail: StateFlow<CharacterDetail?> = _characterDetail

    fun loadCharacters(page: Int = 1) {
        viewModelScope.launch {
            val response = apiService.getCharacters(page)
            _characters.value = response.results
        }
    }

    fun loadCharacterDetail(characterId: Int) {
        viewModelScope.launch {
            _characterDetail.value = apiService.getCharacterDetail(characterId)
        }
    }
}

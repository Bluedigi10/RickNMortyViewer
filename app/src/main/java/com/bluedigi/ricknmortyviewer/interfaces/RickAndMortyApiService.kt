package com.bluedigi.ricknmortyviewer.interfaces

import com.bluedigi.ricknmortyviewer.model.responses.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}
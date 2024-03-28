package com.bluedigi.ricknmortyviewer.interfaces

import com.bluedigi.ricknmortyviewer.model.Character
import com.bluedigi.ricknmortyviewer.model.CharacterDetail
import com.bluedigi.ricknmortyviewer.model.responses.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse<Character>

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") characterId: Int): CharacterDetail
}

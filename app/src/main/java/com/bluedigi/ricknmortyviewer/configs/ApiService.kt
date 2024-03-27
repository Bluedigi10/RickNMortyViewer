package com.bluedigi.ricknmortyviewer.configs

import com.bluedigi.ricknmortyviewer.interfaces.RickAndMortyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private const val BASE_URL = "https://rickandmortyapi.com/api/character/?page=1"

    fun create(): RickAndMortyApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RickAndMortyApiService::class.java)
    }
}
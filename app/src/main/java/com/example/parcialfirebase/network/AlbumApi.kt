package com.example.parcialfirebase.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Album(val id: Int, val userId: Int, val title: String)

interface AlbumApiService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>
}

object RetrofitInstance {
    val api: AlbumApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumApiService::class.java)
    }
}
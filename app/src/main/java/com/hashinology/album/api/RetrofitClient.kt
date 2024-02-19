package com.hashinology.album.api

import com.hashinology.album.models.AlbumModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitClient {
    @GET("movielist.json")
    suspend fun getAlbumFromApi(): Response<AlbumModel>

    companion object{
        var instance: RetrofitClient? = null
        fun getInstance(): RetrofitClient{
            if (instance == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit.create(RetrofitClient::class.java)
            }
            return instance!!
        }
    }
}
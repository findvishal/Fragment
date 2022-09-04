package com.example.recylerviewyt.retrofit


import retrofit2.http.GET
import retrofit2.http.Query
import com.example.recylerviewyt.model.News
import retrofit2.Call


const val baseUrl= "https://newsapi.org/"
const val apiKey="c998a444e9e24311ace1a6475070c838"
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$apiKey")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>
}
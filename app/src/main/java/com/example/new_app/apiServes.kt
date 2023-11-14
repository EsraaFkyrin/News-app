package com.example.new_app

import com.example.new_app.api.model.newsResponse.NewsResponse
import com.example.new_app.api.model.sourcesResponse.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

 interface apiServes {
    @GET("v2/top-headlines/sources")
    //bass the apiKey in parmater func
    suspend fun getSources(
        @Query("apiKey") apiKy: String,
        @Query("category") category: String
    ): SourcesResponse

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apiKy: String,
        @Query("sources") sources: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NewsResponse
}
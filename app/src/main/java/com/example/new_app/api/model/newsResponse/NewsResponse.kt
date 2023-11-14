package com.example.new_app.api.model.newsResponse

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @field:SerializedName("totalResults")
    val totalResults: Int? = null,
    @field:SerializedName("articles")
    val articles: List<News?>? = null,
    @field:SerializedName("status")
    val status: String? = null,
    @field:SerializedName("message")
    val message: String? = null,
    @field:SerializedName("code")
    val code: String? = null
)

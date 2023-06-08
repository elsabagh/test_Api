package com.example.test_api.api

import com.example.test_api.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")   //end point api
    suspend fun getPost(): Response<Post>
}
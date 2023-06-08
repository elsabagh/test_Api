package com.example.test_api.api

import com.example.test_api.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SimpleApi {

    @GET("posts/1")   //end point api
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number:Int
    ): Response<Post>

}
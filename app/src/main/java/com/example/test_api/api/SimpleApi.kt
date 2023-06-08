package com.example.test_api.api

import com.example.test_api.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts/1")   //end point api
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}") //return content you define by id
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")  // return content you define by userid
    suspend fun getCustomPost(
        @Query("userId") userId: Int
    ): Response<List<Post>>
}
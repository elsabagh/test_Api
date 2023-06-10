package com.example.test_api.api

import com.example.test_api.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

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

    @GET("posts")  // return content you define by many Query
    suspend fun getCustomPostQ(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")  // return content you define by Query map
    suspend fun getCustomPostQ2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String,String>
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post : Post
    ) : Response<Post>
}
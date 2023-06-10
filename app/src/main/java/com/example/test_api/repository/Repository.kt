package com.example.test_api.repository

import com.example.test_api.api.RetrofitInstance
import com.example.test_api.model.Post
import retrofit2.Response
import retrofit2.http.POST

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId: Int): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId)
    }

    suspend fun getCustomPostQ(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPostQ(userId, sort, order)
    }

    suspend fun getCustomPostQ2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPostQ2(userId, options)
    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }
}
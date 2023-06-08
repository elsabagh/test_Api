package com.example.test_api.repository

import com.example.test_api.api.RetrofitInstance
import com.example.test_api.model.Post
import retrofit2.Response

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
}
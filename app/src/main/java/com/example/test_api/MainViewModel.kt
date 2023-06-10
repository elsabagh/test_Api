package com.example.test_api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_api.model.Post
import com.example.test_api.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.POST

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseCustom: MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse.value = response
        }
    }

    fun getCustomPost(userId: Int) {
        viewModelScope.launch {
            val response = repository.getCustomPost(userId)
            myResponseCustom.value = response
        }
    }

    fun getCustomPostQ(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPostQ(userId, sort, order)
            myResponseCustom.value = response
        }
    }

    fun getCustomPostQ2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            val response = repository.getCustomPostQ2(userId, options)
            myResponseCustom.value = response
        }
    }


}
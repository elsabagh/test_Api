package com.example.test_api.model

import android.icu.text.CaseMap.Title

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body:String
)

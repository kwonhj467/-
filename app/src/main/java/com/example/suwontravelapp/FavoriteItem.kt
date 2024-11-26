package com.example.suwontravelapp

data class FavoriteItem(
    val title: String,
    val description: String,
    val imageResId: Int,
    val mapUrl: String // 지도 URL 추가
)

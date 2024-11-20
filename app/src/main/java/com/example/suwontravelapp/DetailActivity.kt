package com.example.suwontravelapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            binding = ActivityDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val category = intent.getStringExtra("CATEGORY")
            Log.d("DetailActivity", "Received category: $category")
            binding.categoryTitle.text = category ?: "카테고리 없음"

        } catch (e: Exception) {
            Log.e("DetailActivity", "Error in onCreate: ${e.message}")
        }

        // 여기에서 여행지 설명과 지도 연동 기능 추가 예정
    }
}

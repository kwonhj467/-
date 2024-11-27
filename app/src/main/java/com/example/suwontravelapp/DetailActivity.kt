package com.example.suwontravelapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.suwontravelapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            // ViewBinding 초기화
            binding = ActivityDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // 인텐트로 받은 카테고리 이름 설정
            val category = intent.getStringExtra("CATEGORY")
            Log.d("DetailActivity", "Received category: $category")
            binding.categoryTitle.text = category ?: "카테고리 없음"

            // category_border.xml 배경 적용
            val borderDrawable: Drawable? =
                ContextCompat.getDrawable(this, R.drawable.category_border)
            binding.categoryTitle.background = borderDrawable

        } catch (e: Exception) {
            Log.e("DetailActivity", "Error in onCreate: ${e.message}")
        }
    }
}

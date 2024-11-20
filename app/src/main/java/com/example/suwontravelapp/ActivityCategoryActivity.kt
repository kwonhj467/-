package com.example.suwontravelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityActivityCategoryBinding

class ActivityCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryTitle.text = "액티비티"
    }
}
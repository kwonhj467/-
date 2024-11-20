package com.example.suwontravelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityNightViewBinding

class NightViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNightViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNightViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryTitle.text = "야경"
    }
}
package com.example.suwontravelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityDateCourseBinding

class DateCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryTitle.text = "데이트코스"
    }
}

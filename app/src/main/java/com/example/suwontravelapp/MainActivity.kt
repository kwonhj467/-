package com.example.suwontravelapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        // 각 카테고리 버튼 클릭 이벤트
        binding.dateCourseButton.setOnClickListener { openDetailActivity(DateCourseActivity::class.java) }
        binding.nightViewButton.setOnClickListener { openDetailActivity(NightViewActivity::class.java) }
        binding.historicSiteButton.setOnClickListener { openDetailActivity(HistoricSiteActivity::class.java) }
        binding.activityButton.setOnClickListener { openDetailActivity(ActivityCategoryActivity::class.java) }
        binding.favoriteButton.setOnClickListener { openDetailActivity(PopularityActivity::class.java) }
        binding.mapViewButton.setOnClickListener { openDetailActivity(MapViewActivity::class.java) }
    }

    private fun openDetailActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
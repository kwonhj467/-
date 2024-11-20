package com.example.suwontravelapp
//임포트
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityPopularityBinding

class PopularityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPopularityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryTitle.text = "인기순위"
    }
}

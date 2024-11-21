package com.example.suwontravelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityHistoricSiteBinding

class HistoricSiteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoricSiteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricSiteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.historicTitle.text = "유적지"
    }
}

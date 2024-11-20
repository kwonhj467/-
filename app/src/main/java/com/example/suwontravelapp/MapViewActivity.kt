package com.example.suwontravelapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityMapViewBinding

class MapViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 상단 제목 설정
        binding.categoryTitle.text = "지도"

        // WebView 설정
        val webSettings: WebSettings = binding.mapView.settings
        webSettings.javaScriptEnabled = true // JavaScript 활성화
        webSettings.domStorageEnabled = true // DOM Storage 활성화

        // WebViewClient 설정 - WebView에서 페이지가 열리도록 설정
        binding.mapView.webViewClient = WebViewClient()

        // Google Maps URL 로드
        val googleMapsUrl = "https://www.google.com/maps/embed?pb=!1m28!1m12!1m3!1d101219.61518875544!2d126.9894764!3d37.552402000000015!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m13!3e3!4m5!1s0x357c98dcaddfa8ff%3A0x5cba1f83032e6da1!2z7ISc7Jq47Yq567OE7IucIO2ZjeuMgOyeheq1rOyXreyVng!3m2!1d37.5551463!2d126.9215309!4m5!1s0x357ca3a4c23b83eb%3A0xa27a76b786341663!2z7ISc7Jq47Yq567OE7IucIOyEseuPmeq1rCDsmZXsi63rpqzroZwgODMtMjEg65SU666k7KeA7JeE!3m2!1d37.5438189!2d127.0441812!5e0!3m2!1sko!2skr!4v1731928757623!5m2!1sko!2skr"
        binding.mapView.loadUrl(googleMapsUrl)
    }
}

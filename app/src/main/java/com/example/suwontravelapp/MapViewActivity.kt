package com.example.suwontravelapp

import android.os.Bundle
import android.webkit.WebSettings
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

        // 전달받은 URL로 iframe HTML 생성
        val mapUrl = intent.getStringExtra("MAP_URL") ?: ""

        val iframeHtml = """
            <html>
                <body style='margin:0;padding:0;'>
                    <iframe src="$mapUrl" width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </body>
            </html>
        """.trimIndent()

        // WebView에 iframe HTML 로드
        binding.mapView.loadData(iframeHtml, "text/html", "UTF-8")
    }
}

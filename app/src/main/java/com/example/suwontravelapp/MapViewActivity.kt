package com.example.suwontravelapp

import android.os.Bundle
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

        // 전달받은 지도 URL 가져오기
        val mapUrl = intent.getStringExtra("MAP_URL") ?: ""

        // WebView 설정
        binding.mapView.settings.javaScriptEnabled = true
        binding.mapView.settings.domStorageEnabled = true

        // HTML 코드 생성
        val mapHtml = """
            <html>
                <body style="margin:0;padding:0;">
                    <iframe src="$mapUrl" width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </body>
            </html>
        """.trimIndent()

        // WebView에 HTML 로드
        binding.mapView.loadDataWithBaseURL(null, mapHtml, "text/html", "UTF-8", null)
    }
}

package com.example.suwontravelapp

import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityMapViewBinding

class Map : AppCompatActivity() {
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

        // iframe HTML 로드
        val iframeHtml = """
            <html>
                <body style='margin:0;padding:0;'>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101577.71000894615!2d126.92590307564478!3d37.2879416708218!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b430a20764611%3A0xf1373002ee5db4c9!2z6rK96riw64-EIOyImOybkOyLnA!5e0!3m2!1sko!2skr!4v1732703986626!5m2!1sko!2skr"
                    width='100%' height='100%' style='border:0;' allowfullscreen='' loading='lazy' referrerpolicy='no-referrer-when-downgrade'></iframe>
                </body>
            </html>
        """.trimIndent()

        binding.mapView.loadData(iframeHtml, "text/html", "UTF-8")
    }
}
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

        // iframe HTML 로드, 웹 스크래핑
        val iframeHtml = """
            <html>
                <body style='margin:0;padding:0;'>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4489.281960404894!2d127.01289748622193!3d37.28561198213441!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5dfb88ac6ff5%3A0xa70a2f955b7f9974!2z7ZaJ6raB64-ZIOuyve2ZlOuniOydhA!5e0!3m2!1sko!2skr!4v1732170478323!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">, src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101644.22116080999!2d126.95118442314568!3d37.23864527385618!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b4335c2fbe363%3A0x52ac10a4de5dcd4b!2z6rK96riw64-EIOyImOybkOyLnCDtjJTri6zqtawg7ZaJ6raB64-Z!5e0!3m2!1sko!2skr!4v1732093734282!5m2!1sko!2skr" width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                   
                </body>
            </html>
        """.trimIndent()

        binding.mapView.loadData(iframeHtml, "text/html", "UTF-8")
    }
}
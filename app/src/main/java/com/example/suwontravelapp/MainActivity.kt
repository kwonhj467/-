package com.example.suwontravelapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // FirebaseAuth 초기화
        auth = FirebaseAuth.getInstance()

        // Google 로그인 옵션 구성
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // Web 클라이언트 ID
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // 로그아웃 버튼 이벤트 연결
        binding.signInButton.setOnClickListener {
            logout()
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

    private fun logout() {
        // Firebase 로그아웃
        auth.signOut()

        // Google 로그아웃
        googleSignInClient.signOut().addOnCompleteListener(this) {
            // 로그아웃 후 LoginActivity로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // MainActivity 종료
        }
    }
}

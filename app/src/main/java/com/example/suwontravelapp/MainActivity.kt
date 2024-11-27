package com.example.suwontravelapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityMainBinding
import android.util.Log
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 1001 // 로그인 요청 코드

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FirebaseAuth 초기화
        auth = FirebaseAuth.getInstance()

        // Google 로그인 옵션 구성
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // Web 클라이언트 ID
            .requestEmail()
            .build()
        // GoogleSignInClient 초기화
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // 로그인 버튼 이벤트
        val login_Button: Button = findViewById(R.id.login_button)
        login_Button.setOnClickListener {
            signIn()
        }

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
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(Exception::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: Exception) {
                Log.e("MainActivity", "Google sign in failed", e)
            }
        }
    }
    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("MainActivity", "signInWithCredential:success")
                    val user = auth.currentUser
                    Log.d("MainActivity", "User: ${user?.displayName}")
                } else {
                    Log.w("MainActivity", "signInWithCredential:failure", task.exception)
                }
            }
    }

}
package com.example.suwontravelapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 1001 // 로그인 요청 코드

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // FirebaseAuth 초기화
        auth = FirebaseAuth.getInstance()

        // 이미 로그인한 사용자라면 MainActivity로 이동
        if (auth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 로그인 액티비티 종료
            return
        }

        // ViewBinding 초기화
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Google 로그인 옵션 구성
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // Web 클라이언트 ID
            .requestEmail()
            .build()

        // GoogleSignInClient 초기화
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // 로그인 버튼 클릭 이벤트 설정
        binding.signInButton.setOnClickListener {
            signIn()
        }
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
                Log.e("LoginActivity", "Google sign in failed", e)
                Toast.makeText(this, "Google sign in failed: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("LoginActivity", "signInWithCredential:success")
                    val user = auth.currentUser
                    Log.d("LoginActivity", "User: \${user?.displayName}")  // 로그인 성공한 사용자 정보 로그

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.w("LoginActivity", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this, "Authentication failed: \${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}

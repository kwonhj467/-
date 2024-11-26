package com.example.suwontravelapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityPopularBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PopularityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPopularBinding
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences에서 즐겨찾기 항목 가져오기
        val sharedPreferences = getSharedPreferences("favorites", Context.MODE_PRIVATE)
        val favoritesJson = sharedPreferences.getString("favorites_list", "[]")

        val type = object : TypeToken<MutableList<FavoriteItem>>() {}.type
        val favoriteList: MutableList<FavoriteItem> = gson.fromJson(favoritesJson, type)

        // 즐겨찾기 목록을 favoritesListLayout에 동적으로 추가
        favoriteList.forEach { item ->
            val favoriteView = layoutInflater.inflate(R.layout.favorite_item_layout, binding.favoritesListLayout, false)

            val titleTextView = favoriteView.findViewById<TextView>(R.id.favoriteTitle)
            val descriptionTextView = favoriteView.findViewById<TextView>(R.id.favoriteDescription)
            val imageView = favoriteView.findViewById<ImageView>(R.id.favoriteImage)
            val deleteButton = favoriteView.findViewById<Button>(R.id.deleteButton)
            val mapButton = favoriteView.findViewById<Button>(R.id.mapButton)

            titleTextView.text = item.title
            descriptionTextView.text = item.description
            imageView.setImageResource(item.imageResId)

            // 지도 보기 버튼 클릭 이벤트 설정
            mapButton.setOnClickListener {
                showMap(item.mapUrl)
            }

            // 삭제 버튼 클릭 시 동작
            deleteButton.setOnClickListener {
                // 즐겨찾기에서 해당 항목 삭제
                favoriteList.remove(item)
                val updatedFavoritesJson = gson.toJson(favoriteList)
                sharedPreferences.edit().putString("favorites_list", updatedFavoritesJson).apply()

                // 뷰에서 제거
                binding.favoritesListLayout.removeView(favoriteView)
                Toast.makeText(this, "${item.title}이(가) 즐겨찾기에서 삭제되었습니다.", Toast.LENGTH_SHORT).show()
            }

            binding.favoritesListLayout.addView(favoriteView)
        }
    }

    private fun showMap(url: String) {
        val intent = Intent(this, MapViewActivity::class.java)
        intent.putExtra("MAP_URL", url)
        startActivity(intent)
    }
}

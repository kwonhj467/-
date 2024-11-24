package com.example.suwontravelapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityActivityCategoryBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ActivityCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivityCategoryBinding
    private val gson = Gson()
    private val sharedPreferences by lazy {
        getSharedPreferences("favorites", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 이벤트 설정
        binding.favoriteButtonTheFantasyum.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "더 판타지움",
                    "환상적인 체험을 즐길 수 있는 테마파크입니다.",
                    R.drawable.the_fantasyum
                )
            )
        }

        binding.favoriteButtonFlyingSuwon.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "플라잉 수원",
                    "열기구를 타고 수원의 경치를 감상할 수 있는 곳입니다.",
                    R.drawable.flying_suwon
                )
            )
        }

        binding.favoriteButtonKtwizPark.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "수원 KT위즈파크 야구장",
                    "KT 위즈의 홈구장으로, 야구 경기를 즐길 수 있는 곳입니다.",
                    R.drawable.ktwiz_park
                )
            )
        }

        binding.favoriteButtonGravityClimbing.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "그래비티 클라이밍",
                    "다양한 난이도의 클라이밍을 즐길 수 있는 실내 암벽장입니다.",
                    R.drawable.gravity_climbing
                )
            )
        }
    }

    private fun addFavorite(item: FavoriteItem) {
        val favoritesString = sharedPreferences.getString("favorites_list", null)
        val favoritesList: MutableList<FavoriteItem> = if (favoritesString != null) {
            val type = object : TypeToken<MutableList<FavoriteItem>>() {}.type
            gson.fromJson(favoritesString, type)
        } else {
            mutableListOf()
        }

        // 이미 추가된 항목인지 확인
        if (favoritesList.any { it.title == item.title }) {
            Toast.makeText(this, "${item.title} 이미 즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        favoritesList.add(item)
        val updatedFavoritesString = gson.toJson(favoritesList)
        sharedPreferences.edit().putString("favorites_list", updatedFavoritesString).apply()

        Toast.makeText(this, "${item.title} 즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show()
    }
}

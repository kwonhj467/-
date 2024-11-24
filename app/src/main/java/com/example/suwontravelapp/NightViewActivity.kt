package com.example.suwontravelapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityNightViewBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NightViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNightViewBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNightViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("favorites", Context.MODE_PRIVATE)

        binding.favoriteButtonGwanggyoLakePark.setOnClickListener {
            addFavorite(FavoriteItem("광교 호수 공원", "산책과 피크닉을 즐길 수 있는 아름다운 호수 공원입니다.", R.drawable.gwanggyo_lake_park))
        }

        binding.favoriteButtonBanghwasuryujeong.setOnClickListener {
            addFavorite(FavoriteItem("방화수류정", "아름다운 자연 경관과 함께 할 수 있는 고풍스러운 누정입니다.", R.drawable.gwanggyo_lake_park1))
        }

        binding.favoriteButtonSindaeLake.setOnClickListener {
            addFavorite(FavoriteItem("신대호수", "야경이 아름다운 호수로 저녁 산책에 좋습니다.", R.drawable.sindae_lake))
        }

        binding.favoriteButtonJanganmun.setOnClickListener {
            addFavorite(FavoriteItem("장안문", "성곽의 야경과 함께 사진을 찍기 좋은 명소입니다.", R.drawable.jangmoon1))
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

        // 이미 추가된 항목인지 체크
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
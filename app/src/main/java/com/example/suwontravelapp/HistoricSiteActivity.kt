package com.example.suwontravelapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityHistoricSiteBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HistoricSiteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoricSiteBinding
    private val gson = Gson()
    private val sharedPreferences by lazy {
        getSharedPreferences("favorites", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricSiteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 이벤트 설정
        binding.favoriteButtonHwasung.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "수원 화성",
                    "유네스코 세계문화유산으로 지정된 조선시대의 대표적인 성곽입니다.",
                    R.drawable.suwon_hwasung
                )
            )
        }

        binding.favoriteButtonGgHistPark.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "수원 광교 박물관",
                    "수원의 자연과 역사를 동시에 즐길 수 있는 박물관입니다.",
                    R.drawable.gg_hist_museum
                )
            )
        }

        binding.favoriteButtonHwaseongPalace.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "화성행궁",
                    "조선시대 임금이 잠시 머물던 행궁입니다.",
                    R.drawable.hwaseong_palace
                )
            )
        }

        binding.favoriteButtonJanganGate.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "장안문",
                    "수원의 북쪽을 지키는 성문의 하나입니다.",
                    R.drawable.jangan_gate
                )
            )
        }

        binding.favoriteButtonYeonmudae.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "연무대",
                    "조선시대 군사 훈련이 이루어졌던 장소입니다.",
                    R.drawable.yeonmudae
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

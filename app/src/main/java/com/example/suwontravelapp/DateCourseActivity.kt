package com.example.suwontravelapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suwontravelapp.databinding.ActivityDateCourseBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DateCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateCourseBinding
    private val gson = Gson()
    private val sharedPreferences by lazy {
        getSharedPreferences("favorites", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 각 버튼 클릭 이벤트 설정
        binding.favoriteButtonHwasung.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "수원 화성",
                    "유네스코 세계문화유산으로 지정된 조선시대의 대표적인 성곽입니다.",
                    R.drawable.suwon_hwasung
                )
            )
        }

        binding.favoriteButtonJyCoffeeRoastery.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "정지영 커피 로스터리",
                    "아름다운 인테리어와 맛있는 커피가 있는 인기 카페입니다.",
                    R.drawable.jy_coffee_roastery
                )
            )
        }

        binding.favoriteButtonHaenggungMural.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "행궁동 벽화 마을",
                    "다양한 벽화와 예술작품으로 가득한 매력적인 골목길입니다.",
                    R.drawable.haenggung_mural_village
                )
            )
        }

        binding.favoriteButtonHaengnidanGil.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "행리단길",
                    "다양한 맛집과 카페가 있는 인기 있는 거리입니다.",
                    R.drawable.haengnidan_gil
                )
            )
        }

        binding.favoriteButtonHwaseongPalace.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "화성 행궁",
                    "조선 왕조의 중요한 궁궐 중 하나로, 역사적인 가치가 높은 장소입니다.",
                    R.drawable.hwaseong_palace
                )
            )
        }

        binding.favoriteButtonJidongMarket.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "지동 시장",
                    "다양한 먹거리와 즐길거리가 가득한 전통 시장입니다.",
                    R.drawable.jidong_market
                )
            )
        }

        binding.favoriteButtonGwanggyoLakePark.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "광교 호수 공원",
                    "산책과 피크닉을 즐길 수 있는 아름다운 호수 공원입니다.",
                    R.drawable.gwanggyo_lake_park
                )
            )
        }

        binding.favoriteButtonBanghwasuryujeong.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "방화수류정",
                    "아름다운 자연 경관과 함께 할 수 있는 고풍스러운 누정입니다.",
                    R.drawable.banghwasuryujeong
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

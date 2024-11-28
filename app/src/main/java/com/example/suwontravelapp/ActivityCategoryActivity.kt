package com.example.suwontravelapp

import android.content.Context
import android.content.Intent
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

        // 즐겨찾기 버튼 클릭 이벤트 설정
        binding.favoriteButtonTheFantasyum.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "더 판타지움",
                    "환상적인 체험을 즐길 수 있는 테마파크입니다.",
                    R.drawable.the_fantasyum,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5341.598090340044!2d127.05866494875579!3d37.24454639881454!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b44eb51ecd5cd%3A0x623b97d5a8d5d143!2z642U7YyQ7YOA7KeA7JuA!5e0!3m2!1sko!2skr!4v1732606113826!5m2!1sko!2skr"
                )
            )
        }

        binding.favoriteButtonFlyingSuwon.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "플라잉 수원",
                    "열기구를 타고 수원의 경치를 감상할 수 있는 곳입니다.",
                    R.drawable.flying_suwon,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.330615499737!2d127.02315367532643!3d37.28729744009185!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cb11c7e8091%3A0xe57324e46ddb4c0e!2z7ZSM65287J6J7IiY7JuQ!5e0!3m2!1sko!2skr!4v1732611440174!5m2!1sko!2skr"
                )
            )
        }

        binding.favoriteButtonKtwizPark.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "수원 KT위즈파크 야구장",
                    "KT 위즈의 홈구장으로, 야구 경기를 즐길 수 있는 곳입니다.",
                    R.drawable.ktwiz_park,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3173.8048142597077!2d127.00709357532689!3d37.29975953938153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5db07ba6e26f%3A0xf8d00419ae70fbb8!2z7IiY7JuQS1TsnITspojtjIztgaw!5e0!3m2!1sko!2skr!4v1732614534683!5m2!1sko!2skr")

            )
        }

        binding.favoriteButtonGravityClimbing.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "그래비티 클라이밍",
                    "다양한 난이도의 클라이밍을 즐길 수 있는 실내 암벽장입니다.",
                    R.drawable.gravity_climbing,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3175.5576373716335!2d127.04273337532487!3d37.25820174174939!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b457b0ded9783%3A0x5a3fe2d91549c843!2z6re4656Y67mE7Yuw7YG065287J2067CN!5e0!3m2!1sko!2skr!4v1732614621683!5m2!1sko!2skr"
                )
            )
        }
        binding.favoriteButtonAquaPlanet.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "아쿠아플라넷 광교",
                    "다양한 해양생물 관찰과 체험 프로그램을 즐길 수 있는 아쿠아리움입니다.",
                    R.drawable.aquaplanet,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2660.8440230218634!2d127.05586375296294!3d37.28410589863513!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5bc2a0298c79%3A0x3f76abd4177010a0!2z7JWE7L-g7JWE7ZSM652864S3IOq0keq1kA!5e0!3m2!1sko!2skr!4v1732802574458!5m2!1sko!2skr"
                )
            )
        }

        // 지도 보기 버튼 클릭 이벤트 설정
        binding.mapButtonTheFantasyum.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5341.598090340044!2d127.05866494875579!3d37.24454639881454!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b44eb51ecd5cd%3A0x623b97d5a8d5d143!2z642U7YyQ7YOA7KeA7JuA!5e0!3m2!1sko!2skr!4v1732606113826!5m2!1sko!2skr")
        }

        binding.mapButtonFlyingSuwon.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.330615499737!2d127.02315367532643!3d37.28729744009185!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cb11c7e8091%3A0xe57324e46ddb4c0e!2z7ZSM65287J6J7IiY7JuQ!5e0!3m2!1sko!2skr!4v1732611440174!5m2!1sko!2skr")
        }

        binding.mapButtonKtwizPark.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3173.8048142597077!2d127.00709357532689!3d37.29975953938153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5db07ba6e26f%3A0xf8d00419ae70fbb8!2z7IiY7JuQS1TsnITspojtjIztgaw!5e0!3m2!1sko!2skr!4v1732614534683!5m2!1sko!2skr")
        }

        binding.mapButtonGravityClimbing.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3175.5576373716335!2d127.04273337532487!3d37.25820174174939!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b457b0ded9783%3A0x5a3fe2d91549c843!2z6re4656Y67mE7Yuw7YG065287J2067CN!5e0!3m2!1sko!2skr!4v1732614621683!5m2!1sko!2skr")
        }

        binding.mapButtonAquaPlanet.setOnClickListener{
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2660.8440230218634!2d127.05586375296294!3d37.28410589863513!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5bc2a0298c79%3A0x3f76abd4177010a0!2z7JWE7L-g7JWE7ZSM652864S3IOq0keq1kA!5e0!3m2!1sko!2skr!4v1732802574458!5m2!1sko!2skr")
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

    private fun showMap(url: String) {
        val intent = Intent(this, MapViewActivity::class.java)
        intent.putExtra("MAP_URL", url)
        startActivity(intent)
    }
}

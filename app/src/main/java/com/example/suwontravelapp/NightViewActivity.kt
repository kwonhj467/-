package com.example.suwontravelapp

import android.content.Context
import android.content.Intent
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

        // 즐겨찾기 버튼 클릭 이벤트 설정
        binding.favoriteButtonGwanggyoLakePark.setOnClickListener {
            addFavorite(FavoriteItem("광교 호수 공원",
                "산책과 피크닉을 즐길 수 있는 아름다운 호수 공원입니다.", R.drawable.gwanggyo_lake_park,
                "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.507876755629!2d127.06334657532607!3d37.28309534033133!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b3e6f589601%3A0x159dfe5e577faea4!2z6rSR6rWQ7Zi47IiY6rO17JuQ!5e0!3m2!1sko!2skr!4v1732615833257!5m2!1sko!2skr"))
        }

        binding.favoriteButtonBanghwasuryujeong.setOnClickListener {
            addFavorite(FavoriteItem("방화수류정", "아름다운 자연 경관과 함께 할 수 있는 고풍스러운 누정입니다.", R.drawable.gwanggyo_lake_park1,
                "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.320672232538!2d127.01546127532635!3d37.28753314007836!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0c31c281%3A0x3e312d9e7739243e!2z67Cp7ZmU7IiY66WY7KCV!5e0!3m2!1sko!2skr!4v1732615867928!5m2!1sko!2skr"))
        }

        binding.favoriteButtonSindaeLake.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "신대호수", "야경이 아름다운 호수로 저녁 산책에 좋습니다.", R.drawable.sindae_lake,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.3931129984667!2d127.0737978253262!3d37.28581594017626!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b1bc8cddebb%3A0xaa06d78f4e75139b!2z6rSR6rWQ7Zi47IiY6rO17JuQIOyLoOuMgO2YuOyImA!5e0!3m2!1sko!2skr!4v1732615906029!5m2!1sko!2skr"
                )
            )
        }

        binding.favoriteButtonJanganmun.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "장안문", "성곽의 야경과 함께 사진을 찍기 좋은 명소입니다.", R.drawable.jangmoon1,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.2377955207735!2d127.01244532532648!3d37.28949763996645!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5ccbebc74471%3A0x39d42fadbb7c62e3!2z7J6l7JWI66y4!5e0!3m2!1sko!2skr!4v1732616027067!5m2!1sko!2skr"
                )
            )
        }

        // 지도 보기 버튼 클릭 이벤트 설정
        binding.mapButtonGwanggyoLakePark.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.507876755629!2d127.06334657532607!3d37.28309534033133!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b3e6f589601%3A0x159dfe5e577faea4!2z6rSR6rWQ7Zi47IiY6rO17JuQ!5e0!3m2!1sko!2skr!4v1732615833257!5m2!1sko!2skr")
        }

        binding.mapButtonBanghwasuryujeong.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.320672232538!2d127.01546127532635!3d37.28753314007836!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0c31c281%3A0x3e312d9e7739243e!2z67Cp7ZmU7IiY66WY7KCV!5e0!3m2!1sko!2skr!4v1732615867928!5m2!1sko!2skr")
        }

        binding.mapButtonJanganmun.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.2377955207735!2d127.01244532532648!3d37.28949763996645!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5ccbebc74471%3A0x39d42fadbb7c62e3!2z7J6l7JWI66y4!5e0!3m2!1sko!2skr!4v1732616027067!5m2!1sko!2skr")
        }

        binding.mapButtonSindaeLake.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.3931129984667!2d127.0737978253262!3d37.28581594017626!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b1bc8cddebb%3A0xaa06d78f4e75139b!2z6rSR6rWQ7Zi47IiY6rO17JuQIOyLoOuMgO2YuOyImA!5e0!3m2!1sko!2skr!4v1732615906029!5m2!1sko!2skr")
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

    private fun showMap(url: String) {
        val intent = Intent(this, MapViewActivity::class.java)
        intent.putExtra("MAP_URL", url)
        startActivity(intent)
    }
}

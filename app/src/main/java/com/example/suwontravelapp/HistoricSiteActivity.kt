package com.example.suwontravelapp

import android.content.Context
import android.content.Intent
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

        binding.mapButtonHwasung.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d6069.8652831005775!2d127.00887160642674!3d37.28587540793227!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0fa82ebb%3A0x1326e46ba3ed1641!2z7IiY7JuQ7ZmU7ISx!5e0!3m2!1sko!2skr!4v1732524653710!5m2!1sko!2skr")
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

        binding.mapButtonGgHistPark.setOnClickListener {
            // 올바른 수원 광교 박물관의 지도 URL로 수정
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6348.782001067949!2d127.05070061555366!3d37.296013569172396!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5fa2a1d7a78b%3A0x4ec77537e42ab9f5!2z7JWE7J6Q7ZWZ7IucIOyGoeq1rOyEseyLnOyKpA!5e0!3m2!1sko!2skr!4v1732525820000!5m2!1sko!2skr")
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

        binding.mapButtonHwaseongPalace.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.555309732625!2d127.01115207477176!3d37.28197084039631!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b43340a137667%3A0x692f2601c8996039!2z7ZmU7ISx7ZaJ6raB!5e0!3m2!1sko!2skr!4v1732525047493!5m2!1sko!2skr")
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

        binding.mapButtonJanganGate.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6348.513042066294!2d127.01039946000371!3d37.28905378034501!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5ccbebc74471%3A0x39d42fadbb7c62e3!2z7J6l7JWI66y4!5e0!3m2!1sko!2skr!4v1732605139600!5m2!1sko!2skr")
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

        binding.mapButtonYeonmudae.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.307385631906!2d127.02109197532641!3d37.28784809006049!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cb6b12aa45d%3A0xe5b041181e12d943!2z7Jew66y064yAIOyjvOywqOyepQ!5e0!3m2!1sko!2skr!4v1732605266568!5m2!1sko!2skr")
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

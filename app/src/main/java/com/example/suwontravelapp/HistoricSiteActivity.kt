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
                    R.drawable.suwon_hwasung,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.337913663371!2d127.00936297532633!3d37.28712444010172!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0fa82ebb%3A0x1326e46ba3ed1641!2z7IiY7JuQ7ZmU7ISx!5e0!3m2!1sko!2skr!4v1732615374170!5m2!1sko!2skr"
                )
            )
        }

        binding.mapButtonHwasung.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.337913663371!2d127.00936297532633!3d37.28712444010172!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0fa82ebb%3A0x1326e46ba3ed1641!2z7IiY7JuQ7ZmU7ISx!5e0!3m2!1sko!2skr!4v1732615374170!5m2!1sko!2skr")
        }

        binding.favoriteButtonGgHistPark.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "수원 광교 박물관",
                    "수원의 자연과 역사를 동시에 즐길 수 있는 박물관입니다.",
                    R.drawable.gg_hist_museum,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3173.948670233017!2d127.04879957532668!3d37.29635033957583!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b6f6487f915%3A0x6b561e7054068f64!2z7IiY7JuQ6rSR6rWQ67CV66y86rSA!5e0!3m2!1sko!2skr!4v1732615421421!5m2!1sko!2skr"
                )
            )
        }

        binding.mapButtonGgHistPark.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3173.948670233017!2d127.04879957532668!3d37.29635033957583!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b6f6487f915%3A0x6b561e7054068f64!2z7IiY7JuQ6rSR6rWQ67CV66y86rSA!5e0!3m2!1sko!2skr!4v1732615421421!5m2!1sko!2skr")
        }

        binding.favoriteButtonHwaseongPalace.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "화성행궁",
                    "조선시대 임금이 잠시 머물던 행궁입니다.",
                    R.drawable.hwaseong_palace,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.5553097326656!2d127.01115207532605!3d37.28197084039535!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b43340a137667%3A0x692f2601c8996039!2z7ZmU7ISx7ZaJ6raB!5e0!3m2!1sko!2skr!4v1732615452629!5m2!1sko!2skr"
                )
            )
        }

        binding.mapButtonHwaseongPalace.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.5553097326656!2d127.01115207532605!3d37.28197084039535!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b43340a137667%3A0x692f2601c8996039!2z7ZmU7ISx7ZaJ6raB!5e0!3m2!1sko!2skr!4v1732615452629!5m2!1sko!2skr")
        }

        binding.favoriteButtonJanganGate.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "장안문",
                    "수원의 북쪽을 지키는 성문의 하나입니다.",
                    R.drawable.jangan_gate,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.2377955207735!2d127.01244532532648!3d37.28949763996645!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5ccbebc74471%3A0x39d42fadbb7c62e3!2z7J6l7JWI66y4!5e0!3m2!1sko!2skr!4v1732615492613!5m2!1sko!2skr"
                )
            )
        }

        binding.mapButtonJanganGate.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.2377955207735!2d127.01244532532648!3d37.28949763996645!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5ccbebc74471%3A0x39d42fadbb7c62e3!2z7J6l7JWI66y4!5e0!3m2!1sko!2skr!4v1732615492613!5m2!1sko!2skr")
        }

        binding.favoriteButtonYeonmudae.setOnClickListener {
            addFavorite(
                FavoriteItem(
                    "연무대",
                    "조선시대 군사 훈련이 이루어졌던 장소입니다.",
                    R.drawable.yeonmudae,
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.307385631906!2d127.02109197532641!3d37.28784809006049!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5dc9433b8087%3A0xa8815121dd58ed35!2z7Jew66y064yAIOunpO2RnOyGjCAo7ZmU7ISx7Ja07LCoLCDqta3qtoHssrTtl5gp!5e0!3m2!1sko!2skr!4v1732615534972!5m2!1sko!2skr"
                )
            )
        }

        binding.mapButtonYeonmudae.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.307385631906!2d127.02109197532641!3d37.28784809006049!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5dc9433b8087%3A0xa8815121dd58ed35!2z7Jew66y064yAIOunpO2RnOyGjCAo7ZmU7ISx7Ja07LCoLCDqta3qtoHssrTtl5gp!5e0!3m2!1sko!2skr!4v1732615534972!5m2!1sko!2skr")
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

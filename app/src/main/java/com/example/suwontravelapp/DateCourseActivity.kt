package com.example.suwontravelapp

import android.content.Context
import android.content.Intent
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

        binding.mapButtonHwasung.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d6069.8652831005775!2d127.00887160642674!3d37.28587540793227!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0fa82ebb%3A0x1326e46ba3ed1641!2z7IiY7JuQ7ZmU7ISx!5e0!3m2!1sko!2skr!4v1732524653710!5m2!1sko!2skr")
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

        binding.mapButtonJyCoffeeRoastery.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6348.7812259552575!2d127.0088716053669!3d37.28587520400457!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b439d53ddf9f7%3A0xab9c6cc358896cc9!2z7KCV7KeA7JiB7Luk7ZS866Gc7Iqk7YSw7KaIIO2Wieq2geuzuOygkA!5e0!3m2!1sko!2skr!4v1732524769360!5m2!1sko!2skr")
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

        binding.mapButtonHaenggungMural.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d101644.22116080999!2d126.95118442314568!3d37.23864527385618!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b4335c2fbe363%3A0x52ac10a4de5dcd4b!2z6rK96riw64-EIOyImOybkOyLnCDtjJTri6zqtawg7ZaJ6raB64-Z!5e0!3m2!1sko!2skr!4v1732093734282!5m2!1sko!2skr")
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

        binding.mapButtonHaengnidanGil.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.3884734518747!2d127.01026867491028!3d37.28592592211266!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b43bf43f4bedd%3A0x4bafa109f6109b41!2z7ZaJ66as64uo6ri4!5e0!3m2!1sko!2skr!4v1732524866460!5m2!1sko!2skr")
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

        binding.mapButtonHwaseongPalace.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.555309732625!2d127.01115207477176!3d37.28197084039631!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b43340a137667%3A0x692f2601c8996039!2z7ZmU7ISx7ZaJ6raB!5e0!3m2!1sko!2skr!4v1732525047493!5m2!1sko!2skr")
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

        binding.mapButtonJidongMarket.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2661.0725495348943!2d127.01682471327088!3d37.27764216689883!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b4349e8797107%3A0x578ad93b7735ae37!2z7KeA64-Z7Iuc7J6l!5e0!3m2!1sko!2skr!4v1732525320191!5m2!1sko!2skr")
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

        binding.mapButtonGwanggyoLakePark.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4518.311949104675!2d127.06073825563742!3d37.28353152516911!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5b3e6f589601%3A0x159dfe5e577faea4!2z6rSR6rWQ7Zi47IiY6rO17JuQ!5e0!3m2!1sko!2skr!4v1732525528457!5m2!1sko!2skr")
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

        binding.mapButtonBanghwasuryujeong.setOnClickListener {
            showMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3174.3206722325!2d127.01546127477202!3d37.28753314007926!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5cca0c31c281%3A0x3e312d9e7739243e!2z67Cp7ZmU7IiY66WY7KCV!5e0!3m2!1sko!2skr!4v1732525567011!5m2!1sko!2skr")
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

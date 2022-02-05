package com.example.usefragmentsvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.usefragmentsvp.R
import com.example.usefragmentsvp.fragment.CapitalFragment
import com.example.usefragmentsvp.fragment.FlagFragment
import com.example.usefragmentsvp.fragment.InfoFragment
import com.example.usefragmentsvp.model.Country
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val countries: ArrayList<Country> = prepareCountryList()

        val capitalFragment = CapitalFragment().newInstance(countries)
        val flagFragment = FlagFragment().newInstance(countries)
        val infoFragment = InfoFragment().newInstance(countries)


        setCurrentFragment(capitalFragment)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.capitals -> setCurrentFragment(capitalFragment)
                R.id.flags -> setCurrentFragment(flagFragment)
                R.id.info -> setCurrentFragment(infoFragment)
            }
            true
        }

    }


    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }


    private fun prepareCountryList(): ArrayList<Country> {
        val countries: ArrayList<Country> = ArrayList()
        var index = 1
        for (i in 1..4) {
            countries.add(
                Country(
                    index++.toString() + ")Uzbekiston",
                    "Toshkent",
                    "Oʻzbekiston (rasman: Oʻzbekiston Respublikasi) — Markaziy Osiyoning markaziy qismida joylashgan mamlakat. Maydoni — 448,978[5] km2. Aholi soni (2022) — 35,111,621[6].",
                    R.drawable.uzb
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Qozog`iston",
                    "Nur-Sulton",
                    "Qozogʻiston yoki Qozogʻiston Respublikasi (qozoqcha: Қазақстан, Qazaqstan, Қазақстан Республикасы, Qazaqstan Respublikası) – Oʻrta Osiyoda joylashgan mamlakat.Qozogʻiston yer maydoni boʻyicha (2 million 724,9 ming km²) jahonda 9-oʻrinda turadi.",
                    R.drawable.qozoq
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Qirg`iziston",
                    "Bishkek",
                    "Qirgʻiziston (Qirgʻizcha: Kirgizstan — Ruscha: Kirgizstan), Qirgʻiz Respublikasi (Qirgʻizcha. Kirgiz Respublikasi — Ruscha. Kirgizskaya Respublika) — Oʻrta Osiyoning shimoli-sharqida joylashgan davlat. Qirg'izistonning aholisi soni 6 550 000 kishi.",
                    R.drawable.qirgiz
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Tojikiston",
                    "Dushanbe",
                    "Tojikiston (tojikcha: Тоҷикистон), Tojikiston Respublikasi (tojikcha. Ҷумҳурии Тоҷикистон) — Oʻrta Osiyoning janubi-sharqida joylashgan davlat. Maydoni 143.100 ming km². Aholisi 8,486,300 kishi (2014).",
                    R.drawable.tojik
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Turkmaniston",
                    "Ashxobod",
                    "Turkmaniston (turkmancha. Türkmenistan), Turkmaniston Respublikasi (turkmancha. Türkmenistan Respublikasy) — Markaziy Osiyodagi suveren davlat. Mamlakat aholisi 6 millionni tashkil etadi.",
                    R.drawable.turkman
                )
            )
        }
        return countries
    }

}
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
                    "O??zbekiston (rasman: O??zbekiston Respublikasi) ??? Markaziy Osiyoning markaziy qismida joylashgan mamlakat. Maydoni ??? 448,978[5] km2. Aholi soni (2022) ??? 35,111,621[6].",
                    R.drawable.uzb
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Qozog`iston",
                    "Nur-Sulton",
                    "Qozog??iston yoki Qozog??iston Respublikasi (qozoqcha: ??????????????????, Qazaqstan, ?????????????????? ????????????????????????, Qazaqstan Respublikas??) ??? O??rta Osiyoda joylashgan mamlakat.Qozog??iston yer maydoni bo??yicha (2 million 724,9 ming km??) jahonda 9-o??rinda turadi.",
                    R.drawable.qozoq
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Qirg`iziston",
                    "Bishkek",
                    "Qirg??iziston (Qirg??izcha: Kirgizstan ??? Ruscha: Kirgizstan), Qirg??iz Respublikasi (Qirg??izcha. Kirgiz Respublikasi ??? Ruscha. Kirgizskaya Respublika) ??? O??rta Osiyoning shimoli-sharqida joylashgan davlat. Qirg'izistonning aholisi soni 6 550 000 kishi.",
                    R.drawable.qirgiz
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Tojikiston",
                    "Dushanbe",
                    "Tojikiston (tojikcha: ????????????????????), Tojikiston Respublikasi (tojikcha. ???????????????? ????????????????????) ??? O??rta Osiyoning janubi-sharqida joylashgan davlat. Maydoni 143.100 ming km??. Aholisi 8,486,300 kishi (2014).",
                    R.drawable.tojik
                )
            )
            countries.add(
                Country(
                    index++.toString() + ")Turkmaniston",
                    "Ashxobod",
                    "Turkmaniston (turkmancha. T??rkmenistan), Turkmaniston Respublikasi (turkmancha. T??rkmenistan Respublikasy) ??? Markaziy Osiyodagi suveren davlat. Mamlakat aholisi 6 millionni tashkil etadi.",
                    R.drawable.turkman
                )
            )
        }
        return countries
    }

}
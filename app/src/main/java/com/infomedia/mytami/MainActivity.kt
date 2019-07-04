package com.infomedia.mytami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.infomedia.mytami.progress.ProgressFragment
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
    private var btmNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //custom toolbar
        setSupportActionBar(findViewById(R.id.toolbar_main))


        //bottom navigation bar
        val item1 = AHBottomNavigationItem("Home", R.drawable.ic_home)
        val item2 = AHBottomNavigationItem("Progress", R.drawable.ic_hourglass)
        val item3 = AHBottomNavigationItem("Profile", R.drawable.ic_id_person_20px)

        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item2)
        bottom_navigation.addItem(item3)

        bottom_navigation.accentColor = ContextCompat.getColor(this, R.color.colorPrimary)
        bottom_navigation.currentItem = 0
        loadFragment(HomeFragment())

        // Set listeners
        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
            var fragment: Fragment?
            when(position){
                0 -> {
                    fragment = HomeFragment()
                    loadFragment(fragment)
                }
                1 -> {
                    fragment = ProgressFragment()
                    loadFragment(fragment)
                }
                2 -> {
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                }
                else -> {
                    fragment = HomeFragment()
                    loadFragment(fragment)
                }
            }

        })

    }


    fun loadFragment(fragment: androidx.fragment.app.Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        return true
    }
}

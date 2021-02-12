package com.duvivier.clement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.duvivier.clement.adapters.ViewPageAdapter
import com.duvivier.clement.fragments.DetailFragment
import com.duvivier.clement.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(),"Menu")
        adapter.addFragment(DetailFragment(),"Details")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        //Si je veux ajouter des infos sur certains onglets (icones...)
        //tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
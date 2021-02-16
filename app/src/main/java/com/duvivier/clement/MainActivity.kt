package com.duvivier.clement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.duvivier.clement.adapters.ViewPageAdapter
import com.duvivier.clement.fragments.CoachesFragment
import com.duvivier.clement.fragments.PlayersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title =""

        setUpTabs()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_toolbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    private fun setUpTabs() {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(PlayersFragment(),"Players")
        adapter.addFragment(CoachesFragment(),"Coaches")
        viewPager.adapter = adapter
        
        tabLayout.setupWithViewPager(viewPager)

        //Si je veux ajouter des infos sur certains onglets (icones...)
        //tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_launcher_foreground)
    }
}
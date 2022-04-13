package com.dkdus.dementia.ui

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.dkdus.dementia.R
import com.dkdus.dementia.ui.game.GameFragment
import com.dkdus.dementia.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, HomeFragment())
            .commitAllowingStateLoss()

        nav_view.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()

        when(item.itemId){
            R.id.navigation_home -> {
                val homeFragment = HomeFragment()
                transaction.replace(R.id.fragment, homeFragment)
            }
            R.id.navigation_check -> {
                val checkFragment = CheckFragment()
                transaction.replace(R.id.fragment, checkFragment)
            }
            R.id.navigation_game ->{
                val gameFragment = GameFragment()
                transaction.replace(R.id.fragment, gameFragment)
            }
        }
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
        return true
    }


}
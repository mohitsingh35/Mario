package com.ncs.mario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.ncs.mario.Domain.Presentation.Home.HomeFragment
import com.ncs.mario.Domain.Presentation.Internship.InternshipFragment
import com.ncs.mario.Domain.Presentation.Score.ScoreFragment
import com.ncs.mario.Domain.Presentation.Store.StoreFragment
import com.ncs.mario.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        // Handle Navigation Drawer open/close using btnHam
        binding.actionbar.btnHam.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        loadFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_store->{
                    loadFragment(StoreFragment())
                    true
                }
                R.id.nav_internships->{
                    loadFragment(InternshipFragment())
                    true
                }
                R.id.nav_score->{
                    loadFragment(ScoreFragment())
                    true

                }

                else -> {
                    false
                }
            }
        }
        binding.bottomNavigationView.itemIconTintList = null

        // Handle Navigation Drawer item clicks (if needed)
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    // Handle profile click
                    true
                }
                R.id.nav_settings -> {
                    // Handle settings click
                    true
                }
                R.id.nav_logout -> {
                    // Handle logout click
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
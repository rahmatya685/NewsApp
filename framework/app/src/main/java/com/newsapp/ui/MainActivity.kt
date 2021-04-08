package com.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.newsapp.R
import com.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navControllerProvider: Provider<NavController>

    private val navController: NavController
        get() = navControllerProvider.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appBarConfiguration = AppBarConfiguration
            .Builder(R.id.topStoriesFragment)
            .build()
        NavigationUI.setupActionBarWithNavController(
            this,
            navController,
            appBarConfiguration
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (!onSupportNavigateUp()) {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
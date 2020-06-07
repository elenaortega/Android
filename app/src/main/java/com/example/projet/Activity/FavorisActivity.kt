package com.example.projet.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projet.R
import com.example.projet.ui.Lignes.LignesFragment
import com.example.projet.ui.Plan.PlanFragment
import com.example.projet.ui.home.HomeFragment
import com.google.android.material.navigation.NavigationView

class FavorisActivity : AppCompatActivity() {
    lateinit var lignesFragment: LignesFragment
    lateinit var planFragment: PlanFragment
    lateinit var homeFragment: HomeFragment

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        R.layout.activity_favoris
        setContentView(R.layout.activity_favoris)
        overridePendingTransition(
            R.anim.fade_in,
            R.anim.fade_out
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_plan, R.id.nav_lignes
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }
}
package dev.jaque.navigationgraph

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home_graph, R.id.navigation_dashboard_graph, R.id.navigation_notifications_graph))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navigationListener()
    }

    private fun navigationListener() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.i("Log listener: ", "Destination: ${destination.id}")
            when(destination.id) {
                R.id.homeFragment -> Log.i("Navigation Home", "success")
                R.id.dashboardFragment -> Log.i("Navigation dashboard", "success")
                R.id.notificationsFragment -> Log.i("Navigation notification", "success")
                else -> Log.i("Something wrong", "failure")
            }
        }
    }
}

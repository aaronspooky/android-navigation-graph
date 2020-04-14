package dev.jaque.navigationgraph

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dev.jaque.navigationgraph.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.dashboardFragment, R.id.homeFragment, R.id.notificationsFragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setupToolbar()

        navigationListener()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun navigationListener() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.i("Log listener: ", "Destination: ${destination.id}")
            when(destination.id) {
                R.id.homeFragment -> {
                    Log.i("Navigation Home", "success")
                    onChangePrimaryThemeToolbar()
                }
                R.id.dashboardFragment -> {
                    Log.i("Navigation dashboard", "success")
                    onChangeWhiteToolbar()
                }
                R.id.notificationsFragment -> Log.i("Navigation notification", "success")
                else -> Log.i("Something wrong", "failure")
            }
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun onChangePrimaryThemeToolbar() {
        binding.toolbar.setTitleTextColor(Color.WHITE)
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun onChangeWhiteToolbar() {
        binding.toolbar.setTitleTextColor(Color.BLACK)
        binding.toolbar.setBackgroundColor(Color.WHITE)
        binding.toolbar.backgroundTintList = null

    }
}

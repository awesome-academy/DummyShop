package com.sun.dummyshop.ui.main

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.sun.dummyshop.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.DummyShopTheme)
        setContentView(R.layout.activity_main)

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavigationHost) as NavHostFragment
        val navigationController = navigationHostFragment.navController
        navigationController.addOnDestinationChangedListener {_, destination, _ ->
            when (destination.id) {
                in mainFragments -> showBottomNavigation()
                else -> hideBottomNavigation()
            }
        }
        bottomNavigationView.apply {
            setupWithNavController(navigationController)
            setOnNavigationItemSelectedListener {
                if (it.itemId != bottomNavigationView.selectedItemId) {
                    NavigationUI.onNavDestinationSelected(it, navigationController)
                }
                true
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        currentFocus?.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun showBottomNavigation() {
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNavigation() {
        bottomNavigationView.visibility = View.GONE
    }

    companion object {
        val mainFragments = listOf(
            R.id.fragmentHome,
            R.id.fragmentFavorite,
            R.id.fragmentHistory
        )
    }
}

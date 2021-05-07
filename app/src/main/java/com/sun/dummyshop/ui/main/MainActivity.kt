package com.sun.dummyshop.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.dummyshop.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.DummyShopTheme)
        setContentView(R.layout.activity_main)
    }
}

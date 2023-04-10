package com.example.flixster_app


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flixster_app.R.id.content

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(content, MoviesFragment.MoviesFragment()).commit()
    }
}
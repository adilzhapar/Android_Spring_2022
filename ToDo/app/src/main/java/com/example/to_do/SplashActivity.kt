package com.example.to_do

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.to_do.R
import android.content.Intent
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    fun OnCreate(savedInstanceState: Bundle?) {
        super.onCreate(SavedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        val i = Intent(this@SplashActivity, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(i)
            finish()
        }, 1000)
    }
}
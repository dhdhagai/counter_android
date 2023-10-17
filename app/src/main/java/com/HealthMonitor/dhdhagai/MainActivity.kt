package com.HealthMonitor.dhdhagai

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import java.io.File

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outputDir: File = applicationContext.cacheDir // context being the Activity pointer
        Log.d("TESTING", outputDir.toString())
        val button: Button = findViewById(R.id.start)
        button.setOnClickListener {
            startActivity(Intent(applicationContext, CounterActivity::class.java))
        }
    }

}
package com.counter.dhdhagai

import android.Manifest
import android.widget.Button
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat


class CounterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_activity)
        val mIntent = intent
        val mBundleData = mIntent.extras

        val isEnabled = mBundleData?.getString("Enabled").toString()
        Log.d("Testing",isEnabled)
        if(isEnabled.toBoolean()){
            addNotification("Welcome", "Welcome to the application")
        }
        var goback: Button = findViewById(R.id.goback)
        goback.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
    private fun addNotification(title2Notif: String, desc2Notif: String){
        val OnclickIntent_Notif = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        }
        val pendingIntent_notif: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this, "main_notif")
            .setSmallIcon(R.drawable.icon)
            .setContentTitle(title2Notif)
            .setContentText(desc2Notif)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent_notif)
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.POST_NOTIFICATIONS,

                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            val notificationId = 0
            notify(notificationId, builder.build())
        }
    }
    }



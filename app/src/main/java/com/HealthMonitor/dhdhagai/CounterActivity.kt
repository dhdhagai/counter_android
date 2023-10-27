package com.HealthMonitor.dhdhagai

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CounterActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_activity)

        webView = findViewById(R.id.webView)

        // Enable JavaScript (optional)
        webView.settings.javaScriptEnabled = true

        // Enable caching
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }

        // Load the initial URL
        webView.loadUrl("https://scipotech.netlify.app")
        webView.settings.domStorageEnabled = true
        webView.setWebChromeClient(object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(origin: String, callback: GeolocationPermissions.Callback) {
                // Check if location permission is granted
                if (ContextCompat.checkSelfPermission(this@CounterActivity, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted, allow geolocation
                    callback.invoke(origin, true, false)
                } else {
                    // Permission is not granted, request permission from the user
                    ActivityCompat.requestPermissions(this@CounterActivity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
                }
            }
        })
    }

    // Handle back navigation
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    // Handle the result of location permission request
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Location permission is granted, reload the page or take any action as needed
                webView.reload()
                finish()
                val intent = Intent(this, CounterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

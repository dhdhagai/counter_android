package com.HealthMonitor.dhdhagai
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

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
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                // This ensures that all links clicked within the WebView are loaded in the WebView
                view?.loadUrl(request?.url.toString())
                return true
            }
        }

        // Load the initial URL
        webView.loadUrl("https://scipotech.netlify.app")
    }

    // Handle back navigation
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}

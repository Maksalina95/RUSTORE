package com.maksmarket.app

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Проверка интернета
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        if (networkInfo == null || !networkInfo.isConnected) {
            startActivity(Intent(this, OfflineActivity::class.java))
            finish()
            return
        }

        val webView: WebView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://maksmarket.vercel.app") // Твой сайт
    }
}

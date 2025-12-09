package com.maksmarket.app;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Проверка интернета
        if (!NetworkUtil.isNetworkAvailable(this)) {
            startActivity(new Intent(this, OfflineActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://maksmarket.vercel.app");
    }
}

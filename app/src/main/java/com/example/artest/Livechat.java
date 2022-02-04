package com.example.artest;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Livechat extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livechat);

        webView = (WebView) findViewById(R.id.webview);

        webView.loadUrl("https://facebook-messenger-clone-f25a4.firebaseapp.com/");

        webView.setWebViewClient(new WebViewClient());
        //setContentView(myWebView);
        WebSettings websettings = webView.getSettings();
        websettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {

        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}

package com.example.niuanqi.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);

        try {
            webView.loadUrl("file:///android_asset/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentView(webView);


    }
}

package com.example.foodmate.fragments.Pacfragment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.foodmate.R;

public class frag1_vewview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag1_vewview);
        WebView webView=findViewById(R.id.web_frag1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http://www.baidu.com");
        webView.loadUrl("https://baike.baidu.com/item/%E9%B1%BC%E9%A6%99%E8%82%89%E4%B8%9D/125511?fr=aladdin");

    }
}

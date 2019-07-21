package com.example.foodmate.fragments.Pacfragment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.foodmate.R;

public class webviewfrag_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewfrag_2);
        WebView webView=findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http://www.baidu.com");
        webView.loadUrl("https://v.qq.com/x/cover/ii5krzlohme9ept/M0010Lw6Ttf.html?ptag=baidu.aladdin.doco");
    }
}

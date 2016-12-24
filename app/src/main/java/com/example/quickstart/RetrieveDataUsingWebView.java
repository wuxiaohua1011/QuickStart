package com.example.quickstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class RetrieveDataUsingWebView extends AppCompatActivity implements View.OnClickListener{
private WebView webView;
    private Button buttonBack,buttonload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data_using_web_view);
        wireWidget();
        addListner();


    }

    private void wireWidget() {

        buttonBack=(Button)findViewById(R.id.activity_retrieve_data_using_web_view_button_back);
        buttonload=(Button)findViewById(R.id.activity_retrieve_data_using_web_view_button_load);
        webView=(WebView)findViewById(R.id.activity_retrieve_data_using_web_view_webview_1);
    }

    private void addListner() {
        buttonBack.setOnClickListener(this);
        buttonload.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case    R.id.activity_retrieve_data_using_web_view_button_load:
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                webView.loadUrl("https://docs.google.com/spreadsheets/d/1DHqf4fFbxq0Sn0xwIAnD4QKbDF-QvR8owBAdu0Qk1q0/edit#gid=0");
                break;
            case R.id.activity_retrieve_data_using_web_view_button_back:
                startActivity(new Intent(this,ActionActivity.class));finish();
                break;
        }

    }
}

package com.example.quickstart;

import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PostData extends Activity implements View.OnClickListener{

    final String myTag = "DocsUpload";

private Button buttonPost,buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);
        Log.i(myTag, "OnCreate()");
        wireWidget();
        addListner();
        
        
    }

    private void wireWidget() {
        buttonPost=(Button)findViewById(R.id.activity_post_data_button_post);
        buttonBack=(Button)findViewById(R.id.activity_post_data_button_back);
    }

    private void addListner() {
        buttonBack.setOnClickListener(this);
        buttonPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case    R.id.activity_post_data_button_back:
                startActivity(new Intent(this,ActionActivity.class));finish();break;
            case R.id.activity_post_data_button_post:
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        postData();

                    }
                });
                t.start();
        }
    }
    public void postData() {

        String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfO8UrwSla43P1EenzVLxMuHdFo9r6p-e6c5WT_CL-C_4R_Mg/formResponse";
        HttpRequest mReq = new HttpRequest();
        String col1 = "Hello";

        String data = "entry.1298782818=" + URLEncoder.encode(col1) ; // TODO: 12/23/2016 post user entered data, REQUIRE all entries 

        String response = mReq.sendPost(fullUrl, data);
        Log.i(myTag, response);
    }


}

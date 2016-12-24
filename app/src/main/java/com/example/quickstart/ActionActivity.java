package com.example.quickstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
    }

    public void activity_action_button_post_data_clicked(View view) {
        startActivity(new Intent(this,PostData.class));finish();
    }

    public void activity_action_button_retieve_data_clicked(View view) {
        startActivity(new Intent(this,MainActivity.class));finish();
    }
}

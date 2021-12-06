package com.example.pizzeria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        if (getIntent().hasExtra("Pizza.Type")){
            TextView tv = (TextView) findViewById(R.id.Title3);
            String text = getIntent().getExtras().getString("Pizza.Type");
            tv.setText(text);
        }

    }
}
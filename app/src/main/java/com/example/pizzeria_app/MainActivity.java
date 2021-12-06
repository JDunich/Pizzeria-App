package com.example.pizzeria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button order_bt = (Button) findViewById(R.id.order_bt);
        Button curr_bt = (Button) findViewById(R.id.curr_bt);
        Button all_bt = (Button) findViewById(R.id.all_bt);

        order_bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), PizzaActivity.class);
                startActivity(startIntent);

            }
        });
    }
}
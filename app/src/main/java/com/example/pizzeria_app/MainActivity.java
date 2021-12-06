package com.example.pizzeria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static StoreOrders storeOrders = new StoreOrders();

    Button order_bt, curr_bt, all_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order_bt = findViewById(R.id.order_bt);
        curr_bt = findViewById(R.id.curr_bt);
        all_bt =  findViewById(R.id.all_bt);

        order_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        curr_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });

        all_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStore();
            }
        });
    }

    private void openActivity(){
        Intent intent = new Intent(this, PizzaActivity.class);
        startActivity(intent);
    }

    private void openOrder(){
        Intent intent = new Intent(this, CurrentActivity.class);
        startActivity(intent);
    }

    private void openStore(){
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }
}
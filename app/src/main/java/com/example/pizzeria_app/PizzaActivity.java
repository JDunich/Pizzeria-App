package com.example.pizzeria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        Button pepperoni_bt = (Button) findViewById(R.id.pep_bt);
        Button hawaiian_bt = (Button) findViewById(R.id.haw_bt);
        Button deluxe_bt = (Button) findViewById(R.id.del_bt);

        pepperoni_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), CustomizeActivity.class);
                startIntent.putExtra("Pizza.Type", "Pepperoni");
                startActivity(startIntent);

            }
        });

        hawaiian_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), CustomizeActivity.class);
                startIntent.putExtra("Pizza.Type", "Hawaiian");
                startActivity(startIntent);

            }
        });

        deluxe_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), CustomizeActivity.class);
                startIntent.putExtra("Pizza.Type", "Deluxe");
                startActivity(startIntent);

            }
        });

    }
}
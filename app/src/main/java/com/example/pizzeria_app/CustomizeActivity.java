package com.example.pizzeria_app;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.pizzeria_app.MainActivity.storeOrders;
import static com.example.pizzeria_app.PizzaActivity.arr;

public class CustomizeActivity extends AppCompatActivity {

    EditText phone, total_pizza;
    Button finalize;
    private static final int NUMBER_LENGTH = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        phone = findViewById(R.id.phone);
        total_pizza = findViewById(R.id.total_pizza);
        finalize = findViewById(R.id.finalize);
        finalize.setEnabled(false);
        phone = findViewById(R.id.phone);
        total_pizza = findViewById(R.id.total_pizza);
        calcTotal();
        phone.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                System.out.println(s.toString());
                if (isValidNumber(s.toString())){
                    System.out.println("here");
                    finalize.setEnabled(true);
                } else {
                    finalize.setEnabled(false);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        finalize.setOnClickListener(v -> {
            arr.setPhoneNumber(phone.getText().toString());
        });

    }


    private void calcTotal(){
        double price = arr.getPrice();
        total_pizza.setText(String.format("%,.2f", price));
    }

    private boolean isValidNumber(String number){
        if(arr.getPizzaList().isEmpty() || phone.getText().toString().matches("")){
            return false;
        }
        number = formatNumber(number);
        if(number.length() == NUMBER_LENGTH){
            for(int i = 0; i < NUMBER_LENGTH; i++){
                if(!Character.isDigit(number.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private String formatNumber(String number){
        number = number.replaceAll("\\s","");
        number = number.replace("(", "");
        number = number.replace(")", "");
        number = number.replace("-", "");
        return number;
    }
}
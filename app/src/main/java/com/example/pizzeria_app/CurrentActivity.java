package com.example.pizzeria_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.pizzeria_app.MainActivity.storeOrders;
import static com.example.pizzeria_app.PizzaActivity.arr;

public class CurrentActivity extends AppCompatActivity {

    ListView pizza_list;
    EditText subtotal, tax, total, phoneNumber;
    Button currorder_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setPhoneNumber();
        pizza_list = findViewById(R.id.pizza_list);
        subtotal = findViewById(R.id.subtotal);
        tax = findViewById(R.id.tax);
        total = findViewById(R.id.total);
        phoneNumber = findViewById(R.id.phoneNumber);
        currorder_bt = findViewById(R.id.currorder_bt);
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(
                this,
                android.R.layout.simple_list_item_1, arr.getPizzaList()
        );
        pizza_list.setAdapter(adapter);
        pizza_list.setOnItemClickListener((parent, view, position, id) -> {
            Pizza delete = (Pizza) pizza_list.getItemAtPosition(position);
            pizza_list.removeViewAt(position);
            arr.remove(delete);
            setPrices();
        });
        currorder_bt.setOnClickListener(event -> {
            storeOrders.add(arr);
            currorder_bt.setEnabled(false);
        });

    }


    public void setPrices(){
        double price = arr.getPrice();
        if(price <= 0){
            price = 0;
        }
        subtotal.setText(String.format("%,.2f", price));
        double SALES_TAX = 0.06625;
        double taxes = price * SALES_TAX;
        tax.setText(String.format("%,.2f", taxes));
        price = price + taxes;
        total.setText(String.format("%,.2f", price));
    }

    public void setPhoneNumber(){
        String number = arr.getPhoneNumber();
        number = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        phoneNumber.setText(number);
    }

}

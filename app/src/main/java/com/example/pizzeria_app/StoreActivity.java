package com.example.pizzeria_app;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.pizzeria_app.MainActivity.storeOrders;

public class StoreActivity extends AppCompatActivity {

    ArrayAdapter<String> numberAdapter;
    ListView ordersTable;
    Spinner numbers;
    EditText orderTotal;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        setTable(storeOrders.getFirstNumber());
        setPhoneNumbers();
        numbers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setTable(storeOrders.getSameNumber((String) numbers.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cancel.setOnClickListener(event -> {
            Order toCancel = storeOrders.getSameNumber((String) numbers.getSelectedItem());
            numberAdapter.remove((String) numbers.getSelectedItem());
            numbers.setAdapter(numberAdapter);
            ordersTable.setAdapter(null);
            storeOrders.cancel(toCancel);
        });

    }

    public void setTable(Order order){
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(
                this,
                android.R.layout.simple_list_item_1, order.getPizzaList()
        );
        ordersTable.setAdapter(adapter);
        orderTotal.setText(String.format("%,.2f", order.getFinalTotal()));
    }

    public void setPhoneNumbers(){
        ArrayList<String> formattedNumbers = new ArrayList<>();
        for(Order item : storeOrders.getOrdersList())
            formattedNumbers.add(formatNumber(item.getPhoneNumber()));

        numberAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line, formattedNumbers
        );
        numbers.setAdapter(numberAdapter);
    }

    private String formatNumber(String number){
        return number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

}

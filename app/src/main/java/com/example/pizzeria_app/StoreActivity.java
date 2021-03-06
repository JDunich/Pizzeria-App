package com.example.pizzeria_app;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import static com.example.pizzeria_app.MainActivity.storeOrders;

/**
 * Class for Deluxe child
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class StoreActivity extends AppCompatActivity {
    /**
     * ArrayAdapter
     */
    ArrayAdapter<String> numberAdapter;
    /**
     * Orders
     */
    ListView ordersTable;
    /**
     * Numbers
     */
    Spinner numbers;
    /**
     * Order Total
     */
    EditText orderTotal;
    /**
     * Cancel Button
     */
    Button cancel;

    /**
     * Initialization
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ordersTable = findViewById(R.id.ordersTable);
        numbers = findViewById(R.id.numbers);
        cancel = findViewById(R.id.cancel);
        orderTotal = findViewById(R.id.orderTotal);
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
            orderTotal.setText("0.00");
        });

    }

    /**
     * Set Table
     * @param order
     */
    public void setTable(Order order){
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<Pizza>(
                this,
                android.R.layout.simple_list_item_1, order.getPizzaList()
        );
        ordersTable.setAdapter(adapter);
        orderTotal.setText(String.format("%,.2f", order.getFinalTotal()));
    }

    /**
     * Set Phone Number
     */
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

    /**
     * Format Number
     * @param number phone number
     * @return String
     */
    private String formatNumber(String number){
        return number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

}

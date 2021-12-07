package com.example.pizzeria_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.pizzeria_app.PizzaActivity.curr;

/**
 * Class for Main Activity
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Store Orders for the application
     */
    static StoreOrders storeOrders = new StoreOrders();
    /**
     * Buttons
     */
    static Button curr_bt, all_bt;
    /**
     * Button
     */
    Button order_bt;

    /**
     * Initialization
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order_bt = findViewById(R.id.order_bt);
        curr_bt = findViewById(R.id.curr_bt);
        all_bt =  findViewById(R.id.all_bt);

        if(curr != null)
            curr_bt.setEnabled(true);
        else
            curr_bt.setEnabled(false);

        if(storeOrders.getOrdersList().isEmpty())
            all_bt.setEnabled(false);
        else
            all_bt.setEnabled(true);

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
                if(storeOrders.getFirstNumber() != null)
                    openStore();
            }
        });
    }

    /**
     * Opener
     */
    private void openActivity(){
        Intent intent = new Intent(this, PizzaActivity.class);
        startActivity(intent);
    }

    /**
     * Opener
     */
    private void openOrder(){
        Intent intent = new Intent(this, CurrentActivity.class);
        startActivity(intent);
    }

    /**
     * Opener
     */
    private void openStore(){
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }
}
package com.example.pizzeria_app;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import static com.example.pizzeria_app.MainActivity.curr_bt;
import static com.example.pizzeria_app.PizzaActivity.curr;
/**
 * CustomizeActivity to finalize an order
 * @author Jack Dunich
 * @author Kiana Perst
 */
public class CustomizeActivity extends AppCompatActivity {
    /**
     * Static order variable
     */
    public static Order arr = new Order();
    /**
     * EditText in xml file
     */
    private EditText phone, total_pizza;
    /**
     * Finalize button
     */
    private Button finalize;
    /**
     * Final for number length
     */
    private static final int NUMBER_LENGTH = 10;

    /**
     * Initialization of the activity
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        arr = curr;
        phone = findViewById(R.id.phone);
        total_pizza = findViewById(R.id.total_pizza);
        finalize = findViewById(R.id.finalize);
        finalize.setEnabled(false);
        phone = findViewById(R.id.phone);
        total_pizza = findViewById(R.id.total_pizza);
        calcTotal();
        phone.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (isValidNumber(s.toString())){
                    finalize.setEnabled(true);
                } else {
                    finalize.setEnabled(false);
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        finalize.setOnClickListener(v -> {
            arr.setPhoneNumber(phone.getText().toString());
            curr_bt.setEnabled(true);
        });
    }

    /**
     * Calculates total of the order
     */
    private void calcTotal(){
        double price = arr.getPrice();
        total_pizza.setText(String.format("%,.2f", price));
    }

    /**
     * Checks if the phone number is valid
     * @param number phone number
     * @return boolean depending on valid or not
     */
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

    /**
     * Returns the formatted phone number
     * @param number Phone Number
     * @return String
     */
    private String formatNumber(String number){
        number = number.replaceAll("\\s","");
        number = number.replace("(", "");
        number = number.replace(")", "");
        number = number.replace("-", "");
        return number;
    }
}
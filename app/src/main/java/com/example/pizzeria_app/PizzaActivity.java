package com.example.pizzeria_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class PizzaActivity extends AppCompatActivity implements View.OnClickListener {

    static Order arr = new Order();

    private Pizza type;
    private Size size;
    private Topping toppings;
    ListView currentToppings, extraToppings;
    ArrayAdapter<Topping> current, extra;
    Button pep_bt, haw_bt, del_bt, small, medium, large, add, next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        pep_bt = findViewById(R.id.pep_bt);
        haw_bt = findViewById(R.id.haw_bt);
        del_bt = findViewById(R.id.del_bt);
        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        add = findViewById(R.id.add);
        extra = new ArrayAdapter<Topping>(
                this,
                android.R.layout.simple_list_item_1, Arrays.asList(Topping.values())
        );
        toppingListener();
        add.setOnClickListener(v -> {
                addPizza();
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCust();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pep_bt:
                type = PizzaMaker.createPizza("Pepperoni");
                setFocus(pep_bt, haw_bt, del_bt);
                setClickable();
                setToppings("pep");
                break;
            case R.id.haw_bt:
                type = PizzaMaker.createPizza("Hawaiian");
                setFocus(haw_bt, pep_bt, del_bt);
                setClickable();
                setToppings("haw");
                break;
            case R.id.del_bt:
                type = PizzaMaker.createPizza("Deluxe");
                setFocus(del_bt, haw_bt, pep_bt);
                setClickable();
                setToppings("del");
                break;
            case R.id.small:
                size = Size.Small;
                setFocus(small, medium, large);
                break;
            case R.id.medium:
                size = Size.Medium;
                setFocus(medium, small, large);
                break;
            case R.id.large:
                size = Size.Large;
                setFocus(large, medium, small);
                break;
        }
    }

    private void openCust(){
        Intent intent = new Intent(this, CustomizeActivity.class);
        startActivity(intent);
    }

    private void addPizza(){
        ArrayList<Topping> toppings = new ArrayList<Topping>();
        for (int i = 0; i < current.getCount(); i++)
            toppings.add(current.getItem(i));
        type.setSize(size);
        type.setToppings(toppings);
        arr.add(type);
    }

    private void toppingListener(){
        extraToppings.setOnItemClickListener((parent, view, position, id) -> {
            Topping top = (Topping) extraToppings.getItemAtPosition(position);
            extraToppings.removeViewAt(position);
            current.add(top);
            currentToppings.setAdapter(current);
        });

        currentToppings.setOnItemClickListener((parent, view, position, id) -> {
            Topping top = (Topping) currentToppings.getItemAtPosition(position);
            currentToppings.removeViewAt(position);
            extra.add(top);
            extraToppings.setAdapter(current);
        });
    }

    private void setToppings(String flavor){
        current.clear();
        extra = new ArrayAdapter<Topping>(
                this,
                android.R.layout.simple_list_item_1, Arrays.asList(Topping.values())
        );
        switch(flavor){
            case "pep":
                extra.remove(Topping.Pepperoni);
                current.add(Topping.Pepperoni);
                break;
            case "haw":
                extra.remove(Topping.Ham);
                extra.remove(Topping.Pineapple);
                current.addAll(Topping.Ham, Topping.Pineapple);
                break;
            case "del":
                extra.remove(Topping.Pepperoni);
                extra.remove(Topping.Olives);
                extra.remove(Topping.Bacon);
                extra.remove(Topping.Peppers);
                extra.remove(Topping.Chicken);
                current.addAll(Topping.Pepperoni, Topping.Olives, Topping.Bacon, Topping.Peppers, Topping.Chicken);
        }
        extraToppings.setAdapter(extra);
        currentToppings.setAdapter(current);
    }

    private void setFocus(Button btn_focus, Button btn1, Button btn2){
        btn1.setBackgroundColor(Color.rgb(187, 134, 252));
        btn2.setBackgroundColor(Color.rgb(187, 134, 252));
        btn_focus.setBackgroundColor(Color.rgb(98, 0, 238));
    }

    private void setClickable(){
        small.setClickable(true);
        medium.setClickable(true);
        large.setClickable(true);
    }

    private void setUnClickable(){
        small.setClickable(false);
        medium.setClickable(false);
        large.setClickable(false);
    }

}
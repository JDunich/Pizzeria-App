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
    static Order curr;

    private Pizza type;
    private Size size;
    private Topping toppings;
    private boolean size_selected = false;
    private boolean pizza_type_selected = false;
    ListView currentToppings, extraToppings;
    ArrayAdapter<Topping> current, extra;
    Button pep_bt, haw_bt, del_bt, small, medium, large, add, next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        curr = new Order();
        extraToppings = findViewById(R.id.extraToppings);
        currentToppings = findViewById(R.id.currentToppings);
        pep_bt = findViewById(R.id.pep_bt);
        haw_bt = findViewById(R.id.haw_bt);
        del_bt = findViewById(R.id.del_bt);
        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        add = findViewById(R.id.add);
        add.setEnabled(false);
        next = findViewById(R.id.next);
        next.setEnabled(false);
        extra = new ArrayAdapter<Topping>(
                this,
                android.R.layout.simple_list_item_1, Arrays.asList(Topping.values())
        );
        add.setOnClickListener(v -> {
                addPizza();
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCust();
            }
        });
        extraToppings.setAdapter(null);
        currentToppings.setAdapter(null);
        toppingListener();
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
                pizza_type_selected = true;
                break;
            case R.id.haw_bt:
                type = PizzaMaker.createPizza("Hawaiian");
                setFocus(haw_bt, pep_bt, del_bt);
                setClickable();
                setToppings("haw");
                pizza_type_selected = true;
                break;
            case R.id.del_bt:
                type = PizzaMaker.createPizza("Deluxe");
                setFocus(del_bt, haw_bt, pep_bt);
                setClickable();
                setToppings("del");
                pizza_type_selected = true;
                break;
            case R.id.small:
                size = Size.Small;
                setFocus(small, medium, large);
                size_selected = true;
                break;
            case R.id.medium:
                size = Size.Medium;
                setFocus(medium, small, large);
                size_selected = true;
                break;
            case R.id.large:
                size = Size.Large;
                setFocus(large, medium, small);
                size_selected = true;
                break;
        }

        if(size_selected && pizza_type_selected){
            add.setEnabled(true);
            next.setEnabled(true);
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
        curr.add(type);
    }

    private void toppingListener(){
        extraToppings.setOnItemClickListener((parent, view, position, id) -> {
            if(current.getCount() < 7) {
                Topping top = (Topping) extraToppings.getItemAtPosition(position);
                extra.remove((Topping) extraToppings.getItemAtPosition(position));
                current.add(top);
                extraToppings.setAdapter(extra);
                currentToppings.setAdapter(current);
            }
        });

        currentToppings.setOnItemClickListener((parent, view, position, id) -> {
            Topping top = (Topping) currentToppings.getItemAtPosition(position);
            current.remove((Topping) currentToppings.getItemAtPosition(position));
            extra.add(top);
            currentToppings.setAdapter(current);
            extraToppings.setAdapter(extra);
        });
    }

    private void setToppings(String flavor){
        ArrayList<Topping> tempextra = new ArrayList<>(Arrays.asList(Topping.values()));
        ArrayList<Topping> tempcurrent = new ArrayList<>();

        switch(flavor){
            case "pep":
                tempextra.remove(Topping.Pepperoni);
                tempcurrent.add(Topping.Pepperoni);
                break;
            case "haw":
                tempextra.remove(Topping.Ham);
                tempextra.remove(Topping.Pineapple);
                tempcurrent.add(Topping.Ham);
                tempcurrent.add(Topping.Pineapple);
                break;
            case "del":
                tempextra.remove(Topping.Pepperoni);
                tempextra.remove(Topping.Olives);
                tempextra.remove(Topping.Bacon);
                tempextra.remove(Topping.Peppers);
                tempextra.remove(Topping.Chicken);
                tempcurrent.add(Topping.Pepperoni);
                tempcurrent.add(Topping.Olives);
                tempcurrent.add(Topping.Bacon);
                tempcurrent.add(Topping.Peppers);
                tempcurrent.add(Topping.Chicken);
        }

        extra = new ArrayAdapter<Topping>(
                this,
                android.R.layout.simple_list_item_1, tempextra
        );
        current = new ArrayAdapter<Topping>(
                this,
                android.R.layout.simple_list_item_1, tempcurrent
        );
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
        add.setClickable(true);
    }

    private void setUnClickable(){
        small.setClickable(false);
        medium.setClickable(false);
        large.setClickable(false);
        add.setClickable(false);
    }


}
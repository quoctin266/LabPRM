package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.MutableLiveData;

import com.example.lab1.custom.MyApplication;

import java.text.DecimalFormat;
import java.util.Random;

public class FoodDrinkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.food_drink_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.food_drink_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button foodBtn = findViewById(R.id.foodBtn);
        Button drinkBtn = findViewById(R.id.drinkBtn);
        EditText summary = findViewById(R.id.summaryText);

        foodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodDrinkActivity.this, FoodActivity.class));
            }
        });

        drinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodDrinkActivity.this, DrinkActivity.class));
            }
        });

        MyApplication app = (MyApplication) getApplicationContext();
        String food = app.getFood();
        String drink = app.getDrink();

        if(food != null || drink != null) {
            summary.setText((food == null ? "" : food) + " - " + (drink == null ? "" : drink));
        }
    }
}
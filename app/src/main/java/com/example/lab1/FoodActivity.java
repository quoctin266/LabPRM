package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.MutableLiveData;

import com.example.lab1.custom.MyApplication;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FoodActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;

    private Button chooseBtn;

    final MutableLiveData<String> selectedFood = new MutableLiveData<>("");

    String[] data = {"Phở Hà Nội", "Bún Bò Huế", "Mì Quảng", "Hủ Tiếu Sài Gòn"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.food_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.food_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chooseBtn = findViewById(R.id.chooseFoodBtn);
        listView = findViewById(R.id.foodList);

        items = new ArrayList<>();
        items.addAll(Arrays.asList(data));
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food = items.get(position);
                selectedFood.setValue(food);
            }
        });

        chooseBtn.setOnClickListener(v -> {
            if(selectedFood.getValue().isEmpty()) {
                Toast.makeText(this, "Pleas choose food", Toast.LENGTH_LONG).show();
            }
            else {
                MyApplication app = (MyApplication) getApplicationContext();
                app.setFood(selectedFood.getValue());

                Intent i = new Intent(FoodActivity.this, FoodDrinkActivity.class);
                startActivity(i);
            }
        });
    }
}
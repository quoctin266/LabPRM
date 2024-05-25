package com.example.lab1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1.custom.ListViewAdapter;

public class ImageListActivity extends AppCompatActivity {
    String fruitList[] = {"Apple", "Banana", "Apricot", "Orange", "Water Melon"};
    int fruitImages[] = {R.drawable.apple, R.drawable.banana, R.drawable.apricot, R.drawable.orange, R.drawable.watermelon};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.image_listview_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.image_listview_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), fruitList, fruitImages);
        listView = findViewById(R.id.imageList);
        listView.setAdapter(listViewAdapter);
    }
}
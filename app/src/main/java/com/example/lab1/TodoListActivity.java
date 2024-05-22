package com.example.lab1;

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

import java.util.ArrayList;

public class TodoListActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button saveBtn;

    // save clicked item position as state
    final MutableLiveData<Integer> selected = new MutableLiveData<>(-1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.list_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.todoList);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               addItem(v);
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();
        editItem();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item removed", Toast.LENGTH_LONG).show();

                // remove item from data list and notify adapter
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View v) {
        EditText input = findViewById(R.id.addInput);
        String item = input.getText().toString();

        if(!item.equals("")) {
            // if there is item position saved in state then edit
            if(selected.getValue() >= 0) {
                items.set(selected.getValue(), item);
                itemsAdapter.notifyDataSetChanged();

                selected.setValue(-1);
            }
            // add item otherwise
            else {
                itemsAdapter.add(item);
            }
            input.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter text...", Toast.LENGTH_LONG).show();
        }
    }

    private void editItem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set item to input and save item position to state
                EditText input = findViewById(R.id.addInput);
                String clickedItem = items.get(position);
                input.setText(clickedItem);

                selected.setValue(position);
            }
        });
    }
}
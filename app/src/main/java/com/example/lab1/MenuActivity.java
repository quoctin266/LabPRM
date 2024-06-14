package com.example.lab1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {
    Button btnMenu;
    Button btnChooseColor;
    ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.popupBtn);
        btnChooseColor = findViewById(R.id.contextBtn);
        screen = findViewById(R.id.menu_layout);
        btnMenu.setOnClickListener(v -> {
            showMenu();
        });

        registerForContextMenu(btnChooseColor);
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.menuAdd) {
                btnMenu.setText("Menu Add");
            }
            else if(item.getItemId() == R.id.menuEdit) {
                btnMenu.setText("Menu Edit");
            }
            else if(item.getItemId() == R.id.menuDelete) {
                btnMenu.setText("Menu Delete");
            }
            return false;
        });

        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Choose color");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.yellowMenu) {
            screen.setBackgroundColor(Color.YELLOW);
        }
        else if(item.getItemId() == R.id.redMenu) {
            screen.setBackgroundColor(Color.RED);
        }
        else if(item.getItemId() == R.id.greenMenu) {
            screen.setBackgroundColor(Color.GREEN);
        }

        return super.onContextItemSelected(item);
    }
}
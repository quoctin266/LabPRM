package com.example.lab1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RandomnumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.randomnum_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.randomnum_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.generateBtn);
        EditText minEdt = findViewById(R.id.min);
        EditText maxEdt = findViewById(R.id.max);
        EditText resultEdt = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int max = Integer.parseInt(maxEdt.getText().toString());
                int min = Integer.parseInt(minEdt.getText().toString());

                Random random = new Random();
                int result = random.nextInt(max - min + 1) + min;
                resultEdt.setText(Integer.toString(result));
            }
        });
    }
}
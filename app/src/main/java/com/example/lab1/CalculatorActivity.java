package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.Random;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculator_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button plusBtn = findViewById(R.id.plus);
        Button minusBtn = findViewById(R.id.minus);
        Button multiplyBtn = findViewById(R.id.multiply);
        Button divideBtn = findViewById(R.id.divide);

        EditText firstNum = findViewById(R.id.first_number);
        EditText secondNum = findViewById(R.id.second_number);
        EditText calResult = findViewById(R.id.cal_result);

        plusBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int first = Integer.parseInt(firstNum.getText().toString());
                int second = Integer.parseInt(secondNum.getText().toString());

                int result = first + second;
                calResult.setText(Integer.toString(result));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int first = Integer.parseInt(firstNum.getText().toString());
                int second = Integer.parseInt(secondNum.getText().toString());

                int result = first - second;
                calResult.setText(Integer.toString(result));
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int first = Integer.parseInt(firstNum.getText().toString());
                int second = Integer.parseInt(secondNum.getText().toString());

                int result = first * second;
                calResult.setText(Integer.toString(result));
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                double first = Double.parseDouble(firstNum.getText().toString());
                double second = Double.parseDouble(secondNum.getText().toString());

                double result = first / second;

                DecimalFormat formatter = new DecimalFormat("#.##");

                calResult.setText(formatter.format(result));
            }
        });
    }
}
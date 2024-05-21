package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RelativeActivity extends AppCompatActivity {
    Button btn ;
    TextView signupText;
    EditText emailPhone;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.relative_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.relative_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = (Button)findViewById(R.id.loginBtn);
        signupText = findViewById(R.id.signupText);
        emailPhone = findViewById(R.id.emailPhone);
        password = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkInput()) return;
                startActivity(new Intent(RelativeActivity.this, RandomnumActivity.class));
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RelativeActivity.this, SignupActivity.class));
            }
        });
    }

    private boolean checkInput() {
        if(TextUtils.isEmpty(emailPhone.getText().toString())) {
            emailPhone.setError("Require");
            return false;
        }

        if(TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Require");
            return false;
        }

        return true;
    }
}
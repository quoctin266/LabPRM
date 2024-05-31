package com.example.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {
    Button btn ;
    TextView signinText;
    EditText emailPhone;
    EditText password;
    EditText confirmPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signup_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signup_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = (Button)findViewById(R.id.signupBtn);
        signinText = findViewById(R.id.signinText);
        emailPhone = findViewById(R.id.emailPhoneSignup);
        password = findViewById(R.id.passwordSignup);
        confirmPW = findViewById(R.id.confirmPW);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkInput()) return;

                SharedPreferences sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("emailPhone", emailPhone.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.apply();

                startActivity(new Intent(SignupActivity.this, RelativeActivity.class));
            }
        });

        signinText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, RelativeActivity.class));
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

        if(TextUtils.isEmpty(confirmPW.getText().toString())) {
            confirmPW.setError("Require");
            return false;
        }

        if(!TextUtils.equals(confirmPW.getText().toString(), password.getText().toString())) {
            Toast.makeText(this, "Passwords are not match", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}
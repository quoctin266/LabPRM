package com.example.lab1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1.custom.UserAdapter;
import com.example.lab1.model.User;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ArrayList<User> userList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView rvUser = findViewById(R.id.recycler_user);

        userList = new ArrayList<>();
        userList.add(new User("John123", "John Doe", "johndoe@gmail.com"));
        userList.add(new User("John123", "John Doe", "johndoe@gmail.com"));
        userList.add(new User("John123", "John Doe", "johndoe@gmail.com"));
        userList.add(new User("John123", "John Doe", "johndoe@gmail.com"));
        userList.add(new User("John123", "John Doe", "johndoe@gmail.com"));
        userList.add(new User("John123", "John Doe", "johndoe@gmail.com"));


        UserAdapter adapter = new UserAdapter(userList);

        rvUser.setAdapter(adapter);

        rvUser.setLayoutManager(new LinearLayoutManager(this));
    }
}

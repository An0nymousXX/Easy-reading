package com.example.easyreading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Books_page extends AppCompatActivity {

    private Button home, search,group, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_page);

        home = findViewById(R.id.button_home);
        search = findViewById(R.id.button_search);
        group = findViewById(R.id.button_group);
        profile = findViewById(R.id.button_profile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Books_page.this, Books_page.class));
            }
        });
    }
}
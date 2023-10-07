package com.example.admintrainline;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Path extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        Button tonsbm = findViewById(R.id.tonsbm);
        Button fromnsbm = findViewById(R.id.fromnsbm);

        tonsbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set = new Intent(Path.this, AnuradhapuraTrains.class);
                Path.this.
                        startActivity(set);
            }
        });
        fromnsbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent set = new Intent(Path.this, BadullaTrains.class);
                Path.this.
                        startActivity(set);
            }
        });
    }
}

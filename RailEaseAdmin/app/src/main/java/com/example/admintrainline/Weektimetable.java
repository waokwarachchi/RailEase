package com.example.admintrainline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.admintrainline.databinding.ActivityTimetableBinding;
import com.example.admintrainline.databinding.ActivityWeektimetableBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Weektimetable extends AppCompatActivity {
    private EditText atime,ltime,sstation,estation,day;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ActivityWeektimetableBinding binding;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weektimetable);
        binding = ActivityWeektimetableBinding.inflate(getLayoutInflater());

        atime = findViewById(R.id.atime);
        ltime = findViewById(R.id.ltime);
        sstation = findViewById(R.id.sstation);
        estation = findViewById(R.id.estation);
        day = findViewById(R.id.day);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Monday");

                String  Date = day.getText().toString().trim();
                String  Start = sstation.getText().toString().trim();
                String  End = estation.getText().toString().trim();
                String  Arrival = atime.getText().toString().trim();
                String  Departure = estation.getText().toString().trim();

                weektimehelper weektimehelper = new weektimehelper(Date,Start,End,Arrival,Departure);
                reference.child(Date).setValue(weektimehelper);

            }
        });

    }
}
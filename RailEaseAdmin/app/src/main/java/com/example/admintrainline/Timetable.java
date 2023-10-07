package com.example.admintrainline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admintrainline.databinding.ActivityTimetableBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Timetable extends AppCompatActivity {

    private EditText time, number, start, end;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private ActivityTimetableBinding binding;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        binding = ActivityTimetableBinding.inflate(getLayoutInflater());

        start = findViewById(R.id.sstation);
        end = findViewById(R.id.estation);
        time = findViewById(R.id.time);
        number = findViewById(R.id.number);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Timetable");

                String Time = time.getText().toString().trim();
                String Number = number.getText().toString().trim();
                String Start = start.getText().toString().trim();
                String End = end.getText().toString().trim();

                TimeHelper timeHelper = new TimeHelper(Time, Number, Start, End);
                reference.child(Number).setValue(timeHelper);

                // Display a success message
                Toast.makeText(Timetable.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

                // Clear the entered data from the form
                clearForm();
            }
        });
    }

    private void clearForm() {
        time.getText().clear();
        number.getText().clear();
        start.getText().clear();
        end.getText().clear();
    }
}

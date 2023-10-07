package com.example.admintrainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admintrainline.databinding.ActivityUpdatetimetableBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class Updatetimetable extends AppCompatActivity {
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    EditText time,number,start,end;
    Button save;
    ActivityUpdatetimetableBinding activityUpdatetimetableBinding;

    StorageReference ref;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatetimetable);
        activityUpdatetimetableBinding = ActivityUpdatetimetableBinding.inflate(getLayoutInflater());
        setContentView(activityUpdatetimetableBinding.getRoot());
        start = findViewById(R.id.sstation);
        end = findViewById(R.id.estation);
        time = findViewById(R.id.time);
        number = findViewById(R.id.number);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String time = activityUpdatetimetableBinding.time.getText().toString();
                String number = activityUpdatetimetableBinding.number.getText().toString();
                String start = activityUpdatetimetableBinding.sstation.getText().toString();
                String end = activityUpdatetimetableBinding.estation.getText().toString();


                updateData(time,number,start,end);


            }
        });

    }

    private void updateData(String time, String number, String start, String end) {
        HashMap User = new HashMap();
        User.put("number",number);
        User.put("start",start);
        User.put("end",end);
        User.put("time",time);
        reference = FirebaseDatabase.getInstance().getReference("Timetable");
        reference.child(number).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){

                    activityUpdatetimetableBinding.number.setText("");
                    activityUpdatetimetableBinding.sstation.setText("");
                    activityUpdatetimetableBinding.estation.setText("");
                    activityUpdatetimetableBinding.time.setText("");

                    Toast.makeText(Updatetimetable.this, "Successfully updated", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(Updatetimetable.this, "Failed to Update", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }


    }

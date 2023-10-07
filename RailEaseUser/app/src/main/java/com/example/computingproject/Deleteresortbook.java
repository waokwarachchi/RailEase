package com.example.computingproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.databinding.ActivityDeleteresortbookBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Deleteresortbook extends AppCompatActivity {

    ActivityDeleteresortbookBinding binding;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteresortbookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nic = binding.id.getText().toString();
                if (!nic.isEmpty()) {
                    checkAndDeleteData(nic);
                } else {
                    Toast.makeText(Deleteresortbook.this, "Enter the user NIC", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkAndDeleteData(final String nic) {
        reference = FirebaseDatabase.getInstance().getReference("Book");

        // Check if the NIC exists in the database
        Query query = reference.orderByChild("nic").equalTo(nic);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // NIC exists, proceed with deletion
                    deleteData(nic);
                } else {
                    // NIC does not exist, display an error message
                    Toast.makeText(Deleteresortbook.this, "NIC is incorrect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors or onCancelled events here
                Toast.makeText(Deleteresortbook.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteData(String nic) {
        reference.child(nic).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Deleteresortbook.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                    binding.id.setText("");
                } else {
                    Toast.makeText(Deleteresortbook.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package com.example.computingproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.computingproject.databinding.ActivityContactBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact extends AppCompatActivity {
    ActivityContactBinding binding;
    EditText Name, Email, Message;
    FirebaseDatabase db;
    DatabaseReference reference;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Name = findViewById(R.id.nameedt);
        Email = findViewById(R.id.emailedt);
        Message = findViewById(R.id.msgedt);

        binding.sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("ContactUs");
                String name = Name.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String message = Message.getText().toString().trim();

                // Create a Messageuser object
                Messageuser user = new Messageuser(name, email, message);

                // Push the user object to the database
                reference.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Display a success message using a Toast
                            Toast.makeText(Contact.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
                            clearFields(); // Clear input fields
                        } else {
                            // Handle the error, if any
                            Toast.makeText(Contact.this, "Failed to send message", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    // Helper method to clear input fields
    private void clearFields() {
        Name.setText("");
        Email.setText("");
        Message.setText("");
    }
}

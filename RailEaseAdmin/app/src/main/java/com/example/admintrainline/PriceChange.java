package com.example.admintrainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admintrainline.databinding.ActivityPriceChangeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PriceChange extends AppCompatActivity {

    private EditText train, firstclass, secondclass, thiredclz;
    private Button add;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ActivityPriceChangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_change);
        binding = ActivityPriceChangeBinding.inflate(getLayoutInflater());

        train = findViewById(R.id.train);
        firstclass = findViewById(R.id.first);
        secondclass = findViewById(R.id.second);
        thiredclz = findViewById(R.id.thired);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("TicketPrices");

                String Train = train.getText().toString().trim();
                String First = firstclass.getText().toString().trim();
                String Second = secondclass.getText().toString().trim();
                String Thired = thiredclz.getText().toString().trim();

                if (Train.isEmpty() || First.isEmpty() || Second.isEmpty() || Thired.isEmpty()) {
                    // Display a failure message if any field is empty
                    showToast("Please fill in all fields.");
                } else {
                    // Create a PriceHelper object and add data to the database
                    PriceHelper priceHelper = new PriceHelper(Train, First, Second, Thired);
                    reference.child(Train).setValue(priceHelper)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Display a success message if data is added successfully
                                        showToast("Data added successfully!");
                                        clearFields(); // Clear input fields
                                    } else {
                                        // Display a failure message if data couldn't be added
                                        showToast("Failed to add data.");
                                    }
                                }
                            });
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(PriceChange.this, message, Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        train.setText("");
        firstclass.setText("");
        secondclass.setText("");
        thiredclz.setText("");
    }
}

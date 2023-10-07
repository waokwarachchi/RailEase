package com.example.admintrainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admintrainline.databinding.ActivityPriceupdateBinding;
import com.example.admintrainline.databinding.ActivityUpdatetimetableBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Priceupdate extends AppCompatActivity {
    private EditText train,firstclass,secondclass,thiredclz;
    private Button add;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ActivityPriceupdateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priceupdate);
        binding = binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        train = findViewById(R.id.train);
        firstclass = findViewById(R.id.first);
        secondclass = findViewById(R.id.second);
        thiredclz = findViewById(R.id.thired);
        add = findViewById(R.id.add);
        
        
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String train = binding.train.getText().toString();
                String firstclass = binding.first.getText().toString();
                String secondclass = binding.second.getText().toString();
                String thiredclz = binding.thired.getText().toString();

                updateData(train,firstclass,secondclass,thiredclz);
            }
        });
        
    }

    private void updateData(String train, String firstclass, String secondclass, String thiredclz) {
        HashMap User = new HashMap();
        User.put("train",train);
        User.put("firstclass",firstclass);
        User.put("secondclass",secondclass);
        User.put("thiredclz",thiredclz);
        reference = FirebaseDatabase.getInstance().getReference("TicketPrices");
        reference.child(train).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){

                    binding.train.setText("");
                    binding.first.setText("");
                    binding.second.setText("");
                    binding.thired.setText("");

                    Toast.makeText(Priceupdate.this, "Successfully updated", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(Priceupdate.this, "Failed to Update", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}
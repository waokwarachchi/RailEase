package com.example.admintrainline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.admintrainline.databinding.ActivityEmailBinding;

public class Email extends AppCompatActivity {

    ActivityEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.email.getText().toString();
                String subjct = binding.subject.getText().toString();
                String message = binding.message.getText().toString();
                String[] addresses = email.split(",");

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT,subjct);
                intent.putExtra(Intent.EXTRA_TEXT,message);

                if(intent.resolveActivity(getPackageManager()) !=null){
                    startActivity(intent);
                }else{
                    Toast.makeText(Email.this, "No App in Installed", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
}
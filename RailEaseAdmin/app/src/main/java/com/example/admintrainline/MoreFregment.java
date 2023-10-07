package com.example.admintrainline;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MoreFregment extends Fragment {
    ImageButton email, time, msg, logoutbt;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


    public MoreFregment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_fregment, container, false);

        ImageButton email = (ImageButton) view.findViewById(R.id.email);
        ImageButton time = (ImageButton) view.findViewById(R.id.time);
        ImageButton msg = (ImageButton) view.findViewById(R.id.pushmsg);

        ImageButton logout = (ImageButton) view.findViewById(R.id.logoutbt);


        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("data");
        if(firebaseAuth.getCurrentUser()==null)
        {
            Intent intent = new Intent(MoreFregment.this.getActivity(), lgnpg.class);
            startActivity(intent);
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }

            private void openContact() {
                Intent intent = new Intent(MoreFregment.this.getActivity(), lgnpg.class);
                firebaseAuth.signOut();
                startActivity(intent);
            }
        });


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }

            private void openContact() {
                Intent intent = new Intent(MoreFregment.this.getActivity(), Email.class);
                startActivity(intent);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }

            private void openContact() {
                Intent intent = new Intent(MoreFregment.this.getActivity(), Timetable.class);
                startActivity(intent);
            }
        });
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }

            private void openContact() {
                Intent intent = new Intent(MoreFregment.this.getActivity(), Notificationweb.class);
                startActivity(intent);
            }
        });




        return view;
    }



}




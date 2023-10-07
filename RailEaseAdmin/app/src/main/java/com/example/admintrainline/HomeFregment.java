package com.example.admintrainline;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeFregment extends Fragment {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fregment, container, false);

        ImageView resort = (ImageView) view.findViewById(R.id.resort);
        ImageView price = (ImageView) view.findViewById(R.id.price) ;
        ImageView time =(ImageView) view.findViewById(R.id.time);
        ImageView weektime = (ImageView)view.findViewById(R.id.week);
        ImageView updatetime = (ImageView)view.findViewById(R.id.updatetime);
        ImageView updateprice = (ImageView)view.findViewById(R.id.updateprice);


        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPriceChange();
            }

            private void openPriceChange() {
                Intent intent = new Intent(HomeFregment.this.getActivity(),PriceChange.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimetable();

            }
        });
        weektime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeektimetable();

            }
        });
        updatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateTimetable();
            }
        });
        resort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResort();
            }
        });
        updateprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateprice();
            }
        });


        // Inflate the layout for this fragment
        return view;

    }

    private void openUpdateprice() {
        Intent intent = new Intent(HomeFregment.this.getActivity(),Priceupdate.class);
        startActivity(intent);
    }

    private void openResort() {
        Intent intent = new Intent(HomeFregment.this.getActivity(),Resorts.class);
        startActivity(intent);
    }

    private void openUpdateTimetable() {
        Intent intent = new Intent(HomeFregment.this.getActivity(),Updatetimetable.class);
        startActivity(intent);
    }

    private void openWeektimetable() {
        Intent intent = new Intent(HomeFregment.this.getActivity(),Path.class);
        startActivity(intent);
    }

    private void openTimetable() {
        Intent intent = new Intent(HomeFregment.this.getActivity(),Timetable.class);
        startActivity(intent);
    }

}
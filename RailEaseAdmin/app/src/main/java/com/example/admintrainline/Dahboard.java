package com.example.admintrainline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Dahboard extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    ImageButton email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dahboard);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_menu));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //initialized fegment
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:

                        fragment = new HomeFregment();
                        break;

                    case 2:
                        fragment = new MoreFregment();
                        break;
                    //when id is 3
                    //initialize resort fregment






                }
                //load fregment


                LoadFragment(fragment);

            }
        });

        bottomNavigation.show(1 ,true);

        //set


        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "Your Clicked"+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "You Reselected" +item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void LoadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fram_layout,fragment)
                .commit();
    }
    }

package com.example.admintrainline;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseHelper2 {

    private static final String ONLINE_DRIVERS = "anuradapura";

    private DatabaseReference onlineDriverDatabaseReference;


    public FirebaseHelper2(String driverId) {
        onlineDriverDatabaseReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(ONLINE_DRIVERS)
                .child(driverId);

        onlineDriverDatabaseReference
                .onDisconnect()
                .removeValue();
    }


    public void updateDriver(Driver driver) {
        onlineDriverDatabaseReference
                .setValue(driver);
    }

    public void deleteDriver() {
        onlineDriverDatabaseReference
                .removeValue();
    }

}

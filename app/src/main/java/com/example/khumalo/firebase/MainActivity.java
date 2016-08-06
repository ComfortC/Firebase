package com.example.khumalo.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    Firebase myFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://handy-sensor-136618.firebaseio.com/");
    }

    public void WriteToDatabase(View view) {
        myFirebaseRef.child("Comfort").setValue("My First Ever BackEndMessage");
    }
}

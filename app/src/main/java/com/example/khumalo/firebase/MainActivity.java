package com.example.khumalo.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase myFirebaseRef;
    TextView Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Message = (TextView)findViewById(R.id.message_display_textView);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://handy-sensor-136618.firebaseio.com/");
        myFirebaseRef.child("Comfort").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Message.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
               Message.setText("An Error Occured");
            }
        });
    }

    public void WriteToDatabase(View view) {
        myFirebaseRef.child("Comfort").setValue("My First Ever BackEndMessage");
    }
}

package com.example.mad_p02_exercise;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {
    public static String stored_username;
    public static String stored_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        EditText user_username = findViewById(R.id.userInput_username);

        EditText user_password = findViewById(R.id.userInput_password);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mad-exercise6-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("Users");

        // Read from the database
        myRef.child("mad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stored_username = dataSnapshot.child("username").getValue().toString();
                stored_password = dataSnapshot.child("password").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        Button submitLoginDetails = findViewById(R.id.submit_login);
        submitLoginDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entered_username = user_username.getText().toString();
                String entered_password = user_password.getText().toString();

                if (stored_username.equals(entered_username) && stored_password.equals(entered_password)){
                    Intent intent2 = new Intent(LoginPage.this, ListActivity.class);
                    startActivity(intent2);
                }
            }
        });
    }
}
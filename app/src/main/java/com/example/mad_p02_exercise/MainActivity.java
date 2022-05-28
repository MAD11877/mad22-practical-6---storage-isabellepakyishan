package com.example.mad_p02_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String imported_userName = intent.getStringExtra("User Name");
        String imported_userDescription = intent.getStringExtra("User Description");
        int imported_userId = intent.getIntExtra("User ID", 0);
        boolean imported_userIsFollowing = intent.getBooleanExtra("User Following", false);

        User importedUser = new User(imported_userName, imported_userDescription, imported_userId, imported_userIsFollowing);

        TextView userName = findViewById(R.id.name);
        String userNameWithNum = importedUser.Name;
        userName.setText(userNameWithNum);

        TextView userDescription = findViewById(R.id.description);
        userDescription.setText(importedUser.Description);

        Button userFollowed = findViewById(R.id.followed);

        if (importedUser.Followed = true){
            userFollowed.setText("Unfollow");
        }

        userFollowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (importedUser.Followed){
                    userFollowed.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_LONG).show();
                    importedUser.Followed = false;
                }
                else {
                    userFollowed.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_LONG).show();
                    importedUser.Followed = true;
                }
            }
        });

        Button userMessage = findViewById(R.id.message);
        userMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent2);
            }
        });
    }
}

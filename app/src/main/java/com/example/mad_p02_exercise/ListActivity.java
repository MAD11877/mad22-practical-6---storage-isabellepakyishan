package com.example.mad_p02_exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<User>();
        for (int i = 0; i < 20; i++){
            Random randomNo = new Random();

            int userId = Math.abs(randomNo.nextInt()/1000);
            String userName = "Name" + userId;
            String userDescription = "Description " + Math.abs(randomNo.nextInt()/1000);
            boolean userIsFollowing = randomNo.nextInt(2)==1;

            userList.add(new User(userName, userDescription, userId, userIsFollowing));
        }

        RecyclerView profile_rcv = findViewById(R.id.profile_rcv);
        ProfileAdapter profileAdapter = new ProfileAdapter(userList);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        profile_rcv.setLayoutManager(layout);
        profile_rcv.setAdapter(profileAdapter);

//        ImageView imageProfile = (ImageView) findViewById(R.id.imageProfile);
//        imageProfile.setClickable(true);
//        imageProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder ab = new AlertDialog.Builder(ListActivity.this);
//                ab.setTitle("Profile")
//                    .setMessage("Isabelle Pak")
//                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    })
//                    .setPositiveButton("View", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Random random = new Random();
//                            Intent intent1 = new Intent(ListActivity.this, MainActivity.class);
//                            intent1.putExtra("randomInt", Math.abs(random.nextInt()/1000));
//                            startActivity(intent1);
//                        }});
//                ab.show();
//            }
//        });
    }
}
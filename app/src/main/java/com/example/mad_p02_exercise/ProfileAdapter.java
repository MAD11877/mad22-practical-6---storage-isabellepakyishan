package com.example.mad_p02_exercise;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {
    ArrayList<User> userArrayList;
    public ProfileAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View profileItemView = null;

        for (User tempUser : userArrayList){
            String tempUserId_string = Integer.toString(tempUser.Id);

            if (viewType == 1){
                profileItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profilewith7_rcv, parent, false);
            }
            else {
                profileItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profiles_rcv, parent, false);
            }
        }
        return new ProfileViewHolder(profileItemView);
    }

    @Override
    public int getItemViewType(int position) {
        int userId_Length = Integer.toString(userArrayList.get(position).Id).length();
        int userId_check7 = Integer.toString(userArrayList.get(position).Id).lastIndexOf("7") + 1;

        if (userId_Length - userId_check7 == 0){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        User currentUser = userArrayList.get(position);
        String userName_txt = currentUser.Name;
        String userDescription_txt = currentUser.Description;
        int userId_int = currentUser.Id;
        boolean userIsFollowing_bool = currentUser.Followed;

        holder.userNameTxt.setText(userName_txt);
        holder.userDescriptionText.setText(userDescription_txt);

        holder.userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab = new AlertDialog.Builder(v.getContext());
                ab.setTitle("Profile")
                    .setMessage(userName_txt)
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent1 = new Intent(v.getContext(), MainActivity.class);

                            intent1.putExtra("User Name", userName_txt);
                            intent1.putExtra("User Description", userDescription_txt);
                            intent1.putExtra("User ID", userId_int);
                            intent1.putExtra("User Following", userIsFollowing_bool);

                            v.getContext().startActivity(intent1);
                        }});
                ab.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}

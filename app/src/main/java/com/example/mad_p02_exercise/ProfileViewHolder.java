package com.example.mad_p02_exercise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {
    TextView userNameTxt;
    TextView userDescriptionText;
    ImageView userProfilePic;

    public ProfileViewHolder(View viewItem){
        super(viewItem);

        userNameTxt = viewItem.findViewById(R.id.userName);
        userDescriptionText = viewItem.findViewById(R.id.userDescription);
        userProfilePic = viewItem.findViewById(R.id.userProfilePicture);
    }
}

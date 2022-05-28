package com.example.mad_p02_exercise;

public class User {
    public String Name;
    public String Description;
    public int Id;
    public boolean Followed;

    public User(){

    }

    public User(String name, String description, int id, boolean followed){
        Name = name;
        Description = description;
        Id = id;
        Followed = followed;
    }
}



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

    public void setUserName(String name){
        this.Name = name;
    }
    public String getUserName(){
        return this.Name;
    }

    public void setUserDescription(String description){
        this.Description = description;
    }
    public String getUserDescription(){
        return this.Description;
    }

    public void setUserId(int id){
        this.Id = id;
    }
    public int getUserId(){
        return this.Id;
    }

    public void setUserFollowed(boolean followed){
        this.Followed = followed;
    }
    public boolean getUserFollowed(){
        return this.Followed;
    }
}



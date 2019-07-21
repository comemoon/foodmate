package com.example.foodmate.fragments.Pacfragment1.recyclepart;

public class recycleformation {
    private int imageid;
    private String name;
    private int like;
    public recycleformation(int imageid,String name){
        this.imageid=imageid;
        this.name=name;
        //this.like=like;
    }

    public int getImageid() {
        return imageid;
    }

    public String getName() {
        return name;
    }

    public int getLike() {
        return like;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setName(String name) {
        this.name = name;
    }
}

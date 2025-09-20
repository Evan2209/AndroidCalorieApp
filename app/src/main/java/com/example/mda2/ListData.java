package com.example.mda2;

//adding fields
public class ListData {
    String name, time;
    int ingredients, desc;
    int image;
    int calories;
    //initializing fields
    public ListData(String name, String time, int ingredients, int desc, int image, int calories) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
        this.desc = desc;
        this.image = image;
        this.calories = calories;
    }

    //getter for calories
    public int getCalories() {
        return calories;
    }
}

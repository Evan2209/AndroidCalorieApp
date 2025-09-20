package com.example.mda2;

import java.util.ArrayList;

public class Basket {
    private static Basket instance;
    private ArrayList<ListData> items = new ArrayList<>();

    private int totalCalories = 0;

    private Basket() {
        items = new ArrayList<>();
        totalCalories = 0;
    }

    public static Basket getInstance() {
        if (instance == null) {
            instance = new Basket();
        }
        return instance;
    }

    public void addItem(ListData item) {
        items.add(item);
        totalCalories += item.getCalories();
    }

    public void removeItem(ListData item) {
        if (items.contains(item)) {
            items.remove(item);
            totalCalories -= item.getCalories();
        }
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public ArrayList<ListData> getItems() {
        return items;
    }

}

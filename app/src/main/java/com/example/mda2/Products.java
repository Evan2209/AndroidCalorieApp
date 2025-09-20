package com.example.mda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

//import com.example.mda2.databinding.ActivityMainBinding;
import com.example.mda2.databinding.ActivityProductsBinding;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    ActivityProductsBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.salmon, R.drawable.porridge, R.drawable.peasoup, R.drawable.beetroot, R.drawable.rice, R.drawable.chicken, R.drawable.beef};
        int[] ingredientList = {R.string.salmonIngredients, R.string.porridgeIngredients, R.string.peaSoupIngredients, R.string.beetrootIngredients, R.string.RiceIngredients, R.string.chickenIngredients, R.string.beefIngredients};
        int[] descList = {R.string.salmonDesc, R.string.porridgeDesc, R.string.peaSoupDesc, R.string.beetrootDesc, R.string.riceDesc, R.string.chickenDesc, R.string.beefDesc};
        String[] nameList = {"Salmon", "Porridge", "Pea soup", "Beetroot salad", "Rice", "Chicken", "Beef"};
        String[] timeList = {"30 mins", "2 mins", "25 mins", "10 mins", "60 mins", "45 mins", "30 mins"};
        int[] calorieList = {300, 150, 400, 250, 500, 550, 600};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i], calorieList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(Products.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //go to the detailed directory
                Intent intent = new Intent(Products.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("calories", calorieList[i]);
                startActivityForResult(intent, 1);
            }
        });

        binding.viewBasket.setOnClickListener(view -> {
            Intent intent = new Intent(Products.this, CalorieCount.class);
            startActivity(intent);
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode == RESULT_OK) {
            int totalCalories = data.getIntExtra("totalCalories", 0);
            binding.calorieCount.setText("Total calories: " + totalCalories);
        }
    }
}
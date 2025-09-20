package com.example.mda2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;

import java.util.ArrayList;

public class CalorieCount extends AppCompatActivity {
    TextView totalCalories;
    ListView basketListView;
    ListAdapter basketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calorie_count);

        totalCalories = findViewById(R.id.totalCalories);
        basketListView = findViewById(R.id.basketListView);

        ArrayList<ListData> basketItems = Basket.getInstance().getItems();
        basketAdapter = new ListAdapter(this, basketItems);
        basketListView.setAdapter((basketAdapter));

        totalCalories.setText("Total Calories: " + Basket.getInstance().getTotalCalories());

        basketListView.setOnItemLongClickListener((adapterView, view, position, id) -> {
            ListData item = basketItems.get(position);
            Basket.getInstance().removeItem(item);
            basketAdapter.notifyDataSetChanged();
            totalCalories.setText("Total Calories: " + Basket.getInstance().getTotalCalories());

            Toast.makeText(this, item.name + " removed from basket", Toast.LENGTH_SHORT).show();

            return true;

        });

    }

}

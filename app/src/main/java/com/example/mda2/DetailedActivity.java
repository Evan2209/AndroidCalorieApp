package com.example.mda2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.mda2.databinding.ActivityDetailedBinding;
import android.widget.*;

public class DetailedActivity extends AppCompatActivity {
    ActivityDetailedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        // Retrieve views
        ImageView productImage = findViewById(R.id.detailImage);
        TextView productName = findViewById(R.id.detailName);
        TextView productTime = findViewById(R.id.detailTime);
        TextView productIngredients = findViewById(R.id.detailIngredients);
        TextView productDescription = findViewById(R.id.detailDesc);
        Button addToBasketButton = findViewById(R.id.addToBasketButton);
        TextView productCalories = findViewById(R.id.detailCalories);


        // Get data from intent
        String name = getIntent().getStringExtra("name");
        String time = getIntent().getStringExtra("time");
        int ingredients = getIntent().getIntExtra("ingredients", 0);
        int desc = getIntent().getIntExtra("desc", 0);
        int image = getIntent().getIntExtra("image", 0);
        int calories = getIntent().getIntExtra("calories", 0);


        productName.setText(name);
        productTime.setText("Time: " + time);
        productIngredients.setText(getString(ingredients));
        productDescription.setText(getString(desc));
        productImage.setImageResource(image);
        productCalories.setText("Calories: " + calories);

        // Add to Basket button click
        addToBasketButton.setOnClickListener(view -> {
            ListData item = new ListData(name, time, ingredients, desc, image, calories);
            Toast.makeText(DetailedActivity.this, name + " added to basket!", Toast.LENGTH_SHORT).show();

            Basket.getInstance().addItem(item);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("totalCalories", Basket.getInstance().getTotalCalories());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
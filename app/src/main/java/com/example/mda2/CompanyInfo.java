package com.example.mda2;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.*;
import android.text.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CompanyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_company_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView hyperlink = findViewById(R.id.hyperlink);
        hyperlink.setText("https://www.healthline.com/nutrition/healthy-eating-tips#portion-control");


        TextView hyperlink1 = findViewById(R.id.hyperlink1);
        hyperlink1.setText("https://www.bbcgoodfood.com/health/family-health/top-5-healthy-family-meals");

    }
}
package com.example.mda2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnGoProducts = (Button) findViewById(R.id.btnProducts);
        btnGoProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goProducts = new Intent(getApplicationContext(), Products.class);
                startActivity(goProducts);
            }
        });

        Button btnGoContInfo = (Button) findViewById(R.id.btnContInfo);
        btnGoContInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goContInfo = new Intent(getApplicationContext(), ContactInfo.class);
                startActivity(goContInfo);
            }
        });

        Button btnGoCompInfo = (Button) findViewById(R.id.btnCompPolicy);
        btnGoCompInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCompPolicy = new Intent(getApplicationContext(), CompanyInfo.class);
                startActivity(goCompPolicy);
            }
        });

        Button btnGoFeedback = (Button) findViewById(R.id.btnFeedback);
        btnGoFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goFeedback = new Intent(getApplicationContext(), Feedback.class);
                startActivity(goFeedback);
            }
        });

        Button btnGoHelp = (Button) findViewById(R.id.btnHelp);
        btnGoHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHelp = new Intent(getApplicationContext(), Help.class);
                startActivity(goHelp);
            }
        });
    }
}
package com.example.mda2;

import android.content.*;
import android.net.*;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_help);

        Button btnFindUs = findViewById(R.id.btnFindUs);

        btnFindUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // company address
                String companyAddress = "123-125 Millfield, Belfast BT1 1HS";

                //create URI for google maps navigation
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + Uri.encode(companyAddress));

                //create Intent for google maps
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                //check if google maps is installed
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    //show message if not installed
                    Toast.makeText(Help.this, "Google maps is not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }//onCreate
}//class

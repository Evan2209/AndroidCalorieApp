package com.example.mda2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback);

        EditText txtFeedback = findViewById(R.id.txtFeedback);
        Button btnSaveFeedback = findViewById(R.id.btnSaveFeedback);
        Button btnViewFeedback = findViewById(R.id.btnViewFeedback);
        TextView txtSavedFeedback = findViewById(R.id.txtsavedFeedback);

        btnSaveFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = txtFeedback.getText().toString();
                if (feedback.isEmpty()) {
                    Toast.makeText(Feedback.this, "Pleasae Enter Feedback", Toast.LENGTH_SHORT).show();
                    return;
                }

                //save to file
                try(FileOutputStream fos = openFileOutput("feedback.txt", MODE_APPEND)) {
                    fos.write((feedback + "\n").getBytes());
                    Toast.makeText(Feedback.this, "Feedback saved!", Toast.LENGTH_SHORT).show();
                    txtFeedback.setText("");
                } catch (Exception e) {
                    Toast.makeText(Feedback.this, "Error Saving Feedback!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read from file
                try (FileInputStream fis = openFileInput("feedback.txt");
                     InputStreamReader isr = new InputStreamReader(fis);
                     BufferedReader br = new BufferedReader(isr)) {

                    String feedbackData = new String();
                    String line;

                    while((line = br.readLine()) != null) {
                        feedbackData += line + "\n";
                    }

                    if (feedbackData.length() == 0) {
                        txtSavedFeedback.setText("No Feedback Saved!");
                    } else {
                        txtSavedFeedback.setText(feedbackData.toString());
                    }

                } catch (Exception e) {
                    Toast.makeText(Feedback.this, "Error Reading Feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }//onCreate
}//class

package com.example.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Calendarclass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);

        // To remove ActionBar Title
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("");
        }

        // Retrieve the selected date from the Intent
        String selectedDate = getIntent().getStringExtra("selectedDate");

        // Find the TextView and set the selected date as its text
        TextView dateTextView = findViewById(R.id.datePicked);
        dateTextView.setText(selectedDate);

        // Set OnClickListener for the back button (now ImageView)
        ImageView backButton = findViewById(R.id.calendarBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to handle back button click
                onBackButtonClick();
            }
        });

        // Find the ImageView for date picker and set OnClickListener
        ImageView datePickerButton = findViewById(R.id.ivDate);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to open date picker
                openDatePicker();
            }
        });
    }

    // Method to handle back button click
    private void onBackButtonClick() {
        // Navigate back to the previous activity
        finish();
    }

    // Method to open date picker
    private void openDatePicker() {
        // Get current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.DialogTheme,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                        // Construct the selected date in the desired format
                        String selectedDate = String.format("%d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDayOfMonth);

                        // Log the selected date for testing
                        Log.i("DatePicker", "Selected Date: " + selectedDate);

                        // Update the text view with the selected date
                        TextView dateTextView = findViewById(R.id.datePicked);
                        dateTextView.setText(selectedDate);
                    }
                }, year, month, dayOfMonth);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}
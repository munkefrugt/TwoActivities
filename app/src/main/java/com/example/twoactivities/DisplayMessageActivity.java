package com.example.twoactivities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class DisplayMessageActivity extends AppCompatActivity {

    // create this activity by following the steps "Create a new activity using Android Studio"
    // at http://developer.android.com/training/basics/firstapp/starting-activity.html

    // Im Just following the manual bliendly. but I dont think the Hierarchical Parent step is needed.
    // I just makes that the new created activity looks the same.. I think.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // I added this one.
        Log.i("Hi", "onCreate: New activity ");
    }

}

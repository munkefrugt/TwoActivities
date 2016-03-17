package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

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


        // FOLLOWING ADDED BY ME USING THE GUIDE:
        // I added this Log message not needed .
        Log.i("Hi", "onCreate: New activity ");

        // here we get the intent
        Intent intent = getIntent(); // maybe this should be made on class level?

        // Extract the message delivered by MainActivity with the getStringExtra() method.
        // I changed in the exmple on the android site the MainActivity is called MyActivity.
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // we add an textView object
        TextView textView = new TextView(this);

        // set size and set the text, "message" is  the name of the String we got from the intent.
        textView.setTextSize(40);
        textView.setText(message);

        //Add the TextView to the RelativeLayout identified by R.id.content.
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);


    }

}

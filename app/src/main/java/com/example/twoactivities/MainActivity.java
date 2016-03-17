package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // key name: EXTRA_MESSAGE, is used in the extra intent thing below in method "sendMessage(View view)"
public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // I did this method with help from http://developer.android.com/training/basics/firstapp/starting-activity.html
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {

        // 2 parameters:
        // A Context as its first parameter (this is used because the Activity class is a subclass
        // of Context)

        //  The Class of the app component to which the system should deliver the Intent
        // (in this case, the activity that should be started)
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // get the editText element from the TextView.
        //findViewById() when casted to (EditText ) givees us edit text.

        //IMPORTANT : There is a big difference between textView and editText. the EditText is a field the user can write in.
        //  and here it has to be editText
        EditText editText = (EditText) findViewById(R.id.edit_message);

        // get the text from the editText and make it into a string
        String message = editText.getText().toString();
        // add the text message to the intent.
        intent.putExtra(EXTRA_MESSAGE, message);
        //An Intent can carry data types as key-value pairs called extras.
        // The putExtra() method takes the key name in the first parameter and the value in the second parameter.
        // the EXTRA_MESSAGE is added in on class level.

        //to finish the intent, call the startActivity() method,
        // passing it the Intent object
        startActivity(intent);
    }
}

package com.Sara.pony.alert;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class DisplayMessageActivity extends Activity {

    @TargetApi(11)
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //every activity is invoked by an intent. we'll get the intent and the data we want
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        
        //Text View
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        
        setContentView(textView);
        
 // Default View      setContentView(R.layout.activity_display_message);
  //      getActionBar().setDisplayHomeAsUpEnabled(true);
    }

   

}

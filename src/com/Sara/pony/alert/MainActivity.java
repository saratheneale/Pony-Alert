package com.Sara.pony.alert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	private Button button1; //this is for webview button

	public final static String EXTRA_MESSAGE = "com.example.PonyAlert.MESSAGE";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		final Context context = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//For Webview Stuff:
		button1=(Button) findViewById(R.id.buttonUrl);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, WebViewActivity.class);
				startActivity(intent);
			}
		}); //wat is this ) i don't even know. method invocation??
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/** Called when the user clicks the CLOP button. tHE VIEW passed is the view the user clicked or sent */
	public void sendMessage(View view) {
		// Do something in response to button

		//An intent lets you start another activity and send data to it. 
		//I'm going to start the activity DisplayMessageActivity (defined later)
		Intent intent = new Intent(this, DisplayMessageActivity.class); 
		//Intents manage runtime binding between activities acording to documentation tutorial
		//Now get the data from the text box (Enter a pony!)
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		//Intents can store lots of data types as key-value pairs. Here putExtra  takes key, value. We're just making an extra copy of message I believe
		//We're defining the key to make it unique in case this app interacts with others. So, we'll use our package name as a prefix.
		intent.putExtra(EXTRA_MESSAGE, message);

		//we've contructed an Intent. Now we will start the activity.
		//Intents are created before starting an additional Activity
		startActivity(intent);

		Toast pieceToast= Toast.makeText(getApplicationContext(),"HAI TOAST!!!",Toast.LENGTH_LONG);
		//Show toast
		pieceToast.show();
	}
}

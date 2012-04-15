package com.pandaftp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pandaftp.utils.*;

public class mainShell extends Activity{

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    Button addButton = (Button)findViewById(R.id.buttonConnect);
	    addButton.setOnClickListener(add);
	}
	View.OnClickListener add = new View.OnClickListener() {
	    public void onClick(View v) {
	    	Intent i = new Intent(getApplicationContext(), serverDisplay.class);
	    	startActivity(i);
	    }
	  };
}

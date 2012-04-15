package com.pandaftp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pandaftp.utils.*;

public class serverDisplay extends Activity{

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.serverview);
	    
	    //Creating Buttons
	    Button addButton = (Button)findViewById(R.id.button_Add);
	    Button updateButton = (Button) findViewById(R.id.button_Update);
	    Button backButton = (Button) findViewById(R.id.button_back);
	    //Adding Listeners
	    addButton.setOnClickListener(add);
	    updateButton.setOnClickListener(update);
	    backButton.setOnClickListener(back);
	}
	
	View.OnClickListener add = new View.OnClickListener() {
	    public void onClick(View v) {
	      // it was the 1st button
	    }
	  };
	  View.OnClickListener update = new View.OnClickListener() {
		    public void onClick(View v) {
		      // it was the 1st button
		    }
		  };
		  View.OnClickListener back = new View.OnClickListener() {
			    public void onClick(View v) {
			    	Intent i = new Intent(getApplicationContext(), mainShell.class);
			    	startActivity(i);
			    }
			  };

}

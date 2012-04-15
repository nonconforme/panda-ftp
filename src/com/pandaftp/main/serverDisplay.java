package com.pandaftp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pandaftp.utils.*;

public class serverDisplay extends Activity{
private EditText host;
private EditText user;
private EditText pass;
private EditText port;
private EditText ip;
private String fetchedip;
private DatabaseHandler db = new DatabaseHandler(this);

	
public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.serverview);
	    
	    //Creating Buttons
	    Button addButton = (Button)findViewById(R.id.button_Add);
	    Button updateButton = (Button) findViewById(R.id.button_Update);
	    Button backButton = (Button) findViewById(R.id.button_back);
	    Button Ipfetch = (Button) findViewById(R.id.FindIP);
	    Button current = (Button) findViewById(R.id.buttonCurrent);
	    //Adding Listeners
	    addButton.setOnClickListener(add);
	    updateButton.setOnClickListener(update);
	    backButton.setOnClickListener(back);
	    Ipfetch.setOnClickListener(Ip);
	    current.setOnClickListener(currentlist);
	    //Adds TextBox info
	    host = (EditText) findViewById(R.id.servername);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        port = (EditText) findViewById(R.id.portnumber);
        ip = (EditText) findViewById(R.id.ipaddr);
        
	}
	
	View.OnClickListener add = new View.OnClickListener() {
	    public void onClick(View v) {	
	    
	    Server server = new Server();
	    server.setIpAddress(ip.getText().toString());
	    server.setServerName(host.getText().toString());
	    server.setPortNumber(Integer.parseInt(port.getText().toString()));
	    db.addServer(server);
	      //finish();
	    	//Intent i = new Intent(getApplicationContext(), serverList.class);
	    	//startActivity(i);
	    	//finish();
	    }
	  };
	  View.OnClickListener update = new View.OnClickListener() {
		    public void onClick(View v) {
		     Servers.EditServer(host.getText().toString(),ip.getText().toString(), pass.getText().toString(), user.getText().toString(),Integer.parseInt(port.getText().toString()));
		    }
		  };
		  View.OnClickListener back = new View.OnClickListener() {
			    public void onClick(View v) {
			    	finish();
			    	Intent i = new Intent(getApplicationContext(), mainShell.class);
			    	startActivity(i);
			    	finish();
			    }
			  };
			  View.OnClickListener Ip = new View.OnClickListener() {
				    public void onClick(View v) {
				    	fetchedip = ipfetch.getAddr(host.getText().toString());
				    	ip.setText(fetchedip);
				    }
				  };
				  View.OnClickListener currentlist = new View.OnClickListener() {
					    public void onClick(View v) {
					    	String[] push = Servers.info(host.getText().toString());
					    	ip.setText(push[0]);
					    	user.setText(push[1]);
					    	pass.setText(push[2]);
					    	port.setText(push[3]);
					    }
					  };
private boolean checkhost()
{
	
	for(int i =0;i < db.getServersCount();i++)
	{
		
	}
}
}

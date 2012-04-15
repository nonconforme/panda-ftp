package com.pandaftp.main;

import java.util.ArrayList;
import java.util.List;

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
private Server server = new Server();
	
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
	    
	    
	    server.setIpAddress(ip.getText().toString());
	    server.setServerName(host.getText().toString());
	    server.setPortNumber(Integer.parseInt(port.getText().toString()));
	    server.setPassword(pass.getText().toString());
	    server.setUserName(user.getText().toString());
	  // if(!checkhost())
	   // {
	    db.addServer(server);
	      //finish();
	    	//Intent i = new Intent(getApplicationContext(), serverList.class);
	    	//startActivity(i);
	    	//finish();
	  //  }
	    }
	  };
	  
	  
	  
	  View.OnClickListener update = new View.OnClickListener() {
		    public void onClick(View v) {
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
					    }
					  };
private boolean checkhost()
{
	
	boolean check = false;
	try
	{	
	List<Server> toList = new ArrayList<Server>();
	toList = db.getAllServers();
	
	String[] names = new String[db.getServersCount()];
	
	for (int x = 0; x < names.length; x++)
	{
		if(toList.get(x).getServerName().equals(host.getText().toString()))
		{
			check = true;
		}
	}
	}
	catch(Exception e)
	{
		System.out.println("E: " + e);
	}
	return check;
}
}
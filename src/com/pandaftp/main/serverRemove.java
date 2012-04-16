package com.pandaftp.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pandaftp.utils.DatabaseHandler;
import com.pandaftp.utils.Server;
import com.pandaftp.utils.ftpClass;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class serverRemove extends ListActivity{

	DatabaseHandler db = new DatabaseHandler(this);
	List<Server> toList = new ArrayList<Server>();
	
public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ListView lv = this.getListView();
		View header = getLayoutInflater().inflate(R.layout.deleteheader, null);
		lv.addHeaderView(header);
		
		try {
			
			if (db.getServersCount() == 0)
			{
				toList.add(new Server("No Servers Added."));
			}
			toList = db.getAllServers();
			
			
			
			String[] names = new String[db.getServersCount()];
			
			for (int x = 0; x < names.length; x++)
			{
				names[x] = toList.get(x).getServerName();
			}
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
			setListAdapter(adapter);
			
			
			
		} catch (Exception e)
		{
			Log.e("ERROR ", e.toString());
			e.printStackTrace();
		}
		
	}
	String item;
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		item = (String) getListAdapter().getItem(position);
		
		
		AlertDialog.Builder alert = new AlertDialog.Builder(this);                 
    	alert.setTitle("Are you sure?");  
    	alert.setMessage("Confirm Delete");                

 

    	    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
    	    public void onClick(DialogInterface dialog, int whichButton) {  
    	        	for (int x = 0; x < toList.size(); x++)
    	    		{
    	    			if (toList.get(x).getServerName().equalsIgnoreCase(item))
    	    			{
    	    				db.deleteServer(toList.get(x));
    	    				
    	    			}
    	    			
    	    		}
    	        	finish();
    	        	Intent i = new Intent(getApplicationContext(), serverRemove.class);
	                startActivity(i);
    	        return;                  
    	       }  
    	     });  

    	    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

    	        public void onClick(DialogInterface dialog, int which) {
    	            
    	            return;   
    	        }
    	    });
    	            alert.show();
		
		
	}
	
}

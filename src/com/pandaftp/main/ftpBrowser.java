package com.pandaftp.main;

import com.pandaftp.utils.ftpClass;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ftpBrowser extends ListActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (checkConnectionStatus())
        {
        
        ListAdapter adapter = createAdapter();
        setListAdapter(adapter);
        
        ListView lv = getListView();
          
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
   
                // selected item
                String product = ((TextView) view).getText().toString();
                if (product.contains("."))
                {
                	
                	// Launch Application
                } else {
                	ftpClass.setDirectoryName(ftpClass.getDirectoryName() + product);
                // Launching new Activity on selecting single List Item
                	Intent i = new Intent(getApplicationContext(), ftpBrowser.class);
                // sending data to new activity
                	//i.putExtra("additional", product);
                	startActivity(i);
                }
            }
          });
        
        
        } else {
        	System.out.print("Connection Attempts Were Rejected.");
        	// Connection Failed.
        }
    }
	
	protected boolean checkConnectionStatus()
	{
		if (ftpClass.getConnected())
			return true;
		else
		{ 
			//Setup for Testing Only!
			ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21);
			ftpClass.setDirectoryName("/");
			if (ftpClass.getConnected())
				return true;
			else
				return false;
		}
	}
	
	protected String[] getFilesAndFolders()
	{
		String files[];
		if (ftpClass.getConnected()) {
			files = ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());
			return files;
		} else {
			files = new String[1];
			files[0] = "No Files.";
			return files;
		}
			
			
	}
	
	 protected ListAdapter createAdapter()
	 {
		String[] Files;
		 	
		Files = getFilesAndFolders();
	   
	    ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.dirlist, Files);
	 
	    return adapter;
	 }
	
}

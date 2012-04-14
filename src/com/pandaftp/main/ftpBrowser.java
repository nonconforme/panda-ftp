package com.pandaftp.main;

import java.io.File;

import com.pandaftp.utils.*;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

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
                //String product = ((TextView) view).getText().toString();
            	Object o = parent.getAdapter().getItem(position);
				String product = o.toString();
            	if (product.contains("."))
                {
                	
                	// Launch Application
                } else {
                	File file = new File(product);
             
                	ftpClass.setDirectoryName(ftpClass.getDirectoryName() + file.getName());
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
			ftpClass.setDirectoryName("\\");
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
	   
	    //ListAdapter adapter = new ArrayAdapter<String>(this, R.id.textView1, Files);
		listAdapter adapter = new listAdapter(this, Files);
	    return adapter;
	 }
	 
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	     MenuInflater inflater = getMenuInflater();
	     inflater.inflate(R.layout.menuftp, menu);
	     return true;
	 }
	 
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
	     switch (item.getItemId()) {
	         case R.id.upload:     Toast.makeText(this, "Upload!", Toast.LENGTH_LONG).show();
	                             break;
	         case R.id.download:     Toast.makeText(this, "Download!", Toast.LENGTH_LONG).show();
	                             break;
	         case R.id.open: Toast.makeText(this, "Open!", Toast.LENGTH_LONG).show();
	                             break;
	     }
	     return true;
	 }
	
}

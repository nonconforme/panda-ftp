/**
 * 
 */
package com.pandaftp.main;

import com.pandaftp.utils.*;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * @author jacob
 *
 */
public class directory_list extends ListActivity {
	public String[] filenames;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21)) {
        	filenames = ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());

        if (filenames != null)
	  	{	  		
        	//View header = getLayoutInflater().inflate(R.id.header, null);
    		//ListView listView = getListView();
    		//listView.addHeaderView(header);
        	listAdapter adapter = new listAdapter(this, filenames);
			setListAdapter(adapter);
			
        } else {
        	
        	
        }
        }
       
 }
	


}

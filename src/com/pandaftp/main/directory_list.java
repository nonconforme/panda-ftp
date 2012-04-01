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

        
        
        
       
       if (ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21)) {
    	   
    	   new AlertDialog.Builder(this)
			.setTitle("Connected?")
			 .setPositiveButton("YES!",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialoginterface,
								int i) {
						}
						
					})
					.show();
    	   
    	  filenames = ftpClass.ftpGetCurrentWorkingDirectory("");
    	  	if (filenames != null)
    	  	{	  		
    	  		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.dirlist, R.id.label, filenames));
  	
        } else {
        	 
        		
        }
       
    }
 }

}

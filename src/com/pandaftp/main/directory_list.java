/**
 * 
 */
package com.pandaftp.main;


import org.apache.commons.net.ftp.FTP;

import com.pandaftp.utils.*;


import android.R;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author jacob
 *
 */
public class directory_list extends ListActivity {
	public String[] filenames;
	public String oldDir;
	public static listAdapter adap;
	
	static class ViewHolder {
		public TextView text;
		public ImageView image;
	}
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (ftpClass.getConnected())
        {
       
        
        
        	
        filenames = ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());
        	
        
        if (filenames != null)
	  	{	  		
        	
        	adap = new listAdapter(this, filenames);
			setListAdapter(adap);
        	
	  	}	 
			
        
        ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener() {
			
			    public void onItemClick(AdapterView<?> parent, View view,
			        int position, long id) {
				
			    	//String product = ((TextView) view).getText().toString();
			    	Object o = parent.getAdapter().getItem(position);
					String keyword = o.toString();
					
					if (keyword.contains("."))
					{
						// Open File Bro
					} else {
						oldDir = ftpClass.getDirectoryName();
						if (ftpClass.getDirectoryName().startsWith("\\"))
							ftpClass.setDirectoryName(keyword);
						else
						ftpClass.setDirectoryName("\\" + keyword);
						
						filenames =  ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());
						
						 
			              // Launching new Activity on selecting single List Item
			              Intent i = new Intent(getApplicationContext(), directory_list.class);
			              // sending data to new activity
			              
			              startActivity(i);
			    	
				}
			    }
				
			});
        
        } else {
        	 ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21);
        	 Intent i = new Intent(getApplicationContext(), directory_list.class);
             // sending data to new activity
             
             startActivity(i);
        }
        
        }

	}


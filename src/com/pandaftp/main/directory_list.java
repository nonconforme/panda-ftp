/**
 * 
 */
package com.pandaftp.main;


import org.apache.commons.net.ftp.FTP;

import com.pandaftp.utils.*;


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
	private String[] values;

	
	static class ViewHolder {
		public TextView text;
		public ImageView image;
	}
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ftpClass.setDirectoryName("/");
        if(ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21)) {
        	filenames = ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());

        if (filenames != null)
	  	{	  		
        	
        	listAdapter adapter = new listAdapter(this, filenames);
			setListAdapter(adapter);
        	
        	 
			ListView list = getListView();
			list.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					
					Object o = parent.getAdapter().getItem(position);
					String keyword = o.toString();
					if (keyword.contains("."))
					{
						// Open File Bro
					} else {
						String oldDir = ftpClass.getDirectoryName();
						ftpClass.setDirectoryName(ftpClass.getDirectoryName() + "\\" + keyword);
						filenames =  ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());
						
						if (filenames != null || filenames.length != 0)
						{
							listAdapter ad = new listAdapter(getApplicationContext(), filenames);
							setListAdapter(ad);
						}  else 
						{
							filenames[0] = "No Files in Directory.";
							listAdapter ad = new listAdapter(getApplicationContext(), filenames);
							setListAdapter(ad);
							ftpClass.setDirectoryName(oldDir);
						
						}
					}
				}
				
			});
			

			} else {
				filenames[0] = "No Files Exist.";
				listAdapter adapter = new listAdapter(this, filenames);
				setListAdapter(adapter);
        }
        
        }    


	}
}

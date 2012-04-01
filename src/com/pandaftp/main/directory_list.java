/**
 * 
 */
package com.pandaftp.main;

import com.pandaftp.utils.*;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author jacob
 *
 */
public class directory_list extends ListActivity {
	public String[] filenames;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        
        
       
       if (ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21)) {
    	   
    	  filenames = ftpClass.ftpGetCurrentWorkingDirectory("");
    	  	if (filenames != null)
    	  	{	  		
    	  		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.dirlist, R.id.label, filenames));

    	  
  	
        } else {
        	 
        		
        }
       
    }
 }
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		registerForContextMenu(l);
}


}

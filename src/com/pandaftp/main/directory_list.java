/**
 * 
 */
package com.pandaftp.main;


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

        if(ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21)) {
        	filenames = ftpClass.ftpGetCurrentWorkingDirectory(ftpClass.getDirectoryName());

        if (filenames != null)
	  	{	  		
        	
        	listAdapter adapter = new listAdapter(this, filenames);
			setListAdapter(adapter);
        	//this.setListAdapter(new ArrayAdapter<String>(this, R.layout.listed_items, R.id.label, filenames));
        		
        	
        	
        	ListView lv = getListView();
        	 
            // listening to single list item on click
            lv.setOnItemClickListener(new OnItemClickListener() {
              public void onItemClick(AdapterView<?> parent, View view,
                  int position, long id) {
     
                  // selected item
                  String product = ((TextView) view).getText().toString();
                  ftpClass.setDirectoryName(product);
                  // Launching new Activity on selecting single List Item
                  Intent i = new Intent(getApplicationContext(), directory_list.class);
                  // sending data to new activity
                  startActivity(i);
     
              }
            }); 

        } else {       	
        }
        }    
 }
}

package com.pandaftp.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.pandaftp.utils.*;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ftpBrowser extends ListActivity {
	Object o;
	
	BufferedOutputStream fos = null;
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
            	String product;

            	o = parent.getAdapter().getItem(position);
				product = o.toString();
		
            	if (product.contains("."))
                {
            		File file = new File(product);
            		utilities.message("Now Downloading File. Please Hold.", view.getContext());
            		
            		try {
            			ftpClass.ftpclient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
            			
            			            		
            			File sdDir = Environment.getExternalStorageDirectory();
            			
            			/*if (checkAudio(product))
            				fos = new BufferedOutputStream(new FileOutputStream("/sdcard/Music/" + file.getName()));
            			else if (checkPicture(product))
            				fos = new BufferedOutputStream(new FileOutputStream("/sdcard/Pictures/" + file.getName()));
            			else if (checkMovie(product))
            				fos = new BufferedOutputStream(new FileOutputStream("/sdcard/Movies/" + file.getName()));
            			else
            				fos = new BufferedOutputStream(new FileOutputStream("/sdcard/Download/" + file.getName()));
	            		*/
            			
            			fos = new BufferedOutputStream(new FileOutputStream("/sdcard/" + file.getName()));
	            		if (ftpClass.ftpclient.retrieveFile(ftpClass.getDirectoryName() + file.getName(), fos)) {
	            			utilities.message("finished " + file.getName(), view.getContext());
	            			utilities.localfiles(view.getContext(), "/");
						}
						
					} catch (Exception e) {
						utilities.message("Error " + e, view.getContext());		
						e.printStackTrace();
					}
            		finally {
                        try {
                            if (fos != null) 
                            	fos.close();
                            	utilities.message("Download Complete", view.getContext());
                            }
                            catch (IOException e) {
                            	utilities.message("Error " + e, view.getContext());
                                e.printStackTrace();
                                }
                            }
                } else {
                	
                	File file = new File(product);

						ftpClass.setDirectoryName(ftpClass.getDirectoryName() + file.getName() + "/");
						System.out.println("Wkjak: " + ftpClass.getDirectoryName());
                	
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
	
	protected boolean checkAudio(String product)
	{
		if ( product.contains(".mp3") || (product.contains(".wav") || (product.contains(".wma") || (product.contains(".mp4") || product.contains(".m4a") || product.contains(".flac") || product.contains(".ogg")))))                 
			return true;
		else
			return false;
	}
	
	protected boolean checkPicture(String product)
	{
		if (product.contains(".gif") || product.contains(".jpg") || product.contains(".png") || product.contains(".jpeg") || product.contains(".bmp") || product.contains(".tif"))
			return true;
		else
			return false;
	}
	
	protected boolean checkMovie(String product)
	{
		if (product.contains(".mpg") || product.contains(".mpeg") || product.contains(".avi") || product.contains(".mov") || product.contains(".mkv") || product.contains(".flv"))
			return true;
		else
			return false;
	}
	
	protected boolean checkConnectionStatus()
	{
		if (ftpClass.getConnected())
			return true;
		else
		{ 
			//Setup for Testing Only!
			ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21);
			//ftpClass.setDirectoryName("");
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
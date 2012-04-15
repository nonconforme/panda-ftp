package com.pandaftp.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Set;
import com.pandaftp.utils.ftpClass;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.pandaftp.main.R;
import com.pandaftp.utils.listAdapter;
//import android.os.Bundle;

public class utilities {

	//Displays Errors Located in Strings Allows for later on translations
	public static void errorbox(int code,Context c){
		code = code-1;//allows so that listed codes in strings.xml are logical
		String[] items = c.getResources().getStringArray(R.array.Error);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setMessage(items[code])
		       .setCancelable(false)
		       .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       }).show();
		//AlertDialog alert = builder.create();
	}
	
	public static void upload(String filename)
	{
		FileInputStream fis = null;
		File theCheck = new File(filename);

		try
		{
				fis = new FileInputStream(filename);
		        if (ftpClass.ftpclient.storeFile(ftpClass.getDirectoryName() + theCheck.getName(), fis))
		        	System.out.println("Upload Complete");
		        else
		        	System.out.println("Upload Failed");
		        //fis.close();
		}
		catch (Exception e)
		{
			System.out.println("Error U: " + e);
		    e.printStackTrace();
		} finally {	
			try {
			if (fis != null) {	
				fis.close();
				System.out.println("Fis closed.");
			}
			} catch (IOException e) {
				System.out.println("Error U: " + e);
				e.printStackTrace();	
			}

		}
	}
	//Lets you Browse Local Directory
	public static void localfiles(final Context c, final String Directory)
	{
		File dir = new File(Directory);
		final String[] files = dir.list();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setTitle("Pick a File")
				.setCancelable(true);
		builder.setItems(files, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Toast.makeText(c, files[item], Toast.LENGTH_SHORT).show();
		        if(!isFile(files[item])){
		        String Direct = Directory+ files[item];
		        utilities.localfiles(c,Direct);
		        }
		    }
		})
		
		.show();
	}
	//If wanting to create new Browsing directory.
	public void browse(final Context c,String Directory)
	{
		File dir = new File(Directory);
		final String[] files = dir.list();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setTitle("Pick a File")
				.setCancelable(true);
		builder.setItems(files, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Toast.makeText(c, files[item], Toast.LENGTH_SHORT).show();
		    }
		})
		
		.show();
	}
	//Notifys if its a file or a Directory
	public static boolean isFile(String selection)
	{
		boolean is =false;
		char[] selectionArray = selection.toCharArray();
		
		for(int i =0;i < selectionArray.length;i++ )
		{
			if(selectionArray[i]=='.')
			{
				is =true;
			}
		}
		
		return is;
	} 
	//Browsing Using Jakes File Browser
	public static void listBrowser(final Context c, final String Directory)
	{
		File dir = new File(Directory);
		final String[] files = dir.list();
		listAdapter adapter = new listAdapter(c, files);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setTitle("Pick a File")
				.setCancelable(true);
		builder.setAdapter(adapter,new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	
		        if(!isFile(files[item])){
		        String Direct = Directory + files[item];
		        //For Confirming  if there's any thing inside the directory
		        File nDir = new File(Direct);
		        String[] nFiles = nDir.list();
		        if(nFiles == null)
		        {
		        	utilities.errorbox(2, c);
		        }
		        else
		        {
		        	utilities.listBrowser(c,Direct);
		        }
		        
		        } else {
		        	upload(Directory + "/" + files[item]);
		        }
		    }
		})
		
		.show();
	}
	public static void ftpBrowser(final Context c, final String Directory)
	{
		
		final String[] files;
		files = ftpClass.ftpGetCurrentWorkingDirectory(Directory);
		listAdapter adapter = new listAdapter(c, files);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setTitle("Pick a File")
				.setCancelable(true);
		builder.setAdapter(adapter,new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        if(!isFile(files[item])){
		        	String Directory = ftpClass.getDirectoryName();
					String Selection = files[item];
					Directory = Directory + "/" + Selection;
					ftpClass.setDirectoryName(Directory);
		        utilities.ftpBrowser(c,Directory);
		        }
		    }
		})
		
		.show();
	}
	//Displays Custom Message
		public static void message(String message,Context c){
			
			AlertDialog.Builder builder = new AlertDialog.Builder(c);
			builder.setMessage(message)
			       .setCancelable(false)
			       .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       }).show();
			//AlertDialog alert = builder.create();
		}
}

package com.pandaftp.utils;

import java.io.ByteArrayInputStream;
import java.io.File;

import javax.annotation.Resource;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.widget.Toast;
import com.pandaftp.main.R;

public class utilities {

	public static void errorbox(int code,Context c){
		
		String[] items = c.getResources().getStringArray(R.array.Error);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setMessage(items[0])
		       .setCancelable(false)
		       .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       }).show();
		//AlertDialog alert = builder.create();
	}
	
	public static boolean upload(String filename)
	{
		boolean result =false;
		try
		{
				String data = "test data";
		        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
		        result = ftpClass.ftpclient.storeFile(filename, in);
		        in.close();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		return result;
	}
	
	public static void localfiles(final Context c)
	{
		File dir = new File("/");
		final String[] files = dir.list();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		builder.setTitle("Pick a File");
		builder.setItems(files, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Toast.makeText(c, files[item], Toast.LENGTH_SHORT).show();
		    }
		}).show();
	}
	
}

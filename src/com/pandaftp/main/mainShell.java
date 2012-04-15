package com.pandaftp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.pandaftp.utils.*;

public class mainShell extends Activity {
	public Servers server = new Servers();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_grid);
		
		ListView view = (ListView) findViewById(R.id.list);
		View header = getLayoutInflater().inflate(R.layout.main, null);
		view.addHeaderView(header);
		//view.addHeaderView(header, null, false);
		view.setClickable(false);
		view.setAdapter(new CustomImageListAdapter(this));
		view.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == 1)
				{
					// Add Server
					Intent i = new Intent(getApplicationContext(), serverDisplay.class);
	                startActivity(i);
					
				} else if (arg2 == 2)
				{
					// Connect Server
					Intent i = new Intent(getApplicationContext(), serverList.class);
	                startActivity(i);
				} else if (arg2 == 3)
				{
					// Admin Stuff
					Intent i = new Intent(getApplicationContext(), mainShell.class);
	                startActivity(i);
				}
			}
			
				//
				
			});
	}
	
	
	
}
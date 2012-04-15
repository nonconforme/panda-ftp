package com.pandaftp.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pandaftp.utils.*;

public class mainShell extends Activity {
	
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
		
	}
	
	
}
package com.pandaftp.main;

import java.util.ArrayList;
import java.util.List;

import com.pandaftp.utils.DatabaseHandler;
import com.pandaftp.utils.Server;
import com.pandaftp.utils.ftpClass;
import com.pandaftp.utils.utilities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class serverList extends ListActivity{

	DatabaseHandler db = new DatabaseHandler(this);
	List<Server> toList = new ArrayList<Server>();
	
	public void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		
		ListView lv = this.getListView();
		View header = getLayoutInflater().inflate(R.layout.connectheader, null);
		lv.addHeaderView(header);
		
		try {
					

			toList = db.getAllServers();
			
			
			
			String[] names = new String[db.getServersCount()];
			
			for (int x = 0; x < names.length; x++)
			{
				names[x] = toList.get(x).getServerName();
			}
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
			setListAdapter(adapter);
			
		} catch (Exception e)
		{
			Log.e("ERROR ", e.toString());
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		
		//String item = (String) getListAdapter().getItem(position);
		Object o = l.getAdapter().getItem(position);
		String item = o.toString();
		
		for (int x = 0; x < toList.size(); x++)
		{
	
			if (toList.get(x).getServerName().equalsIgnoreCase(item))
			{
				
				if (ftpClass.ftpConnect(toList.get(x).getIpAddress(), toList.get(x).getUserName(), toList.get(x).getPassword(), toList.get(x).getPortNumber()))
				{
					finish();
					Intent i = new Intent(getApplicationContext(), ftpBrowser.class);
	                startActivity(i);
	                
				} 
			}

		}
	}
	
	
}

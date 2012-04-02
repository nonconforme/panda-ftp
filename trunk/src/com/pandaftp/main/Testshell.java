package com.pandaftp.main;

import android.app.Activity;
import android.os.Bundle;
import com.pandaftp.utils.*;

import org.apache.commons.net.ftp.*;


public class Testshell extends Activity{

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    //utilities.listBrowser(this, "/");
	    
	   // utilities.message(ipfetch.getAddr("www.google.ca"), this);
	}
	
}

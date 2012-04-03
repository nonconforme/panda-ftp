package com.pandaftp.main;

import android.app.Activity;
import android.os.Bundle;
import com.pandaftp.utils.*;

import org.apache.commons.net.ftp.*;


public class Testshell extends Activity{

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	  try{
		 if(ftpClass.ftpConnect("193.43.36.131", "anonymous", "anonymous", 21)){
			utilities.listBrowser(this,"/");
		 }
	  }catch(Exception e){
		  
		  utilities.errorbox(1, this);
	  }
	}
	
}

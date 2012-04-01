package com.pandaftp.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;  

public class ipfetch {
 
public static String getAddr(String input)
{
	InetAddress address =null;
	try{
		address = InetAddress.getByName(input);
		input = address.getHostAddress();
	}
	catch(UnknownHostException e){
		input ="Server Not Found";
	}
	return input;
}
public static boolean isHostname(String input)
{
	boolean is = true;
	
	if (ipfetch.getAddr(input) == "Server Not Found")
	{
		is = false;
	}
	 
	
	return is;
}

public static String getHostname(String input)
{
	InetAddress address = null;
	try
	{
		address = InetAddress.getByName(input);
		input = address.getHostName();
		
	}
	catch(UnknownHostException e)
	{
		input = "Unknown Server";
	}
	return input;
}
}

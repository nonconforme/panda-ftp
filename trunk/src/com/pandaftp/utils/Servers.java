package com.pandaftp.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import android.content.Context;
import android.widget.TextView;

import com.pandaftp.utils.*;

public class Servers {

//private static ServerRAM[] ServerArray;
//private static Vector<ServerRAM> ServerArray = new Vector<ServerRAM>();
public static ArrayList<ServerRAM> ServerArray = new ArrayList<ServerRAM>();
//Default Constructor 

public Servers()
{
	// temp constructor.
	
	
}



public static void AddServer(String ServerName,String Ip,String pass, String user, int port){
		
	ServerRAM temp = new ServerRAM(ServerName, Ip, pass, user);
	ServerArray.add(temp);	
	
}

public static void EditServer(String ServerName, String Ip, String pass, String user, int port)
{
	for (int x = 0; x < ServerArray.size(); x++ )
	{
		if (ServerArray.get(x).equals(ServerName))
		{
			ServerArray.get(x).setAddr(Ip);
			ServerArray.get(x).setHostName(ServerName);
			ServerArray.get(x).setUser(user);
			ServerArray.get(x).setPass(pass);
			ServerArray.get(x).setPort(port);
		}
		
	}
}

public static String[] listServers()
{
	String[] names = new String[ServerArray.size()];
	for (int x = 0; x < ServerArray.size(); x++ )
		names[x] = ServerArray.get(x).gethost();
	return names;
}


public static String[] info(String HostName)
{
	String[] info = new String[4];

	for (int x = 0; x < ServerArray.size(); x++)
	{
		if (ServerArray.get(x).equals(HostName))
		{
			info[0] = ServerArray.get(x).getInfo('h');
			info[1] = ServerArray.get(x).getInfo('i');
			info[2] = ServerArray.get(x).getInfo('u');
			info[3] = ServerArray.get(x).getInfo('p');
		}
	}
	
	return info;
}
}

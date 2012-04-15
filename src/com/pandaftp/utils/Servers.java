package com.pandaftp.utils;

import java.io.Serializable;

import android.content.Context;
import android.widget.TextView;

import com.pandaftp.utils.*;

public class Servers {

private static ServerRAM[] ServerArray;

//Default Constructor
public Servers(){
	ServerArray = new ServerRAM[5];
	for(int i =0;i < ServerArray.length;i++)
	{
		ServerArray[i] = new ServerRAM();
	}
}

public static void AddServer(String ServerName,String Ip,String pass, String user, int port){
		
	for(int i = 0;i < ServerArray.length;i++)
	{
		if(ServerArray[i].gethost() == "default" )
		{
			ServerArray[i].setHostName(ServerName);
			ServerArray[i].setAddr(Ip);
			ServerArray[i].setPass(pass);
			ServerArray[i].setUser(user);
			ServerArray[i].setPort(port);
			break;
		}
	}
}

public static void EditServer(String ServerName,String Ip,String pass, String user, int port)
{
	for(int i = 0;i < ServerArray.length;i++)
	{
		if(ServerArray[i].getInfo('h') == ServerName)
		{
				ServerArray[i].setAddr(Ip);
				ServerArray[i].setPass(pass);
				ServerArray[i].setUser(user);
				ServerArray[i].setPort(port);
		}
	}
}

public static String[] listServers()
{
	
	String[] listnames = new String[ServerArray.length];
	for(int i =0;i < ServerArray.length;i++)
	{
		listnames[i] = ServerArray[i].gethost();
	}
	return listnames;
}
}

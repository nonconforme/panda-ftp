/*
package com.pandaftp.utils;

public class ServerRAM {

private String hostname ="default";
private String ipaddr = "127.0.0.1";
private String user ="anonymous";
private String pass = "anonymous";
private int port = 21;

//Default Constructor
public ServerRAM()
{

}
public ServerRAM(String h, String i, String u, String p)
{
	hostname = h;
	ipaddr = i;
	user = u;
	pass = p;
	port = 21;

}
public ServerRAM(String host)
{
	setHostName(host);
	user = "anonymous";
	pass = "anonymous";
	port = 21;
}
public void setHostName(String host)
{
	if(ipfetch.isHostname(host))
	{
		ipaddr = ipfetch.getAddr(host);
	}
	hostname = host;
}
public void setUser(String username)
{
	user = username;
}
public void setPass(String password)
{
	pass = password;
}
public void setPort(int portnum)
{
	port = portnum;
}
public void setAddr(String Address)
{
	ipaddr = Address;
}
//Params for getting

public String getInfo(char input)
{
	switch(input)
	{
	case 'p':
	return pass;		
	case 'u':
	return user;
	case 'i':
	return ipaddr;
	case 'h':
	return hostname;
	default:
	return "Error Bro";
	}	
}
public int getPort()
{
	return port;
}
public String gethost(){
	return hostname;
}
}
*/
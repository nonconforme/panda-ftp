package com.pandaftp.utils;

public class Server {

private String hostname;
private String ipaddr;
private String user;
private String pass;
private int port;

//Default Constructor
public Server(String host)
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
}

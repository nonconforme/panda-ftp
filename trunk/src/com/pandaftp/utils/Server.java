package com.pandaftp.utils;



		 
		public class Server {
		 
		    //private variables
		    int id;
		    String serverName;
		    int portNumber;
		    String ipAddress;
		    String userName;
		    String password;
		    
		 
		    // Empty constructor
		    public Server(){
		 
		    }
		    // constructor
		    public Server(int id, String serverName, int portNumber, String ipAddress, String
		    		userName, String password)
		    {
		        this.id = id;
		        this.serverName = serverName;
		        this.portNumber = portNumber;
		        this.ipAddress = ipAddress;
		        this.userName = userName;
		        this.password = password;
		    }
		 
		    // constructor
		    public Server(String serverName, int portNumber, String ipAddress, String userName, String password){
		        this.serverName = serverName;
		        this.portNumber = portNumber;
		        this.ipAddress = ipAddress;
		        this.userName = userName;
		        this.password = password;
		    }
		    // getting ID
		    public int getID(){
		        return this.id;
		    }
		 
		    // setting ID
		    public void setID(int id){
		        this.id = id;
		    }
		 
		    // getting server_name
		    public String getServerName(){
		        return this.serverName;
		    }
		 
		    // setting server_name
		    public void setServerName(String serverName){
		        this.serverName = serverName;
		    }
		 
		    // getting port number
		    public int getPortNumber(){
		        return this.portNumber;
		    }
		 
		    // setting port number
		    public void setPortNumber(int portNumber){
		        this.portNumber = portNumber;
		    }
		    
		    // getting ip address
		    public String getIpAddress(){
		    	return this.ipAddress;
		    }
		    
		    // setting ip address
		    public void setIpAddress(String ipAddress){
		    	this.ipAddress = ipAddress;
		    }
		    
		    // getting userName
		    public String getUserName(){
		    	return this.userName;
		    }
		    
		    // setting userName
		    public void setUserName(String userName){
		    	this.userName = userName;
		    }
		    
		    // getting password
		    public String getPassword(){
		    	return this.password;
		    }
		    
		    // setting password
		    public void setPassword(String password){
		    	this.password = password;
		    }
		    
		
}
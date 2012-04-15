package com.pandaftp.utils;



		 
		public class Server {
		 
		    //private variables
		    int id;
		    String serverName;
		    int portNumber;
		    String ipAddress;
		 
		    // Empty constructor
		    public Server(){
		 
		    }
		    // constructor
		    public Server(int id, String serverName, int portNumber, String ipAddress){
		        this.id = id;
		        this.serverName = serverName;
		        this.portNumber = portNumber;
		        this.ipAddress = ipAddress;
		    }
		 
		    // constructor
		    public Server(String serverName, int portNumber, String ipAddress){
		        this.serverName = serverName;
		        this.portNumber = portNumber;
		        this.ipAddress = ipAddress;
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
		    
		
}
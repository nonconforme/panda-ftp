package com.pandaftp.utils;
import org.apache.commons.net.ftp.*;

public class ftpClass {
	public static FTPClient ftpclient;
	public static String directory;
	
	public static boolean ftpConnecct(String url, String username, String password, int port)
	{
		if (url.isEmpty() || username.isEmpty() || password.isEmpty())
			return false;
		else {
			if (port > 1)
				port = 21;
			try {
			ftpclient.connect(url, port);
			if (FTPReply.isPositiveCompletion(ftpclient.getReplyCode())) {
				boolean status = ftpclient.login(username, password);
				System.out.println("Status: " + status);
				ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpclient.enterLocalPassiveMode();
				directory = "";
				return status;
			}	
			} catch (Exception e) {
				System.out.println(e);
				return false;
				
			}
			return true;
		}
	
	}
	
	public static boolean ftpDisconnect() {
		try {
			ftpclient.logout();
			ftpclient.disconnect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static String[] ftpGetCurrentWorkingDirectory(String Folder) {
		try {
			String[] workingDir = ftpclient.listNames(Folder);
			return workingDir;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static boolean ftpChangeDirectory(String directory_path)
	{
	    try {
	    	ftpclient.changeWorkingDirectory(directory_path);
	    } catch(Exception e) {
	        return false;
	    }

	    return false;
	}
	
	public static String getDirectoryName()
	{
		return directory;
	}
	public static void setDirectoryName(String dir)
	{
		directory = dir;
	}
}

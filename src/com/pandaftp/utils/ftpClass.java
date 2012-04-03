package com.pandaftp.utils;
import org.apache.commons.net.ftp.*;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class ftpClass {
	
	public static FTPClient ftpclient = new FTPClient();
	public static String directory;
	public static String error;
	
	public static boolean ftpConnect(String url, String username, String password, int port)
	{
		try {
			
			// connecting to the host
			ftpclient.connect(url, port);

			// now check the reply code, if positive mean connection success
			if (FTPReply.isPositiveCompletion(ftpclient.getReplyCode())) {
				// login using username & password
				
				boolean status = ftpclient.login(username, password);
				//someValue.setText("" + status);
				/*
				 * Set File Transfer Mode
				 * 
				 * To avoid corruption issue you must specified a correct
				 * transfer mode, such as ASCII_FILE_TYPE, BINARY_FILE_TYPE,
				 * EBCDIC_FILE_TYPE .etc. Here, I use BINARY_FILE_TYPE for
				 * transferring text, image, and compressed files.
				 */
				directory = "";
				ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpclient.enterLocalPassiveMode();

				return status;
				// Returns the Status!!!
			}
		} catch (Exception e) {
			error = e + "";
			return false;
		}

		return false;
	
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

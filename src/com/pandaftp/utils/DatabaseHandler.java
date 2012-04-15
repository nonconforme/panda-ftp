package com.pandaftp.utils;



import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
		 
	    // All Static variables
	    // Database Version
	    private static final int DATABASE_VERSION = 1;
	 
	    // Database Name
	    private static final String DATABASE_NAME = "serverManager";
	 
	    // Contacts table name
	    private static final String TABLE_SERVERS = "servers";
	 
	    // Contacts Table Columns names
	    private static final String KEY_ID = "id";
	    private static final String KEY_SERVER_NAME = "serverName";
	    private static final String KEY_PORT_NO = "portNumber";
	    private static final String KEY_IP_ADDRESS = "ipAddress";
	 
	    public DatabaseHandler(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	 
	    // Creating Tables
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        String CREATE_SERVERS_TABLE = "CREATE TABLE " + TABLE_SERVERS + "("
	                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_SERVER_NAME + " TEXT,"
	                + KEY_PORT_NO + " INT," + KEY_IP_ADDRESS + " TEXT" + ")";
	        db.execSQL(CREATE_SERVERS_TABLE);
	    }
	 
	    // Upgrading database
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // Drop older table if existed
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVERS);
	 
	        // Create tables again
	        onCreate(db);
	    }
	    
	    
	    
	    
	    
	    // Adding Server
	    public void addServer(Server server) {
	    	
	        SQLiteDatabase db = this.getWritableDatabase();
	        
	        ContentValues values = new ContentValues();
	        values.put(KEY_SERVER_NAME, server.getServerName()); // Server Name
	        values.put(KEY_PORT_NO, server.getPortNumber()); // Server Port Number
	        values.put(KEY_IP_ADDRESS, server.getIpAddress()); // Server IP Address
	        
	     
	        // Inserting Row
	        db.insert(TABLE_SERVERS, null, values);
	        db.close(); // Closing database connection
	    	
	    }
	     
	 
	    // Updating Server
	    public int updateServer(Server server) {
	        SQLiteDatabase db = this.getWritableDatabase();
	 
	        ContentValues values = new ContentValues();
	        values.put(KEY_SERVER_NAME, server.getServerName());
	        values.put(KEY_PORT_NO, server.getPortNumber());
	        values.put(KEY_IP_ADDRESS, server.getIpAddress());
	 
	        // updating row
	        return db.update(TABLE_SERVERS, values, KEY_ID + " = ?",
	                new String[] { String.valueOf(server.getID()) });
	    }
	 
	    // Deleting Server
	    public void deleteServer(Server server) {
	        SQLiteDatabase db = this.getWritableDatabase();
	        db.delete(TABLE_SERVERS, KEY_ID + " = ?",
	                new String[] { String.valueOf(server.getID()) });
	        db.close();
	    }
	    
	 // Recall Server
	    public Server getServer(int id) {
	        SQLiteDatabase db = this.getReadableDatabase();
	 
	        Cursor cursor = db.query(TABLE_SERVERS, new String[] { KEY_ID,
	                KEY_SERVER_NAME, KEY_PORT_NO, KEY_IP_ADDRESS }, KEY_ID + "=?",
	                new String[] { String.valueOf(id) }, null, null, null, null);
	        if (cursor != null)
	            cursor.moveToFirst();
	 
	        Server server = new Server(Integer.parseInt(cursor.getString(0)),
	                cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3));
	        // return server
	        return server;
	    }
	    
	    // Getting All Servers
	    public List<Server> getAllServers() {
	        List<Server> serverList = new ArrayList<Server>();
	        // Select All Query
	        String selectQuery = "SELECT  * FROM " + TABLE_SERVERS;
	 
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	                Server server = new Server();
	                server.setID(Integer.parseInt(cursor.getString(0)));
	                server.setServerName(cursor.getString(1));
	                server.setPortNumber(Integer.parseInt(cursor.getString(2)));
	                server.setIpAddress(cursor.getString(3));
	                // Adding server to list
	                serverList.add(server);
	            } while (cursor.moveToNext());
	        }
	 
	        // return server list
	        return serverList;
	    }
	  
	    // Getting server Count
	    public int getServersCount() {
	        String countQuery = "SELECT  * FROM " + TABLE_SERVERS;
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.rawQuery(countQuery, null);
	        cursor.close();
	 
	        // return count
	        return cursor.getCount();
	    }
	 
}
	    

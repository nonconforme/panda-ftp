package com.pandaftp.main;

import com.pandaftp.main.R;
import android.util.Log;
import com.pandaftp.utils.DatabaseHandler;
import com.pandaftp.utils.Server;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dataTest extends Activity {

EditText 	editTextID, editTextServerName, editTextPortNo, editTextIpAddress;

// buttons listening for action
Button 		buttonAddServer, buttonDeleteServer, buttonRecallServer, buttonUpdateServer, buttonList;

// table displaying the data
//TableLayout dataTable = (TableLayout)findViewById(R.id.dataTable);

//let's open up a NEW SERVER YEAH
static Server server = new Server();

// class to open / create database
DatabaseHandler db = new DatabaseHandler(this);





public void onCreate(Bundle savedInstanceState)
{
// always try catch
try
{

super.onCreate(savedInstanceState);
setContentView(R.layout.datascreen);

//I think these are necessary
setupViews();
addButtonListeners();

server.setID(4);
server.setServerName("5g0");
server.setPortNumber(1);
server.setIpAddress("fds");

}
catch (Exception e)
{
Log.e("ERROR", e.toString());
e.printStackTrace();
}



}



private void setupViews()
{
	// THE DATA TABLE
    //dataTable =	 		(TableLayout)findViewById(R.id.dataTable);

    // THE DATA FORM FIELDS
    editTextID = (EditText)findViewById(R.id.editTextID);
    editTextServerName = (EditText)findViewById(R.id.editTextServerName);
    editTextPortNo = (EditText)findViewById(R.id.editTextPortNo);
    editTextIpAddress = (EditText)findViewById(R.id.editTextIpAddress);

    // THE BUTTONS
    buttonAddServer = 		(Button)findViewById(R.id.buttonAddServer);
    buttonDeleteServer = 	(Button)findViewById(R.id.buttonDeleteServer);
    buttonRecallServer =	(Button)findViewById(R.id.buttonRecallServer);
    buttonUpdateServer = 	(Button)findViewById(R.id.buttonUpdateServer);
    buttonList = (Button)findViewById(R.id.buttonList);
    
    
}




//adds listeners to each of the buttons and sets them to call relevant methods
//in retrospect, this was a little more work than necessary

private void addButtonListeners()
{
	buttonAddServer.setOnClickListener
	(
		new View.OnClickListener()
    	{
			public void onClick(View v) {try
			{
				String serverName = editTextServerName.getText().toString();
				int portNumber = Integer.parseInt(editTextPortNo.getText().toString());
				String ipAddress = editTextIpAddress.getText().toString();
				
				
				server.setServerName(serverName);
				server.setIpAddress(ipAddress);
				
				try{
				server.setPortNumber(portNumber);
				}
				catch(Exception e)
				{
					Log.e("Port doesn't add either", e.toString());
					e.printStackTrace();
				}
				
				// pass server to the database handler
				db.addServer(server);
				

				// request the table be updated
		    	//updateTable();

				// remove all user input from the Activity
				emptyFormFields();
			}
			catch (Exception e)
			{
				Log.e("Add Error", e.toString());
				e.printStackTrace();
			}
			}
		}
	);

    buttonDeleteServer.setOnClickListener
    (
    	new View.OnClickListener()
        {
			public void onClick(View v) {try
			{
				int id = Integer.parseInt(editTextID.getText().toString());
				
				
				
				server.setID(id);
				
				// ask the database delete the server with the associated ID.
				
				db.deleteServer(server);

				// request the table be updated
				//updateTable();

				// remove all user input from the Activity
				emptyFormFields();
			}
			catch (Exception e)
			{
				Log.e("Delete Error", e.toString());
				e.printStackTrace();
			}
			
			}
		}
    );

    buttonRecallServer.setOnClickListener
    (
    	new View.OnClickListener()
        {
        	public void onClick(View v) {try
        	{
        		
        		// ask the database manager to retrieve server
        		server = db.getServer(Integer.parseInt(editTextID.getText().toString()));

        		// update the form fields to hold the retrieved data
        		editTextServerName.setText(server.getServerName()); 
        		editTextIpAddress.setText(server.getIpAddress());
        		try{
        		editTextPortNo.setText(Integer.toString(server.getPortNumber()));
        		}
        		catch (Exception e)
        		{
        		Log.e("it's the freaking PORT", e.toString());
        		e.printStackTrace();
        		}
        	}
        	catch (Exception e)
        	{
        		Log.e("Retrieve Error", e.toString());
        		e.printStackTrace();
        	}}
        }
    );

    buttonUpdateServer.setOnClickListener
    (
    	new View.OnClickListener()
    	{
			public void onClick(View v) {try
			{
				
				server.setID(Integer.parseInt(editTextID.getText().toString()));
				server.setServerName(editTextServerName.getText().toString());
				server.setPortNumber(Integer.parseInt(editTextPortNo.getText().toString()));
				server.setIpAddress(editTextIpAddress.getText().toString());
				
				
				// pass the server to the database handler for the updating
				
				db.updateServer
				(
					server
				);

				// request the table be updated
				//updateTable();

				// remove all user input from the Activity
				
			}
			catch (Exception e)
			{
				Log.e("Update Error", e.toString());
				e.printStackTrace();
			}
			}
		}
    );

    buttonList.setOnClickListener
    (
    	new View.OnClickListener()
    	{
			public void onClick(View v) {try
			{
				
				server.setID(Integer.parseInt(editTextID.getText().toString()));
				server.setServerName(editTextServerName.getText().toString());
				server.setPortNumber(Integer.parseInt(editTextPortNo.getText().toString()));
				server.setIpAddress(editTextIpAddress.getText().toString());
				
				
				// pass the server to the database handler for the updating
				
				//List<Server> ServerList = db.getAllServers();

				// request the table be updated
				//updateTable();

				// remove all user input from the Activity
				
			}
			catch (Exception e)
			{
				Log.e("Update Error", e.toString());
				e.printStackTrace();
			}
			}
		}
    );
    
}




/*
 * kills all text
 */


private void emptyFormFields()
{
    editTextID.setText("");
    editTextPortNo.setText("");
    editTextServerName.setText("");
    editTextIpAddress.setText("");
}







/**
 * updates the table from the database.
 */


/*
 * 
 * 
 * private void updateTable()
{
	// delete all but the first row.  remember that the count 
	// starts at one and the index starts at zero
	while (dataTable.getChildCount() > 1)
	{
		// while there are at least two rows in the table widget, delete
		// the second row.
		dataTable.removeViewAt(1);
	}

	// collect the current row information from the database and
	// store it in a two dimensional ArrayList
	ArrayList<ArrayList<Object>> data = db.getAllRowsAsArrays();

	// iterate the ArrayList, create new rows each time and add them
	// to the table widget.
	for (int position=0; position < data.size(); position++)
	{
		TableRow tableRow= new TableRow(this);

		ArrayList<Object> row = data.get(position);

		TextView idText = new TextView(this);
		idText.setText(row.get(0).toString());
		tableRow.addView(idText);

		TextView textOne = new TextView(this);
		textOne.setText(row.get(1).toString());
		tableRow.addView(textOne);

		TextView textTwo = new TextView(this);
		textTwo.setText(row.get(2).toString());
		tableRow.addView(textTwo);

		dataTable.addView(tableRow);
	}
}
*
*
*
*/
}








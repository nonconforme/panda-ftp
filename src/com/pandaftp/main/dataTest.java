package com.pandaftp.main;

import com.pandaftp.main.R;
import com.pandaftp.main.R.layout;
import com.pandaftp.utils.DatabaseHandler;
import com.pandaftp.utils.Server;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class dataTest extends Activity {

EditText 	editTextID, editTextServerName, editTextPortNo, editTextIpAddress;

// buttons listening for action
Button 		buttonAddServer, buttonDeleteServer, buttonRecallServer, buttonUpdateServer;

// table displaying the data
TableLayout dataTable;

// class to open / create database
DatabaseHandler db;

// let's open up a NEW SERVER YEAH
Server server = new Server();


@Override
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
    dataTable =	 		(TableLayout)findViewById(R.id.dataTable);

    // THE DATA FORM FIELDS
    editTextID = (EditText)findViewById(R.id.editTextID);
    editTextServerName = (EditText)findViewById(R.id.editTextServerName);
    editTextPortNo = (EditText)findViewById(R.id.editTextPortNo);
    editTextIpAddress = (EditText)findViewById(R.id.editTextIpAddress);

    // THE BUTTONS
    buttonAddServer = 		(Button)findViewById(R.id.buttonAddServer);
    buttonDeleteServer = 		(Button)findViewById(R.id.buttonDeleteServer);
    buttonRecallServer =	(Button)findViewById(R.id.buttonRecallServer);
    buttonUpdateServer = 		(Button)findViewById(R.id.buttonUpdateServer);
    
    
}




//adds listeners to each of the buttons and sets them to call relevant methods
//in retrospect, this was a little more work than necessary

private void addButtonListeners()
{
    buttonAddServer.setOnClickListener
	(
		new View.OnClickListener()
    	{
			public void onClick(View v) {addRow();}
		}
	);

    buttonDeleteServer.setOnClickListener
    (
    	new View.OnClickListener()
        {
			public void onClick(View v) {deleteRow();}
		}
    );

    buttonUpdateServer.setOnClickListener
    (
    	new View.OnClickListener()
        {
        	public void onClick(View v) {updateRow();}
        }
    );

    buttonRecallServer.setOnClickListener
    (
    	new View.OnClickListener()
    	{
			public void onClick(View v) {retrieveRow();}
		}
    );

}




/*
 * adds a server to the database
 */

private void addRow()
{
	try
	{
		String serverName = editTextServerName.getText().toString();
		int portNumber = Integer.parseInt(editTextPortNo.getText().toString());
		String ipAddress = editTextIpAddress.getText().toString();
		
		server.setServerName(serverName);
		server.setPortNumber(portNumber);
		server.setIpAddress(ipAddress);
		
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




/*
 * deletes a server with the corresponding id number from the database
 */

private void deleteRow()
{
	try
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




/*
 * retrieves a server with the associated ID from the database
 */

private void retrieveRow()
{
	try
	{
		
		// ask the database manager to retrieve server
		server = db.getServer(Integer.parseInt(editTextID.getText().toString()));

		// update the form fields to hold the retrieved data
		editTextServerName.setText(server.getServerName()); 
		editTextPortNo.setText(server.getPortNumber());
		editTextIpAddress.setText(server.getIpAddress());
	}
	catch (Exception e)
	{
		Log.e("Retrieve Error", e.toString());
		e.printStackTrace();
	}
}




/*
 * updates a server with the information from user
 */

private void updateRow()
{
	try
	{
		
		server.setID(Integer.parseInt(editTextID.getText().toString()));
		
		
		// pass the server to the database handler for the updating
		
		db.updateServer
		(
			server
		);

		// request the table be updated
		//updateTable();

		// remove all user input from the Activity
		emptyFormFields();
	}
	catch (Exception e)
	{
		Log.e("Update Error", e.toString());
		e.printStackTrace();
	}
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








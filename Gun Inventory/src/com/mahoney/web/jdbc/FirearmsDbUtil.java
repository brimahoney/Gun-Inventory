package com.mahoney.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mahoney.entities.Firearm;

public class FirearmsDbUtil
{
	private DataSource dataSource;

	public FirearmsDbUtil(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	public List<Firearm> getFirearms() throws Exception 
	{
		List<Firearm> firearms = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStatement = null;
		ResultSet myResults = null;
		
		try
		{
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql query
			String sql = "select * from firearms order by date_purchased";
			myStatement = myConn.createStatement();
			
			// execute query
			myResults = myStatement.executeQuery(sql);
			
			// process result set
			while(myResults.next())
			{
				String serialNumber = myResults.getString("serial_number");
				String model = myResults.getString("model");
				String make = myResults.getString("make");
				String type = myResults.getString("type");
				String caliber = myResults.getString("caliber");
				Date datePurchased = myResults.getDate("date_purchased");
				String notes = myResults.getString("notes");
				
				Firearm tempFirearm = new Firearm(serialNumber, model, make, type, caliber, datePurchased, notes);
				
				firearms.add(tempFirearm);
			}
			return firearms;
		}
		finally
		{
			// close JDBC objects
			close(myConn, myStatement, myResults);
		}
	}
	
	public Firearm getFirearm(String serialNumber) throws Exception 
	{
		Firearm theFirearm = null;
		
		Connection myConn = null;
		PreparedStatement myStatement = null;
		ResultSet myResults = null;
		
		try
		{
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql query
			String sql = "select * from firearms where serial_number = ?";
			
			// create prepared statement
			myStatement = myConn.prepareStatement(sql);
			
			// set params
			myStatement.setString(1, serialNumber);
			
			// execute statement
			myResults = myStatement.executeQuery();
			
			// process result set
			if(myResults.next())
			{
				String theSerialNumber = myResults.getString("serial_number");
				String model = myResults.getString("model");
				String make = myResults.getString("make");
				String type = myResults.getString("type");
				String caliber = myResults.getString("caliber");
				Date datePurchased = myResults.getDate("date_purchased");
				String notes = myResults.getString("notes");
				
				theFirearm = new Firearm(theSerialNumber, model, make, type, caliber, datePurchased, notes);
				return theFirearm;
			}
			else
			{
				throw new Exception("Could not find firearm with serial number: " + serialNumber);
			}
		}
		finally
		{
			// close JDBC objects
			close(myConn, myStatement, myResults);
		}
	}

	private void close(Connection myConn, Statement myStatement, ResultSet myResults)
	{
		try
		{
			if(myResults != null)
				myResults.close();
			
			if(myStatement != null)
				myStatement.close();
			
			if(myConn != null)
				myConn.close(); // this releases the connection back to the pool
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

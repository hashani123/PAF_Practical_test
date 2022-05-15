package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

	
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/eg_usermanagement";
            String user="root";
            String password="";

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertUser(String name, String uAddress,  String uEmail,  String nic, String pno) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into user(`uID`,`name`,`uAddress`,`uEmail`,`nic`,`Pno`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, uAddress);
			preparedStmt.setString(4, uEmail);
			preparedStmt.setString(5, nic);
			preparedStmt.setString(6, pno);
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newUser = readUser(); 
			output = "{\"status\":\"success\", \"data\": \"" + newUser+ "\"}"; 
			
			
		} catch (Exception e) {
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the user.\"}"; 

			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readUser() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>User ID</th>"
					+ "<th> Name</th>"
					+ "<th>Address</th>"
					+ "<th>Email</th>"
					+ "<th>NIC</th>"
					+ "<th>Phone No</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from user";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs =  ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String uID = Integer.toString(rs.getInt("uID"));
				String name = rs.getString("name");
				String uAddress = rs.getString("uAddress");
				String uEmail = rs.getString("uEmail");
				String nic = rs.getString("nic");
				String Pno = rs.getString("Pno");

				// Add into the html table
				output += "<tr><td><input id='hidUserIDUpdate' name='hidUserIDUpdate' "
						+ "type='hidden' value='" + uID+ "'>" + uID + "</td>"; 
				output += "<td>" + name + "</td>";
				output += "<td>" + uAddress + "</td>";
				output += "<td>" + uEmail + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + Pno + "</td>";
				
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' "
						+ " class='btnUpdate btn btn-secondary'></td>"
						 + "<td><input name='btnRemove' type='button' value='Remove'"
						 + " class='btnRemove btn btn-danger'  data-itemid='"+ uID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the user.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateUser(String uID, String name, String uAddress, String uEmail,  String nic, String pno) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE user SET name=?,uAddress=?,uEmail=?,nic=?,Pno=?" + "WHERE uID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, uAddress);
			preparedStmt.setString(3,uEmail);
			preparedStmt.setString(4, nic);
			preparedStmt.setString(5, pno);
			preparedStmt.setInt(6, Integer.parseInt(uID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newUser = readUser(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}"; 

		} catch (Exception e) {
			output =  "{\"status\":\"error\", \"data\": \"Error while updating the user.\"}"; 
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteUser(String uID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from user where uID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(uID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newUser = readUser(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}"; 


			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the user.\"}"; 

			System.err.println(e.getMessage());
		}

		return output;
	}

	
	
	
}

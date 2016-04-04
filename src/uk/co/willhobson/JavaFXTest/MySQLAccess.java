package uk.co.willhobson.JavaFXTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAccess {
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	/*
	public void readDataBase() throws Exception {
		try {
			// load the squiggle driver
			Class.forName("com.mysql.jdbc.Driver");

			// squiggle to the dibble
			connect = DriverManager.getConnection("jdbc:mysql://tmp.willhobson.co.uk/feedback?" + "user=guest&password=password");

			// squawk to the squiggle
			statement = connect.createStatement();

			// become the squiggle
			resultSet = statement.executeQuery("select * from data_table");

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	 */
	public static boolean openConnection() throws Exception {
		boolean success = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://tmp.willhobson.co.uk/db?" + "user=guest&password=password");
			success = true;
		} catch (Exception e) {
			throw e;
		}
		return success;
	}
	
	public static ResultSet queryConnection(String arg) throws Exception{
		statement = connect.createStatement();
		resultSet = statement.executeQuery(arg);
		return resultSet;
	}
	
	public static void closeConnection() { // sniff ;-; you will be missed squiggle
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}

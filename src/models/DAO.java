package models;

import java.sql.*;

public class DAO {
	private Connection connection;
	private Statement statement;
	private String user = "mysql";
	private String password = "prac";
	
	public DAO() {
		connect();
	}
	
	private void connect()  {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost/movieT", user, password);
			statement = connection.createStatement();
			}
		catch (ClassNotFoundException e) {
			System.out.println("Driver not found " + e);
		} 
		catch (SQLException e) {
			System.out.println("Connect not possible" + e);
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectBD() throws SQLException {
		statement.close();
		connection.close();
	}
	
	public ResultSet executeSQL(String query) throws SQLException {
		return statement.executeQuery(query);
	}
	
	public void updateSQL(String query) throws SQLException {
		statement.executeUpdate(query);
	}
}
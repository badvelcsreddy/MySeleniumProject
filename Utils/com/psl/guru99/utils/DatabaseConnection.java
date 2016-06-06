package com.psl.guru99.utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {
	public Statement stmt = null;
	public ResultSet rs = null;
	public ResultSetMetaData rsmd = null;
    public String query;
    public String DBName;
    public Connection con=null;
    public String FileName = "connection.properties";

	/*Creating the Connection object to take the parameter as Database Type
	base on the data type this code will create the connection object*/
	
	public Connection GetConnection(String dbname) {
		
		try {
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream("./Utils/"+FileName);
			prop.load(fs);
			fs.close();
			System.out.println("Database Name is : " +dbname);
			String driver = prop.getProperty(dbname+".Driver");
			String url = prop.getProperty(dbname+".URL");
			String username = prop.getProperty(dbname+".UserName");
			String password = prop.getProperty(dbname+".PassWord");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection is created Successfully for "+dbname + "Database");
			return con;
			
		} catch (FileNotFoundException e) {
			System.out.println("The provided property file " + FileName + "is not avaialble");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The file can not be able to read");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	/*This method is used to create the result set for the given query*/
	
	public ResultSet CreateResultSet(String Query){
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(Query);
			rsmd = rs.getMetaData();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}

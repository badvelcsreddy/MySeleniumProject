package com.psl.guru99.utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	
	public Connection GetConnection(String dbname) {
		Connection con=null;
		
		
		
		try {
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream("./Utils/connection.properties");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	

}

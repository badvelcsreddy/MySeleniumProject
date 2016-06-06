package com.psl.guru99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.psl.guru99.utils.DatabaseConnection;


public class ReadDatabaseData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnection odc = new DatabaseConnection();
		//odc.GetConnection();
		
		try {
			Statement Stmt = odc.GetConnection("oracle").createStatement();
			String sql;
			sql = "select * from EMP";
			
			ResultSet rs = Stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("EMPNO");
				System.out.println(id);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

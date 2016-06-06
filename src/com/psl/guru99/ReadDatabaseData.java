package com.psl.guru99;

import java.sql.Date;
import java.sql.SQLException;

import com.psl.guru99.utils.DatabaseConnection;


public class ReadDatabaseData {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnection odc = new DatabaseConnection();
		
		
		try {
		    odc.GetConnection("oracle");
			odc.CreateResultSet("select * from EMP");
			
			int NumOfColumns = odc.rsmd.getColumnCount();
			System.out.println(NumOfColumns);
			
	
			for (int i = 1; i <=NumOfColumns; i++)
			{
				System.out.println(odc.rsmd.getColumnName(i) +" " + odc.rsmd.getColumnTypeName(i));
			}
				while (odc.rs.next()) {
				
				int id = odc.rs.getInt("EMPNO");
				String name = odc.rs.getString("ENAME");
				String job = odc.rs.getString("JOB");
				int mgr = odc.rs.getInt("MGR");
				Date date = odc.rs.getDate("HIREDATE");
				int sal = odc.rs.getInt("SAL");
				int comm = odc.rs.getInt("COMM");
				int deptno = odc.rs.getInt("DEPTNO");
				System.out.println(id + " " + name + " " + job + " " + mgr + " " + date + " " + sal + " " + comm + " " + deptno);
				
				
			}
			odc.rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

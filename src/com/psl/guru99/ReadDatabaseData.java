package com.psl.guru99;


import java.sql.Date;
import java.sql.SQLException;

import com.psl.guru99.utils.DatabaseConnection;


public class ReadDatabaseData {
	

	public static void main(String[] args) {
		
		DatabaseConnection odc = new DatabaseConnection();
		try {
			odc.CreateConnection("oracle");
			try {
				odc.ResultSetforSelect("select * from EMP");
				while(odc.rs.next()){
					int id = odc.rs.getInt(1);
					String name = odc.rs.getString(2);
					String job = odc.rs.getString(3);
					int mgr = odc.rs.getInt(4);
					Date date = odc.rs.getDate(5);
					int sal = odc.rs.getInt(6);
					int comm = odc.rs.getInt(7);
					int deptno = odc.rs.getInt(8);
					System.out.println(id + " " + name + " " + job + " " + mgr + " " + date + " " + sal + " " + comm + " " + deptno);
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (odc.rs!=null)
						odc.rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			odc.ResultSetforUpdate("update DEPT set LOC = 'TEXAS4' where DEPTNO = 40");
			
			try {
				odc.ResultSetforSelect("select * from DEPT");
				while(odc.rs.next()) {
					int deptno = odc.rs.getInt(1);
					String deptname = odc.rs.getString(2);
					String location = odc.rs.getString(3);
					System.out.println(deptno + " " + deptname + " " + location);
				
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (odc.rs!=null)
						odc.rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} finally {
			try {
				if (odc.con!=null)
					odc.con.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	
	}
}


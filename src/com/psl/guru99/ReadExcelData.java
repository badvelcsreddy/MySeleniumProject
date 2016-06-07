package com.psl.guru99;

import com.psl.guru99.utils.ReadFromExcel;

public class ReadExcelData {

	public static void main(String[] args) {
		
		ReadFromExcel rfe = new ReadFromExcel();
		
		String filePath = System.getProperty("user.dir")+"\\Utils";
		System.out.println(filePath);
		rfe.ReadData(filePath, "LoginData.xls", "Sheet1");
		
				
	}

}

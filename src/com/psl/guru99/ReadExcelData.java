package com.psl.guru99;

import java.util.List;

import com.psl.guru99.utils.ReadFromExcel;

public class ReadExcelData {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List Data = null;
		ReadFromExcel rfe = new ReadFromExcel();
		
		String filePath = System.getProperty("user.dir")+"\\Utils";
		System.out.println(filePath);
		rfe.ReadData(filePath, "LoginData.xls", "Sheet1");
		rfe.ShowExcelData(Data);
		
				
	}

}

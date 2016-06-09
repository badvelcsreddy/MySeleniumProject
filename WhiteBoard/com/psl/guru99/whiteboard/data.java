package com.psl.guru99.whiteboard;

import java.io.IOException;
import java.util.HashMap;

public class data {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Test ts = new Test();
		String filePath = System.getProperty("user.dir")+"\\Utils";
		System.out.println(filePath);
		
		try {
			HashMap Data = ts.ExcelData(filePath,  "LoginData.xls", "Sheet1");
			ts.showExelData(Data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

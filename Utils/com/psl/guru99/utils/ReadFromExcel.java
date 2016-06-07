package com.psl.guru99.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public String filePath = null;
	public String fileName = null;
	public String sheetName = null;
	Workbook wb = null;
	
	public String[][] ReadData(String filePath, String fileName, String sheetName) {
		
		String[][] Data = null;
		
		
		File file = new File(filePath+"\\"+fileName);
		try {
			FileInputStream fis = new FileInputStream(file);
											
			/*Creating the workbook object 
			 * if file type	is ".xlsx" then workbook object type is XSSF
			 * if file type is ".xls" then workbook object type is HSSF */
			
			
			if (fileName.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			}
			
			else if (fileName.endsWith(".xls")) {
				wb = new HSSFWorkbook(fis);
			}
			
			Sheet sheet = wb.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
			
			for (int i = 1; i <= totalRows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++ ){
					System.out.print(row.getCell(j).getStringCellValue() +"||");
				}
				System.out.println();
			}
				
			
		} catch (FileNotFoundException e) {
			System.out.println("The provided File " + "'"+ file + "'" + " does not exist");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The provided File " + "'"+ file + "'" + " can not be read");
			e.printStackTrace();
		} 
		return Data;
		
		
	}
		
	
}

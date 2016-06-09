package com.psl.guru99.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public String filePath = null;
	public String fileName = null;
	public String sheetName = null;
	Workbook wb = null;
	Sheet excelSheet = null;
	@SuppressWarnings("rawtypes")
	List excelData = new ArrayList();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List ReadData(String filePath, String fileName, String sheetName) {

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
			
			 excelSheet = wb.getSheet(sheetName);
			 Iterator rows = excelSheet.rowIterator();
			 while (rows.hasNext()) {
	                HSSFRow row = (HSSFRow) rows.next();
	                Iterator cells = row.cellIterator();
	  
	                List cellData = new ArrayList();
	                while (cells.hasNext()) {
	                    HSSFCell cell = (HSSFCell) cells.next();
	                    cellData.add(cell);
	                }
	  
	                excelData .add(cellData);
	            }
		} catch (FileNotFoundException e) {
			System.out.println("The provided File " + "'"+ file + "'" + " does not exist");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The provided File " + "'"+ file + "'" + " can not be read");
			e.printStackTrace();
		} 
		return excelData;
	}
		
	@SuppressWarnings("rawtypes")
	public void ShowExcelData(List Data){
		
		
		 for (int rowNum = 1; rowNum < excelData.size(); rowNum++) {
             
             List list = (List) excelData.get(rowNum);
              
             for (int cellNum = 0; cellNum < list.size(); cellNum++) {
                  
                 HSSFCell cell = (HSSFCell) list.get(cellNum);
                  
                 if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                     System.out.print(cell.getRichStringCellValue().getString() + " ");
                 } else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                     System.out.print(cell.getNumericCellValue() + " ");
                 } else if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
                     System.out.println(cell.getBooleanCellValue() + " ");
                 }
             }
             System.out.println("");
         }
		
	}
}


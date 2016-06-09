package com.psl.guru99.whiteboard;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test {
	public String filePath = null;
	public String fileName = null;
	public String sheetName = null;
	Workbook wb = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap  ExcelData(String filePath, String fileName, String sheetName) throws IOException{
		
		
		File file = new File(filePath+"\\"+fileName);
		HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();
		LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();

		FileInputStream fis = null;
		
		try{
		fis = new FileInputStream(file);
		
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
		
		Iterator rows = sheet.rowIterator();
		while(rows.hasNext()){
			HSSFRow row = (HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
		
			List data = new LinkedList();
			while(cells.hasNext()) {
				HSSFCell cell = (HSSFCell) cells.next();
				
				data.add(cell);
			}
			hashMap.put(row.getRowNum(), data);
			
			
		}
		
		
		}catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
		return outerMap;
		
	}
	
	 @SuppressWarnings("rawtypes")
	public void showExelData(HashMap outerMap) {
	        //
	        // Iterates the data and print it out to the console.
	        //
	        for (int i = 1; i < outerMap.size(); i++) {
	            HashMap list = (HashMap) outerMap.get(i);
	            for (int j = 0; j < list.size(); j++) {
	                HSSFCell cell = (HSSFCell) list.get(j);
	                System.out.print(cell.getRichStringCellValue().getString());
	                if (j < list.size() - 1) {
	                    System.out.print(", ");
	                }
	            }
	            System.out.println("");
	        }
	    }
}


package com.psl.guru99;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadTestData {

	
	public String[][] ReadData(String FileName, String SheetName) {

		String[][] data = null;
		try {

			FileInputStream fs = new FileInputStream(FileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(SheetName);
			System.out.println(sh);

			int totalRows = sh.getRows();
			//System.out.println(totalRows);
			
			int totalCol = sh.getColumns();
			//System.out.println(totalCol);

			data = new String[totalRows - 1][totalCol];

			for (int i = 1; i < totalRows; i++) {
				for (int j = 0; j < totalCol; j++) {
					data[i-1][j] = sh.getCell(j, i).getContents();
					//System.out.println(data[i-1][j]);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return data;

	}

	

}

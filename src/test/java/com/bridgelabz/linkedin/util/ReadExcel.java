package com.bridgelabz.linkedin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Ankush Kumar Agrawal
 *@purpose To Read data from excel sheet
 */
public class ReadExcel {
	
	
	public static XSSFWorkbook xWorkBook;
	public static XSSFSheet xsheet;
	public static File src = new File("/home/admin1/Desktop/JavaAdvanced/Linkedin/src/test/java/com/bridgelabz/linkedin/repository/linkedin.xlsx");
	public static FileInputStream fis;
	
	
	/**
	 * @purpose To read data from excel sheet 
	 * @param sheet
	 * @return data of excel sheet in 2D array
	 */
	public static Object[][] getData(String sheet) {		
			try {
				fis = new FileInputStream(src);
				xWorkBook = new XSSFWorkbook(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			xsheet = xWorkBook.getSheet(sheet);
			int row = xsheet.getLastRowNum();
			Object[][] data = new Object[row][2];			
			int k=0;
			for(int i=0;i<row;i++) {
				Object user =xsheet.getRow(i+1).getCell(k).getStringCellValue() ;				
				data[i][0] = user;					
			}
			for(int i=0;i<row;i++) {
				Object pass = xsheet.getRow(i+1).getCell(k+1).getStringCellValue();			
				data[i][1] = pass;				
			}
			
			return data;
			
	}
}

package com.openmrs.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=10;
	
	static String TEST_DATA_SHEET_PATH = "/Users/shubhagg/Documents/Details.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public static void main(String args[]) {
		getTestData("NewPatient");
	}
	
	public static  Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
		
		try {
			file =new FileInputStream(TEST_DATA_SHEET_PATH);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
		book=WorkbookFactory.create(file);	
			
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    sheet=book.getSheet(sheetName);
	    
	
	  //System.out.println(sheet.getPhysicalNumberOfRows());  
	    
	Object[][] data  = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i = 0; i < sheet.getLastRowNum(); i++) {
		
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++ ) {
			data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			
		System.out.println(data[i][j]);
		}
		
	}
	return data;
	}
	
}

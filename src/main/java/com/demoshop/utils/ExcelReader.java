package com.demoshop.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



public class ExcelReader {
	
	public static String getCellValue(int rowNumber, int cellNumber) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\DemoWebShopFW\\src\\test\\resources\\testData\\registration.xlsx");
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		XSSFSheet sh = xs.getSheet("Sheet1");
		XSSFRow row = sh.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		return cell.toString();

		
}
}
package com.toFetchTheData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.captureCode.LoginPage_ScreenShots;

public class FetchDataForLoginPage extends LoginPage_ScreenShots {

	static Workbook book;
	static Sheet sheet;

	public String getData(int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\TestData\\Login_Credentials.xlsx");
		String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	public Object[][] getDataforInvalidTest(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\TestData\\Login_Invalid_Cred.xlsx");
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	public String getDataforDashboardTest(int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\TestData\\DashboardFields.xlsx");
		String data1 = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		return data1;
	}

}

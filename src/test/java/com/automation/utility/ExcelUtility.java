package com.automation.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	String excelFileName;
	String testCase;
	String sheetName = "Test_Data";

	public ExcelUtility() throws IOException {
		excelFileName = System.getProperty("user.dir") + "\\src\\test\\java\\com\\automation\\testdata\\" + TestConfigUtil.GetConfigValue("TEST_DATA_FILE");
		FileInputStream fileInputStream = new FileInputStream(excelFileName);
		wb = new XSSFWorkbook(fileInputStream);
		sheet = wb.getSheet(sheetName);
		
	}

	public int RowCount() {
		return sheet.getLastRowNum();
	}

	public int ColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public String GetCellData(int rowNum, int colNum) {
		XSSFRow row = wb.getSheet(sheetName).getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);
		String cellData = "";
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			boolean blnValue = cell.getBooleanCellValue();
			cellData = String.valueOf(blnValue);
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			cellData = "";
		} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			cellData = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
				cellData = dateFormat.format(cell.getDateCellValue());
			} else {
				double intCellData = cell.getNumericCellValue();
				cellData = String.valueOf(intCellData);
			}
		}

		return cellData;
	}
	
	public int PutCellData(String testCase, String columnName, String cellText, String iteration) throws IOException {
		int rowCount = RowCount();
		int colCount = ColumnCount();
		int rowIndex = -999;
		int colIndex = -999;
		
		for(int icol = 0; icol <= colCount; icol++) {
			if(columnName.equals(GetCellData(0, icol))) {
				colIndex = icol;
				break;
			}
		}
		
		for(int irow = 0; irow <= rowCount; irow++) {
			if(testCase.equals(GetCellData(irow, 1)) && iteration.equalsIgnoreCase(GetCellData(irow, 3))) {
				rowIndex = irow + 1;
				break;
			}
		}
		
		
		XSSFRow row = wb.getSheet(sheetName).getRow(rowIndex-1);
		if(row == null) {
			wb.getSheet(sheetName).createRow(rowIndex-1);
		}
		XSSFCell cell = wb.getSheet(sheetName).getRow(rowIndex-1).getCell(colIndex);
		if(cell == null) {
			cell = wb.getSheet(sheetName).getRow(rowIndex-1).createCell(colIndex);
		}
		
		cell.setCellValue(cellText);
		saveExcel();
		
		return 0;
	}


	public void saveExcel() throws IOException {
		FileOutputStream fisOutput = new FileOutputStream(excelFileName);
		wb.write(fisOutput);
		fisOutput.close();
	}


}

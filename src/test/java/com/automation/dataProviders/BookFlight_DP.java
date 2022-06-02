package com.automation.dataProviders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.automation.utility.ExcelUtility;

public class BookFlight_DP {

	@DataProvider(name = "DP_Bookflight")
	public static Object[][] DP_Bookflight() throws IOException {
		List<String> list = GetTestData("Test_BookFlight_1");
		Object[][] obj = new Object[list.size()][17];
		for (int ilist = 0; ilist < list.size(); ilist++) {
			obj[ilist][0] = list.get(ilist).split(";")[0];
			obj[ilist][1] = list.get(ilist).split(";")[1];
			obj[ilist][2] = list.get(ilist).split(";")[2];
			obj[ilist][3] = list.get(ilist).split(";")[3];
			obj[ilist][4] = list.get(ilist).split(";")[4];
			obj[ilist][5] = list.get(ilist).split(";")[5];
			obj[ilist][6] = list.get(ilist).split(";")[6];
			obj[ilist][7] = list.get(ilist).split(";")[7];
			obj[ilist][8] = list.get(ilist).split(";")[8];
			obj[ilist][9] = list.get(ilist).split(";")[9];
			obj[ilist][10] = list.get(ilist).split(";")[10];
			obj[ilist][11] = list.get(ilist).split(";")[11];
			obj[ilist][12] = list.get(ilist).split(";")[12];
			obj[ilist][13] = list.get(ilist).split(";")[13];
			obj[ilist][14] = list.get(ilist).split(";")[14];
			obj[ilist][15] = list.get(ilist).split(";")[15];
			obj[ilist][16] = list.get(ilist).split(";")[16];
		}

		return obj;
	}

	public static List<String> GetTestData(String testCaseName) throws IOException {

		List<String> list = new ArrayList<String>();
		
		ExcelUtility xl = new ExcelUtility();
		int rowCount = xl.RowCount();

		for (int irow = 0; irow <= rowCount; irow++) {
			if (xl.GetCellData(irow, 4).equalsIgnoreCase("Y")
					&& xl.GetCellData(irow, 1).equalsIgnoreCase(testCaseName)) {
				String testCaseId = xl.GetCellData(irow, 1);
				String testCaseDescription = xl.GetCellData(irow, 2);
				String iteration = xl.GetCellData(irow, 3);
				String departureCity = xl.GetCellData(irow, 5);
				String destinationCity = xl.GetCellData(irow, 6);
				String chooseBy = xl.GetCellData(irow, 7);
				String chooseValue = xl.GetCellData(irow, 8);
				String name = xl.GetCellData(irow, 9);
				String address = xl.GetCellData(irow, 10);
				String city = xl.GetCellData(irow, 11);
				String state = xl.GetCellData(irow, 12);
				String zipCode = xl.GetCellData(irow, 13);
				String cardType = xl.GetCellData(irow, 14);
				String cardNumber = xl.GetCellData(irow, 15);
				String month = xl.GetCellData(irow, 16);
				String year = xl.GetCellData(irow, 17);
				String nameOnCard = xl.GetCellData(irow, 18);
				list.add(testCaseId + ";" + testCaseDescription + ";" + iteration + ";" + departureCity + ";"
						+ destinationCity + ";" + chooseBy + ";" + chooseValue + ";" + name + ";" + address + ";" + city
						+ ";" + state + ";" + zipCode + ";" + cardType + ";" + cardNumber + ";" + month + ";" + year
						+ ";" + nameOnCard);
			}
		}

		return list;

	}

}

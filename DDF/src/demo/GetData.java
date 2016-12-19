package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {

	public static String[][] readExcel(String filename, String sheetname) throws IOException {

		File file = new File("E:\\TestData.xlsx");

		FileInputStream ips = new FileInputStream(file);// read your excelfile
		// write excel file - FileOutputStrem

		Workbook wb = new XSSFWorkbook(ips);

		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Data");

		int rownNum = sh.getLastRowNum() + 1;
		int colNum = sh.getRow(0).getLastCellNum(); // (+1 addition will be
													// performed internally)

		String[][] data = new String[rownNum][colNum];

		for (int i = 0; i < rownNum; i++) {//iterating row wise

			Row row = sh.getRow(i);

			for (int j = 0; j < colNum; j++) {//iterating column wise

				String value = row.getCell(j).getStringCellValue();
				data[i][j] = value;

			}

		}
		return data;

	}

}

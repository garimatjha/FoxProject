package com.fox.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelReadWrite {

	public static String filename = System.getProperty("user.dir") + "\\src\\Module7Config\\Reading_Excel.java";
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fout = null;
	private HSSFWorkbook workbook = null;
	private HSSFSheet sheet = null;
	private HSSFRow row = null;
	private HSSFCell cell = null;

	public ExcelReadWrite(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeNewSheet(String sheetName, String[][] contentToWrite) {
		try {
			if (sheetName != null && workbook.getSheet(sheetName) == null) {
				sheet = workbook.createSheet(sheetName);
			}
			int rowNum = 0;
			for (String[] r : contentToWrite) {
				row = sheet.createRow(rowNum++);
				int cellNum = 0;
				for (String cellToWrite : r) {
					cell = row.createCell(cellNum++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(cellToWrite);
				}

			}

			fout = new FileOutputStream(new File(path));
			workbook.write(fout);
			fout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
package com.fox.shows;

import java.util.ArrayList;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.fox.helper.Helper;
import com.fox.helper.ExcelReadWrite;

public class DuplicateFinder extends Helper {

	public WebDriver driver;
	private ArrayList<String> value2;
	private ArrayList<String> value1 = new ArrayList<String>();

	public DuplicateFinder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void DuplicateFinderFX(ArrayList<String> last, ArrayList<String> arrays) {

		String[] four = last.toArray(new String[last.size()]);

		String[] fxshows = arrays.toArray(new String[arrays.size()]);

		checkDuplicate(four, fxshows);
	}

	public void DuplicateFinderNationalGeographic(ArrayList<String> last, ArrayList<String> arrays) {

		String[] four = last.toArray(new String[last.size()]);

		String[] ngshows = arrays.toArray(new String[arrays.size()]);

		checkDuplicate(four, ngshows);
	}

	public void DuplicateFinderFoxSports(ArrayList<String> last, ArrayList<String> arrays) {

		String[] four = last.toArray(new String[last.size()]);

		String[] sportshows = arrays.toArray(new String[arrays.size()]);

		checkDuplicate(four, sportshows);
	}

	public void DuplicateFinderAllSports(ArrayList<String> last, ArrayList<String> arrays) {

		String[] four = last.toArray(new String[last.size()]);

		String[] allshows = arrays.toArray(new String[arrays.size()]);

		checkDuplicate(four, allshows);
	}

	public void checkDuplicate(String[] LastFour, String[] Shows) {

		int flag = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < Shows.length; j++) {
				if (LastFour[i].contains(Shows[j])) {
					flag = 1;
				} else {
					continue;
				}
			}
			if (flag == 0) {
				value1.add("");
			} else {
				value1.add("Duplicate Record");
			}
		}
		excelData(LastFour, value1);
	}

	public void excelData(String[] lastfour, ArrayList<String> value2) {

		String[][] cell = new String[5][5];

		cell[0][0] = "Shows";
		cell[0][1] = "FX";
		cell[0][2] = "National Geographic";
		cell[0][3] = "Fox Sports";
		cell[0][4] = "All Shows";

		for (int i = 0; i < 4; i++) {
			cell[i + 1][0] = lastfour[i];
		}
		int num = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (num < value2.size()) {
					cell[j + 1][i + 1] = value2.get(num);
					num++;
				}

			}
		} // fix this 
		cell[1][3] = "";
		cell[2][3] = "";
		cell[3][3] = "";
		cell[4][3] = "";
		new ExcelReadWrite("output/foxshows.xls").writeNewSheet("Sheet1", cell);
	}

}

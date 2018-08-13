package com.fox.testcases;

import java.util.ArrayList;
import org.testng.annotations.Test;
import com.fox.helper.Helper;


public class FoxTestCases extends Helper {
	
	@Test
	public void test1() throws InterruptedException {

		lts.signIn_image();
		lts.LogIn();
		lts.FillDetails(username, password);
		Thread.sleep(5000L);
		lts.clickShowsTab();
		aft.clickFOX();
		Thread.sleep(5000L);
		runJavaScript();
		Thread.sleep(2000L);
		ArrayList<String> lastFourShows = aft.AddLastFourShows();
		Thread.sleep(2000L);
		aft.clickFX();
		runJavaScript();
		Thread.sleep(2000L);
		ArrayList<String> fxTitles = aft.ShowTitlesInFx();
		Thread.sleep(2000L);
		df.DuplicateFinderFX(lastFourShows, fxTitles);
		aft.clickNationalGeographic();
		runJavaScript();
		Thread.sleep(2000L);
		ArrayList<String> nationalTitles = aft.ShowTitlesInNationalGeographic();
		Thread.sleep(2000L);
		df.DuplicateFinderNationalGeographic(lastFourShows, nationalTitles);
		aft.clickFoxSports();
		runJavaScript();
		Thread.sleep(2000L);
		ArrayList<String> sportTitles = aft.ShowTitlesInFoxSports();
		Thread.sleep(2000L);
		df.DuplicateFinderFoxSports(lastFourShows, sportTitles);
		aft.clickAllShows();
		runJavaScript();
		Thread.sleep(2000L);
		ArrayList<String> allShowTitles = aft.ShowTitlesInAllShows();
		Thread.sleep(2000L);
		df.DuplicateFinderAllSports(lastFourShows, allShowTitles);
	}

}

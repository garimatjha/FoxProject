package com.fox.shows;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fox.helper.Helper;

public class AllFoxTabs extends Helper {
	
	@FindBy(linkText = "FOX")
	WebElement fox;

	@FindBy(xpath = "//a[@class='Tile_title_2XOxg MovieTile_title_1u6rs']/div")
	List<WebElement> titleText;

	@FindBy(linkText = "FX")
	WebElement fx;

	@FindBy(xpath = "//a[@class='Tile_title_2XOxg MovieTile_title_1u6rs']/div/div[1]")
	List<WebElement> fx_titles;

	@FindBy(linkText = "National Geographic")
	WebElement nationalGeographic;

	@FindBy(xpath = "//a[@class='Tile_title_2XOxg MovieTile_title_1u6rs']/div")
	List<WebElement> nationalGeographic_titles;

	@FindBy(linkText = "FOX Sports")
	WebElement foxSports;

	@FindBy(xpath = "//a[@class='Tile_title_2XOxg MovieTile_title_1u6rs']/div/div[1]")
	List<WebElement> foxSports_titles;

	@FindBy(linkText = "All Shows")
	WebElement allShows;

	@FindBy(xpath = "//a[@class='Tile_title_2XOxg MovieTile_title_1u6rs']/div")
	List<WebElement> allShows_titles;


	public AllFoxTabs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFOX() throws InterruptedException {
		clickOnTab(fox);
	}


	public void clickFX() throws InterruptedException {
		clickOnTab(fx);
	}

	public void clickNationalGeographic() throws InterruptedException {

		clickOnTab(nationalGeographic);
	}

	public void clickFoxSports() throws InterruptedException {
		clickOnTab(foxSports); 
	}

	public void clickAllShows() throws InterruptedException {

		clickOnTab(allShows);
	}



	ArrayList<String> LastFourShows = new ArrayList<String>();

	public ArrayList<java.lang.String> AddLastFourShows() {

		ArrayList<String> title = new ArrayList<String>();

		for (int i = 0; i < titleText.size(); i++) {

			title.add(titleText.get(i).getText());

		}

		int lastFourTitle = title.size() - 4;
		for (int i = lastFourTitle; i < title.size(); i++) {
			LastFourShows.add(title.get(i));

		}

		return LastFourShows;

	}

	
	public ArrayList<String> ShowTitlesInFx() {

		ArrayList<String> title = new ArrayList<String>();

		for (int i = 0; i < fx_titles.size(); i++) {
			title.add(fx_titles.get(i).getText());
		}

		return title;

	}

	public ArrayList<String> ShowTitlesInNationalGeographic() {

		ArrayList<String> title = new ArrayList<String>();

		for (int i = 0; i < nationalGeographic_titles.size(); i++) {
			title.add(nationalGeographic_titles.get(i).getText());
		}

		return title;
	}

	public ArrayList<String> ShowTitlesInFoxSports() {

		ArrayList<String> title = new ArrayList<String>();

		for (int i = 0; i < foxSports_titles.size(); i++) {
			title.add(foxSports_titles.get(i).getText());
		}

		return title;
	}

	public ArrayList<String> ShowTitlesInAllShows() {

		ArrayList<String> title = new ArrayList<String>();

		for (int i = 0; i < allShows_titles.size(); i++) {

			title.add(allShows_titles.get(i).getText());

		}

		return title;

	}

}
 	
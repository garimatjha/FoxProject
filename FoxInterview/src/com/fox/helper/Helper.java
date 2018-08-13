package com.fox.helper;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fox.shows.LoginToShows;
import com.fox.shows.AllFoxTabs;
import com.fox.shows.DuplicateFinder;



public class Helper {

	protected WebDriver driver;
	public static String browser = "ff";
	public static String driverPath = "resources";
	public static String url = "https://www.fox.com";
	public static long page_timeout = 60L;
	public static long implicit_Wait = 20L;
	public static String username = "garimathakurjha@gmail.com";
	public static String password = "foxinterview";
	
	protected DuplicateFinder df;
	protected LoginToShows lts;
	protected AllFoxTabs aft;
		

	/**
	 * launching the browser, navigating to the URL, declaring implicit and page
	 * timeout and creating objects for the webpages
	 */
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");

		launchBrowser(browser);
		driver.navigate().to(url);
		driver.manage().timeouts().pageLoadTimeout(page_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicit_Wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		createObjectofPages();

	}

	/**
	 * destroys web page objects and quits browser
	 */
	@AfterMethod
	public void afterMethod() {
		destroyObjectOfPages();
		System.out.println("After Method");
		driver.quit();
	}

	//Default browser: Firefox, Can select Chrome as well

	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
			driver = new FirefoxDriver();
		}
	}

	/**
	 * creating the objects for each class created for each webpage
	 */
	public void createObjectofPages() {
		
		df = new DuplicateFinder(driver);
		lts = new LoginToShows(driver);
		aft = new AllFoxTabs(driver);
	}

	/**
	 * JavaScript executor for scrolling down
	 */
	public void runJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}


	public void clickOnTab(WebElement webElement) throws InterruptedException {
		webElement.click();

		for (int i = 0; i < 10; i++) {
			Thread.sleep(3000L);
			runJavaScript();
		}

	}


	public void destroyObjectOfPages() {
		
		lts = null;
		aft = null;
		df = null;
	}

}




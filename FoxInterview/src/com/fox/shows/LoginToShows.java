package com.fox.shows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fox.helper.Helper;


public class LoginToShows extends Helper {

	@FindBy(id = "path-1")
	WebElement sign_in_image;
	
	@FindBy(xpath = "//button[@class=\"Account_signIn_Q0B7n\"]")
	WebElement LogIn;
	
	@FindBy(name = "signinEmail")
	WebElement email;

	@FindBy(name = "signinPassword")
	WebElement password;

	@FindBy(xpath = "//div[@class='Account_signinButtonDesktop_2SO1g']/button")
	WebElement sign_in_button;

	@FindBy(xpath = "//a[@class='Account_signInForgotPassword_19u2T Account_link_1bICR']")
	WebElement forgot_password;

	@FindBy(linkText = "Shows")
	WebElement shows_tab;

	
	public LoginToShows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public void signIn_image() {
		sign_in_image.click();
	}

    public void LogIn() {
		LogIn.click();
	}
    
	public void FillDetails(String e_mail, String pwd) {
		email.sendKeys(e_mail);
		password.sendKeys(pwd);
		sign_in_button.click();
	}

	public void clickShowsTab() {
		shows_tab.click();

	}

}

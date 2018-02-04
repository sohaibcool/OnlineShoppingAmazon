package com.shopping.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.qa.base.TestBase;

public class LoginPage2 extends TestBase{
	

	public LoginPage2() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//input[@id='ap_email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signInBtn;
	
	@FindBy(xpath="//a[@class='a-link-nav-icon']")
	WebElement AmazonIcon;
	
		//PageFactory.initElements(driver, this);
	
	public String verifyHomePageTile()
	{
		return driver.getTitle();
	}
	public HomePage loginAmazon(String un, String pwd) throws IOException {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		return new HomePage();
	}
	public boolean validateImage() {
		return AmazonIcon.isDisplayed();
	}
	
}

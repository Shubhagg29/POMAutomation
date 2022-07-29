package com.openmrs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openmrs.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory- OR;
	
	@FindBy(name = "username")
	WebElement username;
	
	//private By username= By.name("username");

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "loginButton")
	WebElement loginBtn;

	@FindBy(xpath = "//div[contains(@class,'logo')]")
	WebElement openmrsLogo;

	@FindBy(xpath = "//li[contains(text(),'Inpatient Ward')]")
	WebElement loginType;

//Initializing the Page Object
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean ValidateCRMImage() {
		return openmrsLogo.isDisplayed();

	}
	
	public HomePage login(String user, String pwd) {
		username.sendKeys(user);	
		password.sendKeys(pwd);
		loginType.click();
		loginBtn.click();
		
		return new HomePage();

	}
}

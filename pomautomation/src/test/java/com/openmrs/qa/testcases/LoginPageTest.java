package com.openmrs.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openmrs.qa.base.TestBase;
import com.openmrs.qa.pages.HomePage;
import com.openmrs.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	
	
	
	public LoginPageTest() {
		
		super();
	}
  
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage =new LoginPage();
		
		
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {	
		
	String title=loginPage.validateLoginPageTitle();
	Assert.assertEquals("Login", title);	
	}
	
	@Test(priority = 2)
	public void openmrsLogoImageTest() {
		boolean flag = loginPage.ValidateCRMImage();
	Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

package com.openmrs.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openmrs.qa.base.TestBase;
import com.openmrs.qa.pages.HomePage;
import com.openmrs.qa.pages.LoginPage;
import com.openmrs.qa.pages.RegisterPatientPage;

public class HomePageTest extends TestBase{
	
	public LoginPage loginPage;
	public HomePage homePage;
	
  
	public RegisterPatientPage registerPatientPage;
	
	public HomePageTest(){
		
		super();
		
	}

	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		loginPage = new LoginPage();
		
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void homePageTitleTest() {
		
	String title=	homePage.validateHomePageTitle();
	Assert.assertEquals( title,"Home","Home Page title not matched.");
	
	}
	
	@Test
	public void homePageUserNameTest() {
		
		boolean flag=homePage.verifyHomeUserName();
		
		Assert.assertTrue(flag);
	}
	
	@Test
	public void registerPatientTest() {
		
		registerPatientPage=homePage.clickOnregisterPatientLink();
		
	}
	
	
	
	
}
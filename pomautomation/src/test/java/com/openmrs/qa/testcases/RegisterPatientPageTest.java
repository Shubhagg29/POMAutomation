package com.openmrs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.openmrs.qa.base.TestBase;
import com.openmrs.qa.pages.HomePage;
import com.openmrs.qa.pages.LoginPage;
import com.openmrs.qa.pages.RegisterPatientPage;
import com.openmrs.qa.util.TestUtil;

public class RegisterPatientPageTest extends TestBase {

	public LoginPage loginPage;
	public HomePage homePage;
	public RegisterPatientPage registerPatientPage;

	String sheetName = "NewPatient";

	public RegisterPatientPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		registerPatientPage = homePage.clickOnregisterPatientLink();

	}

	@Test(priority = 1)
	public void registerPatientLabelTest() {
		boolean flag = registerPatientPage.verifyRegisterPageUserName();
		Assert.assertTrue(flag);
	}

	@DataProvider
	public Object[][] getOpenCrmData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 2, dataProvider = "getOpenCrmData")
	public void createNewPatientTest(String firstName, String lastName, String gender, String dob, String dom,
			String doy) {

		registerPatientPage.createNewPatient(firstName, lastName, gender, dob, dom, doy);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
package com.openmrs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openmrs.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory- OR;
	@FindBy(xpath = "//a[contains(@id,'coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension')]")
	WebElement findRecords;

	@FindBy(xpath = "//h4[contains(text(),'Logged in as Super User (admin) at Inpatient Ward.')]")
	WebElement userLabel;

	@FindBy(xpath = "//a[contains(@id,'coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension')]")
	WebElement activeVisits;

	@FindBy(xpath = "//a[contains(@id,'referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension')]")
	WebElement registerPatient;

//Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}

	// Actions
	public boolean verifyHomeUserName() {
		
		return userLabel.isDisplayed();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public RegisterPatientPage clickOnregisterPatientLink() {
		registerPatient.click();
		return new RegisterPatientPage();
	}

	 
}

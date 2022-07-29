package com.openmrs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.openmrs.qa.base.TestBase;

public class RegisterPatientPage extends TestBase {
	
	// Page Factory- OR;
	@FindBy(xpath = "//h2[contains(text(),'Register a patient')]")
	WebElement RegisterPatientLabel;

	@FindBy(name = "givenName")
	WebElement registerFirstName;

	@FindBy(name = "familyName")
	WebElement registerLastName;

	@FindBy(id = "genderLabel")
	WebElement genderLink;

	@FindBy(id = "birthdateLabel")
	WebElement birthDayLink;

	@FindBy(id = "birthdateDay-field")
	WebElement bdayDate;

	@FindBy(id = "birthdateYear-field")
	WebElement birthYearSelect;

	
	@FindBy(xpath = "//span[contains(text(),'Address')]")
	WebElement addressLink;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id = "confirmation_label")
	WebElement confirmAction;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement confirmSubmit;

	// Intializing the Page Objects
	public RegisterPatientPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public boolean verifyRegisterPageUserName() {
		return RegisterPatientLabel.isDisplayed();
	}

	public PatientDetailPage createNewPatient(String firstName,String lastName,String gender,String dob,String dom,String doy) {
		registerFirstName.sendKeys(firstName);
		registerLastName.sendKeys(lastName);
		genderLink.click();
		Select select = new Select(driver.findElement(By.name("gender")));
	    select.selectByVisibleText(gender);
	    
		birthDayLink.click();
		bdayDate.sendKeys(dob);
		Select selectMonth = new Select(driver.findElement(By.name("birthdateMonth")));
		selectMonth.selectByVisibleText(dom);
		birthYearSelect.sendKeys(doy);
		addressLink.click();
		address1.sendKeys("Banglore");
		confirmAction.click();
		confirmSubmit.click();
		
		return new PatientDetailPage();
		
		
		
	}
}



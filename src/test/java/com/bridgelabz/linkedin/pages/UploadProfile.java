package com.bridgelabz.linkedin.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.util.Utility;

public class UploadProfile extends BaseClass{

	public UploadProfile() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='nav-settings__dropdown-trigger']")
	WebElement cta;
	
	@FindBy(xpath = "//span[@class='artdeco-button artdeco-button--tertiary artdeco-button--fluid']")
	WebElement viewProfile;
	
	@FindBy(xpath = "//img[@alt='Edit photo']")
	WebElement uploadInput;
	
	@FindBy(xpath = "//span[text()='Change photo']")
	WebElement changePhoto;
	
	@FindBy(xpath = "//span[text()='Save photo']")
	WebElement save;
	
	
	public void addProfile() throws InterruptedException {
		cta.click();
		viewProfile.click();
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(3000);
		changePhoto.click();
		Thread.sleep(4000);
		Utility.uploadItems(property.getProperty("imagePath"));
		Thread.sleep(5000);
		save.click();
		
	}
	
}

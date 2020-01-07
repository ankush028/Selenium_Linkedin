package com.bridgelabz.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.BaseClass;

public class SignOut extends BaseClass{
	
	/**
	 * @Constructor
	 */
	public SignOut() {
		PageFactory.initElements(driver,this);	
		
	}
	
	@FindBy(xpath = "//button[@id='nav-settings__dropdown-trigger']")
	WebElement cta;
	@FindBy(xpath = "//a[@href='/m/logout/']")
	WebElement signout;
	
	/**
	 * @purpose To test sign out functionality
	 * @throws InterruptedException
	 */
	public void signOut() throws InterruptedException {
		
		cta.click();
		Thread.sleep(2000);
		signout.click();
	}
	
	
}

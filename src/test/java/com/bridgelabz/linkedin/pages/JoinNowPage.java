package com.bridgelabz.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.BaseClass;

public class JoinNowPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='nav__button-tertiary']")
	WebElement joinNow;
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='join-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='join-password']")
	WebElement password;
	
	@FindBy(xpath = "//a[contains(text(),'User Agreement')]")
	WebElement userAgreement;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	WebElement privacy;
	
	@FindBy(xpath = "//a[contains(text(),'Cookie Policy')]")
	WebElement cookiePolicy;
	
	@FindBy(xpath = "//span[@id='submit-join-form-text']")
	WebElement signup;
	
	public JoinNowPage() {
		PageFactory.initElements(driver,this);
	}
	
	public HomePage JoinNow(String fname,String lName,String emailid,String pass) {
		joinNow.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		email.sendKeys(emailid);
		password.sendKeys(pass);
		signup.click();
		return new HomePage(); 
	}
	public void privacypolicy() throws InterruptedException {
		joinNow.click();
		privacy.click();
		Thread.sleep(4000);
	}
	public void cookie() {
		joinNow.click();
		cookiePolicy.click();
	}
	public void userAgreement() {
		joinNow.click();
		userAgreement.click();
	}
}

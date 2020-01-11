package com.bridgelabz.linkedin.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.util.CustomListener;

@Listeners(CustomListener.class)
public class Login extends BaseClass{

	
	@FindBy(xpath = "//a[@class='nav__button-secondary']")
	WebElement signinBtn;
	
	

	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	WebElement uname;
	
	

	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement upass;

	@FindBy(xpath="//button[@class='btn__primary--large from__button--floating']")
	@CacheLookup
	WebElement loginbtn;
	
	
	/**
	 * @Constructor
	 */
	public Login() {
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * @return login page title
	 */
	public String getLoginPageTitle() {
		signinBtn.click();
		return driver.getTitle();
	}
	
	/**
	 * @param user
	 * @param pass
	 * @return
	 */
	public HomePage login(String user,String pass) {
		signinBtn.click();
		uname.sendKeys(user);
		upass.sendKeys(pass);
		loginbtn.click();
		
	return new HomePage();
	}
	

	
}

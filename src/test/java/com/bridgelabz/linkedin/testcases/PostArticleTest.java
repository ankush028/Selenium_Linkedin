package com.bridgelabz.linkedin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.pages.Login;
import com.bridgelabz.linkedin.pages.PostArticle;

/**
 * @author Ankush Kumar Agrawal
 *@purpose To test the post article functionality
 */
public class PostArticleTest extends BaseClass{

	PostArticle postarticle;
	Login login;
	
	/**
	 * @Constructor
	 */
	public PostArticleTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		login = new Login();
		login.login(property.getProperty("username"),property.getProperty("password"));
		postarticle = new PostArticle();
	}
	
	@Test(priority = 1)
	public void postArticleTest() throws InterruptedException {
		postarticle.writeArticle();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

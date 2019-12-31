package com.bridgelabz.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.util.Utility;

public class PostArticle extends BaseClass{

	public PostArticle() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@class='link-without-visited-state hoverable-link-text']")
	WebElement article;
	
	@FindBy(xpath = "//label[@class='cover-image__label']")
	WebElement articlecoverImage;
	
	@FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
	WebElement articleDesc;
	
	@FindBy(xpath = "//a[@href='https://www.linkedin.com/post/new']")
	WebElement selectArticle;
	
	@FindBy(xpath = "//span[@class='slate-insertion-control-default-icon publishing-icon publishing-icon__content-add-icon']")
	WebElement articleCTA;
	
	@FindBy(xpath = "//span[contains(text(),'Video')]")
	WebElement articleCTAVideo;	
	
	@FindBy(xpath = "//textarea[@placeholder='Headline']")
	WebElement headline;
	
	public void writeArticle() throws InterruptedException {
		selectArticle.click();
		Thread.sleep(10000);
		articlecoverImage.click();
		Utility.uploadItems("/home/admin1/Pictures/Screenshot from 2019-12-27 16-50-16.png");
		headline.sendKeys("hello first article selenium");
		
		articleDesc.sendKeys("Nothing fancy");
		articleCTA.click();
		articleCTAVideo.click();
		Utility.uploadItems("/home/admin1/Videos/SampleVideo_1280x720_1mb.mp4");
		Thread.sleep(5000);
		
	}
	
}

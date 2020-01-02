package com.bridgelabz.linkedin.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.util.Utility;

public class PostArticle extends BaseClass {

	public PostArticle() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link-without-visited-state hoverable-link-text']")
	WebElement article;

	@FindBy(xpath = "//label[@class='cover-image__label']")
	WebElement articlecoverImage;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
	WebElement articleDesc;

	@FindBy(xpath = "//a[@href='https://www.linkedin.com/post/new']")
	WebElement selectArticle;

	@FindBy(xpath = "//span[@class='slate-insertion-control-default-icon publishing-icon publishing-icon__content-add-icon']")
	WebElement articleCTA;

	@FindBy(xpath = "//span[contains(text(),'Video')and @class='slate-embed-toolbar-label t-14']")
	WebElement articleCTAVideo;

	@FindBy(xpath = "//textarea[@placeholder='Headline']")
	WebElement headline;

	@FindBy(xpath = "//button[@id='ember55']")
	WebElement publish;

	@FindBy(xpath = "//div[@role='textbox']")
	WebElement aboutArticle;
	
	//@FindBy(xpath = "//div[@class='share-box__actions share-actions mlA ember-view']")
	@FindBy(xpath = "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")
	WebElement publish_artile; 
	
	
	public void writeArticle() throws InterruptedException {

		selectArticle.click();
		ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newtab.get(1));
		Thread.sleep(1000);
		articlecoverImage.click();
		Utility.uploadItems("/home/admin1/Pictures/Screenshot from 2019-12-27 16-50-16.png");
		Thread.sleep(3000);
		js.executeScript("scrollBy(0,1000)");
		Thread.sleep(2000);
		headline.sendKeys("hello first article selenium");
		Thread.sleep(2000);
		articleDesc.sendKeys("Nothing fancy");
		articleCTA.click();
		Thread.sleep(2000);
		articleCTAVideo.click();
		Utility.uploadItems("https://www.youtube.com/watch?v=odAlhb3EHGI");
		Thread.sleep(7000);
		publish.click();
		Thread.sleep(2000);
		aboutArticle.sendKeys("This is selenium learning");
		Thread.sleep(2000);
		publish_artile.click();
		Thread.sleep(3000);
	}

}

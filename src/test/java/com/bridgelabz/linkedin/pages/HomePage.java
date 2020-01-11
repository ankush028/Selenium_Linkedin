package com.bridgelabz.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bridgelabz.linkedin.base.BaseClass;
import com.bridgelabz.linkedin.util.Utility;

/**
 * @author Ankush kumar Agrawal
 *@purpose To test Home page functionality
 */
public class HomePage extends BaseClass{
	
	@FindBy(xpath="//button[@class='share-box__open share-box__trigger p4 hoverable-link-text t-16 t-black--light t-bold']")
	WebElement startPost;
	
	@FindBy(xpath = "//p[@class='mentions-texteditor__content']")
	WebElement createPost;
	

	@FindBy(xpath = "//span[text()='Add hashtag']")
	WebElement addHashTag;	
	
	@FindBy(xpath = "//span[text()='Post']")
	WebElement post;
	
	//@FindBy(xpath = "//li-icon[@type='camera-icon'and @class='artdeco-button__icon']")	
	@FindBy(xpath="//li-icon[@type='camera-icon']")
	WebElement selectImage;
	
	@FindBy(xpath ="//li-icon[@type='video-camera-icon']" )
	WebElement selectVideo;

	@FindBy(xpath = "//li-icon[@type='document-icon']")
	WebElement selectDoc;
		
	@FindBy(xpath = "//span[@data-control-name='document_share.select_file_local']")
	WebElement chooseFile;
	
	@FindBy(xpath = "//input[@placeholder='Add a descriptive title to your document']")
	WebElement doctitle;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath = "//span[@class='ph1']")
	WebElement anyone;
	
	@FindBy(xpath = "//h4[text()='Connections only']")
	WebElement connectionOnly;
	
	@FindBy(xpath = "//span[text()='Done']")
	WebElement done;
	
	@FindBy(xpath = "//span[text()='Add hashtag']")
	WebElement addhash;
	
	/**
	 * @constructor
	 */
	public HomePage() {
		PageFactory.initElements(driver,this);		
	}
	
	/**
	 * @param title
	 * @throws InterruptedException
	 * @action to test post article with attach image
	 */
	public void imagePostStory(String title) throws InterruptedException  {
			startPost.click();
			anyone.click();
			connectionOnly.click();
			done.click();
			js.executeScript("window.scrollBy(0,350)");	
			createPost.sendKeys(title);
			selectImage.click();
			Utility.uploadItems(property.getProperty("imagePath"));
			next.click();
			Thread.sleep(1000);

			
			addHashTag.click();
			
			post.click();
			
			Thread.sleep(2000);
	}
	/**
	 * @param title
	 * @throws InterruptedException
	 * @action to test post article with attach video
	 */
	public void videoPostStory(String title) throws InterruptedException {
		startPost.click();
		js.executeScript("window.scrollBy(0,350)");
		createPost.sendKeys(title);
		selectVideo.click();
		Utility.uploadItems(property.getProperty("videoPath"));
		next.click();
		Thread.sleep(1000);
		addHashTag.click();
		post.click();
		Thread.sleep(10000);		
	}
	/**
	 * @param postTitle
	 * @param docTitle
	 * @throws InterruptedException
	 * @action to test post article with story
	 */
	public void documentPostStory(String postTitle,String docTitle) throws InterruptedException {
		startPost.click();
		js.executeScript("window.scrollBy(0,350)");
		createPost.sendKeys(postTitle);
		selectDoc.click();
		Thread.sleep(1000);
		chooseFile.click();	
		Utility.uploadItems(property.getProperty("documentPath"));
		Thread.sleep(8000);
		doctitle.sendKeys(docTitle);
		next.click();
		addHashTag.click();
		post.click();
		Thread.sleep(10000);
	}
	
	
	}

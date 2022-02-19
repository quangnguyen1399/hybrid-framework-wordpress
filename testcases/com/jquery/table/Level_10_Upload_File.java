package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;
import pageUIs.jQuery.HomePageUI;

public class Level_10_Upload_File extends BaseTest {
	WebDriver driver;
	//String[] fileName = {"bia.jpg", "Ngan.jpg", "thuong.jpg"};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {

		driver = getBrowserDriver(browserName, appurl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		String[] fileNames = {"bia.jpg"};
		homePage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
		// //p[@class='name' and text()='bia.jpg']
		
		homePage.clickToStartUploadButton();
		
		Assert.assertTrue(homePage.areFileUpLoadedSuccess(fileNames));
		// //p[@class='name']/a[text()='bia.jpg']
		
	}
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshPage(driver);
		String[] fileNames = {"bia.jpg", "Ngan.jpg", "thuong.jpg"};
		
		homePage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
		// //p[@class='name' and text()='bia.jpg']
		
		homePage.clickToStartUploadButton();
		
		Assert.assertTrue(homePage.areFileUpLoadedSuccess(fileNames));
		// //p[@class='name']/a[text()='bia.jpg']
		
	}
	
  
	@AfterClass
	public void afterClass() {
		driver.quit();
	  
	}
	private HomePageObject homePage;

}

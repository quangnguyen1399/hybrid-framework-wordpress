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

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {

		driver = getBrowserDriver(browserName, appurl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	public void Table_01_Paging() {
		homePage.openPageByNumber("7");
		Assert.assertTrue(homePage.isPageActiveByNumber("7"));
		
		homePage.openPageByNumber("9");
		Assert.assertTrue(homePage.isPageActiveByNumber("9"));
		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		homePage.refreshPage(driver);
		
	}
	public void Table_02_Search_Verify() {
		homePage.inputToHeaderTextboxByLabel("Females", "276880");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.areRowRecordDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
	}
	public void Table_03_Edit_Delete() {
		//remove
		homePage.clickToActionIconByCountryName("AFRICA","remove");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);
		
		//edit
		homePage.clickToActionIconByCountryName("AFRICA","edit");
		
		homePage.refreshPage(driver);
		
	}
	@Test
	public void Table_04_Edit_Delete() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		homePage.clickToAddToTable();
		homePage.clickToAddToTable();
		homePage.clickToAddToTable();
		homePage.clickToAddToTable();
		homePage.clickToAddToTable();
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Artist", "4", "automation fc");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Album", "1", "quang fc");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Year", "4", "nhatquang");
		homePage.sleepInSecond(2);
	}
	
  
	@AfterClass
	public void afterClass() {
		driver.quit();
	  
	}
	private HomePageObject homePage;

}

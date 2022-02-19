package com.wordpress.posts;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_11_Login_Element_Undisplayed extends BaseTest{
	WebDriver driver;	
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		loginPage = new LoginPageObject(driver);
	}

	@Test
	public void TC_01_Valid_Email_Password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToLoginButton();
		
		dashboardPage = new DashboardPageObject(driver);
		loginPage.sleepInSecond(2);
		Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
	}
	@Test
	public void TC_02_Element_Displayed() {
		// True
		dashboardPage.clickToScreenOptionButton();
		dashboardPage.sleepInSecond(3);
		
		Assert.assertTrue(dashboardPage.isActivityCheckboxDisplayed());
		
	}
	
	@Test
	public void TC_03_Element_Undisplayed() {
		// False
		dashboardPage.clickToScreenOptionButton();
		dashboardPage.sleepInSecond(3);
		
		Assert.assertFalse(dashboardPage.isActivityCheckboxUndisplayed());
	}
	@Test
	public void TC_04_Element_Undisplayed_Without_DOM() {
		// False
		Assert.assertFalse(dashboardPage.isPostSearchTextboxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

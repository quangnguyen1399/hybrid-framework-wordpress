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

public class Level_04_Login_Multiple_Browser extends BaseTest{
	WebDriver driver;	
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		
	}
	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPageObject(driver);
	}
	@Test
	public void Login_01_Empty_Email_Username() {
		loginPage.inputToUsernameTextbox("");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	}
	
	public void Login_02_Invalid_Email() {
		loginPage.inputToUsernameTextbox("nhat@$#");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		String userNotExistMeseage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
	}
	
	public void Login_03_Username_Not_Exist() {
		loginPage.inputToUsernameTextbox("autotest" + getRandom());
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		
		String userNotExistMeseage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
		
	}
	
	public void TC_04_Empty_Password() {
		loginPage.inputToUsernameTextbox("autotest");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);

		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	
	public void TC_05_Invalid_Password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());

	}
	
	public void TC_06_Incorrect_Password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("1234567");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());

	}
	@Test
	public void TC_07_Valid_Email_Password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToLoginButton();
		
		dashboardPage = new DashboardPageObject(driver);
		loginPage.sleepInSecond(2);
		Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

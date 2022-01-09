package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_03_Login_Page_Object {
	WebDriver driver;	
	String projectLocation = System.getProperty("user.dir");
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin");
		loginPage = new LoginPageObject(driver);
	}
	@Test
	public void Login_01_Empty_Email_Username() {
		loginPage.inputToUsernameTextbox("");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	}
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.inputToUsernameTextbox("nhat@$#");
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		String userNotExistMeseage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
	}
	@Test
	public void Login_03_Username_Not_Exist() {
		loginPage.inputToUsernameTextbox("autotest" + randomEmail());
		loginPage.clickToContinueButton();
		loginPage.sleepInSecond(2);
		
		String userNotExistMeseage = loginPage.getInvalidEmailErrorMessage();
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
		
	}
	@Test
	public void TC_04_Empty_Password() {
		loginPage.inputToUsernameTextbox("autotest");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);

		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	@Test
	public void TC_05_Invalid_Password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());

	}
	@Test
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
	
	public int randomEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}

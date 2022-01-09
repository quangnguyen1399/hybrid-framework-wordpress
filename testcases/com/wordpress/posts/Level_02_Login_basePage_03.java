package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Login_basePage_03 extends BasePage {
	WebDriver driver;	
	String projectLocation = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@BeforeMethod
	public void beforeMethod() {
		openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin");
	}
	@Test
	public void Login_01_Empty_Email_Username() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");
		clickToElement(driver, "//button[@type='submit']");
		
		Assert.assertTrue(isElementDisplayed(driver, "//span[text()='Please enter a username or email address.']"));
	}
	@Test
	public void Login_02_Invalid_Email() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "nhat@$#");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		String userNotExistMeseage = getElementText(driver, "//div[@class='form-input-validation is-error']");
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
		
	}
	@Test
	public void Login_03_Username_Not_Exist() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "quang123ahaha");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		String userNotExistMeseage = getElementText(driver, "//div[@class='form-input-validation is-error']");
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
		
	}
	@Test
	public void TC_04_Empty_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "autotest");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		sendkeyToElement(driver, "//input[@id='password']", "");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Don't forget to enter your password.\"]"));
	}
	@Test
	public void TC_05_Invalid_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "autotest");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		sendkeyToElement(driver, "//input[@id='password']", "123");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));

	}
	@Test
	public void TC_06_Incorrect_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "autotest");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		sendkeyToElement(driver, "//input[@id='password']", "123453645747");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));

	}
	@Test
	public void TC_07_Valid_Email_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		sendkeyToElement(driver, "//input[@id='password']", "automationfc");
		clickToElement(driver ,"//button[@type='submit']");
		sleepInSecond(2);
		
		Assert.assertTrue(isElementDisplayed(driver, "//h1[text()='Dashboard']"));
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

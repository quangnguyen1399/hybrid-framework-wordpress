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

public class Level_01_Login_Repeat_Yourself {
	WebDriver driver;
	
	String projectLocation = System.getProperty("user.dir");
	By usernameTextbox = By.id("usernameOrEmail");
	By continueButton = By.xpath("//button[@type='submit']");
	By passwordTextbox = By.id("password");
	By loginButton = By.xpath("//button[@type='submit']");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.wordpress.com/wp-admin");

	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin");
	}
	@Test
	public void Login_01_Empty_Email_Username() {
		driver.findElement(usernameTextbox).sendKeys("");
		driver.findElement(continueButton).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please enter a username or email address.']")).isDisplayed());
		
	}
	@Test
	public void Login_02_Invalid_Email() {
		driver.findElement(usernameTextbox).sendKeys("nhat@$#");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		String userNotExistMeseage = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']")).getText();
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
		
	}
	@Test
	public void Login_03_Username_Not_Exist() {
		driver.findElement(usernameTextbox).sendKeys("quang123ahaha");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		String userNotExistMeseage = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']")).getText();
		Assert.assertEquals(userNotExistMeseage, "User does not exist. Would you like to create a new account?");
		
	}
	@Test
	public void TC_04_Empty_Password() {
		driver.findElement(usernameTextbox).sendKeys("autotest");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		driver.findElement(passwordTextbox).sendKeys("");
		driver.findElement(loginButton).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Don't forget to enter your password.\"]")).isDisplayed());
	}
	@Test
	public void TC_05_Invalid_Password() {
		driver.findElement(usernameTextbox).sendKeys("autotest");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		driver.findElement(passwordTextbox).sendKeys("123");
		driver.findElement(loginButton).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]")).isDisplayed());
	}
	@Test
	public void TC_06_Incorrect_Password() {
		driver.findElement(usernameTextbox).sendKeys("automationeditor");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		driver.findElement(passwordTextbox).sendKeys("1234556789");
		driver.findElement(loginButton).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]")).isDisplayed());

	}
	@Test
	public void TC_07_Valid_Email_Password() {
		driver.findElement(usernameTextbox).sendKeys("automationeditor");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		driver.findElement(passwordTextbox).sendKeys("automationfc");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int randomEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}

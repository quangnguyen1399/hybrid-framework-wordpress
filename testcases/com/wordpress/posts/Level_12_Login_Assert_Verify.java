package com.wordpress.posts;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_12_Login_Assert_Verify extends BaseTest{
	WebDriver driver;	
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	String name;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		loginPage = new LoginPageObject(driver);
	}

	@Test
	public void Login_01_Assert() {
		System.out.println("Step 1: false");
		Assert.assertTrue(true);
		
		System.out.println("Step 2: true");
		Assert.assertTrue(true);
		
		System.out.println("Step 3: true");
		Assert.assertFalse(false);
		
		System.out.println("Step 4: false");
		Assert.assertFalse(false);
	}
	@Test
	public void Login_02_Verify() {
		name = "nguyen nhat quang";
		
		System.out.println("Step 1: false");
		verifyTrue(true);
		
		System.out.println("Step 2: true");
		verifyTrue(true);
		
		System.out.println("Step 3: true");
		verifyFalse(false);
		
		System.out.println("Step 4: false");
		verifyFalse(false);
		
		
		verifyEquals(name, "nguyen nhat quang...");

	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

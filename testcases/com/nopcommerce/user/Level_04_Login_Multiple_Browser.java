package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.RegisterPageObject;



public class Level_04_Login_Multiple_Browser extends BaseTest {
	
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	String emailAddress;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		emailAddress = "quangnguyen" + getRandom() + "@gmail.com";
		homePage = new HomePageObject(driver);
	}
	@Test
	public void User_01_Register_To_System() {
		
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstnameTextbox("quang");
		
		registerPage.inputToLastnameTextbox("nguyen");
		
		registerPage.inputToEmailTextbox(emailAddress);
		
		registerPage.inputToPasswordTextbox("123456");
		
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.sleepInSecond(3);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageObject(driver);
	
	}
	@Test
	public void User_02_Login_To_System() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");
		
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}

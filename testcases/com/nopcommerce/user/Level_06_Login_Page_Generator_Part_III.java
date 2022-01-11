package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.CustomerInforPageObject;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;



public class Level_06_Login_Page_Generator_Part_III extends BaseTest {
	
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject customerInforPage;
	//PageGeneratorManager pageGenerator;
	
	String emailAddress;
	
	String projectLocation = System.getProperty("user.dir");
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		
		emailAddress = "quangnguyen" + getRandom() + "@gmail.com";
		//pageGenerator = PageGeneratorManager.getPageGenerator();
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	@Test
	public void User_01_Register_To_System() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstnameTextbox("quang");
		
		registerPage.inputToLastnameTextbox("nguyen");
		
		registerPage.inputToEmailTextbox(emailAddress);
		
		registerPage.inputToPasswordTextbox("123456");
		
		registerPage.inputToConfirmPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		homePage = registerPage.clickToLogoutLink();
		
	
	}
	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");
		
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
		
	}
	@Test
	public void User_03_Customer_Infor() {
		
		customerInforPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), "quang");
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), "nguyen");
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), emailAddress);
		
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	public int getRandom() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}

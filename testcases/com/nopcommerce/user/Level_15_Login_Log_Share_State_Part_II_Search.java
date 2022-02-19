package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;


public class Level_15_Login_Log_Share_State_Part_II_Search extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Login - Step 1: Open Login Page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 2: Input to Email textbox with value: "+ Common_01_Register.email);
		loginPage.inputToEmailTextbox(Common_01_Register.email);
		
		log.info("Login - Step 3: Input to Password textbox with value: "+ Common_01_Register.password);
		loginPage.inputToPasswordTextbox(Common_01_Register.password);
		
		log.info("Login - Step 4: Click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 5: Verify My Account link displayed");
		verifyTrue(homePage.isMyAcountLinkDisplayed());
		
		log.info("Login - Step 6: Verify Log out link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC_01_Search_Product_With_Name() {
		
		
	}
	
	@Test
	public void TC_02_Search_Product_With_Category() {
		
	}
	
	@Test
	public void TC_03_Search_Product_With_Price() {
		
	}
	
	@Test
	public void TC_04_Search_Product_With_Distance() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}

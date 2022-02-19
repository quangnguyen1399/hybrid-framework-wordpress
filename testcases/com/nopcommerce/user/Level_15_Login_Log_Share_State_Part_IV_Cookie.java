package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_02_Register_Cookie;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;


public class Level_15_Login_Log_Share_State_Part_IV_Cookie extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		
		log.info("Login - Step 1: Open Login Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Login - Step 2: Login by Cookie");
		for(Cookie cookie : Common_02_Register_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		
		homePage.refreshPage(driver);
		
		log.info("Login - Step 3: Verify My Account link displayed");
		verifyTrue(homePage.isMyAcountLinkDisplayed());
		
		log.info("Login - Step 4: Verify Log out link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@Test
	public void TC_01_Sort_Name_Ascending() {
		
		
	}
	
	@Test
	public void TC_02_Sort_Name_Descending() {
		
	}
	
	@Test
	public void TC_03_Sort_Price_Ascending() {
		
	}
	
	@Test
	public void TC_04_Sort_Price_Descending() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}


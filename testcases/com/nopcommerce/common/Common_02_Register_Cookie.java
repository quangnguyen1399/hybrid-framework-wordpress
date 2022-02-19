package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;


public class Common_02_Register_Cookie extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	String firstName, lastName, date, month, year, companyName, configPassword;
	public static String email, password;
	public static Set<Cookie> allCookies;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
		
		firstName = "quang";
		lastName = "nguyen";
		date ="1";
		month = "March";
		year = "1999";
		companyName ="quang cong ty";
		email ="quang" + getRandom() + "@gmail.com";
		password = "123456";
		configPassword ="123456";
		
		log.info("Register - Step 1: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Register - Step 2: Verify Register link displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 3: Verify Login link displayed ");
		verifyTrue(homePage.isLoginLinkDisplayed());
		
		log.info("Register - Step 4: Click to Register link at home Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 5: Click to Gender male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 6: Input to Firstname textbox with value: "+ firstName);
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 7: Input to Lastname textbox with value: "+ lastName);
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Register - Step 8: Select date dropdown");
		registerPage.selectDayDropdown(date);
		
		log.info("Register - Step 9: Select month dropdown");
		registerPage.selectMothDropdown(month);
		
		log.info("Register - Step 10: Select year dropdown");
		registerPage.selectYearDropdown(year);
		
		log.info("Register - Step 11: Input to Email textbox with value: "+ email);
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 12: Input to Company textbox with value: "+ companyName);
		registerPage.inputCompanyTextbox(companyName);
		
		log.info("Register - Step 13: Input to Password textbox with value: "+ password);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(configPassword);
		
		log.info("Register - Step 14: Click to Register button at Register page ");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 15: Verify success message displayed ");
		verifyEquals(registerPage.SuccessMessageDisplayed(), "Your registration completed");
		
		allCookies = driver.manage().getCookies();
		
		driver.quit();
	}

}

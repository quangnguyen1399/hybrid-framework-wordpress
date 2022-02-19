package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;

import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;

import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;
import utilitiesConfig.FakerConfig;


public class Level_18_Login_Fake_Data extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	int random = getRandom();

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {
		driver = getBrowserDriver(browserName, appurl);
	}
	@Test
	public void Login_01_Register() {
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
		
		log.info("Register - Step 6: Input to Firstname textbox with value: "+ UserData.Login.FIRST_NAME);
		registerPage.inputToFirstnameTextbox(UserData.Login.FIRST_NAME);
		
		log.info("Register - Step 7: Input to Lastname textbox with value: "+ UserData.Login.LAST_NAME);
		registerPage.inputToLastnameTextbox(UserData.Login.LAST_NAME);
		
		log.info("Register - Step 8: Select date dropdown");
		registerPage.selectDayDropdown(UserData.Login.DATE);
		
		log.info("Register - Step 9: Select month dropdown");
		registerPage.selectMothDropdown(UserData.Login.MONTH);
		
		log.info("Register - Step 10: Select year dropdown");
		registerPage.selectYearDropdown(UserData.Login.YEAR);
		
		log.info("Register - Step 11: Input to Email textbox with value: "+ UserData.Login.EMAIL_PREFIX + random + UserData.Login.EMAIL_POSTFIX);
		registerPage.inputToEmailTextbox(UserData.Login.EMAIL_PREFIX + random + UserData.Login.EMAIL_POSTFIX);
		
		log.info("Register - Step 12: Input to Company textbox with value: "+ UserData.Login.COMPANY_NAME);
		registerPage.inputCompanyTextbox(UserData.Login.COMPANY_NAME);
		
		log.info("Register - Step 13: Input to Password textbox with value: "+ UserData.Login.PASWORD);
		registerPage.inputToPasswordTextbox(UserData.Login.PASWORD);
		registerPage.inputToConfirmPasswordTextbox(UserData.Login.PASWORD);
		
		log.info("Register - Step 14: Click to Register button at Register page ");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 15: Verify success message displayed ");
		verifyEquals(registerPage.SuccessMessageDisplayed(), "Your registration completed");
		
		log.info("Register - Step 16: Click to Logout link to navigate to Home page ");
		registerPage.clickToLogoutLink();
		
	}
	@Test
	public void TC_02_Login() {
		log.info("Register - Step 1: Open Login Page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Register - Step 2: Input to Email textbox with value: "+ UserData.Login.EMAIL_PREFIX + random + UserData.Login.EMAIL_POSTFIX);
		loginPage.inputToEmailTextbox(UserData.Login.EMAIL_PREFIX + random + UserData.Login.EMAIL_POSTFIX);
		
		log.info("Register - Step 3: Input to Password textbox with value: "+ UserData.Login.PASWORD);
		loginPage.inputToPasswordTextbox(UserData.Login.PASWORD);
		
		log.info("Register - Step 4: Click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Register - Step 5: Verify My Account link displayed");
		verifyTrue(homePage.isMyAcountLinkDisplayed());
		
		log.info("Register - Step 6: Verify Log out link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}


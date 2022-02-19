package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;


@Feature("User")
public class Level_14_Login_Log_Allure_Report extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	String firstName, lastName, date, month, year, email, companyName, password, configPassword;
	

	@Parameters({"browser", "url"})
	@BeforeClass
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
		
		
	}
	
	@Description("User 01 - Rigister to System")
	@Severity(SeverityLevel.NORMAL)
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
		
		log.info("Register - Step 16: Click to Logout link to navigate to Home page ");
		registerPage.clickToLogoutLink();
		
	}
	
	@Description("User 02 - Login to System")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Login() {
		log.info("Register - Step 1: Open Login Page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Register - Step 2: Input to Email textbox with value: "+ email);
		loginPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 3: Input to Password textbox with value: "+ password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 4: Click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Register - Step 5: Verify My Account link displayed");
		verifyTrue(homePage.isMyAcountLinkDisplayed());
		
		log.info("Register - Step 6: Verify Log out link displayed");
		verifyFalse(homePage.isLogoutLinkDisplayed());
		
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}


package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.AboutUsPageObject;
import pageObject.nopCommerce.CustomerInforPageObject;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.NewsPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;
import pageObject.nopCommerce.ShoppingCartPageObject;
import pageObject.nopCommerce.SiteMapPageObject;



public class Level_08_Login_Page_Dynamic_Locator extends BaseTest {
	
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject customerInforPage;
	SiteMapPageObject siteMapPage;
	ShoppingCartPageObject shoppingCartPage;
	NewsPageObject newsPage;
	AboutUsPageObject aboutUsPage;
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
	@Test
	public void User_04_Switch_Page() {
		// Customer -> Site Map
		siteMapPage = (SiteMapPageObject) customerInforPage.openFooterPageByName(driver, "Sitemap");
		
		//Site Map -> News
		newsPage = (NewsPageObject) customerInforPage.openFooterPageByName(driver, "News");
		
		//News -> Shopping Cart
		shoppingCartPage = (ShoppingCartPageObject) customerInforPage.openFooterPageByName(driver, "Shopping cart");
		
		//Shopping Cart -> About Us
		aboutUsPage = (AboutUsPageObject) customerInforPage.openFooterPageByName(driver, "About us");
		
	}
	@Test
	public void User_05_Dynamic_Page_Locator() {
		// Customer -> Site Map
		siteMapPage.openFooterPageByName(driver, "Sitemap");
		newsPage = PageGeneratorManager.getNewsPage(driver);
		//Site Map -> News
		newsPage.openFooterPageByName(driver, "News");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		//News -> Shopping Cart
		shoppingCartPage.openFooterPageByName(driver, "Shopping cart");
		aboutUsPage = PageGeneratorManager.getAboutUsPage(driver);
		
		//Shopping Cart -> About Us
		aboutUsPage.openFooterPageByName(driver, "About us");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
		
		
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

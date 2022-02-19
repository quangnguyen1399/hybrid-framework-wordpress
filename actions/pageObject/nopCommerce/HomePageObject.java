package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	//PageGeneratorManager pageGenerator;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	//	pageGenerator = new PageGeneratorManager();
	}

	@Step("Step 04 : click To Register Link ")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}

	public boolean isMyAcountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

	public CustomerInforPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}

	@Step("Step 02 : is Register Link Displayed")
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

	@Step("Step 03 : is Login Link Displayed")
	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGIN_LINK);
	}

	@Step("Step  : is Logout Link Displayed")
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}
}

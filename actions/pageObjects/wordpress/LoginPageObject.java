package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.LoginPageUI;

public class LoginPageObject extends BasePage{
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String usernameOrEmail) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, usernameOrEmail);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}

	public void inputToPasswordTextbox(String passwrord) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwrord);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
	}

	public boolean isInvalidPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
	}

}

package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	//PageGeneratorManager pageGenerator;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator = new PageGeneratorManager();
	}

	@Step("Step 06 : input To Firstname Textbox with value: {0}")
	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRT_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRT_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}
	
	
	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("Step 05 : click To Gender Male Radio Button ")
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
		
	}

	public void selectDayDropdown(String date) {
		waitForElementClickable(driver, RegisterPageUI.DATE_SELECTED, date);
		clickToElement(driver, RegisterPageUI.DATE_SELECTED, date);
		
	}

	public void selectMothDropdown(String month) {
		waitForElementClickable(driver, RegisterPageUI.MONTH_SELECTED, month);
		clickToElement(driver, RegisterPageUI.MONTH_SELECTED, month);
		
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, RegisterPageUI.YEAR_SELECTED, year);
		clickToElement(driver, RegisterPageUI.YEAR_SELECTED, year);
		
	}

	public void inputCompanyTextbox(String companyName) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public Object SuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	
}

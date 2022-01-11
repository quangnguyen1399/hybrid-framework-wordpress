package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInforPageUI;
import pageUIs.nopCommerce.HomePageUI;

public class CustomerInforPageObject extends BasePage {
	WebDriver driver;
	//PageGeneratorManager pageGenerator;
	
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	//	pageGenerator = new PageGeneratorManager();
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
	}

}

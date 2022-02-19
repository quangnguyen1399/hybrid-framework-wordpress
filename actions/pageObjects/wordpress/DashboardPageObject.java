package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.DashboardPageUI;

public class DashboardPageObject extends BasePage {

	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDashboardHeaderTextDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
	}
	
	public boolean isActivityCheckboxDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	
	public boolean isActivityCheckboxUndisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	
	public boolean isPostSearchTextboxUndisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.POST_SEARCH_TEXTBOX);
	}
	
	public void clickToScreenOptionButton() {
		waitForElementVisible(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
	}

}

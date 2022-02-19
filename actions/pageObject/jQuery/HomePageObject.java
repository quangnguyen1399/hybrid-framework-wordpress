package pageObject.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderTextboxByLabel(String labelName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, labelName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, labelName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, labelName);
		
	}

	public boolean areRowRecordDisplayed(String female, String countryName, String male, String total) {
		waitForElementClickable(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, female, countryName, male, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, female, countryName, male, total);
	}

	public void clickToActionIconByCountryName(String countryName, String actionIcon) {
		waitForElementVisible(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionIcon);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionIcon);
		
	}

	public void inputToTextboxByColumnNameAtRowNumber(String columnName, String rowIndex, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName);
		//x - columnIndex
		int columnIndex = getElementNumber(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName) + 1;
		// y - rowIndex
		sendkeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_AND_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
		
	}

	public void clickToAddToTable() {
		waitForElementVisible(driver, HomePageUI.ADD_TO_TABLE_BUTTON);
		clickToElement(driver, HomePageUI.ADD_TO_TABLE_BUTTON);
		
	}

	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for(String fileName : fileNames) {
			if(isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName)) {
				status = true;
			} else {
				return status;
			}
		}
		return status;
	}

	public void clickToStartUploadButton() {
		List<WebElement> uploadButtons = getListWebElement(driver, HomePageUI.START_UPLOAD_BUTTON);
		
		for (WebElement uploadBtn : uploadButtons) {
			uploadBtn.click();
			sleepInSecond(2);
		}
	}

	public boolean areFileUpLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for(String fileName : fileNames) {
			if(isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME, fileName)) {
				status = true;
			} else {
				return status;
			}
		}
		return status;
	}

}

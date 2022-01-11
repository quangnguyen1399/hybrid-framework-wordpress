package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AboutUsPageUI;

public class AboutUsPageObject extends BasePage{
	WebDriver driver;
	
	public AboutUsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

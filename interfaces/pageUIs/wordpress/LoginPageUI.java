package pageUIs.wordpress;

public class LoginPageUI {
	// UI: User Interfacfe - Xpath/ Locator
	
	public static final String USERNAME_EMAIL_TEXTBOX = "//input[@id='usernameOrEmail']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String CONTINUE_BUTTON = "//button[@type='submit']";
	public static final String LOGIN_BUTTON = "//button[text()='Log In']";
	public static final String EMPTY_EMAIL_ERROR_MSG = "//span[text()='Please enter a username or email address.']";
	public static final String INVALID_EMAIL_ERROR_MSG = "//div[@class='form-input-validation is-error']";
	public static final String EMPTY_PASSWORD_ERROR_MSG = "//span[text()=\"Don't forget to enter your password.\"]";
	public static final String INVALID_PASSWORD_ERROR_MSG = "//span[text()=\"Oops, that's not the right password. Please try again!\"]";

}

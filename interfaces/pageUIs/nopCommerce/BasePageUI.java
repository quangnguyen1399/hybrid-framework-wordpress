package pageUIs.nopCommerce;

public class BasePageUI {
	// ko tham so = truyen co dinh ten page
	public static final String SITE_MAP_LINK="//div[@class='footer']//a[text()='Sitemap']";
	public static final String HOME_PAGE_LINK="//img[@alt='nopCommerce demo store']";
	public static final String SHOPPING_CART_LINK="//div[@class='footer']//a[text()='Shopping cart']";
	public static final String ABOUT_US_LINK="//div[@class='footer']//a[text()='About us']";
	public static final String NEWS_LINK="//div[@class='footer']//a[text()='News']";

	
	// co 1 tham so = dynamic page name
	public static final String FOOTER_PAGE_LINK_BY_NAME ="//div[@class='footer']//a[text()='%s']";

}

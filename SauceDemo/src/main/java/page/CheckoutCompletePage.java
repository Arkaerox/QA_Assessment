package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{
	final WebDriver driver;
	// Page Objects
	@CacheLookup
	@FindBy(xpath = "//h2[@class='complete-header']")
	public WebElement completeHdr;
	@FindBy(xpath = "//div[@class='complete-text']")
	public WebElement completeTxt;
	@FindBy(xpath = "//img[@src='https://upload.wikimedia.org/wikipedia/commons/7/72/Pony_Express%2760_West_bound_1860.jpg']")
	public WebElement completeImg;
	
	@FindBy(xpath = "//div[@class='bm-burger-button']")
	public WebElement menuIcon;
	@FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
	public WebElement cartIcon;
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	public WebElement allItemsLink;
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	public WebElement aboutLink;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	public WebElement logoutLink;
	@FindBy(xpath = "//a[@id='reset_sidebar_link]")
	public WebElement resetAppState;

	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver);
		PageFactory.initElements(driver, this);
	}
	public void validateCompleteCheckout() {
		checkExist(completeHdr);
		checkExist(completeTxt);
		checkExist(completeImg);
		System.out.println("Order has been successfully dispatched.");
		
	}
	
	public void clickMenu(){
		hover(menuIcon, driver);
		click(menuIcon);
	}

	public void clickLogout() {
		hover(logoutLink, driver);
		click(logoutLink);
	}
	
	public void clickAllItemsLink() {
		hover(allItemsLink, driver);
		click(allItemsLink);
	}

	public void clickCart() {
		hover(cartIcon, driver);
		click(cartIcon);
	}

}


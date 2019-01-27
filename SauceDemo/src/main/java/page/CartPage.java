package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
	final WebDriver driver;
	// Page Objects
	@CacheLookup
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	public WebElement backpackTitle;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bike Light')]")
	public WebElement bikelightTitle;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
	public WebElement boltTshirtTitle;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
	public WebElement fleeceJacketTitle;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Onesie')]")
	public WebElement onesieTitle;
	@FindBy(xpath = "//div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]")
	public WebElement tshirtRedTitle;

	@FindBy(xpath = "//a[@id='item_4_title_link']//following::div[@class='inventory_item_desc']")
	public WebElement backpackDescr;
	@FindBy(xpath = "//a[@id='item_0_title_link']//following::div[@class='inventory_item_desc']")
	public WebElement bikelightDescr;
	@FindBy(xpath = "//a[@id='item_1_title_link']//following::div[@class='inventory_item_desc']")
	public WebElement boltTshirtDescr;
	@FindBy(xpath = "//a[@id='item_5_title_link']//following::div[@class='inventory_item_desc']")
	public WebElement fleeceJacketDescr;
	@FindBy(xpath = "//a[@id='item_2_title_link']//following::div[@class='inventory_item_desc']")
	public WebElement onesieDescr;
	@FindBy(xpath = "//a[@id='item_3_title_link']//following::div[@class='inventory_item_desc']")
	public WebElement tshirtRedDescr;

	@FindBy(xpath = "//a[@id='item_4_title_link']//preceding::div[@class='cart_quantity']")
	public WebElement backpackQuantity;
	@FindBy(xpath = "//a[@id='item_0_title_link']//preceding::div[@class='cart_quantity']")
	public WebElement bikelightQuantity;
	@FindBy(xpath = "//a[@id='item_1_title_link']//preceding::div[@class='cart_quantity']")
	public WebElement boltTshirtQuantity;
	@FindBy(xpath = "//a[@id='item_5_title_link']//preceding::div[@class='cart_quantity']")
	public WebElement fleeceJacketQuantity;
	@FindBy(xpath = "//a[@id='item_2_title_link']//preceding::div[@class='cart_quantity']")
	public WebElement onesieQuantity;
	@FindBy(xpath = "//a[@id='item_3_title_link']//preceding::div[@class='cart_quantity']")
	public WebElement tshirtRedQuantity;

	@FindBy(xpath = "//a[@id='item_4_title_link']//preceding::div[@class='inventory_item_price']")
	public WebElement backpackPrice;
	@FindBy(xpath = "//a[@id='item_0_title_link']//preceding::div[@class='inventory_item_price']")
	public WebElement bikelightPrice;
	@FindBy(xpath = "//a[@id='item_1_title_link']//preceding::div[@class='inventory_item_price']")
	public WebElement boltTshirtPrice;
	@FindBy(xpath = "//a[@id='item_5_title_link']//preceding::div[@class='inventory_item_price']")
	public WebElement fleeceJacketPrice;
	@FindBy(xpath = "//a[@id='item_2_title_link']//preceding::div[@class='inventory_item_price']")
	public WebElement onesiePrice;
	@FindBy(xpath = "//a[@id='item_3_title_link']//preceding::div[@class='inventory_item_price']")
	public WebElement tshirtRedPrice;

	@FindBy(xpath = "//a[@id='item_4_title_link']//following::button")
	public WebElement backpackRemoveToCart;
	@FindBy(xpath = "//a[@id='item_0_title_link']//following::button")
	public WebElement bikelightRemoveToCart;
	@FindBy(xpath = "//a[@id='item_1_title_link']//following::button")
	public WebElement boltTshirtRemoveToCart;
	@FindBy(xpath = "//a[@id='item_5_title_link']//following::button")
	public WebElement fleeceJacketRemoveToCart;
	@FindBy(xpath = "//a[@id='item_2_title_link']//following::button")
	public WebElement onesieRemoveToCart;
	@FindBy(xpath = "//a[@id='item_3_title_link']//following::button")
	public WebElement tshirtRedRemoveToCart;

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
	
	@FindBy(xpath = "//a[@class='cart_checkout_link']")
	public WebElement checkoutBtn;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateCartPageObjects(int item) {
		if (item == 1) {
			checkExist(backpackTitle);
			checkExist(backpackDescr);
			checkExist(backpackQuantity);
			checkExist(backpackPrice);
			checkExist(backpackRemoveToCart);
		} else if (item == 2) {
			checkExist(bikelightTitle);
			checkExist(bikelightDescr);
			checkExist(bikelightQuantity);
			checkExist(bikelightPrice);
			checkExist(bikelightRemoveToCart);
		} else if (item == 3) {
			checkExist(boltTshirtTitle);
			checkExist(boltTshirtDescr);
			checkExist(boltTshirtQuantity);
			checkExist(boltTshirtPrice);
			checkExist(boltTshirtRemoveToCart);
		} else if (item == 4) {
			checkExist(fleeceJacketTitle);
			checkExist(fleeceJacketDescr);
			checkExist(fleeceJacketQuantity);
			checkExist(fleeceJacketPrice);
			checkExist(fleeceJacketRemoveToCart);
		} else if (item == 5) {
			checkExist(bikelightTitle);
			checkExist(bikelightDescr);
			checkExist(bikelightQuantity);
			checkExist(bikelightPrice);
			checkExist(boltTshirtRemoveToCart);
		} else if (item == 6) {
			checkExist(tshirtRedTitle);
			checkExist(tshirtRedDescr);
			checkExist(tshirtRedQuantity);
			checkExist(tshirtRedPrice);
			checkExist(tshirtRedRemoveToCart);
		}
		return true;
	}
	
	public boolean validateEmptyCart(){
		return false;
		
	}
	
	public boolean validateProduct(int item) {
		if (item == 1) {
			getText(backpackTitle);
			getText(backpackDescr);
			getText(backpackQuantity);
			getText(backpackPrice);
			getText(backpackRemoveToCart);
		} else if (item == 2) {
			getText(bikelightTitle);
			getText(bikelightDescr);
			getText(bikelightQuantity);
			getText(bikelightPrice);
			getText(bikelightRemoveToCart);
		} else if (item == 3) {
			getText(boltTshirtTitle);
			getText(boltTshirtDescr);
			getText(boltTshirtQuantity);
			getText(boltTshirtPrice);
			getText(boltTshirtRemoveToCart);
		} else if (item == 4) {
			getText(fleeceJacketTitle);
			getText(fleeceJacketDescr);
			getText(fleeceJacketQuantity);
			getText(fleeceJacketPrice);
			getText(fleeceJacketRemoveToCart);
		} else if (item == 5) {
			getText(bikelightTitle);
			getText(bikelightDescr);
			getText(bikelightQuantity);
			getText(bikelightPrice);
			getText(boltTshirtRemoveToCart);
		} else if (item == 6) {
			getText(tshirtRedTitle);
			getText(tshirtRedDescr);
			getText(tshirtRedQuantity);
			getText(tshirtRedPrice);
			getText(tshirtRedRemoveToCart);
		}
		return true;
	}
	
	public void validateCartEm(int item) {
		if (item == 1) {
			checkExist(backpackTitle);
			checkExist(backpackDescr);
			checkExist(backpackQuantity);
			checkExist(backpackPrice);
			checkExist(backpackRemoveToCart);
		} else if (item == 2) {
			checkExist(bikelightTitle);
			checkExist(bikelightDescr);
			checkExist(bikelightQuantity);
			checkExist(bikelightPrice);
			checkExist(bikelightRemoveToCart);
		} else if (item == 3) {
			checkExist(boltTshirtTitle);
			checkExist(boltTshirtQuantity);
			checkExist(boltTshirtPrice);
			checkExist(boltTshirtRemoveToCart);
		} else if (item == 4) {
			checkExist(fleeceJacketTitle);
			checkExist(fleeceJacketDescr);
			checkExist(fleeceJacketQuantity);
			checkExist(fleeceJacketPrice);
			checkExist(fleeceJacketRemoveToCart);
		} else if (item == 5) {
			checkExist(bikelightTitle);
			checkExist(bikelightDescr);
			checkExist(bikelightQuantity);
			checkExist(bikelightPrice);
			checkExist(boltTshirtRemoveToCart);
		} else if (item == 6) {
			checkExist(tshirtRedTitle);
			checkExist(tshirtRedDescr);
			checkExist(tshirtRedQuantity);
			checkExist(tshirtRedPrice);
			checkExist(tshirtRedRemoveToCart);
		}
		
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
		getText(allItemsLink);
		click(allItemsLink);
	}

	public void clickCart() {
		hover(cartIcon, driver);
		click(cartIcon);
	}

	public void validateQuantity() {
		verifyReadOnly(bikelightQuantity);
	}
	
	public void clickCheckoutBtn() {
		click(checkoutBtn);
	}
}

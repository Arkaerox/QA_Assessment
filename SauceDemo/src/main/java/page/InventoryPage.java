package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {
	final WebDriver driver;
	// Page Objects
	@CacheLookup
	@FindBy(xpath = "//div[@class='product_label']")
	public WebElement productsHeader;

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

	@FindBy(xpath = "//div[contains(text(),'carry.allTheThings() with the sleek, streamlined S')]")
	public WebElement backpackDescr;

	@FindBy(xpath = "//a[@id='item_4_title_link']//following::button[text()='ADD TO CART']")
	public WebElement backpackAddToCart;
	@FindBy(xpath = "//a[@id='item_0_title_link']//following::button[text()='ADD TO CART']")
	public WebElement bikelightAddToCart;
	@FindBy(xpath = "//a[@id='item_1_title_link']//following::button[text()='ADD TO CART']")
	public WebElement boltTshirtAddToCart;
	@FindBy(xpath = "//a[@id='item_5_title_link']//following::button[text()='ADD TO CART']")
	public WebElement fleeceJacketAddToCart;
	@FindBy(xpath = "//a[@id='item_2_title_link']//following::button[text()='ADD TO CART']")
	public WebElement onesieAddToCart;
	@FindBy(xpath = "//a[@id='item_3_title_link']//following::button[text()='ADD TO CART']")
	public WebElement tshirtRedAddToCart;

	@FindBy(xpath = "//a[@id='item_4_title_link']//following::button[text()='REMOVE']")
	public WebElement backpackRemoveToCart;
	@FindBy(xpath = "//a[@id='item_0_title_link']//following::button[text()='REMOVE']")
	public WebElement bikelightRemoveToCart;
	@FindBy(xpath = "//a[@id='item_1_title_link']//following::button[text()='REMOVE']")
	public WebElement boltTshirtRemoveToCart;
	@FindBy(xpath = "//a[@id='item_5_title_link']//following::button[text()='REMOVE']")
	public WebElement fleeceJacketRemoveToCart;
	@FindBy(xpath = "//a[@id='item_2_title_link']//following::button[text()='REMOVE']")
	public WebElement onesieRemoveToCart;
	@FindBy(xpath = "//a[@id='item_3_title_link']//following::button[text()='REMOVE']")
	public WebElement tshirtRedRemoveToCart;

	@FindBy(xpath = "//button[contains(text(),'Open Menu')]")
	public WebElement menuIcon;
	@FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
	public WebElement cartIcon;

	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	public WebElement allItemsLink;
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	public WebElement aboutLink;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	public WebElement logoutLink;
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	public WebElement resetAppStateLink;
	@FindBy(xpath = "//button[contains(text(),'Close Menu')]")
	public WebElement closeLeftPanelBtn;

	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(),'1')]")
	public WebElement cartItem1;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(),'2')]")
	public WebElement cartItem2;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(),'3')]")
	public WebElement cartItem3;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(),'4')]")
	public WebElement cartItem4;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(),'5')]")
	public WebElement cartItem5;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge' and contains(text(),'6')]")
	public WebElement cartItem6;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	public WebElement sortDropdown;
	@FindBy(xpath = "//option[contains(text(),'Name (A to Z)')]")
	public WebElement ascNameSort;
	@FindBy(xpath = "//option[contains(text(),'Name (Z to A)')]")
	public WebElement descNameSort;
	@FindBy(xpath = "//option[contains(text(),'Price (low to high)')]")
	public WebElement ascPriceSort;
	@FindBy(xpath = "//option[contains(text(),'Price (high to low)')]")
	public WebElement descPriceSort;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateInventoryPageObjects() {
		if (checkExist(backpackTitle) == true && checkExist(bikelightTitle) == true
				&& checkExist(boltTshirtTitle) == true && checkExist(fleeceJacketTitle) == true
				&& checkExist(onesieTitle) == true && checkExist(tshirtRedTitle) == true
				&& checkExist(backpackAddToCart) == true && checkExist(bikelightAddToCart) == true
				&& checkExist(boltTshirtAddToCart) == true && checkExist(fleeceJacketAddToCart) == true
				&& checkExist(onesieAddToCart) == true && checkExist(tshirtRedAddToCart) == true
				&& checkExist(menuIcon) == true && checkExist(cartIcon) == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateLeftPanelObjects() {
		click(menuIcon);
		if (
		checkExist(allItemsLink) == true &&
		checkExist(aboutLink) == true &&
		checkExist(logoutLink) == true &&
		checkExist(resetAppStateLink) == true) {
			return true;
		} else {
			return false;
		}
	}

	public void clickCloseLeftPanel() {
		click(closeLeftPanelBtn);
	}

	public void addItemToCart(int item) {
		if (item == 1) {
			click(backpackAddToCart);
		} else if (item == 2) {
			click(bikelightAddToCart);
		} else if (item == 3) {
			click(boltTshirtAddToCart);
		} else if (item == 4) {
			click(fleeceJacketAddToCart);
		} else if (item == 5) {
			click(onesieAddToCart);
		} else if (item == 6) {
			click(tshirtRedAddToCart);
		}
	}

	public void removeItemToCart(int item) {
		if (item == 1) {
			click(backpackRemoveToCart);
		} else if (item == 2) {
			click(bikelightRemoveToCart);
		} else if (item == 3) {
			click(boltTshirtRemoveToCart);
		} else if (item == 4) {
			click(fleeceJacketRemoveToCart);
		} else if (item == 5) {
			click(onesieRemoveToCart);
		} else if (item == 6) {
			click(tshirtRedRemoveToCart);
		}
	}

	public void validateCartItemCount(int cartCount) {
		if (cartCount == 1) {
			checkExist(cartItem1);
		} else if (cartCount == 2) {
			checkExist(cartItem2);
		} else if (cartCount == 3) {
			checkExist(cartItem3);
		} else if (cartCount == 4) {
			checkExist(cartItem4);
		} else if (cartCount == 5) {
			checkExist(cartItem5);
		} else if (cartCount == 6) {
			checkExist(cartItem6);
		}
	}

	public void clickCart() {
		click(cartIcon);
	}

	public void clickSortDropdown(String sortType) {
		click(sortDropdown);
	}

	public void sortBy(String sortType) {

		if (sortType == "NameAsc=") {
			hover(ascNameSort, driver);
			click(ascNameSort);
			getText(backpackTitle);
		} else if (sortType == "NameDesc") {
			hover(descNameSort, driver);
			click(descNameSort);
		} else if (sortType == "PriceAsc") {
			hover(ascPriceSort, driver);
			click(ascPriceSort);
		} else if (sortType == "PriceDesc") {
			hover(descPriceSort, driver);
			click(descPriceSort);
		}
	}

	public void validateRedirectedToInventory() {
		checkExist(productsHeader);
	}

	public void clickMenu() {
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

	public void clickAboutLink() {
		hover(aboutLink, driver);
		click(aboutLink);
	}

	public void resetLink() {
		hover(resetAppStateLink, driver);
		click(resetAppStateLink);
	}

	public void validateReset() {
		checkExist(backpackRemoveToCart);
		checkExist(bikelightRemoveToCart);
		checkExist(boltTshirtRemoveToCart);
		checkExist(fleeceJacketRemoveToCart);
		checkExist(onesieRemoveToCart);
		checkExist(tshirtRedRemoveToCart);
	}

	public boolean validateSuccessfulLogin() {
		if (checkExist(productsHeader) == true) {
			return true;
		} else {
			return false;
		}
	}

}

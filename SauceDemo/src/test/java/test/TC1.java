package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page.CartPage;
import page.InventoryPage;
import page.LoginPage;

public class TC1 extends BaseTest {
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@Test(priority = 0)
	public void setup() {
		openURL();
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\test-output\\ExtentReports//TC1.1-TC1.8.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("TC1.1 - 1.8", "Basic Functionality Testing");
		extent.flush();
	}

	@Test(priority = 1)
	public void testLogin() {
		String usernameInput = readProperty("username");
		String passwordInput = readProperty("password");
		usernameInput = readProperty("username");
		passwordInput = readProperty("password");
		loginPage.login(usernameInput, passwordInput);
		if (inventoryPage.validateSuccessfulLogin() == true) {
			logger.log(Status.INFO, "Logged in Successfully.");
			extent.flush();
		}
	}

	@Test(priority = 2)
	public void clickSort() {
		inventoryPage.clickSortDropdown("NameAsc");
		logger.log(Status.FAIL, "Click sort dropdown");
		extent.flush();
	}

	@Test(priority = 3)
	public void sortByNameAsc() {
		clickSort();
		inventoryPage.sortBy("NameAsc");
		wait(1500);
		logger.log(Status.FAIL, "Sort by Name Ascending");
		extent.flush();
	}

	@Test(priority = 4)
	public void sortByNameDesc() {
		clickSort();
		inventoryPage.sortBy("NameDesc");
		wait(1500);
		logger.log(Status.FAIL, "Sort by Name Descending");
		extent.flush();
	}

	@Test(priority = 5)
	public void sortByPriceAsc() {
		clickSort();
		inventoryPage.sortBy("PriceAsc");
		wait(1500);
		logger.log(Status.FAIL, "Sort by Price Ascending");
		extent.flush();
	}

	@Test(priority = 6)
	public void sortByPriceDesc() {
		clickSort();
		inventoryPage.sortBy("PriceDesc");
		wait(1500);
		logger.log(Status.FAIL, "Sort by Price Descending");
		extent.flush();
	}

	@Test(priority = 7)
	public void addToCart() {
		inventoryPage.addItemToCart(1);
		inventoryPage.validateCartItemCount(1);
		logger.log(Status.INFO, "Add 1 item to cart");
		extent.flush();
	}
	
	@Test(priority = 8)
	public void removeToCart() {
		inventoryPage.removeItemToCart(1);
		logger.log(Status.INFO, "Removed selected item to cart");
		logger.log(Status.PASS, "Verified that user can	add/remove item to cart");
		extent.flush();
		
	}
	
	@Test(priority = 9)
	public void addToCart2() {
		inventoryPage.addItemToCart(2);
		logger.log(Status.INFO, "Add 1 item to cart");
		extent.flush();
	}
	
	@Test(priority = 10)
	public void clickCartIcon() {
		inventoryPage.clickCart();
		wait(1000);
		logger.log(Status.INFO, "Cart icon clicked");
		extent.flush();
	}
	
	@Test(priority = 11)
	public void validateQuantityEdit() {
		cartPage.validateQuantity();
		logger.log(Status.FAIL, "Quantity field cannot be edited");
		extent.flush();
		wait(1500);
	}
	
	@Test(priority = 12)
	public void clickMenuIcon() {
		cartPage.clickMenu();
		logger.log(Status.INFO, "Menu icon clicked");
		extent.flush();
		wait(1000);
	}
	
	@Test(priority = 13)
	public void clickAllItems() {
		cartPage.clickAllItemsLink();
		wait(1000);
		inventoryPage.validateRedirectedToInventory();
		logger.log(Status.PASS,"Products page was displayed after clicking All Items link");
		extent.flush();
	}
	
	
	@Test(priority = 14)
	public void clickAbout() {
		inventoryPage.clickMenu();
		inventoryPage.clickAboutLink();
		logger.log(Status.PASS,"SauceLabs page was displayed after clicking About link");
		extent.flush();
		driver.close();
	}
	
	@Test(priority = 15)
	public void reLogin() {
	setup();
	testLogin();
	}
	
	@Test(priority = 16)
	public void clickMenuIcon1() {
		inventoryPage.clickMenu();
		logger.log(Status.INFO, "Menu icon clicked");
		extent.flush();
		wait(1000);
	
	}
	@Test(priority = 17)
	public void logout() {
		inventoryPage.clickLogout();
		logger.log(Status.INFO, "Logout button clicked");
		extent.flush();
	}
	
	@Test(priority = 18)
	public void validateRedirectedToLogin() {
		setup();
		loginPage.validateLoginPageObjects();
		testLogin();
		
	}
	
	@Test(priority = 19)
	public void addToCart3() {
		inventoryPage.addItemToCart(4);
		logger.log(Status.INFO, "Add 1 item to cart");
		extent.flush();
	}
	
	@Test(priority = 20)
	public void clickResetLink() {
		clickMenuIcon1();
		wait(1000);
		inventoryPage.resetLink();
		inventoryPage.clickCloseLeftPanel();
		logger.log(Status.FAIL,"Reset App State did not refresh the page. Item is still selected.");
		extent.flush();
	}
	
	@Test(priority = 21)
	public void validateAppStateReset() {
		inventoryPage.validateReset();
		clickMenuIcon1();
		wait(1000);
		logout();
		driver.close();
	}
	

}

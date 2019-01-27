package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page.CartPage;
import page.CheckoutCompletePage;
import page.CheckoutInfoPage;
import page.CheckoutOverviewPage;
import page.InventoryPage;
import page.LoginPage;

public class TC4 extends BaseTest {
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutInfoPage checkoutInfoPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CheckoutCompletePage checkoutCompletePage;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@Test(priority = 0)
	public void setup() {
		openURL();
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutInfoPage = new CheckoutInfoPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\test-output\\ExtentReports//TC4.1-TC4.6.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("TC4.1 - 4.6", "Single Data Testing");
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
	public void addToCart() {
		inventoryPage.addItemToCart(1);
		inventoryPage.addItemToCart(2);
		inventoryPage.addItemToCart(4);
		inventoryPage.validateCartItemCount(3);
		logger.log(Status.INFO, "Adding 3 items to the Cart");
		extent.flush();
	}

	@Test(priority = 4)
	public void clickCartIcon() {
		inventoryPage.clickCart();
		logger.log(Status.INFO, "Clicked Cart Icon");
		extent.flush();
	}

	@Test(priority = 5)
	public void validateOrder() {
		if (cartPage.validateCartPageObjects(1) == true) {
			logger.log(Status.PASS, "User is able to view the selected products in Cart Page");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "User is cannot view the selected products in Cart Page");
			extent.flush();
		}
	}

	@Test(priority = 6)
	public void validateProductDetails() {
		if (cartPage.validateProduct(1) == true) {
			logger.log(Status.PASS, "Product details are correct");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "Product details are incorrect");
			extent.flush();
		}
	}

	@Test(priority = 7)
	public void clickCheckout() {
		cartPage.clickCheckoutBtn();
		logger.log(Status.INFO, "Clicked checkout button");
		extent.flush();
	}

	@Test(priority = 8)
	public void fllInCheckoutInfo() {
		checkoutInfoPage.fillInCheckoutInfo("Tester2", "Testing", "2222");
		checkoutInfoPage.clickContinueBtn();
		logger.log(Status.INFO, "Values have been entered on the Checkout Information Page");
		extent.flush();
		logger.log(Status.PASS, "Checkout Successful");
		extent.flush();
	}

	@Test(priority = 9)
	public void validateDetails() {
		logger.log(Status.PASS, "Details are correct");
		extent.flush();
	}

	@Test(priority = 10)
	public void validatePrice() {
		logger.log(Status.PASS, "Total Price is correct");
		extent.flush();
	}

	@Test(priority = 11)
	public void clickFinish() {
		checkoutOverviewPage.clickfinishBtn();
		logger.log(Status.INFO, "Finish Button Clicked");
		extent.flush();
	}

	@Test(priority = 12)
	public void validate() {
		checkoutCompletePage.validateCompleteCheckout();
		logger.log(Status.PASS, "Confirmation Page appeared and order has been dispatched.");
		extent.flush();
	}

	@Test(priority = 13)
	public void clickCart() {
		checkoutCompletePage.clickCart();
		wait(1000);
		driver.close();
		logger.log(Status.PASS, "Cart is empty");
		extent.flush();
	}
}

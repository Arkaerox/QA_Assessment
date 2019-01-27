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

public class TC5B extends BaseTest {
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
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\test-output\\ExtentReports//TC5.3-TC5.5.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("TC5.3 - 5.5", "Checkout Information Testing");
		extent.flush();
	}

	@Test(priority = 2)
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

	@Test(priority = 3)
	public void addToCart() {
		inventoryPage.addItemToCart(1);
		inventoryPage.validateCartItemCount(1);
		logger.log(Status.INFO, "Add 1 item to Cart");
		extent.flush();
	}
	
	@Test(priority = 4)
	public void clickCartIcon() {
		inventoryPage.clickCart();
		logger.log(Status.INFO, "Clicked Cart Icon");
		extent.flush();	
	}
	
	@Test(priority = 5)
	public void clickCheckout() {
		cartPage.clickCheckoutBtn();
		logger.log(Status.INFO, "Clicked Checkout Button");
		extent.flush();	
	}
	
	@Test(priority = 6)
	public void fllInCheckoutInfo() {
		checkoutInfoPage.fillInCheckoutInfo("", "Testing", "3333");
		logger.log(Status.INFO, "Entering value on Last Name and Zip/Postal Code field");
		extent.flush();	
		wait(500);
		checkoutInfoPage.clickContinueBtn();
	}
	@Test(priority = 7)
	public void verifyError() {
		if (checkoutInfoPage.validateErrorMsg() == true) {
			logger.log(Status.PASS, "Error message was encountered");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "No Error message was encountered");
			extent.flush();

		}
		driver.close();
	}
	
	@Test(priority = 8)
	public void fllInCheckoutInfo2() {
		openURL();
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutInfoPage = new CheckoutInfoPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		testLogin();
		addToCart();
		clickCartIcon();
		clickCheckout();
		
		checkoutInfoPage.fillInCheckoutInfo("Tester3", "", "3333");
		logger.log(Status.INFO, "Entering value on First Name and Zip/Postal Code field");
		extent.flush();	
		wait(500);
		checkoutInfoPage.clickContinueBtn();
	}
	
	@Test(priority = 9)
	public void verifyError2() {
		if (checkoutInfoPage.validateErrorMsg() == true) {
			logger.log(Status.PASS, "Error message was encountered");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "No Error message was encountered");
			extent.flush();

		}
		driver.close();
	}
	
	@Test(priority = 10)
	public void fllInCheckoutInfo3() {
		openURL();
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		checkoutInfoPage = new CheckoutInfoPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		testLogin();
		addToCart();
		clickCartIcon();
		clickCheckout();
		
		checkoutInfoPage.fillInCheckoutInfo("Tester3", "Testing", "");
		logger.log(Status.INFO, "Entering value on First Name and Last Name");
		extent.flush();	
		wait(500);
		checkoutInfoPage.clickContinueBtn();
	}
	
	@Test(priority = 11)
	public void verifyError3() {
		if (checkoutInfoPage.validateErrorMsg() == true) {
			logger.log(Status.PASS, "Error message was encountered");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "No Error message was encountered");
			extent.flush();

		}
		driver.close();
	}

}

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

public class TC2 extends BaseTest {
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
				"C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\test-output\\ExtentReports//TC2.1-TC2.2.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("TC2.1 - TC2.2", "Zero Data Testing");
		extent.flush();
	}

	@Test(priority = 1)
	public void testLogin() {
		String usernameInput = readProperty("username");
		String passwordInput = readProperty("password");
		usernameInput = readProperty("username");
		passwordInput = readProperty("password");
		loginPage.login(usernameInput, passwordInput);
		logger.log(Status.INFO, "Logged in Successfully.");
		extent.flush();
	}

	@Test(priority = 2)
	public void clickCartIcon() {
		inventoryPage.clickCart();
		logger.log(Status.INFO, "Clicked Cart Icon");
		extent.flush();
	}

	@Test(priority = 3)
	public void validateCartPage() {
		cartPage.validateCartPageObjects(1);
		cartPage.validateCartPageObjects(2);
		cartPage.validateCartPageObjects(3);
		cartPage.validateCartPageObjects(4);
		cartPage.validateCartPageObjects(5);
		cartPage.validateCartPageObjects(6);
		logger.log(Status.INFO, "Cart Page can be viewed even without product selected");
		extent.flush();
	}

	@Test(priority = 4)
	public void clickCheckout() {
		cartPage.clickCheckoutBtn();
		logger.log(Status.INFO, "Clicked Checkout button");
		extent.flush();
	}

	@Test(priority = 5)
	public void fllInCheckoutInfo() {
		checkoutInfoPage.fillInCheckoutInfo("Tester123", "Test1", "103924");
		logger.log(Status.FAIL, "User can proceed with checkout without any selected item.");
		extent.flush();
	}

	@Test(priority = 6)
	public void clickContinue() {
		checkoutInfoPage.clickContinueBtn();
	}

	@Test(priority = 7)
	public void clickFinish() {
		checkoutOverviewPage.clickfinishBtn();
	}

	@Test(priority = 8)
	public void validate() {
		checkoutCompletePage.validateCompleteCheckout();
		driver.close();
	}
}
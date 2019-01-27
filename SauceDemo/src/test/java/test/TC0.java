package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page.CartPage;
import page.InventoryPage;
import page.LoginPage;

public class TC0 extends BaseTest {
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
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\test-output\\ExtentReports//TC0.1-TC0.4.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("TC0.1 - 0.4", "Page Objects Testing");
		extent.flush();
	}
	
	@Test(priority = 1)
	public void validateLoginPage(){
		if (loginPage.validateLoginPageObjects() == true) {
			logger.log(Status.PASS, "All Page Objects on Login Page are displayed.");
			extent.flush();
		}
		else {
			logger.log(Status.FAIL, "Page Object/s is not visible.");
			extent.flush();
		}
		
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
	public void validateInventoryPage(){		
		if (inventoryPage.validateInventoryPageObjects() == true) {
			logger.log(Status.PASS, "All Page Objects on Inventory Page are displayed.");
			extent.flush();
		}
		else {
			logger.log(Status.FAIL, "Page Object/s is not visible.");
			extent.flush();
		}
	}
	
	@Test(priority = 5)
	public void validateLeftPanel(){
		if (inventoryPage.validateLeftPanelObjects() == true) {
			logger.log(Status.PASS, "All links are shown in the Left-Hand Panel");
			extent.flush();
		}
		else {
			logger.log(Status.FAIL, "Links were not found on the Left-Hand Panel");
			extent.flush();
		}
	}
	
	@Test(priority = 6)
	public void closeLeftPanel() {
		inventoryPage.clickCloseLeftPanel();
		logger.log(Status.INFO, "Closing Left-Hand Panel.");
		wait(1000);
	}
	
	@Test(priority = 7)
	public void addToCart() {
		logger.log(Status.INFO, "Adding 1 item to the Cart.");
		inventoryPage.addItemToCart(1);
		inventoryPage.validateCartItemCount(1);
	}
	
	@Test(priority = 8)
	public void clickCartIcon() {
		logger.log(Status.INFO, "Clicking Cart Icon.");
		inventoryPage.clickCart();
		wait(1000);
	}
	
	@Test(priority = 9)
	public void validateCartPage() {
		if (cartPage.validateCartPageObjects(1) == true) {
			logger.log(Status.PASS, "All links are shown in the Left-Hand Panel");
			extent.flush();
		}
		else {
			logger.log(Status.FAIL, "Links were not found on the Left-Hand Panel");
			extent.flush();
		}
	}
	
	@Test(priority = 10)
	public void logout() {
		logger.log(Status.INFO, "Logging Out.");
		cartPage.clickMenu();
		wait(1000);
		cartPage.clickLogout();
	}

	@Test(priority = 11)
	public void closeBrowser() {
		driver.close();
	}

}


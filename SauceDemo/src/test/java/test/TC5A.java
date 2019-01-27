package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page.LoginPage;

public class TC5A extends BaseTest {
	LoginPage loginPage;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@Test(priority = 1)
	public void setup() {
		openURL();
		loginPage = new LoginPage(driver);
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\test-output\\ExtentReports//TC5.1-TC5.2.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("TC5.1 - TC5.2", "Username Password Testing");
		extent.flush();
	}

	@Test(priority = 2)
	public void testLogin() {
		String usernameInput = readProperty("username");
		String passwordInput = readProperty("password");
		usernameInput = "";
		passwordInput = readProperty("password");
		loginPage.login(usernameInput, passwordInput);
		logger.log(Status.INFO, "Logging in with only Password populated");
		extent.flush();
	}
	
	@Test(priority = 3)
	public void verifyErrorMessage() {
		if (loginPage.verifyError() == true) {
			logger.log(Status.PASS, "Error message was encountered");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "No Error message was encountered");
			extent.flush();

		}
		driver.close();
	}

	@Test(priority = 4)
	public void testLogin2() {
		openURL();
		loginPage = new LoginPage(driver);
		String usernameInput = readProperty("username");
		String passwordInput = readProperty("password");
		usernameInput = readProperty("username");
		passwordInput = "";
		loginPage.login(usernameInput, passwordInput);
		logger.log(Status.INFO, "Logging in with only Username populated");
		extent.flush();
	}

	@Test(priority = 5)
	public void verifyErrorMessage2() {
		if (loginPage.verifyError() == true) {
			logger.log(Status.PASS, "Error message was encountered");
			extent.flush();
		} else {
			logger.log(Status.FAIL, "No Error message was encountered");
			extent.flush();

		}
		driver.close();
	}
}

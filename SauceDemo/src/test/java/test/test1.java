package test;

import org.testng.annotations.Test;

import page.LoginPage;

public class test1 extends BaseTest {
	LoginPage loginPage;
	
	@Test(priority = 0)
	public void setup() {
		openURL();
		loginPage = new LoginPage(driver);
		
	}
	@Test(priority = 1)
	public void validatePageObjects(){
		//loginPage.assertPageObjects();
	}
	
	@Test(priority = 2)
	public void testLogin() {
		String usernameInput = readProperty("username");
		String passwordInput = readProperty("password");
		usernameInput = readProperty("username");
		passwordInput = readProperty("password");
		loginPage.login(usernameInput, passwordInput);
		
	}
	@Test(priority = 3)
	public void closeBrowser() {
		driver.quit();
	}

}

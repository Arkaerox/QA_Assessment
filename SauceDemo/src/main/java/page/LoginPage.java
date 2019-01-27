package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	final WebDriver driver;
	// Page Objects
	@CacheLookup
	@FindBy(id = "user-name")
	public WebElement username;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(xpath = "//input [@value='LOGIN']")
	public WebElement loginBtn;
	@FindBy(xpath = "//pre [@id='login_credentials']")
	public WebElement flowerBox;

	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateLoginPageObjects() {
		if (checkExist(username) == true && checkExist(password) == true && checkExist(loginBtn) == true
				&& checkExist(flowerBox) == true)
			return true;
		else {
			return false;
		}

	}

	public void login(String usernameInput, String passwordInput) {
		typeText(username, usernameInput);
		typeText(password, passwordInput);
		click(loginBtn);
	}

	public boolean verifyError() {
		if (checkExist(errorMsg) == true) {
			return true;
		} else {
			return false;
		}
	
	}

}

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutInfoPage extends BasePage {
	final WebDriver driver;
	// Page Objects
	@CacheLookup
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
	public WebElement zipCode;
	@FindBy(xpath = "//input[@value='CONTINUE']")
	public WebElement continueBtn; 
	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement errorMsg;

	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver);
		PageFactory.initElements(driver, this);
	}
	public void fillInCheckoutInfo(String firstNameInput, String lastNameInput, String zipCodeInput) {
		typeText(firstName, firstNameInput);
		typeText(lastName, lastNameInput);
		typeText(zipCode, zipCodeInput);
	}
	
	public void validateCheckoutInformation() {
		Assert.assertEquals(firstName, "Tester1");
		Assert.assertEquals(lastName, "Testing");
		Assert.assertEquals(zipCode, "1111");
	}
	
	public void clickContinueBtn() {
		click(continueBtn);
	}
	
	public boolean validateErrorMsg() {
		if (checkExist(errorMsg) == true) {
			return true;
		} else {
			return false;
		}
	
	}

}

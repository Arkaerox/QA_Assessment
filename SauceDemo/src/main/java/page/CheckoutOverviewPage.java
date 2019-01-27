package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {
	final WebDriver driver;
	// Page Objects
	@CacheLookup
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	public WebElement subTotal;
	@FindBy(xpath = "//div[@class='summary_total_label']")
	public WebElement tax;
	@FindBy(xpath = "//div[@class='summary_total_label']")
	public WebElement total;
	@FindBy(xpath = "//a[@class='cart_checkout_link']")
	public WebElement finishBtn;

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver);
		PageFactory.initElements(driver, this);
	}

	public void clickfinishBtn() {
		click(finishBtn);
	}
	
	public int validatePrice() {
		getText(subTotal);
		getText(tax);
		getText(total);
		int n1 = Integer.parseInt(getText(subTotal));
		int n2 = Integer.parseInt(getText(tax));
		
		int n4 = Integer.parseInt(getText(tax));
		int n3 = n1 + n2;
		n4 = n3;
		
		System.out.print(n4 + n3);
		return n4;
	}
	
	

}

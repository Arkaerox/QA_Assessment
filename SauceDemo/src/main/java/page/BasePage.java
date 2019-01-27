package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	public String typeText(WebElement element, String text) {
		String Status = "";
		try {
			element.sendKeys(text);
			System.out.println("Entering " + text + " to" + element + " element.");
			Status = "true";
		} catch (NoSuchElementException e) {
			Status = "false";
			e.printStackTrace();
		} catch (Exception e) {
			Status = "false";
			e.printStackTrace();
		}

		return Status;
	}
	
	public void click(WebElement element) {
		try {
			element.click();
			System.out.println("Sucessfully clicked the element " + element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public String getText(WebElement element) {

		String elementText = "";

		try{
			elementText = element.getAttribute("innerhtml");
			System.out.println("Getting the text of the element " + element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return elementText;
	}
	
	public boolean checkExist(WebElement element) {
		boolean status = false;
		try {
			if ((element.getSize().height > 0) && (element.getSize().width > 0)){
				status = true;
				System.out.println("Object " + element + " exists.");
			} else {
				System.out.println("Object " + element + " does not exists.");
			}

		} catch (NoSuchElementException ignored) {
			System.out.println("Object " + element + " does not exists.");
			return status;
		}

		return status;
	}
	
	public boolean checkifEnabled(WebElement element) {
		boolean status = false;
		try {
			if (element.isEnabled()){
				status = true;
				System.out.println("Object " + element + " is enabled.");
			} else {
				System.out.println("Object " + element + " is disabled.");
			}

		} catch (NoSuchElementException ignored) {
			System.out.println("Object " + element + " does not exists.");
			return status;
		}

		return status;
	}
	
	public boolean verifyReadOnly(WebElement element) {
			boolean status = false;
			String old_text = element.getAttribute("value");
	        element.sendKeys("test");
	        String new_text = element.getAttribute("value");
	        element.clear();
	        element.sendKeys(old_text);
	        try {
	        if (old_text == new_text){
				status = true;
				System.out.println("Object " + element + " is Read Only.");
			} else {
				System.out.println("Object " + element + " is not Read Only.");
			}

		} catch (NoSuchElementException ignored) {
			System.out.println("Object " + element + " does not exists.");
			return status;
		}

		return status;
	}
	
	public void hover(WebElement element, WebDriver driver) {
		try {
			Actions oAction = new Actions(driver);
			oAction.moveToElement(element).perform();
			//logger.debug("Sucessfully hovered the element"  + element);
			System.out.println("Sucessfully hovered the element"  + element);
		} catch (NoSuchElementException ignored) {
			//logger.debug("Object " + element + " does not exists.");
			System.out.println("Object " + element + " does not exists.");
			//e.printStackTrace();
		}
	}
	
}

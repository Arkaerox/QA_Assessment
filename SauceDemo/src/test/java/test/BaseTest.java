package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;


public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	//ExtentHtmlReporter htmlReporter;
	//ExtentReports extent;
	//xtentTest logger;
	
	
	public void openURL() {
		String path = "";
		String browserType = readProperty("browser");
		String URL = readProperty("url");
		
		try {
			if ("chrome".equals(browserType)) {
				path = readProperty("chromedriver");
				System.setProperty("webdriver.chrome.driver", path);
				//logger.log(Status.INFO, "Navigating to https://www.saucedemo.com/ via Google Chrome");
				System.out.println("Navigating to " + URL + " via Google Chrome.");
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			} else if ("firefox".equals(browserType)) {
				path = readProperty("firefoxdriver");
				System.setProperty("webdriver.gecko.driver", path);
				// logger.debug("Navigating to " + URL + " via Firefox.");
				System.out.println("Navigating to " + URL + " via Firefox.");
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			} else if ("ie".equals(browserType)) {
				path = readProperty("IEdriver");
				System.setProperty("webdriver.ie.driver", path);
				// logger.debug("Navigating to " + URL + " via Internet Explorer.");
				System.out.println("Navigating to " + URL + " via Internet Explorer.");
				driver = new InternetExplorerDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readProperty(String PropertyName) {
		Properties prop = new Properties();
		InputStream input = null;
		String propValue = null;
		try {
			input = new FileInputStream(
					"C:\\Users\\John Erick\\Documents\\GitHub\\SauceDemo\\src\\main\\java\\config\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			propValue = prop.getProperty(PropertyName);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return propValue;
	}

	public static void closeBrowser(WebDriver Driver) {
		try {
			driver.close();
			driver.quit();
			// logger.debug("Closing the Browser...");
			System.out.println("Closing the Browser...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void wait(int milliseconds){
		try {
			Thread.sleep(milliseconds);
			System.out.println("Wait for " + milliseconds + "ms.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
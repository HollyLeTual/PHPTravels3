package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverFactory {
		private static WebDriverFactory instance = new WebDriverFactory();
		private WebDriver driver;
		
		public static WebDriverFactory getInstance( ) {
			return instance;
		}
		
	    public void createWebDriver() {
	    	String browser = "chrome"; 
	    	switch (browser) {
			case "chrome":
				driver = initiateChromeDriver();
				break;
			default:
				driver = initiateChromeDriver();
				break;
			}
	    }
	    
	    public WebDriver getWebDriver() {
	    	return driver;
	    }
	    
	    public void removeWebDriver() {
	    	driver.quit();
	    }
	    
		private static WebDriver initiateChromeDriver() {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium WebDrivers\\chromedriver.exe");
			
	        ChromeOptions options = new ChromeOptions();
	        options.setBinary("C:\\Users\\Holly Le Tual\\Downloads\\chromedriver_win32 (2)");
	        options.addArguments("start-maximized");
	        options.addArguments("--touch-events=disabled");
	        options.addArguments("disable-infobars");
	        options.addArguments("--disable-default-apps");
	        options.setExperimentalOption("useAutomationExtension", false);
	        
			
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 
	        
	        WebDriver driver = new ChromeDriver(options);
	        return driver;
	    }
	}

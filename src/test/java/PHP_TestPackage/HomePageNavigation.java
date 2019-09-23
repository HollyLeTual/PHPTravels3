package PHP_TestPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SignUp;
import Resources.Base;

public class HomePageNavigation extends Base {
	
	@Test
	public void HomePageNavigation() throws IOException {
	
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	Log1.info("Successfully Opened Home Page");
	
	HomePage h = new HomePage(driver);
	h.ClickAccount().click();
		
	SignUp s = new SignUp(driver);
	s.signup().click();
	
	//driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")).click();
	
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(prop.getProperty("fname"));
	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(prop.getProperty("lname"));
	driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(prop.getProperty("mobile"));
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(prop.getProperty("email"));
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click();
	
	SearchHotel sh = new SearchHotel(driver);
	sh.SeachHotel();
	
	driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys(prop.getProperty("hotelcity"));
	driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys(prop.getProperty("checkin"));
	driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys(prop.getProperty("checkout"));
	driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();
	
	
		
	Log1.info("Successfully entered Sign Up information");
	
	}

	
	/*@AfterTest
	public void teardown() {
		//driver.close();
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		data[0][0] = "Test1FN";
		data[0][1] = "Test1LN";
		data[0][2] = "1-709-748-4894";
		
		return data;
				
	}*/
	
}
	



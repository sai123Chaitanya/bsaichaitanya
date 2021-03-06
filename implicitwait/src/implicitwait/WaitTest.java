package implicitwait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitTest {
	final Logger log = LoggerFactory.getLogger(WaitTest.class);
	private WebDriver driver;
	private String baseUrl;
	private WebElement element;
	

	
	@BeforeMethod
	private void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.google.com";
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

	}
	
	@Test
	public void testUntitled() 
	{

		driver.get(baseUrl);
		element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium interview questions");
		element.sendKeys(Keys.RETURN);
		Logger log = LoggerFactory.getLogger(WaitTest.class);
		log.info("hi");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}

package test1;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test(groups = "smoke")
	public void verifytest1()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\software-Testing\\softwarefiles\\chromedriver99\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D://AutomationChallengeIDC//index.html");
		
		driver.findElement(By.xpath("//button[text()='Open Modal']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys("B Sai Chaitanya");
		driver.findElement(By.id("city")).sendKeys("Hyderabad");
		driver.findElement(By.id("enter")).click();
		WebElement ele = driver.findElement(By.xpath("//button[text()='Close']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		String name =driver.findElement(By.id("nameVal")).getText();
		String city = driver.findElement(By.id("cityVal")).getText();
		boolean namestatus = name.contains("B Sai Chaitanya");
		boolean citystatus = city.contains("Hyderabad");
		assertEquals(namestatus, true);
		assertEquals(citystatus, true);
		driver.close();
		
	
	}
	
	@Test(groups = "smoke")
	public void verifytest2()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\software-Testing\\softwarefiles\\chromedriver99\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D://AutomationChallengeIDC//index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/button")).click();
		
		
		
		String dropdown1 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[1]")).getText();
		boolean status1 = dropdown1.equals("Java");
		assertEquals(status1, true);
		
		String dropdown2 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[2]")).getText();
		boolean status2 = dropdown2.equals("C#");
		assertEquals(status2, true);
		
		String dropdown3 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[3]")).getText();
		boolean status3 = dropdown3.equals("Python");
		assertEquals(status3, true);
		
		
		String dropdown4 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[4]")).getText();
		boolean status4 = dropdown4.equals("Angular 2");
		assertEquals(status4, true);
		
		
		String dropdown5 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[5]")).getText();
		boolean status5 = dropdown5.equals("Angular");
		assertEquals(status5, true);
		
		driver.findElement(By.id("myInput")).sendKeys("Angular");
		
		String angular1 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[4]")).getText();
		boolean status6 = angular1.equals("Angular 2");
		assertEquals(status6, true);
		
		
		
		
		String angular2 = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[5]")).getText();
		boolean status7 = angular2.equals("Angular");
		assertEquals(status7, true);
		
		driver.findElement(By.id("myInput")).clear();
		driver.findElement(By.id("myInput")).sendKeys("ReactJs");
		
		String no_dropdown = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[1]")).getAttribute("style");
		boolean status8 = no_dropdown.equals("display: none;");
		assertEquals(status8, true);
		
		driver.close();
		
		
	}
	
	@Test(groups = "smoke")
	public void verifytest3()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\software-Testing\\softwarefiles\\chromedriver99\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D://AutomationChallengeIDC//index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/button")).click();
		
		driver.findElement(By.id("searchMe")).sendKeys("USA");
		
		String table1 = driver.findElement(By.xpath("//*[@id='someTable']/tr[1]/td[3]")).getText();
		boolean status1 = table1.equals("USA");
		assertEquals(status1, true);
		
		
		String table2 = driver.findElement(By.xpath("//*[@id='someTable']/tr[2]/td[3]")).getText();
		boolean status2 = table2.equals("USA");
		assertEquals(status2, true);

		driver.findElement(By.id("searchMe")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
	
		
		List<WebElement> table = driver.findElements(By.tagName("tr"));
		int count =0;
		
		
		for(int i=0;i<table.size(); i++)
		{
			System.out.println(table.get(i).getText());
			count ++;
		}
		
		
		System.out.println(count);
		boolean status3 = count-1==4;
		assertEquals(status3, true);
		driver.close();	
		
		
		
	}
	
	@Test(groups = "sanity")
	public void verifytest4() {
		System.setProperty("webdriver.chrome.driver", "D:\\software-Testing\\softwarefiles\\chromedriver99\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D://AutomationChallengeIDC//index.html");
		driver.manage().window().maximize();
		
		WebElement test4element = driver.findElement(By.xpath("//*[@id='test-4-div']/h1"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", test4element);
		
		WebElement source = driver.findElement(By.xpath("//*[@id='drag1']"));
		
		WebElement target = driver.findElement(By.xpath("//*[@id='div1']"));
		
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id='drag1']")).click();
		action.dragAndDrop(source, target).build().perform();
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}


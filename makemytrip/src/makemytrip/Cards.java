package makemytrip;

import java.text.Format;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cards {
	public static void main(String[] args) throws Exception {
		
			
		System.setProperty("webdriver.chrome.driver", "D:\\software-Testing\\softwarefiles\\chromedriver99\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		try {
			driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/main/div[9]/span")).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		
		}
		//WebElement ab =  driver.findElement(By.linkText("Bank Offers"));

			WebElement offers =   driver.findElement(By.xpath("//*[@id='PROMOTIONS']/div/div/div/div/div[1]/div/div"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)",offers);			
			WebElement links = driver.findElement(By.xpath("//*[@id='Offers_Listing']/div[1]/div/ul"));
			List<WebElement> linksofcard = links.findElements(By.tagName("li"));
			
			for(WebElement linksof : linksofcard)
			{
				

			WebElement linktexta;
			try {
				linktexta = linksof.findElement(By.tagName("a"));
				linktexta.getText();
				linktexta.click();
				WebElement cards= driver.findElement(By.xpath("//*[@id='Offers_Listing']/div[2]/div/div/div"));
				List<WebElement> ele =   cards.findElements(By.className("slideItem"));
				//System.out.printf("offers%s          %s %n",linktexta.getText(),ele.size());
				System.out.format(linktexta.getText()+" the offers are " );
				System.out.println(ele.size());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
				
				
	
	}
			driver.quit();
	}

}

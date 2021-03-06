package readdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {
	
	
	
	
//	@DataProvider(name = "details")
//	public Object[][] getdata() throws Exception {
//		String[] testdata = new String[2];
//		
//		
//		String filepath = ".//resources//info.xlsx";
//		FileInputStream ins = new FileInputStream(filepath);
//		XSSFWorkbook workbook = new XSSFWorkbook(ins);
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		int lastrow = sheet.getLastRowNum();
//		int cellcount = sheet.getRow(0).getLastCellNum();
//		System.out.println(lastrow);
//		System.out.println(cellcount);
//		String logindata[][] = new String[lastrow+1][cellcount];
//		for(int i=0;i<=lastrow;i++)
//		{
//			
//			for(int j=0;j<cellcount;j++)
//			{
//				String data = sheet.getRow(i).getCell(j).getStringCellValue();
//				System.out.println(data);
//				logindata [i][j] =data;
//				
//				
//			}
//		}
//		
//		for(int i=0;i<=lastrow;i++)
//
//		{
//		int k=0;
//		for(int j=0;j<cellcount;j++)
//		{
//			testdata[k++] = logindata[i][j];
//		}	
//		}
//		
//		Object[][] info =new Object[][] {{testdata[0],testdata[1]}};
//		info[0][0];
//		return info;
//		
//		
//	}
	
	
	
	
	@Test(dataProvider = "details")
	public void senda(String a,String b,String c) throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "D:\\software-Testing\\softwarefiles\\chromedriver99\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	driver.findElement(By.id("txtUsername")).sendKeys(a+c);
	driver.findElement(By.id("txtPassword")).sendKeys(b);
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(3000);
	System.out.println(driver.getCurrentUrl());
	driver.close();

	}

@DataProvider(name="details")
public static Object[][] datafromexcel() throws Exception
{

	String filepath = ".//resources//info.xlsx";
	FileInputStream stream = new FileInputStream(filepath);
	XSSFWorkbook workbook = new XSSFWorkbook(stream);
	XSSFSheet sheet = workbook.getSheet("sheet1");
	int row1 = sheet.getLastRowNum();
	System.out.println(row1);

	String datacell = sheet.getRow(0).getCell(0).getStringCellValue();

	String datacell1 = sheet.getRow(0).getCell(1).getStringCellValue();
	int cellcount = sheet.getRow(0).getLastCellNum();
	Object[][] stringdata = new Object[row1+1][cellcount];
	for(int i=0;i<=row1;i++)
	{
		
			for(int j=0;j<cellcount;j++)
			{
			String data = sheet.getRow(i).getCell(j).getStringCellValue();
			stringdata [i][j] = data ;
			
			}
	}
	return stringdata;
}
}

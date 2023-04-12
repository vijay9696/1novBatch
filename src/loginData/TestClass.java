package loginData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelUtility.ReadExcelSheet;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class TestClass 
{
	WebDriver driver;
	
	@BeforeTest
	public void setupDriver()
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void LinkedinTest() throws IOException
	{
		ReadExcelSheet rs=new ReadExcelSheet();
		ArrayList userName=rs.readExcelData(0);
		ArrayList password=rs.readExcelData(1);
		for(int i=0;i<userName.size();i++)
		{
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName.get(i).toString());
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password.get(i).toString());
			driver.findElement(By.xpath("//button[@aria-label='Sign in']")).click();
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//img[@id='ember15']")).click();
			driver.findElement(By.xpath("//a[contains(.,'Sign Out')]']")).click();
			driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
		}
		System.out.println("Test success");
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}

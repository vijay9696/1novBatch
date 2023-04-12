package loginData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import excelUtility.ReadExcelSheet;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class LoginTest 
{
	WebDriver driver;
	public void loginSetup() throws IOException, InterruptedException
	{
		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get(Constants.URL);
		
		ReadExcelSheet rs=new ReadExcelSheet();
		ArrayList userName=rs.readExcelData(0);
		ArrayList password=rs.readExcelData(1);
		for(int i=0;i<userName.size();i++)
		{
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName.get(i).toString());
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password.get(i).toString());
			driver.findElement(By.xpath("//button[@aria-label='Sign in']")).click();
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//img[contains(@class,'global-nav__me-photo ghost-person ember-view')]")).click();
			driver.findElement(By.xpath("//div[@class='artdeco-dropdown__content-inner']//a[contains(.,'Sign Out')]")).click();
			driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[@class='more-actions-btn']")).click();
			driver.findElement(By.xpath("//button[@function-type='forget']")).click();
			if(i>userName.size())
			{
				break;
			}
			
		}
		System.out.println("Test success");
		//driver.close();
	}
}

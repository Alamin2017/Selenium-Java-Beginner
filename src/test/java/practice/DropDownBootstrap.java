package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownBootstrap {

	public static String browser="chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		if(browser.equals("chrome")) {
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Select Product Type']")).click();
		Thread.sleep(3000);
		
		List<WebElement> producttypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println("Number of product sizes:" +producttypes.size());
		
		for(WebElement ptype:producttypes)
		{
			if(ptype.getText().equals("Accounts"))
			{
				ptype.click();
				break;
			}
		}
		
	
		
	
	
	}

}

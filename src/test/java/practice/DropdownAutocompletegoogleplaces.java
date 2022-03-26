package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownAutocompletegoogleplaces {

	public static String browser="chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();
		
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='autocomplete']"));
		Thread.sleep(2000);
		searchbox.clear();
		Thread.sleep(2000);
		searchbox.sendKeys("Toronto");
		Thread.sleep(2000);
		String text;
		do {
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			text=searchbox.getAttribute("value");
			if(text.equals("Toronto, OH, USA"))
			{
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		}while(!text.isEmpty());
		
	}

}

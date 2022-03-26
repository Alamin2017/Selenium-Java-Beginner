package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownAutoSuggest {


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
		
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("selenium");
		
		List<WebElement> list=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println("Size of auto suggestions:"+list.size());
		
		for(WebElement listitem:list)
		{
			if(listitem.getText().contains("benefits"))
			{
				listitem.click();
				break;
			}
		}
	}

}

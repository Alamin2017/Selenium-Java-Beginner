package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdownwithvisibletextandindex {

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
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		
		WebElement ddown=driver.findElement(By.xpath("//select[@name=\"employees_c\"]"));
		Select select=new Select(ddown);
		select.selectByValue("level1");
		Thread.sleep(5000);
		select.selectByVisibleText("51 - 100 employees");
		Thread.sleep(5000);
		select.selectByIndex(5);
		

	}

}

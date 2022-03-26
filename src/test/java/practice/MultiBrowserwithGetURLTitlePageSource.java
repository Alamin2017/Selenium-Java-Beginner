package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserwithGetURLTitlePageSource {
	
	public static String browser="firefox";
	public static WebDriver driver;

	public static void main(String[] args) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}	
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();	
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);	
		String title=driver.getTitle();
		System.out.println(title);	
		String getPageSource=driver.getPageSource();
		System.out.println(getPageSource);	
		driver.navigate().to("https://www.google.com/");
	}

}

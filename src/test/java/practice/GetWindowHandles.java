package practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetWindowHandles {
	public static String browser="edge";
	public static WebDriver driver;
	public static void main(String[] args) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement elements = driver.findElement(By.xpath("//div[@class='inventory_list']"));
		System.out.println(elements);
		
		driver.navigate().to("https://www.sugarcrm.com/au/request-demo/");
		String windowhandle=driver.getWindowHandle();
		System.out.println(windowhandle);
		
		driver.findElement(By.xpath("//*[@id=\"field1\"]/div/input")).click(); 
		Set<String> windowhandles=driver.getWindowHandles();
		System.out.println(windowhandles);
		
		
	
		
	}
}

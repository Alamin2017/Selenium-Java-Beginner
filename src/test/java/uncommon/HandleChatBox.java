package uncommon;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.zxing.NotFoundException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleChatBox {

	public static String browser="chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, NotFoundException, InterruptedException {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.manage().window().maximize();
		/*
		driver.findElement(By.xpath("//div[@id='corover-cb-widget']")).click();
		*/
		WebElement element=driver.findElement(By.xpath("//div[@id='corover-close-btn']"));
		Thread.sleep(3000);
		element.click();
		
	}
	

}

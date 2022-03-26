package uncommon;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.zxing.NotFoundException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleChatBox2 {

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
			driver.get("https://classic.crmpro.com/index.html");
			driver.manage().window().maximize();
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			System.out.println("Waiting for frame:");
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@style,\"height\") and contains(@class,\"intercom\")]")));
			System.out.println("Frame Found");
			
			driver.findElement(By.xpath("//*[@id=\"intercom-container\"]/div/div/div[1]/div/div/span")).click();
			
			System.out.println("Chat Box is closed:");
			
		
			

	}

}

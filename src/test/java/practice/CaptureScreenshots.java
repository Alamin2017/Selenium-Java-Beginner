package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {

	public static String browser="chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();		
		/*
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sr=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\User\\Desktop\\TEST CASE\\homepage.png");
		FileUtils.copyFile(sr,trg);
		*/
	    WebElement ts=driver.findElement(By.xpath("//div[@class='collapse navbar-collapse nav-collapse']"));
		File sr=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\User\\Desktop\\TEST CASE\\homepage.png");
		FileUtils.copyFile(sr,trg);
		driver.close();
		
	}

}

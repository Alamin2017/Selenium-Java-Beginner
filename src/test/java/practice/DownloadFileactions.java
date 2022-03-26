package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileactions {
	
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
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();	
		driver.findElement(By.xpath("//a[@type='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("Al-Amin now downloading the text file after generating");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		Thread.sleep(3000);
		
	}

}

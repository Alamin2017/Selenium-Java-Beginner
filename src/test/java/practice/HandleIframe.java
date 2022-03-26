package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	public static String browser="chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		/*
		//single frame
		WebElement single=driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(single);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
		*/
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		
		
		WebElement multiple=driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(multiple);
		
		WebElement single=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(single);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
		
		
	}

}

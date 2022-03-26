package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.get("http://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame-one1434677811");
		WebElement upload=driver.findElement(By.id("RESULT_FileUpload-10"));
		upload.sendKeys("F:/Govt_job_Others/Al-Amin.jpg");
		js.executeScript("arguments[0].scrollIntoView()", upload);
		
		System.out.print("Uploading file is done::::");
		
	
		
		
		
	}

}

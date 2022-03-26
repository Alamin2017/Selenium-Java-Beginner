package uncommon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadCaptcha {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();
		
		WebElement imageelement=driver.findElement(By.xpath("//*[@id=\"nlpImgContainer\"]"));
		File src=imageelement.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\User\\Desktop\\TEST CASE\\captcha.png";
		
		FileHandler.copy(src, new File(path));
		
		ITesseract image=new Tesseract();
		
		String str=image.doOCR(new File(path));
		
		System.out.print(str);
		

		
		
		
	}

}

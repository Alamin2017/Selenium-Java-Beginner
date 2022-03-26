package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileFirefoxActions {


	public static void main(String[] args) throws InterruptedException {
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(option);
		 
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

package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker1Actions {

	public static String browser="chrome";
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
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		String year="2024";
		String month="jan";
	    String date="18";
	    
	    driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
	    while(true)
	    {
	    	String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
	    	String arr[]=monthyear.split(" ");
	    	String mo=arr[0];
	    	String yr=arr[1];
	    	if(mo.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
	    	{
	    		break;
	    	}
	    	else 
	    	{
	    		driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
	    	}
	    }
	    List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
	   
	    for(WebElement ele: alldates)
	    {
	    	String dt=ele.getText();
	    	if(dt.equals(date))
	    	{
	    		ele.click();
	    		break;
	    	}
	    }
	}

}

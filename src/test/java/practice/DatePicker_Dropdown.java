package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Dropdown {

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
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
	   Select monthdrp= new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
	   monthdrp.selectByVisibleText("Oct");
		
	   Select yeardrp= new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
	   yeardrp.selectByVisibleText("1992");
	   
	   
	   String date="18";
	   
	   List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	   
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

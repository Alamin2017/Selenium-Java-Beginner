package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {
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
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
	  List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
	  System.out.println("Total number of text boxes:"+checkboxes.size());
	 /* 
	  for(int i=0;i<checkboxes.size();i++)
	  {
		  checkboxes.get(i).click();
	  }
		*/
		 /* 
	  for(WebElement check:checkboxes) {
		  check.click();
	  }
		*/
	  
	  /*
	  for(WebElement check:checkboxes) {
		  String checkboxname=check.getAttribute("id");
		  if(checkboxname.equals("monday")||checkboxname.equals("saturday"))
		  {
			  check.click();
		  }
	  }
	  */
	  int totalcheckbox=checkboxes.size();
	  
	  for(int i=totalcheckbox-3;i<totalcheckbox;i++)
	  {
		checkboxes.get(i).click();  
	  }


	}

}

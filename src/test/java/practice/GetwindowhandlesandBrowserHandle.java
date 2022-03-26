package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetwindowhandlesandBrowserHandle {

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
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		String windowID=driver.getWindowHandle();
		System.out.println(windowID);
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs=driver.getWindowHandles();
		/*
		Iterator<String> it=windowIDs.iterator();
		
		String parentwid=it.next();
		String childwid=it.next();
		
		System.out.println("Parent Window ID"+parentwid);
		System.out.println("Child Window ID"+childwid);
		*/
		
		List<String> windowidlist=new ArrayList(windowIDs);
		
		String parentwid=windowidlist.get(0);
		String childwid=windowidlist.get(1);
		
		System.out.println("Parent window ID"+parentwid);
		System.out.println("Child window ID:"+childwid);
		
		driver.switchTo().window(parentwid);
		System.out.println("Parent window title:"+driver.getTitle());
		
		driver.switchTo().window(childwid);
		System.out.println("Child window title:"+driver.getTitle());
		
		//driver.close();
		driver.quit();
		
		
		
	}

}

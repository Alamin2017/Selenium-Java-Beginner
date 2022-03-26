package practice;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesHandle {

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
		
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		
		 Set<Cookie> cookies=driver.manage().getCookies();
		 System.out.println("Size of Cookies:"+cookies.size());
		 
		 for(Cookie cookie:cookies)
		 {
			 System.out.println(cookie.getName()+":"+cookie.getValue());
		 }
		 
		 Cookie cokkieobj=new Cookie("My Cookie123","12344");
		 
		 driver.manage().addCookie(cokkieobj);
		 cookies=driver.manage().getCookies();
		 System.out.println("Size of Cookies after adding:->"+cookies.size());
		 
	 
		 driver.manage().deleteAllCookies();
		 cookies=driver.manage().getCookies();
		 System.out.println("Size of Cookies after deletion:->"+cookies.size());
		 driver.quit();
	}

}

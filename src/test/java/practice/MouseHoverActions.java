package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MouseHoverActions {

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
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement admin= driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']"));
		WebElement usermg= driver.findElement(By.xpath("//*[@id='menu_admin_UserManagement']"));
		WebElement user= driver.findElement(By.xpath("//*[@id='menu_admin_viewSystemUsers']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).moveToElement(usermg).moveToElement(user).click().build().perform();
		
	}
}

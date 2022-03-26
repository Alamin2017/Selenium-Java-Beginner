package uncommon;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestHM {
	
	static HashMap<String ,String> logindata(){
		HashMap<String ,String> hm=new HashMap<String ,String>();
		hm.put("x", "Admin@admin123");
		return hm;
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		String credentials=logindata().get("x");
		String arr[]=credentials.split("@");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(arr[0]);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
	}

}

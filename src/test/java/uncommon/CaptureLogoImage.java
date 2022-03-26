package uncommon;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.google.zxing.NotFoundException;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage {

	public static String browser="chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, NotFoundException {
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
		
		WebElement LogoImageElement=driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		Screenshot LogoImageScreenshot=new AShot().takeScreenshot(driver,LogoImageElement);
		ImageIO.write(LogoImageScreenshot.getImage(),"png",new File("C:\\Users\\User\\Desktop\\TEST CASE\\logos.png"));
		
		File f=new File("C:\\Users\\User\\Desktop\\TEST CASE\\logos.png");
		if(f.exists()) {
			System.out.print("Image File Captured");
		}
		else
		{
			System.out.print("Image file not exists");
		}
		

   }
}


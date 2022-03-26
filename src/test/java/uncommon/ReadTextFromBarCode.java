package uncommon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ReadTextFromBarCode {
	
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
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();	
		String barCodeURL=driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/img")).getAttribute("src");
		System.out.println(barCodeURL);
		URL url=new URL(barCodeURL);
		BufferedImage bufferedimage=ImageIO.read(url);
		// Process the image
		LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
		//To Capture details of QR code
		Result result =new MultiFormatReader().decode(binaryBitmap);
		System.out.println(result.getText());
		driver.close();
	}

}

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {


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
		driver.get("https://datatables.net/extensions/fixedcolumns/examples/initialisation/left_right_columns.html");
		driver.manage().window().maximize();
		
		int rows=driver.findElements(By.xpath("//div[@id='example_wrapper']//tbody//tr")).size();
		System.out.println("Total number of rows:"+rows);
		
		int cols=driver.findElements(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div[1]/div/table/thead/tr/th")).size();
		System.out.println("Total number of cols:"+cols);
		
	
		String value=driver.findElement(By.xpath("//div[@id='example_wrapper']//tbody//tr[2]//td[1]")).getText();
		System.out.println("The value of row :"+value);
		
		for(int r=1;r<=3;r++) {
			for(int c=1;c<=9;c++)
			{
				String data=driver.findElement(By.xpath("//div[@id='example_wrapper']//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+" ");
			}
			System.out.println(" ");
		}
		
		driver.quit();
		
	}

}

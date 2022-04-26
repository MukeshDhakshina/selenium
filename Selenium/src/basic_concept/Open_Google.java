package basic_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;





public class Open_Google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.open  Chrome Browser 
		//2.open google
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("http://192.168.3.251:8090/Portal/HDPAY/login");


		driver.findElement(By.name("uname")).sendKeys("ADMIN");

		driver.findElement(By.name("psw")).sendKeys("Login@123"+Keys.ENTER);

		WebElement target = driver.findElement(By.partialLinkText("Reports"));
		WebElement target1 = driver.findElement(By.xpath("//*[@id=\'report\']/ul/li[1]/a/span"));

		Actions select = new Actions(driver);

		select.moveToElement(target);
		select.click(target1);
		select.build().perform();


		
		
		
			
	}

} 

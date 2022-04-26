package h2h;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_010 {
	
	

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void TC_01() throws InterruptedException {
		//1.Check- click the "Administrator" parental  menu 
		WebElement PIU = driver.findElement(By.xpath("//*[@id=\"profile\"]/ul/li[1]/a/span"));
		PIU.click();
		Thread.sleep(3000);
		//Result --- It shows child menu - "My profile","edit profile","settings".
	}
	
	
	
	
	
	
	
	
	
	
	

}

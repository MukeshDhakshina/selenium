package h2h;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_006 {

	
	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "Url_HealthTest", priority = 1)
	public void TC_01() throws InterruptedException {		
		// _01.Check- click the "Administrator" parent menu 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("check");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
			Thread.sleep(5000);
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();
			Thread.sleep(5000);
		// Result --- It shows child menu - "My profile,edit profile,settings".	
	}

	@Test(priority = 2)
	public void TC_02() throws InterruptedException {		
		// _02.click to verify the "Reports" parent menu 
			WebElement Reports = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[1]/a"));
			Reports.click();
			Thread.sleep(3000);
		// Result --- It shows child menu -                          
		//      	 		            -Receipt invoice Print,                               
		//								-Invoice payment status,                            
		//								-Report Generation.                                                                                  
	}
	
	@Test(priority = 3)
	public void TC_03() throws InterruptedException {		
		// _03.In Reports- click the "Receipt invoice Print" child menu.
			WebElement RIP = driver.findElement(By.xpath("//*[@id=\"reports\"]/ul/li[3]/a/span"));
			RIP.click();
			Thread.sleep(3000);
		// Result --- It navigate "Receipt invoice Print" page.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

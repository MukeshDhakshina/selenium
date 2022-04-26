package h2h;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TS_011 {

WebDriver driver;
	

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void TC_01_Check_click_the_Administrator_parental_menu () 
			throws InterruptedException {
		//1.Check- click the "Administrator" parental  menu 
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("MAKER");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123" + Keys.ENTER);
		Thread.sleep(5000);
		WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
		threedots.click();
		Thread.sleep(5000);
		//Result --- It shows child menu - "My profile","edit profile","settings".                       
	}
	
	@Test(priority = 2)
	public void TC_02_click_to_verify_the_Peer_to_Peer_parent_menu ()
		throws InterruptedException {
		//2.click to verify the "Peer to Peer" parent menu 
		WebElement P2P = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a"));
		P2P.click();
		Thread.sleep(3000);
		//Result --- It shows child menu - "Payment Bill" .                                                                                      
	}
	
	@Test(priority = 3)
	public void TC_03_In_Payment_Bill_Click_to_verify_Payment_Bill_child_menu ()
			throws InterruptedException {
		//3.In Payment Bill- Click to verify "Payment Bill" child menu.
		WebElement P2P = driver.findElement(By.xpath("//*[@id=\"p2p\"]/ul/li[1]"));
		P2P.click();
		Thread.sleep(3000);
		//Result --- It navigate "Payment Bill" page.                                                                                   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

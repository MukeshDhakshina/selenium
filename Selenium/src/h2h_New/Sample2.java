package h2h_New;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample2 {
	
	WebDriver driver;
	
	String H2H_url = "http://192.168.1.5:18080/H2H/";
	String HDPAY_url ="http://192.168.1.5:18080/Portal/HDPAY";
	
	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.8).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(H2H_url);
		Thread.sleep(2000);
	}
	
	
	
	@Test(priority = 1)
	public void TS_Checker_Reports_02_Check_click_the_Administrator_parent_menu()
		throws InterruptedException {
		//TS_Checker-Reports_02.""In Reset Password- Check the ""Re-Enter Password"" field."
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("siva001");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(6000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(12000);
		//Result --"It shows child menu - ""My profile,edit profile,settings""."       

	}
	
	@Test(priority = 2) 
	public void TS_Peer_to_Peer_02_click_to_verify_the_Peer_to_Peer_parent_menu()
	  throws InterruptedException { 
		//TS_Peer_to_Peer_02.click to verify the "Peer to Peer" parent menu
		  WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
		  threedots.click(); 
		  Thread.sleep(5000); 
		  WebElement peep_peer = driver.findElement(By.id("p2p_"));
		  peep_peer.click(); 
		  Thread.sleep(5000);
		  WebElement Gepgpayment = driver.findElement(By.xpath("//*[@id=\"p2p\"]/ul/li[1]/a"));
		  Gepgpayment.click(); 
		  Thread.sleep(8000);
	  //Result--It shows child menu - "Payment Bill".
	
	}
	
	@Test(priority = 40) 
	public void TS_GePG_01_In_Gepg_payment_Check_the_Invoice_No_field_When_we_submit_the_Correct_Invoice_No()
	  throws InterruptedException { 
		//TS_GePG_01."In Gepg payment : Check the Invoice No. field When we submit the Correct Invoice No."
		WebElement invoice_No = driver.findElement(By.id("billno"));
		  invoice_No.sendKeys("991900001801 - correct invoice");
		  Thread.sleep(1000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900001801");
		  Thread.sleep(3000);
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(5000);
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(4000);
		  WebElement submit_btn = driver.findElement(By.id("submit"));
		  submit_btn.click();
		  Thread.sleep(4000);
		  driver.navigate().refresh();
	  //Result--It navigate "Payment Bill" page.
	
	}

}

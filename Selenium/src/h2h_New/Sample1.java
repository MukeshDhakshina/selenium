package h2h_New;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample1 {
	WebDriver driver;
	String H2H_url = "http://192.168.1.5:18080/H2H/";
	String HDPAY_url = "http://192.168.1.5:18080/Portal/HDPAY";
	
	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.8).exe");
		driver = new ChromeDriver();
		driver.get(H2H_url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void TC_01() throws InterruptedException {	
		//1.click the "user Registration" parent menu 
		Thread.sleep(3000);		
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("siva002");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123");
		Thread.sleep(3000);

		//Result ---- It shows child menu - "User Registraion and Reset password"
	}
		
	@Test(priority = 58) 
	public void TS_GePG_21_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
	  throws InterruptedException { 
		//TS_GePG_21.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
			((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(2000);
			driver.navigate().refresh();
			WebElement UsernameField = driver.findElement(By.name("uname"));
			UsernameField.sendKeys("ADMIN");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.name("psw"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click(); 
			Thread.sleep(3000); 
			WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
			Reports_Parentmenu.click(); 
			Thread.sleep(3000); 
			WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
			Trans_Report.click(); 
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			WebElement Search_field = driver.findElement(By.id("tst_search"));
			Search_field.sendKeys("991900002519"); 
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			Thread.sleep(10000);
			WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
		    // Scroll to div's most right:
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
		    Thread.sleep(3000);
			WebElement Highlight_invoice = driver. findElement(By.xpath("//*[@id=\"example\"]/tbody/tr/td[12]"));          // Highligh "Invoice No"
		    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",Highlight_invoice);
			Thread.sleep(6000);
		    WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[5]/a/div/img"));
			Logoutimg.click();
			Thread.sleep(5000);
			WebElement Logoutbutton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[5]/ul/div/div[1]/li[2]/a[5]"));
			Logoutbutton.click();	
			Thread.sleep(3000);
			//close the TabS
//			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(1));
//			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
			PasswordField1.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		//Result-- The Request should be received in HDPAY
		
	}
	
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
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

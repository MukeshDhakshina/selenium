package h2h_New;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
	
      
public class GEPG {
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
	
	@Test(priority = 41) 
	public void TS_GePG_02_In_Gepg_payment_Check_the_Invoice_No_field_When_we_submit_the_Wrong_Invoice_No()
	  throws InterruptedException { 
		//TS_GePG_02."In Gepg payment : Check the Invoice No. field When we submit the Wrong Invoice No."
		  WebElement invoice_No = driver.findElement(By.id("billno"));
		  invoice_No.sendKeys("0000000000000 - wrong invoice");
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("0000000000000");
		  Thread.sleep(3000);
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(6000);
		  driver.navigate().refresh();	 
		//Result--It should Not able to auto complete the below respected fields based on the invoice no, it will show the message as "Bill Details Not found!!!"
	
	}
	
	@Test(priority = 42) 
	public void TS_GePG_03_In_Gepg_payment_Check_the_Invoice_No_field_When_we_submit_the_Expired_invoice_for_requseting_to_get_bill_details()
	  throws InterruptedException { 
		//TS_GePG_03."In Gepg payment : Check the Invoice No. field When we submit the Expired invoice for requseting to get bill details"
		  WebElement invoice_No = driver.findElement(By.id("billno"));             //Non Tiss - Infinity
		  invoice_No.sendKeys("991900001801 Non Tiss - Infinity");
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));             //Non Tiss - Infinity
		  invoice_No1.sendKeys("991900001801");
		  Thread.sleep(3000);
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount = driver.findElement(By.id("pamount"));
		  pay_amount.clear();
		  Thread.sleep(1000);
		  pay_amount.sendKeys("1000",Keys.TAB);         
		  Thread.sleep(3000); 
		  WebElement light_alert = driver. findElement(By.id("description"));          // ligh "Bill is already in queue there!!!"
		  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
		  Thread.sleep(6000);
		  driver.navigate().refresh();  
	  //Result--It should Not able to auto complete the below respected fields based on the invoice no, it will show the message as "Bill details are not found"
	
	}
	
	@Test(priority = 43) 
	public void TS_GePG_04_In_Gepg_payment_Non_Tiss_Invoice_No_within_Bank_Enter_the_Non_Tiss_Invoice_number_in_the_Invoice_number_field()
	  throws InterruptedException { 
		//TS_GePG_04."In Gepg payment : Non Tiss Invoice No. (within Bank) Enter the Non-Tiss Invoice number in the Invoice number field "
		  WebElement invoice_No = driver.findElement(By.id("billno"));
		  invoice_No.sendKeys("991900001804 Non-Tiss");                        //Non-Tiss
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900001804");
		  Thread.sleep(2000);
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);
		  WebElement light_alert1 = driver. findElement(By.id("bid"));          // ligh "Bank Name"
		  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
		  Thread.sleep(3000);
		  WebElement light_alert2 = driver. findElement(By.id("accountno"));          // ligh "Account Number"
		  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
		  Thread.sleep(3000);
		  WebElement light_alert3 = driver. findElement(By.id("accholder"));          // ligh "Account Holder"
		  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
		  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result--It should Not able to access or Not able to edit the below fields like Bank Name, Account number, Account Holder  Other field should be auto complete field
	
	}
	
	@Test(priority = 43) 
	public void TS_GePG_05_In_Gepg_payment_Non_tiss_Within_Bank_Postpaid_invoice_No_Check_after_entering_the_invoice_No_and_click_the_Get_bill_details()
	  throws InterruptedException { 
		//TS_GePG_05."In Gepg payment : Non Tiss Invoice No. (within Bank) Enter the Non-Tiss Invoice number in the Invoice number field "
		  WebElement invoice_No = driver.findElement(By.id("billno"));
		  invoice_No.sendKeys("991900002805 Non-Tiss = postpaid ");          //Non-Tiss = postpaid 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002805");
		  Thread.sleep(3000);
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);
		  WebElement light_alert1 = driver. findElement(By.id("billdate"));          // ligh "Invoice Date"
		  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
		  Thread.sleep(3000);
		  WebElement light_alert2 = driver. findElement(By.id("billamount"));          // ligh "Invoice Amount"
		  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
		  Thread.sleep(3000);
		  WebElement light_alert3 = driver. findElement(By.id("billcust"));          // ligh "Customer Name"
		  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
		  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
		  Thread.sleep(3000);
		  WebElement light_alert4 = driver. findElement(By.id("status"));          	// ligh "Payment status"
		  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
		  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
		  Thread.sleep(3000);
		  WebElement light_alert5 = driver. findElement(By.id("pplan"));          // ligh "Payment Type"
		  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
		  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  //Result--It should auto fill  the below fields only with read only fields like Invoice Date, Invoice Amount,
	 //Customer Name, Payment status, Payment Type and Other fields had facility to edit
	
	}
	
	@Test(priority = 44) 
	public void TS_GePG_06_In_Gepg_payment_Non_Tiss_Postpaid_Invoice_Postpaid_Check_when_it_is_a_Exact_Type_means()
	  throws InterruptedException { 
		//TS_GePG_06.In Gepg payment : Non Tiss Postpaid Invoice. In Postpaid, Check when it is a Exact Type means,
		  WebElement invoice_No = driver.findElement(By.id("billno"));
		  invoice_No.sendKeys("991900002706 Non-Tiss = postpaid - Exact");          // Non-Tiss = postpaid , Exact 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002706");
		  Thread.sleep(3000);
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);      
		  Actions actions = new Actions(driver);
		  WebElement elementLocator = driver.findElement(By.id("pamount"));
		  actions.doubleClick(elementLocator).perform();
		  Thread.sleep(3000);        
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  //Result-- It should not able to access or not able to edit the Payment Amount field.(payment amount is equal to invoice amount)
	
	}
	
	@Test(priority = 45) 
	public void TS_GePG_07_In_Gepg_payment_Non_Tiss_Postpaid_Invoice_In_Postpaid_Check_it_is_a_Partial_or_Infinity_or_limited_or_Full_Type_means()
	  throws InterruptedException { 
		//TS_GePG_07.In Gepg payment:Non Tiss Postpaid Invoice.In Postpaid, Check it is a Partial or Infinity or limited or Full Type means,
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002607 Non-Tiss = postpaid , partial ");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002607");
		  Thread.sleep(3000);
		  WebElement GBD1 = driver.findElement(By.id("getbill"));
		  GBD1.click();
		  Thread.sleep(3000);      
		  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
		  pay_amount1.clear();
		  Thread.sleep(3000);
		  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
		  pay_amount2.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  WebElement invoice_No3 = driver.findElement(By.id("billno"));
		  invoice_No3.sendKeys("991900002807 Non-Tiss = postpaid , Infinity");          // Non-Tiss = postpaid , Infinity 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  WebElement invoice_No4 = driver.findElement(By.id("billno"));
		  invoice_No4.sendKeys("991900002807");
		  Thread.sleep(3000);
		  WebElement GBD2 = driver.findElement(By.id("getbill"));
		  GBD2.click();
		  Thread.sleep(3000); 
		  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
		  pay_amount3.clear();
		  Thread.sleep(3000);
		  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
		  pay_amount4.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  WebElement invoice_No5 = driver.findElement(By.id("billno"));
		  invoice_No5.sendKeys("991900002907 Non-Tiss = postpaid , limited");          // Non-Tiss = postpaid , limited 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  WebElement invoice_No6 = driver.findElement(By.id("billno"));
		  invoice_No6.sendKeys("991900002907");
		  Thread.sleep(3000);	
		  WebElement GBD3 = driver.findElement(By.id("getbill"));
		  GBD3.click();
		  Thread.sleep(3000);
		  WebElement pay_amount5 = driver.findElement(By.id("pamount"));
		  pay_amount5.clear();
		  Thread.sleep(3000);
		  WebElement pay_amount6 = driver.findElement(By.id("pamount"));
		  pay_amount6.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  WebElement invoice_No7 = driver.findElement(By.id("billno"));
		  invoice_No7.sendKeys("991900002507 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  WebElement invoice_No8 = driver.findElement(By.id("billno"));
		  invoice_No8.sendKeys("991900002507");
		  Thread.sleep(3000);
		  WebElement GBD4 = driver.findElement(By.id("getbill"));
		  GBD4.click();
		  Thread.sleep(3000); 
		  WebElement pay_amount7 = driver.findElement(By.id("pamount"));
		  pay_amount7.clear();
		  Thread.sleep(3000);
		  WebElement pay_amount8 = driver.findElement(By.id("pamount"));
		  pay_amount8.sendKeys("1200");         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result-- "It should able to access or edit the Payment Amount field.(Invoice amount > 0)"
	
	}
	
	@Test(priority = 46) 
	public void TS_GePG_08_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_cash_Payment_mode_partial_After_entering_the_invoice_check_the_payment_amount()
	  throws InterruptedException { 
		//TS_GePG_08.In Gepg payment : Non Tiss postpaid invoice Payment type - cash Payment mode - partial. After entering the invoice check the payment amount.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002608 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002608");
		  Thread.sleep(3000);			  
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount = driver.findElement(By.id("pamount"));
		  pay_amount.clear();
		  Thread.sleep(3000);
		  pay_amount.sendKeys("999",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result-- Payment amount should be editable in that field, Payment amount should Greater than zero or Lesser than invoice amount
	
	}
	
	
	@Test(priority = 47) 
	public void TS_GePG_09_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_cash_Payment_mode_partial_After_entering_the_invoice_check_the_payment_amount()
	  throws InterruptedException { 
		//TS_GePG_09.In Gepg payment : Non Tiss postpaid invoice Payment type - cash Payment mode - partial. After entering the invoice check the payment amount.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002709 Non-Tiss = postpaid , Exact ");          // Non-Tiss = postpaid , Exact 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002709");
		  Thread.sleep(3000);		 
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);     
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount = driver.findElement(By.id("pamount"));
		  Thread.sleep(3000);
		  pay_amount.sendKeys("999");         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result-- Payment amount should be editable in that field, Payment amount should Greater than zero or Lesser than invoice amount
	
	}
	
	@Test(priority = 48) 
	public void TS_GePG_10_In_Gepg_payment_Non_Tiss_Postpaid_Invoice_In_Postpaid_Check_it_is_partial_or_Infinity_or_limited_or_Full_Type()
	  throws InterruptedException { 
		//TS_GePG_10."In Gepg payment : Non Tiss Postpaid Invoice. In Postpaid, Check it is a Partial or Infinity or limited."
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002610 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002603");          
		  Thread.sleep(3000);		 
		  WebElement GBD1 = driver.findElement(By.id("getbill"));
		  GBD1.click();
		  Thread.sleep(3000);      
		  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
		  pay_amount1.clear();
		  Thread.sleep(3000);
		  pay_amount1.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No3 = driver.findElement(By.id("billno"));
		  invoice_No3.sendKeys("991900002810 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No4 = driver.findElement(By.id("billno"));
		  invoice_No4.sendKeys("991900002810");          
		  Thread.sleep(3000);
		  WebElement GBD2 = driver.findElement(By.id("getbill"));
		  GBD2.click();
		  Thread.sleep(3000);  
		  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
		  pay_amount2.clear();
		  Thread.sleep(3000);
		  pay_amount2.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No5 = driver.findElement(By.id("billno"));
		  invoice_No5.sendKeys("991900002910 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No6 = driver.findElement(By.id("billno"));
		  invoice_No6.sendKeys("991900002910");          
		  Thread.sleep(3000);	
		  WebElement GBD3 = driver.findElement(By.id("getbill"));
		  GBD3.click();
		  Thread.sleep(3000);  
		  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
		  pay_amount3.clear();
		  Thread.sleep(3000);
		  pay_amount3.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No7 = driver.findElement(By.id("billno"));
		  invoice_No7.sendKeys("991900002510 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No8 = driver.findElement(By.id("billno"));
		  invoice_No8.sendKeys("991900002510");          
		  Thread.sleep(3000);
		  WebElement GBD4 = driver.findElement(By.id("getbill"));
		  GBD4.click();
		  Thread.sleep(3000); 
		  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
		  pay_amount4.clear();
		  Thread.sleep(3000);
		  pay_amount4.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000); 
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result-- Payment amount should be editable in that field Payment amount should Greater than zero.
	
	}
	
	
	@Test(priority = 49) 
	public void TS_GePG_11_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_cash_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount()
	  throws InterruptedException { 
		//TS_GePG_11.In Gepg payment : Non Tiss postpaid invoice Payment type - cash Payment mode - Full. After entering the invoice check the payment amount.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002511 Non-Tiss = Cash, Full");          // Non-Tiss = postpaid cash, Full  /  equal to invoice amount
		  Thread.sleep(2000);   
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002511");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(3000);		  
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);     
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");      
		  Thread.sleep(3000);
		  WebElement pay_amount = driver.findElement(By.id("pamount"));
		  pay_amount.clear();
		  Thread.sleep(3000);
		  pay_amount.sendKeys("1000",Keys.TAB); 
		  Thread.sleep(3000);
		  WebElement submit_btn = driver.findElement(By.id("submit"));
		  submit_btn.click();
		  Thread.sleep(5000); 
	  //Result-- Payment amount should be editable in that field Payment amount should equal to invoice amount or greater than payment amount.
	
	}
	
	
	@Test(priority = 50) 
	public void TS_GePG_12_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Cash_Payment_modeFull_After_entering_the_invoice_check_the_payment_amount_amount()
	  throws InterruptedException { 
		//TS_GePG_12.In Gepg payment : Non Tiss postpaid invoice Payment type - cash Payment mode - Full.
		  //After entering the invoice check the payment amount.In Gepg payment : Non Tiss postpaid invoice Payment type - Cash Payment mode - Full. After entering the invoice check the payment amount. Payment amount should be editable in that field If we enter less than the invoice amount.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002512 Non-Tiss = Cash, Full");          // Non-Tiss = postpaid cash, Full    / less than invoice amount
		  Thread.sleep(2000);   
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002512");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(3000);		  
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000); 
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount = driver.findElement(By.id("pamount"));
		  pay_amount.clear();
		  Thread.sleep(3000);
		  pay_amount.sendKeys("999",Keys.TAB);   	
		  Thread.sleep(3000);
		  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment amount" for less than invoice amount
		  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
		  Thread.sleep(3000);
	  //Result-- The payment process should not happen and leave a message "Amount Should not be less than Invoice amount".
	
	}
	
	@Test(priority = 51) 
	public void TS_GePG_13_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_cash_Payment_mode_Limited_After_entering_the_invoice_check_the_payment_amount()
	  throws InterruptedException { 
		//TS_GePG_13."In Gepg payment : Non Tiss postpaid invoice Payment type - cash Payment mode - Limited. After entering the invoice check the payment amount."
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002913 Non-Tiss = Cash, Limited");         // Non-Tiss = postpaid cash, Limited / Payment amount should not equal to zero.
		  Thread.sleep(2000);   
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002913");          // Non-Tiss = postpaid , Limited 
		  Thread.sleep(3000);		  
		  WebElement GBD = driver.findElement(By.id("getbill"));
		  GBD.click();
		  Thread.sleep(3000);      
		  WebElement pay_mode = driver.findElement(By.id("pmode"));
		  Select select = new Select(pay_mode);
		  select.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);  
		  WebElement pay_amount = driver.findElement(By.id("pamount"));
		  pay_amount.clear();
		  Thread.sleep(3000);
		  pay_amount.sendKeys("0",Keys.TAB); 
		  Thread.sleep(3000);
		  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payamount"
		  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
		  Thread.sleep(3000); 
	  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero.
	
	}
	
	
	@Test(priority = 52) 
	public void TS_GePG_14_In_Gepg_payment_Non_Tiss_postpaid_invoice_Check_whether_the_Outstanding_amount_presenting_the_right_balance_amount_or_Not()
	  throws InterruptedException { 
		//TS_GePG_14.In Gepg payment : Non Tiss postpaid invoice  Check whether the Outstanding amount presenting the right balance amount or Not.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002614 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002614");          
		  Thread.sleep(3000);		 
		  WebElement GBD1 = driver.findElement(By.id("getbill"));
		  GBD1.click();
		  Thread.sleep(3000);      
		  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
		  pay_amount1.clear();
		  Thread.sleep(3000);
		  pay_amount1.sendKeys("101",Keys.TAB);         
		  Thread.sleep(3000);
		  Actions actions = new Actions(driver);
		  WebElement elementLocator = driver.findElement(By.id("outamount"));
		  actions.doubleClick(elementLocator).perform();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No3 = driver.findElement(By.id("billno"));
		  invoice_No3.sendKeys("991900002814 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No4 = driver.findElement(By.id("billno"));
		  invoice_No4.sendKeys("991900002814");          
		  Thread.sleep(3000);
		  WebElement GBD2 = driver.findElement(By.id("getbill"));
		  GBD2.click();
		  Thread.sleep(3000); 
		  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
		  pay_amount2.clear();
		  Thread.sleep(3000);
		  pay_amount2.sendKeys("201",Keys.TAB);         
		  Thread.sleep(3000);
		  Actions actions1 = new Actions(driver);
		  WebElement elementLocator1 = driver.findElement(By.id("outamount"));
		  actions1.doubleClick(elementLocator1).perform();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No5 = driver.findElement(By.id("billno"));
		  invoice_No5.sendKeys("991900002914 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No6 = driver.findElement(By.id("billno"));
		  invoice_No6.sendKeys("991900002914");          
		  Thread.sleep(3000);
		  WebElement GBD3 = driver.findElement(By.id("getbill"));
		  GBD3.click();
		  Thread.sleep(3000); 
		  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
		  pay_amount3.clear();
		  Thread.sleep(3000);
		  pay_amount3.sendKeys("301",Keys.TAB);         
		  Thread.sleep(3000);
		  Actions actions3 = new Actions(driver);
		  WebElement elementLocator3 = driver.findElement(By.id("outamount"));
		  actions3.doubleClick(elementLocator3).perform();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No7 = driver.findElement(By.id("billno"));
		  invoice_No7.sendKeys("991900002514 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No8 = driver.findElement(By.id("billno"));
		  invoice_No8.sendKeys("991900002514");          
		  Thread.sleep(3000);	
		  WebElement GBD4 = driver.findElement(By.id("getbill"));
		  GBD4.click();
		  Thread.sleep(3000);   
		  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
		  pay_amount4.clear();
		  Thread.sleep(3000);
		  pay_amount4.sendKeys("1200",Keys.TAB);         
		  Thread.sleep(3000); 
		  Actions actions4 = new Actions(driver);
		  WebElement elementLocator4 = driver.findElement(By.id("outamount"));
		  actions4.doubleClick(elementLocator4).perform();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);	 
	  //Result-- "It should be presenting value of subracting the payment amount from invoice amount (invoice amount - payment amount = Outstanding amount)."
	
	}
	
	@Test(priority = 53) 
	public void TS_GePG_15_In_Gepg_payment_Non_Tiss_postpaid_invoice_Entering_the_minus_valu_in_payment_amount_field_and_after_click_the_submit()
	  throws InterruptedException { 
		//TS_GePG_15."In Gepg payment : Non Tiss postpaid invoice. Entering the minus value in payment amount field and after click the submit."
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002615 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002615");          
		  Thread.sleep(3000);		 
		  WebElement GBD1 = driver.findElement(By.id("getbill"));
		  GBD1.click();
		  Thread.sleep(3000);      
		  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
		  pay_amount1.clear();
		  Thread.sleep(3000);
		  pay_amount1.sendKeys("-499",Keys.TAB);         
		  Thread.sleep(3000);
		  WebElement light_alert1 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No3 = driver.findElement(By.id("billno"));
		  invoice_No3.sendKeys("991900002815 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No4 = driver.findElement(By.id("billno"));
		  invoice_No4.sendKeys("991900002815");          
		  Thread.sleep(3000);
		  WebElement GBD2 = driver.findElement(By.id("getbill"));
		  GBD2.click();
		  Thread.sleep(3000); 
		  WebElement light_alert2 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
		  Thread.sleep(3000);
		  Actions actions2 = new Actions(driver);
		  WebElement elementLocator2 = driver.findElement(By.id("pamount"));
		  actions2.doubleClick(elementLocator2).perform();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No5 = driver.findElement(By.id("billno"));
		  invoice_No5.sendKeys("991900002915 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No6 = driver.findElement(By.id("billno"));
		  invoice_No6.sendKeys("991900002915");          
		  Thread.sleep(3000);
		  WebElement GBD3 = driver.findElement(By.id("getbill"));
		  GBD3.click();
		  Thread.sleep(3000);
		  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
		  pay_amount3.clear();
		  Thread.sleep(3000);
		  pay_amount3.sendKeys("-899",Keys.TAB);         
		  Thread.sleep(3000);
		  WebElement light_alert3 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
		  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No7 = driver.findElement(By.id("billno"));
		  invoice_No7.sendKeys("991900002515 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No8 = driver.findElement(By.id("billno"));
		  invoice_No8.sendKeys("991900002515");          
		  Thread.sleep(3000);
		  WebElement GBD4 = driver.findElement(By.id("getbill"));
		  GBD4.click();
		  Thread.sleep(3000);
		  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
		  pay_amount4.clear();
		  Thread.sleep(3000);
		  pay_amount4.sendKeys("-1200",Keys.TAB);         
		  Thread.sleep(3000); 
		  WebElement light_alert4 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
		  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);	 
	  //Result-- It should leave a message "Payment amount should not be less than or equal 0!!!”
	
	}
	
	
	@Test(priority = 54) 
	public void TS_GePG_16_In_Gepg_payment_Non_Tiss_postpaid_CASH_invoice_After_entering_the_correct_payment_amount_and_click_the_submit_button()
	  throws InterruptedException { 
		//TS_GePG_16.In Gepg payment : Non Tiss postpaid invoice  After entering the correct payment amount and click the submit button.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002616 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002616");          
		  Thread.sleep(3000);		 
		  WebElement GBD1 = driver.findElement(By.id("getbill"));
		  GBD1.click();
		  Thread.sleep(3000);
		  WebElement pay_mode1 = driver.findElement(By.id("pmode"));
		  Select select1 = new Select(pay_mode1);
		  select1.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
		  pay_amount1.clear();
		  Thread.sleep(3000);
		  pay_amount1.sendKeys("500",Keys.TAB);         
		  Thread.sleep(3000);
		  WebElement submit_btn1 = driver.findElement(By.id("submit"));
		  submit_btn1.click();
		  Thread.sleep(5000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No3 = driver.findElement(By.id("billno"));
		  invoice_No3.sendKeys("991900002816 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No4 = driver.findElement(By.id("billno"));
		  invoice_No4.sendKeys("991900002816");          
		  Thread.sleep(3000);
		  WebElement GBD2 = driver.findElement(By.id("getbill"));
		  GBD2.click();
		  Thread.sleep(3000);
		  WebElement pay_mode2 = driver.findElement(By.id("pmode"));
		  Select select2 = new Select(pay_mode2);
		  select2.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
		  pay_amount2.clear();
		  Thread.sleep(3000);
		  pay_amount2.sendKeys("600",Keys.TAB);         
		  Thread.sleep(3000);
		  WebElement submit_btn2 = driver.findElement(By.id("submit"));
		  submit_btn2.click();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No5 = driver.findElement(By.id("billno"));
		  invoice_No5.sendKeys("991900002916 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No6 = driver.findElement(By.id("billno"));
		  invoice_No6.sendKeys("991900002916");          
		  Thread.sleep(3000);	
		  WebElement GBD3 = driver.findElement(By.id("getbill"));
		  GBD3.click();
		  Thread.sleep(3000);  
		  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
		  pay_amount3.clear();
		  Thread.sleep(3000);
		  pay_amount3.sendKeys("800",Keys.TAB);         
		  Thread.sleep(3000);
		  WebElement pay_mode3 = driver.findElement(By.id("pmode"));
		  Select select3 = new Select(pay_mode3);
		  select3.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement submit_btn3 = driver.findElement(By.id("submit"));
		  submit_btn3.click();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No7 = driver.findElement(By.id("billno"));
		  invoice_No7.sendKeys("991900002516 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No8 = driver.findElement(By.id("billno"));
		  invoice_No8.sendKeys("991900002516");          
		  Thread.sleep(3000);
		  WebElement GBD4 = driver.findElement(By.id("getbill"));
		  GBD4.click();
		  Thread.sleep(3000);
		  WebElement pay_mode4 = driver.findElement(By.id("pmode"));
		  Select select4 = new Select(pay_mode4);
		  select4.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
		  pay_amount4.clear();
		  Thread.sleep(3000);
		  pay_amount4.sendKeys("1200",Keys.TAB);         
		  Thread.sleep(3000); 
		  WebElement submit_btn4 = driver.findElement(By.id("submit"));
		  submit_btn4.click();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No9 = driver.findElement(By.id("billno"));
		  invoice_No9.sendKeys("991900002716 Non-Tiss = postpaid , Exact ");          // Non-Tiss = postpaid , Exact 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No10 = driver.findElement(By.id("billno"));
		  invoice_No10.sendKeys("991900002716");          
		  Thread.sleep(3000);
		  WebElement GBD5 = driver.findElement(By.id("getbill"));
		  GBD5.click();
		  Thread.sleep(3000);
		  WebElement pay_mode5 = driver.findElement(By.id("pmode"));
		  Select select5 = new Select(pay_mode5);
		  select5.selectByVisibleText("Non-TISS(Cash)");
		  Thread.sleep(3000);
		  WebElement submit_btn5 = driver.findElement(By.id("submit"));
		  submit_btn5.click();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result-- It will shown a message as "Record Successfully updated"
	
	}
	
	
	@Test(priority = 55) 
	public void TS_GePG_17_In_Gepg_payment_Non_Tiss_postpaid_CASH_invoice_Re_submititing_the_same_invoice()
	  throws InterruptedException { 
		//TS_GePG_17.In Gepg payment : Non Tiss postpaid invoice  Re-submititing the same invoice.
		  WebElement invoice_No1 = driver.findElement(By.id("billno"));
		  invoice_No1.sendKeys("991900002616 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No2 = driver.findElement(By.id("billno"));
		  invoice_No2.sendKeys("991900002616");          
		  Thread.sleep(3000);		 	
		  WebElement GBD1 = driver.findElement(By.id("getbill"));
		  GBD1.click();
		  Thread.sleep(3000);
		  WebElement light_alert1 = driver. findElement(By.id("description"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No3 = driver.findElement(By.id("billno"));
		  invoice_No3.sendKeys("991900002816 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No4 = driver.findElement(By.id("billno"));
		  invoice_No4.sendKeys("991900002816");          
		  Thread.sleep(3000);
		  WebElement GBD2 = driver.findElement(By.id("getbill"));
		  GBD2.click();
		  Thread.sleep(3000); 
		  WebElement light_alert2 = driver. findElement(By.id("description"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No5 = driver.findElement(By.id("billno"));
		  invoice_No5.sendKeys("991900002916 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No6 = driver.findElement(By.id("billno"));
		  invoice_No6.sendKeys("991900002916");          
		  Thread.sleep(3000);
		  WebElement GBD3 = driver.findElement(By.id("getbill"));
		  GBD3.click();
		  Thread.sleep(3000);
		  WebElement light_alert3 = driver. findElement(By.id("description"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
		  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No7 = driver.findElement(By.id("billno"));
		  invoice_No7.sendKeys("991900002516 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No8 = driver.findElement(By.id("billno"));
		  invoice_No8.sendKeys("991900002516");          
		  Thread.sleep(3000);
		  WebElement GBD4 = driver.findElement(By.id("getbill"));
		  GBD4.click();
		  Thread.sleep(3000); 
		  WebElement light_alert4 = driver. findElement(By.id("description"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
		  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No9 = driver.findElement(By.id("billno"));
		  invoice_No9.sendKeys("991900002716 Non-Tiss = postpaid , Exact ");          // Non-Tiss = postpaid , Exact 
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  WebElement invoice_No10 = driver.findElement(By.id("billno"));
		  invoice_No10.sendKeys("991900002716");          
		  Thread.sleep(3000);
		  WebElement GBD5 = driver.findElement(By.id("getbill"));
		  GBD5.click();
		  Thread.sleep(3000); 
		  WebElement light_alert5 = driver. findElement(By.id("description"));          // ligh "Payment amount"
		  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
		  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  //Result-- It will shown a message as ""Bill No" is already in queue there!!!"
	
	}
	

	   //TS_GePG_18 ------- Not able to turn off the network




		@Test(priority = 56) 
		public void TS_GePG_19_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Cash_Payment_mode_Full_After_submitting_the_invoice_check_the_payment_amount()
		throws InterruptedException { 
		//TS_GePG_19.In Gepg payment : Non Tiss postpaid invoice Payment type - Cash Payment mode - Full. After entering the invoice check the payment amount. Payment amount should be editable in that field If we enter less than the invoice amount.
			WebElement invoice_No1 = driver.findElement(By.id("billno"));
			invoice_No1.sendKeys("991900002519 Non-Tiss = postpaid , full");          // Non-Tiss = postpaid , cash full 
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement invoice_No2 = driver.findElement(By.id("billno"));
			invoice_No2.sendKeys("991900002519");          
			Thread.sleep(3000);		 
			WebElement GBD1 = driver.findElement(By.id("getbill"));
			GBD1.click();
			Thread.sleep(3000);
			WebElement pay_mode4 = driver.findElement(By.id("pmode"));
			Select select4 = new Select(pay_mode4);
			select4.selectByVisibleText("Non-TISS(Cash)");
			Thread.sleep(3000);
			WebElement pay_amount = driver.findElement(By.id("pamount"));
			pay_amount.clear();
			Thread.sleep(3000);
			pay_amount.sendKeys("1000",Keys.TAB);         
			Thread.sleep(3000);
			WebElement submit_btn = driver.findElement(By.id("submit"));
			submit_btn.click();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(3000);		
		//Result-- After submitting the invoice in Gepg paymentin maker role it is shown on the approval page in checker role, waiting for authorization

		}
	
		@Test(priority = 57) 
		public void TS_GePG_20_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_20.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002519");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
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
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900002519"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			    Thread.sleep(3000);
				WebElement light_invoice = driver. findElement(By.xpath("//*[@id=\"example\"]/tbody/tr/td[12]"));          // Highlight "Invoice No"
			    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_invoice);
				Thread.sleep(6000);
			   //close the TabS
			    WebElement Logoutimg = driver.findElement(By.id("user_img"));
				Logoutimg.click();
				Thread.sleep(5000);
				WebElement Logoutbutton = driver.findElement(By.id("user_logout"));
				Logoutbutton.click();
				Thread.sleep(4000);
				driver.close();
				Thread.sleep(4000);
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
	
		@Test(priority = 59) 
		public void TS_GePG_22_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_20.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
			    driver.navigate().refresh();
			    Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002516");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
	
	
		@Test(priority = 60) 
		public void TS_GePG_23_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_partial_After_entering_the_invoice_check_the_payment_amoun()
		  throws InterruptedException { 
			//TS_GePG_23.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - partial. After entering the invoice check the payment amount.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva001");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement P2P_parent = driver.findElement(By.id("p2p_"));
				P2P_parent.click(); 
				Thread.sleep(3000); 
				WebElement GEPG_child = driver.findElement(By.xpath("//*[@id=\"p2p\"]/ul/li[1]/a")); 
				GEPG_child.click();
				Thread.sleep(3000);
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002623 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002623");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  /*WebElement Debit_amount = driver.findElement(By.id("deacc"));
			  Debit_amount.sendKeys("4700000015");
			  Thread.sleep(3000);*/
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field, Payment amount should Greater than zero or Lesser than invoice amount
		
		}
	
	
		@Test(priority = 61) 
		public void TS_GePG_24_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Exact_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_24.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Exact. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002724 Non-Tiss = postpaid , Exact");          // Non-Tiss = postpaid , Exact  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002724");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("pamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should not be editable field it is a fixed amount which is equal to invoice amount.
		
		}
	
	
		@Test(priority = 62) 
		public void TS_GePG_25_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_25.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002825 Non-Tiss = postpaid , Infinite ");          // Non-Tiss = postpaid , Infinite  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002825");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should Greater than zero
		
		}
	
	
		@Test(priority = 63) 
		public void TS_GePG_26_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_26.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Full. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002526 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002526");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("1000");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should equal to invoice amount or greater than invoice amount.
		
		}
	
	
		@Test(priority = 64) 
		public void TS_GePG_27_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Transfe_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount_Payment_amount_should_be_editable_in_that_field_If_we_enter_less_than_the_invoice_amount()
		  throws InterruptedException { 
			//TS_GePG_27.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Full. After entering the invoice check the payment amount. Payment amount should be editable in that field If we enter less than the invoice amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002527 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002527");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- The payment process should not happen and leave a message "check the payment amount".
		
		}
	
		@Test(priority = 65) 
		public void TS_GePG_28_In_Gepg_payment_Non_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Limited_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_28.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Limited. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002928 Non-Tiss = postpaid , Limited ");          // Non-Tiss = postpaid , Limited  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002928");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero.
		
		}
	
	
		@Test(priority = 66) 
		public void TS_GePG_29_In_Gepg_payment_Non_Tiss_postpaid_invoice_Check_whether_the_Outstanding_amount_resenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_29.In Gepg payment : Non Tiss postpaid invoice  Check whether the Outstanding amount presenting the right balance amount or Not.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002629 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002629");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("129",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002829 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002829");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("229",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions1 = new Actions(driver);
			  WebElement elementLocator1 = driver.findElement(By.id("outamount"));
			  actions1.doubleClick(elementLocator1).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002929 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002929");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("329",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions3 = new Actions(driver);
			  WebElement elementLocator3 = driver.findElement(By.id("outamount"));
			  actions3.doubleClick(elementLocator3).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002529 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002529");          
			  Thread.sleep(3000);	
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);   
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("1229",Keys.TAB);         
			  Thread.sleep(3000); 
			  Actions actions4 = new Actions(driver);
			  WebElement elementLocator4 = driver.findElement(By.id("outamount"));
			  actions4.doubleClick(elementLocator4).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);	 
		  //Result-- It should be presenting value of subracting the payment amount from invoice amount  (invoice amount - payment amount = Outstanding amount)
		
		}
	
	
		@Test(priority = 67) 
		public void TS_GePG_30_In_Gepg_payment_Non_Tiss_postpaid_invoice_Entering_the_minus_value_inpayment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_30.In Gepg payment : Non Tiss postpaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002630 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002630");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("-499",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002830 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002830");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("-599",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002930 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002930");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("-899",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002530 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002530");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("-1200",Keys.TAB);         
			  Thread.sleep(3000); 
			  WebElement light_alert4 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);	 
		  //Result-- It should leave a message "Payment amount amount will be greater than zero.
		
		}
	
	
		@Test(priority = 68) 
		public void TS_GePG_31_In_Gepg_payment_Non_Tiss_postpaid_invoice_Transfe_After_entering__the_correct_payment_amount_and__click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_31.In Gepg payment : Non Tiss postpaid invoice Transfer  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002631 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002631");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);
			  WebElement pay_mode1 = driver.findElement(By.id("pmode"));
			  Select select1 = new Select(pay_mode1);
			  select1.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("500",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement Debit_amount1 = driver.findElement(By.id("deacc"));
			  Debit_amount1.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn1 = driver.findElement(By.id("submit"));
			  submit_btn1.click();
			  Thread.sleep(5000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002831 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002831");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000);
			  WebElement pay_mode2 = driver.findElement(By.id("pmode"));
			  Select select2 = new Select(pay_mode2);
			  select2.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("600",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement Debit_amount2 = driver.findElement(By.id("deacc"));
			  Debit_amount2.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn2 = driver.findElement(By.id("submit"));
			  submit_btn2.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002931 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002931");          
			  Thread.sleep(3000);	
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);  
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("800",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement Debit_amount3 = driver.findElement(By.id("deacc"));
			  Debit_amount3.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement pay_mode3 = driver.findElement(By.id("pmode"));
			  Select select3 = new Select(pay_mode3);
			  select3.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement submit_btn3 = driver.findElement(By.id("submit"));
			  submit_btn3.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002531 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002531");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);
			  WebElement pay_mode4 = driver.findElement(By.id("pmode"));
			  Select select4 = new Select(pay_mode4);
			  select4.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("1200",Keys.TAB);         
			  Thread.sleep(3000); 
			  WebElement Debit_amount4 = driver.findElement(By.id("deacc"));
			  Debit_amount4.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn4 = driver.findElement(By.id("submit"));
			  submit_btn4.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No9 = driver.findElement(By.id("billno"));
			  invoice_No9.sendKeys("991900002731 Non-Tiss = postpaid , Exact ");          // Non-Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No10 = driver.findElement(By.id("billno"));
			  invoice_No10.sendKeys("991900002731");          
			  Thread.sleep(3000);
			  WebElement GBD5 = driver.findElement(By.id("getbill"));
			  GBD5.click();
			  Thread.sleep(3000);
			  WebElement pay_mode5 = driver.findElement(By.id("pmode"));
			  Select select5 = new Select(pay_mode5);
			  select5.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement Debit_amount5 = driver.findElement(By.id("deacc"));
			  Debit_amount5.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn5 = driver.findElement(By.id("submit"));
			  submit_btn5.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as "Record Successfully updated"
		
		}
	
	
		@Test(priority = 69) 
		public void TS_GePG_32_In_Gepg_payment_Non_Tiss_TRANSFER_postpaid_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_32.In Gepg payment : Non Tiss postpaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002631 Non-Tiss = postpaid , partial");          // Non-Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002631");          
			  Thread.sleep(3000);		 	
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002831 Non-Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002831");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement light_alert2 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002931 Non-Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002931");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002531 Non-Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002531");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000); 
			  WebElement light_alert4 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No9 = driver.findElement(By.id("billno"));
			  invoice_No9.sendKeys("991900002731 Non-Tiss = postpaid , Exact ");          // Non-Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No10 = driver.findElement(By.id("billno"));
			  invoice_No10.sendKeys("991900002731");          
			  Thread.sleep(3000);
			  WebElement GBD5 = driver.findElement(By.id("getbill"));
			  GBD5.click();
			  Thread.sleep(3000); 
			  WebElement light_alert5 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
			  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!! "
		
		}
	
	
		//TS_GePG_33 ------- Not able to turn off the network
		
		
	
		@Test(priority = 70) 
		public void TS_GePG_34_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_34.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002631");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
	
		@Test(priority = 71) 
		public void TS_GePG_35_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_35.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900002831"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
		
		
		@Test(priority = 72) 
		public void TS_GePG_36_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_36.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				driver.navigate().refresh();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002831");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
	
		
		@Test(priority = 73) 
		public void TS_GePG_37_In_Gepg_payment_Non_tiss_prepaid_invoice_Check_After_entering_the_invoice_and_click_the_Get_bill_details()
		  throws InterruptedException { 
			//TS_GePG_37.In Gepg payment : Non tiss prepaid invoice Check After entering the invoice and click the Get bill details
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva001");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement P2P_parent = driver.findElement(By.id("p2p_"));
				P2P_parent.click(); 
				Thread.sleep(3000); 
				WebElement GEPG_child = driver.findElement(By.xpath("//*[@id=\"p2p\"]/ul/li[1]/a")); 
				GEPG_child.click();
				Thread.sleep(3000);
				WebElement invoice_No = driver.findElement(By.id("billno"));
				  invoice_No.sendKeys("991900001837 Non-Tiss = prepaid ");          //Non-Tiss = Prepaid   
				  Thread.sleep(2000);
				  driver.navigate().refresh();
				  Thread.sleep(2000);
				  WebElement invoice_No1 = driver.findElement(By.id("billno"));
				  invoice_No1.sendKeys("991900001837");
				  Thread.sleep(3000);
				  WebElement GBD = driver.findElement(By.id("getbill"));
				  GBD.click();
				  Thread.sleep(3000);
				  WebElement Invoice_Date = driver. findElement(By.id("accholder"));          // ligh "Invoice Date"
				  Invoice_Date.sendKeys(Keys.TAB);
				  Thread.sleep(2000);
				  WebElement Invoice_Date1 = driver. findElement(By.id("billdate"));          // ligh "Invoice Date"
				  Invoice_Date1.sendKeys(Keys.TAB,Keys.TAB);
				  Thread.sleep(2000);
				  WebElement Invoice_Amount = driver. findElement(By.id("curr"));          // ligh "Invoice Amount"
				  Invoice_Amount.sendKeys(Keys.TAB);
				  Thread.sleep(2000);
				  WebElement Customer_Name = driver. findElement(By.id("billamount"));          // ligh "Invoice Amount"
				  Customer_Name.sendKeys(Keys.TAB);
				  Thread.sleep(2000);
				  WebElement Payment_Status = driver. findElement(By.id("billcust"));          // ligh "Invoice Amount"
				  Payment_Status.sendKeys(Keys.TAB);
				  Thread.sleep(3000);
				  driver.navigate().refresh();
				  Thread.sleep(2000);
		  //Result-- It should auto complete the below fields only with readonly function Invoice Date Invoice Amount Customer Name Payment status  Payment Type  Other fields had facility to edit
		
		}
	
	
		@Test(priority = 74) 
		public void TS_GePG_38_In_Gepg_payment_Non_Tiss_Prepaid_Invoice_In__prepaid_Check_when_it_is_infinite_Type_means()
		  throws InterruptedException { 
			//TS_GePG_38.In Gepg payment : Non Tiss Prepaid Invoice  In Prepaid Check when it is  infinite Type means
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001838 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001838");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It should able to access or edit the Payment Amount field
		
		}
	
		@Test(priority = 75) 
		public void TS_GePG_39_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Payment_type_Cash_Payment_mode_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_39.In Gepg payment : Non Tiss Prepaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001839 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001839");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("0",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero
		
		}
	
	
		@Test(priority = 76) 
		public void TS_GePG_40_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Check_whether_the_Outstanding_amount_presenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_40.In Gepg payment : Non Tiss Prepaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001840 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001840");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("140",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should be presenting value of subracting the payment amount from invoice amount (invoice amount - payment amount = Outstanding amount).
		
		}
	
	
		@Test(priority = 77) 
		public void TS_GePG_41_In_Gepg_payment_Non_Prepaid_invoice_Entering_the_minus_value_in_payment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_41.In Gepg payment : Non Tiss Prepaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001841 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001841");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("-100",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should leave a message "Payment amount will be greater than zero".
		
		}
	
	
		@Test(priority = 78) 
		public void TS_GePG_42_In_Gepg_payment_Non_Tiss_Prepaid_invoice_After_entering_the_correct_payment_amount_and_click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_42.In Gepg payment : Non Tiss Prepaid invoice  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001842 Non-Tiss = prepaid Authorize");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001842");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btn = driver.findElement(By.id("submit"));
			  submit_btn.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No1R = driver.findElement(By.id("billno"));
			  invoice_No1R.sendKeys("991900001843 Non-Tiss = prepaid Reject");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2R = driver.findElement(By.id("billno"));
			  invoice_No2R.sendKeys("991900001843");
			  Thread.sleep(3000);			  
			  WebElement GBDR = driver.findElement(By.id("getbill"));
			  GBDR.click();
			  Thread.sleep(3000);
			  WebElement pay_modeR = driver.findElement(By.id("pmode"));
			  Select selectR = new Select(pay_modeR);
			  selectR.selectByVisibleText("Non-TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amountR = driver.findElement(By.id("pamount"));
			  pay_amountR.clear();
			  Thread.sleep(3000);
			  pay_amountR.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btnR = driver.findElement(By.id("submit"));
			  submit_btnR.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It will shown a message as "Record Successfully updated"
		
		}
	
	
		@Test(priority = 79) 
		public void TS_GePG_43_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_43.In Gepg payment : Non Tiss Prepaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001842 Non-Tiss = prepaid ,Infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001842");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("description"));          // ligh "Bill is already in queue there!!!"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!! "
		
		}
		
		
		
	
		 //TS_GePG_44 ------- Not able to turn off the network
	
	
	
	
		@Test(priority = 80) 
		public void TS_GePG_45_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_CASH_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_45.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001842");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
		@Test(priority = 81) 
		public void TS_GePG_46_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_46.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900001842"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
		
		
		
		
		@Test(priority = 82) 
		public void TS_GePG_47_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_47.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				driver.navigate().refresh();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001843");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
	
		@Test(priority = 83) 
		public void TS_GePG_48_In_Gepg_payment_NonTiss_Prepaid_invoice_Payment_type_Transfer_Payment_mode_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_48.In Gepg payment : Non Tiss Prepaid Invoice  In Prepaid Check when it is  infinite Type means
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001848 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001848");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero
		
		}
	
	
	
		@Test(priority = 84) 
		public void TS_GePG_49_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Check_whether_the_Outstanding_amount_presenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_49.In Gepg payment : Non Tiss Prepaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001849 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001849");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("149",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should be presenting value of subracting the payment amount from invoice amount (invoice amount - payment amount = Outstanding amount).
		
		}
	
	
		@Test(priority = 85) 
		public void TS_GePG_50_In_Gepg_payment_Non_Prepaid_invoice_Entering_the_minus_value_in_payment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_50.In Gepg payment : Non Tiss Prepaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001850 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001850");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("-150",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Bill is already in queue there!!!"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should leave a message "Payment amount will be greater than zero".
		
		}
	
	
	
		@Test(priority = 86) 
		public void TS_GePG_51_In_Gepg_payment_Non_Tiss_Prepaid_invoice_After_entering_the_correct_payment_amount_and_click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_51.In Gepg payment : Non Tiss Prepaid invoice  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001851 Non-Tiss = prepaid Authorize");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001851");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btn = driver.findElement(By.id("submit"));
			  submit_btn.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No1R = driver.findElement(By.id("billno"));
			  invoice_No1R.sendKeys("991900001852 Non-Tiss = prepaid Reject");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2R = driver.findElement(By.id("billno"));
			  invoice_No2R.sendKeys("991900001852");
			  Thread.sleep(3000);			  
			  WebElement GBDR = driver.findElement(By.id("getbill"));
			  GBDR.click();
			  Thread.sleep(3000);
			  WebElement pay_modeR = driver.findElement(By.id("pmode"));
			  Select selectR = new Select(pay_modeR);
			  selectR.selectByVisibleText("Non-TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amountR = driver.findElement(By.id("pamount"));
			  pay_amountR.clear();
			  Thread.sleep(3000);
			  pay_amountR.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btnR = driver.findElement(By.id("submit"));
			  submit_btnR.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It will shown a message as "Record Successfully updated"
		
		}
	
	
		@Test(priority = 87) 
		public void TS_GePG_52_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_52.In Gepg payment : Non Tiss Prepaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001851 Non-Tiss = prepaid ,Infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001851");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("description"));          // ligh "Bill is already in queue there!!!"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!! "
		
		}
		
		
		
	
		 //TS_GePG_53 ------- Not able to turn off the network
	
	
	
		@Test(priority = 88) 
		public void TS_GePG_54_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_TRANSFER_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_54.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001851");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
		@Test(priority = 89) 
		public void TS_GePG_55_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_55.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				driver.close();
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900001851"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
	
		@Test(priority = 90) 
		public void TS_GePG_56_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_56.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				driver.navigate().refresh();
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001852");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
	
	
		@Test(priority = 91) 
		public void TS_GePG_57_In_Gepg_payment_Check_the_Tiss_invoice_when_the_invoice_will_be_Tiss_means()
		  throws InterruptedException { 
			//TS_GePG_57."In Gepg payment : Check the Tiss invoice when the invoice will be Tiss means
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002157 Tiss");                        //Tiss
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002157");
			  Thread.sleep(2000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("bid"));          // ligh "Bank Name"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("accountno"));          // ligh "Account Number"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("accholder"));          // ligh "Account Holder"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should able editable the below fields Bank Name Account No Account Holder
		
		}
	
	
		@Test(priority = 92) 
		public void TS_GePG_58_In_Gepg_payment_Tiss_Postpaid_invoice_Check_After_entering_the_invoice_and_click_the_Get_bill_details()
		  throws InterruptedException { 
			//TS_GePG_58."In Gepg payment :  Tiss Postpaid invoice  Check After entering the invoice and click the Get bill details
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002158 Tiss = postpaid ");          //Tiss = postpaid .Partial
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002158");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("billdate"));          // ligh "Invoice Date"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("billamount"));          // ligh "Invoice Amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("billcust"));          // ligh "Customer Name"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  WebElement light_alert4 = driver. findElement(By.id("status"));          	// ligh "Payment status"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  WebElement light_alert5 = driver. findElement(By.id("pplan"));          // ligh "Payment Type"
			  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
			  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result--After entering the Bank name other fields in the table are auto fill. Kindly avoid the manual Input in the fields 
			 // like Bank Name, Account No., Account holder, Invoice Date, Invoice amount, Customer name  
		
		}
	
	
		@Test(priority = 93) 
		public void TS_GePG_59_In_Gepg_payment_Tiss_Postpaid_invoice_In_Postpaid_Check_when_it_is_Exact_Type_means()
		  throws InterruptedException { 
			//TS_GePG_59.In Gepg payment : Tiss Postpaid invoice  In Postpaid Check when it is  Exact Type means,
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002259 Tiss = postpaid - Exact");          // Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002259");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);      
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("pamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);  
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- It should not able to access or edit the Payment Amount field
		
		}
	
	
		@Test(priority = 94) 
		public void TS_GePG_60_In_Gepg_payment_Tiss_Postpaid_Invoice_In_Postpaid_Check_it_is_a_Partial_or_Infinity_or_limited_or_Full_Type_means()
		  throws InterruptedException { 
			//TS_GePG_07.In Gepg payment:Non Tiss Postpaid Invoice.In Postpaid, Check it is a Partial or Infinity or limited or Full Type means,
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002160 Tiss = postpaid , partial ");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002160");
			  Thread.sleep(3000);
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.sendKeys("500",Keys.TAB);         
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(5000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002360 Tiss = postpaid , Infinity");          //Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002360");
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.sendKeys("500",Keys.TAB);         
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(5000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002460 Tiss = postpaid , limited");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002460");
			  Thread.sleep(3000);	
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement pay_amount5 = driver.findElement(By.id("pamount"));
			  pay_amount5.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount6 = driver.findElement(By.id("pamount"));
			  pay_amount6.sendKeys("500",Keys.TAB);         
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(5000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002060 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002060");
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount7 = driver.findElement(By.id("pamount"));
			  pay_amount7.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount8 = driver.findElement(By.id("pamount"));
			  pay_amount8.sendKeys("1600");         
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- "It should able to access or edit the Payment Amount field"
		
		}
	
	
		@Test(priority = 94) 
		public void TS_GePG_61_In_Gepg_payment_Tiss_Postpaid_invoice_Payment_type_Cash_Payment_mode_Partial_After_entering_the_invoice_check_the_payment_amounnt()
		  throws InterruptedException { 
			//TS_GePG_61.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - Partial. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002061 Tiss = postpaid - Partial");          // Tiss = postpaid , Partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002061");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.sendKeys("500");      
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000); 
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- It should not able to access or not able to edit the Payment Amount field.(payment amount is equal to invoice amount)
		
		}
	
	
	
		@Test(priority = 95) 
		public void TS_GePG_62_In_Gepg_payment_Tiss_Postpaid_invoice_Payment_type_Cash_Payment_mode_Exact_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_62.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - Partial. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002262 Tiss = postpaid - Exact");          // Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002262");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("pamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);        
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- Payment amount should not be  editable field.
			  
		}
	
	
		@Test(priority = 96) 
		public void TS_GePG_63_In_Gepg_payment_Tiss_Postpaid_invoice_Payment_type_Cash_Payment_mod_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_63.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002363 Tiss = postpaid - Infinite");          // Tiss = postpaid , Infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002363");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.sendKeys("500");      
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000); 
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero
		
		}
	
	
		@Test(priority = 97) 
		public void TS_GePG_64_In_Gepg_payment_Tiss_Postpaid_invoice_Payment_type_Cash_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_64.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - Full. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002064 Tiss = postpaid - Full");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002064");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.sendKeys("1500",Keys.TAB);    
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000); 
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero and greater than invoice amount
		
		}
	
	
		@Test(priority = 98) 
		public void TS_GePG_65_In_Gepg_payment_Tiss_postpaid_invoice_Payment_type_Cash_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount_Payment_amount_should_be_editable_in_that_field_the_invoice_amount()
		  throws InterruptedException { 
			//TS_GePG_65.In Gepg payment : Tiss postpaid invoice Payment type - Cash Payment mode - Full. After entering the invoice check the payment amount. Payment amount should be editable in that field If we enter less than the invoice amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002065 Tiss = postpaid - Full");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002065");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.sendKeys("1499",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000); 
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- The payment process should not happen and leave a message "check the payment amount".
		
		}
	
	
		@Test(priority = 99) 
		public void TS_GePG_66_In_Gepg_payment_Tiss_Postpaid_invoice_Payment_type_Cash_Payment_mode_Limited_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_66.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - Limited. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002466 Tiss = postpaid - Limited");          // Tiss = postpaid , Limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002466");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.sendKeys("1400",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000); 
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero
		
		}
	
	
		@Test(priority = 100) 
		public void TS_GePG_67_In_Gepg_payment_Tiss_postpaid_invoice_Check_whether_the_Outstanding_amount_resenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_67.In Gepg payment : Tiss postpaid invoice  Check whether the Outstanding amount presenting the right balance amount or Not.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002067 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002067");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("129",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002367 Tiss = postpaid , Infinity ");          // Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002367");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("229",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions1 = new Actions(driver);
			  WebElement elementLocator1 = driver.findElement(By.id("outamount"));
			  actions1.doubleClick(elementLocator1).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002467 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002467");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("329",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions3 = new Actions(driver);
			  WebElement elementLocator3 = driver.findElement(By.id("outamount"));
			  actions3.doubleClick(elementLocator3).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002067 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002067");          
			  Thread.sleep(3000);	
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);   
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("1600",Keys.TAB);         
			  Thread.sleep(3000); 
			  Actions actions4 = new Actions(driver);
			  WebElement elementLocator4 = driver.findElement(By.id("outamount"));
			  actions4.doubleClick(elementLocator4).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);	 
		  //Result-- It should be presenting value of subracting the payment amount from invoice amount  (invoice amount - payment amount = Outstanding amount)
		
		}
	

		@Test(priority = 101) 
		public void TS_GePG_68_In_Gepg_payment_Tiss_postpaid_invoice_Entering_the_minus_value_inpayment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_68.In Gepg payment : Tiss postpaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002068 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002068");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("-499",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002368 Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002368");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("-599",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002468 Tiss = postpaid , limited ");          // Non-Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002468");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("-899",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002068 Tiss = postpaid , Full ");          // Non-Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002068");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("-1600",Keys.TAB);         
			  Thread.sleep(3000); 
			  WebElement light_alert4 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);	 
		  //Result-- It should leave a message "Payment amount amount will be greater than zero.
		
		}
	
	
		@Test(priority = 102) 
		public void TS_GePG_69_In_Gepg_payment_Tiss_postpaid_CASH_invoice_After_entering_the_correct_payment_amount_and_click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_69.In Gepg payment : Tiss postpaid invoice  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002069 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002069");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);
			  WebElement pay_mode1 = driver.findElement(By.id("pmode"));
			  Select select1 = new Select(pay_mode1);
			  select1.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("500",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btn1 = driver.findElement(By.id("submit"));
			  submit_btn1.click();
			  Thread.sleep(5000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002369 Tiss = postpaid , Infinity ");          // Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002369");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000);
			  WebElement pay_mode2 = driver.findElement(By.id("pmode"));
			  Select select2 = new Select(pay_mode2);
			  select2.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("600",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btn2 = driver.findElement(By.id("submit"));
			  submit_btn2.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002469 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002469");          
			  Thread.sleep(3000);	
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);  
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("800",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement pay_mode3 = driver.findElement(By.id("pmode"));
			  Select select3 = new Select(pay_mode3);
			  select3.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement submit_btn3 = driver.findElement(By.id("submit"));
			  submit_btn3.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002069 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002069");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);
			  WebElement pay_mode4 = driver.findElement(By.id("pmode"));
			  Select select4 = new Select(pay_mode4);
			  select4.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("1500",Keys.TAB);         
			  Thread.sleep(3000); 
			  WebElement submit_btn4 = driver.findElement(By.id("submit"));
			  submit_btn4.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No9 = driver.findElement(By.id("billno"));
			  invoice_No9.sendKeys("991900002269 Tiss = postpaid , Exact ");          // Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No10 = driver.findElement(By.id("billno"));
			  invoice_No10.sendKeys("991900002269");          
			  Thread.sleep(3000);
			  WebElement GBD5 = driver.findElement(By.id("getbill"));
			  GBD5.click();
			  Thread.sleep(3000);
			  WebElement pay_mode5 = driver.findElement(By.id("pmode"));
			  Select select5 = new Select(pay_mode5);
			  select5.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement submit_btn5 = driver.findElement(By.id("submit"));
			  submit_btn5.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as "Record Successfully updated"
		
		}
	
	
	
		@Test(priority = 103) 
		public void TS_GePG_70_In_Gepg_payment_Tiss_postpaid_CASH_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_17.In Gepg payment :Tiss postpaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002069 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002069");          
			  Thread.sleep(3000);		 	
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002369 Tiss = postpaid , Infinity ");          // Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002369");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement light_alert2 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002469 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002469");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002069 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002069");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000); 
			  WebElement light_alert4 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No9 = driver.findElement(By.id("billno"));
			  invoice_No9.sendKeys("991900002269 Tiss = postpaid , Exact ");          //Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No10 = driver.findElement(By.id("billno"));
			  invoice_No10.sendKeys("991900002269");          
			  Thread.sleep(3000);
			  WebElement GBD5 = driver.findElement(By.id("getbill"));
			  GBD5.click();
			  Thread.sleep(3000); 
			  WebElement light_alert5 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
			  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!!"
		
		}
	
		
		
		
		
		   //TS_GePG_71 ------- Not able to turn off the network

	
	
	
		@Test(priority = 104) 
		public void TS_GePG_72_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_72.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002069");      //partial
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
	
		@Test(priority = 105) 
		public void TS_GePG_73_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_73.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900002069"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
	
		@Test(priority = 106) 
		public void TS_GePG_74_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_74.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				driver.navigate().refresh();
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002369");      //Infinite
				Thread.sleep(3000);
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
	
		
		
		
		
		@Test(priority = 107) 
		public void TS_GePG_75_In_Gepg_payment_Tiss_Prepaid_invoice_Check_After_entering_the_invoice_and_click_the_Get_bill_details()
		  throws InterruptedException { 
			//TS_GePG_75."In Gepg payment : Non Tiss Invoice No. (within Bank) Enter the Non-Tiss Invoice number in the Invoice number field "
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002175 Tiss = postpaid ");          //Tiss = postpaid(partial) 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002175");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("billdate"));          // ligh "Invoice Date"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("billamount"));          // ligh "Invoice Amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("billcust"));          // ligh "Customer Name"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  WebElement light_alert4 = driver. findElement(By.id("status"));          	// ligh "Payment status"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  WebElement light_alert5 = driver. findElement(By.id("pplan"));          // ligh "Payment Type"
			  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
			  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result--It should auto fill  the below fields only with read only fields like Invoice Date, Invoice Amount,
		 //Customer Name, Payment status, Payment Type and Other fields had facility to edit
		
		}
	
	
		@Test(priority = 108) 
		public void TS_GePG_76_In_Gepg_payment_Tiss_Prepaid_invoice_Payment_type_Transfer_Payment_mode_Partial_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_76.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - partial. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002176 Tiss = postpaid - partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002176");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.sendKeys("500",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000); 
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- Payment amount should be editable field in that field, Payment amount should not equal to zero
		
		}
	
	
		@Test(priority = 109) 
		public void TS_GePG_77_In_Gepg_payment_Tiss_Prepaid_invoice_Payment_type_Transfer_Payment_mode_Exact_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_77.In Gepg payment : Tiss Postpaid invoice Payment type - Cash Payment mode - Exact. After entering the invoice check the payment amount.
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002277 Tiss = postpaid - Exact");          // Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002277");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000); 
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("pamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);  
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result-- Payment amount should be editable field in that field, Payment amount should not equal to zero
		
		}
	
	
	
		@Test(priority = 110) 
		public void TS_GePG_78_In_Gepg_payment_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_78.In Gepg payment : Tiss postpaid invoice Payment type - Transfer Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002378 Non-Tiss = postpaid , Infinite ");          // Tiss = postpaid , Infinite  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002378");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should Greater than zero
		
		}
	
	
		@Test(priority = 111) 
		public void TS_GePG_79_In_Gepg_payment_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_79.In Gepg payment : Tiss postpaid invoice Payment type - Transfer Payment mode - Full. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002079 Tiss = postpaid , Full ");          // Tiss = postpaid , Full  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002079");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("1500");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should equal to invoice amount or greater than invoice amount.
		
		}
	
	
		@Test(priority = 112) 
		public void TS_GePG_80_In_Gepg_payment_Tiss_postpaid_invoice_Payment_type_Transfe_Payment_mode_Full_After_entering_the_invoice_check_the_payment_amount_Payment_amount_should_be_editable_in_that_field_If_we_enter_less_than_the_invoice_amount()
		  throws InterruptedException { 
			//TS_GePG_80.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Full. After entering the invoice check the payment amount. Payment amount should be editable in that field If we enter less than the invoice amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002080 Tiss = postpaid , Full ");          // Tiss = postpaid , Full  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002080");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("1499");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- The payment process should not happen and leave a message "check the payment amount".
		
		}
	
		@Test(priority = 113) 
		public void TS_GePG_81_In_Gepg_payment_Tiss_postpaid_invoice_Payment_type_Transfer_Payment_mode_Limited_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_81.In Gepg payment : Non Tiss postpaid invoice Payment type - Transfer Payment mode - Limited. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002481 Tiss = postpaid , Limited ");          //Tiss = postpaid , Limited  Transfer
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002481");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("1499");         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero.
		
		}
	
	
		@Test(priority = 114) 
		public void TS_GePG_82_In_Gepg_payment_Tiss_postpaid_invoice_Check_whether_the_Outstanding_amount_resenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_82.In Gepg payment : Tiss postpaid invoice  Check whether the Outstanding amount presenting the right balance amount or Not.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002182 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002182");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("182",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002382 Tiss = postpaid , Infinity ");          // Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002382");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("282",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions1 = new Actions(driver);
			  WebElement elementLocator1 = driver.findElement(By.id("outamount"));
			  actions1.doubleClick(elementLocator1).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002482 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002482");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("382",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions3 = new Actions(driver);
			  WebElement elementLocator3 = driver.findElement(By.id("outamount"));
			  actions3.doubleClick(elementLocator3).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002082 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002082");          
			  Thread.sleep(3000);	
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);   
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("1582",Keys.TAB);         
			  Thread.sleep(3000); 
			  Actions actions4 = new Actions(driver);
			  WebElement elementLocator4 = driver.findElement(By.id("outamount"));
			  actions4.doubleClick(elementLocator4).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);	 
		  //Result-- It should be presenting value of subracting the payment amount from invoice amount  (invoice amount - payment amount = Outstanding amount)
		
		}
	
	
	
		@Test(priority = 115) 
		public void TS_GePG_83_In_Gepg_payment_Tiss_postpaid_invoice_Transfer_After_entering__the_correct_payment_amount_and__click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_83.In Gepg payment : Tiss postpaid invoice Transfer  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002183 Tiss = postpaid , partial");          //Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002183");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  WebElement Bank_name1 = driver.findElement(By.id("bid"));
			  Select Selectbank1 = new Select(Bank_name1);
			  Selectbank1.selectByVisibleText("TANZTZTX");
			  Thread.sleep(3000);
			  WebElement pay_mode1 = driver.findElement(By.id("pmode"));
			  Select select1 = new Select(pay_mode1);
			  select1.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("500",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement Debit_amount1 = driver.findElement(By.id("deacc"));
			  Debit_amount1.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn1 = driver.findElement(By.id("submit"));
			  submit_btn1.click();
			  Thread.sleep(5000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002383 Tiss = postpaid , Infinity ");          // Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002383");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  WebElement Bank_name2 = driver.findElement(By.id("bid"));
			  Select Selectbank2 = new Select(Bank_name2);
			  Selectbank2.selectByVisibleText("TANZTZTX");
			  Thread.sleep(3000);
			  WebElement pay_mode2 = driver.findElement(By.id("pmode"));
			  Select select2 = new Select(pay_mode2);
			  select2.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("600",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement Debit_amount2 = driver.findElement(By.id("deacc"));
			  Debit_amount2.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn2 = driver.findElement(By.id("submit"));
			  submit_btn2.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002483 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002483");          
			  Thread.sleep(3000);	
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement Bank_name3 = driver.findElement(By.id("bid"));
			  Select Selectbank3 = new Select(Bank_name3);
			  Selectbank3.selectByVisibleText("TANZTZTX");
			  Thread.sleep(3000);
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("800",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement Debit_amount3 = driver.findElement(By.id("deacc"));
			  Debit_amount3.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement pay_mode3 = driver.findElement(By.id("pmode"));
			  Select select3 = new Select(pay_mode3);
			  select3.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement submit_btn3 = driver.findElement(By.id("submit"));
			  submit_btn3.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002083 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002083");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  WebElement Bank_name4 = driver.findElement(By.id("bid"));
			  Select Selectbank4 = new Select(Bank_name4);
			  Selectbank4.selectByVisibleText("TANZTZTX");
			  Thread.sleep(3000);
			  Thread.sleep(3000);
			  WebElement pay_mode4 = driver.findElement(By.id("pmode"));
			  Select select4 = new Select(pay_mode4);
			  select4.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("1500",Keys.TAB);         
			  Thread.sleep(3000); 
			  WebElement Debit_amount4 = driver.findElement(By.id("deacc"));
			  Debit_amount4.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn4 = driver.findElement(By.id("submit"));
			  submit_btn4.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No9 = driver.findElement(By.id("billno"));
			  invoice_No9.sendKeys("991900002283 Tiss = postpaid , Exact ");          // Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No10 = driver.findElement(By.id("billno"));
			  invoice_No10.sendKeys("991900002283");          
			  Thread.sleep(3000);
			  WebElement GBD5 = driver.findElement(By.id("getbill"));
			  GBD5.click();
			  Thread.sleep(3000);
			  WebElement Bank_name5 = driver.findElement(By.id("bid"));
			  Select Selectbank5 = new Select(Bank_name5);
			  Selectbank5.selectByVisibleText("TANZTZTX");
			  Thread.sleep(3000);
			  WebElement pay_mode5 = driver.findElement(By.id("pmode"));
			  Select select5 = new Select(pay_mode5);
			  select5.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement Debit_amount5 = driver.findElement(By.id("deacc"));
			  Debit_amount5.sendKeys("4700000015",Keys.TAB);
			  Thread.sleep(3000);
			  WebElement submit_btn5 = driver.findElement(By.id("submit"));
			  submit_btn5.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as "Record Successfully updated"
		
		}
	
	
		@Test(priority = 116) 
		public void TS_GePG_84_In_Gepg_payment_Tiss_TRANSFER_postpaid_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_84.In Gepg payment : Tiss postpaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002183 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002183");          
			  Thread.sleep(3000);		 	
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002383 Tiss = postpaid , Infinity ");          // Non-Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002383");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement light_alert2 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002483 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002483");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002083 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002083");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000); 
			  WebElement light_alert4 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No9 = driver.findElement(By.id("billno"));
			  invoice_No9.sendKeys("991900002283 Tiss = postpaid , Exact ");          // Tiss = postpaid , Exact 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No10 = driver.findElement(By.id("billno"));
			  invoice_No10.sendKeys("991900002283");          
			  Thread.sleep(3000);
			  WebElement GBD5 = driver.findElement(By.id("getbill"));
			  GBD5.click();
			  Thread.sleep(3000); 
			  WebElement light_alert5 = driver. findElement(By.id("description"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
			  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!! "
		
		}
	
		
	
		//TS_GePG_85 ------- Not able to turn off the network
		
		
		@Test(priority = 117) 
		public void TS_GePG_86_In_Gepg_payment_Tiss_TRANSFER_postpaid_invoice_Entering_the_minus_value_inpayment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_86.In Gepg payment : Tiss postpaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002185 Tiss = postpaid , partial");          // Tiss = postpaid , partial 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900002185");          
			  Thread.sleep(3000);		 
			  WebElement GBD1 = driver.findElement(By.id("getbill"));
			  GBD1.click();
			  Thread.sleep(3000);      
			  WebElement pay_amount1 = driver.findElement(By.id("pamount"));
			  pay_amount1.clear();
			  Thread.sleep(3000);
			  pay_amount1.sendKeys("-499",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No3 = driver.findElement(By.id("billno"));
			  invoice_No3.sendKeys("991900002385 Tiss = postpaid , Infinity ");          // Tiss = postpaid , Infinity 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No4 = driver.findElement(By.id("billno"));
			  invoice_No4.sendKeys("991900002385");          
			  Thread.sleep(3000);
			  WebElement GBD2 = driver.findElement(By.id("getbill"));
			  GBD2.click();
			  Thread.sleep(3000); 
			  WebElement pay_amount2 = driver.findElement(By.id("pamount"));
			  pay_amount2.clear();
			  Thread.sleep(3000);
			  pay_amount2.sendKeys("-599",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No5 = driver.findElement(By.id("billno"));
			  invoice_No5.sendKeys("991900002485 Tiss = postpaid , limited ");          // Tiss = postpaid , limited 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No6 = driver.findElement(By.id("billno"));
			  invoice_No6.sendKeys("991900002485");          
			  Thread.sleep(3000);
			  WebElement GBD3 = driver.findElement(By.id("getbill"));
			  GBD3.click();
			  Thread.sleep(3000);
			  WebElement pay_amount3 = driver.findElement(By.id("pamount"));
			  pay_amount3.clear();
			  Thread.sleep(3000);
			  pay_amount3.sendKeys("-899",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No7 = driver.findElement(By.id("billno"));
			  invoice_No7.sendKeys("991900002085 Tiss = postpaid , Full ");          // Tiss = postpaid , Full 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No8 = driver.findElement(By.id("billno"));
			  invoice_No8.sendKeys("991900002085");          
			  Thread.sleep(3000);
			  WebElement GBD4 = driver.findElement(By.id("getbill"));
			  GBD4.click();
			  Thread.sleep(3000);
			  WebElement pay_amount4 = driver.findElement(By.id("pamount"));
			  pay_amount4.clear();
			  Thread.sleep(3000);
			  pay_amount4.sendKeys("-1600",Keys.TAB);         
			  Thread.sleep(3000); 
			  WebElement light_alert4 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);	 
		  //Result-- It should leave a message "Payment amount amount will be greater than zero.
		
		}
		
	
		@Test(priority = 118) 
		public void TS_GePG_87_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_87.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002183");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
	
		@Test(priority = 119) 
		public void TS_GePG_88_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_88.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900002183"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
		
		
		@Test(priority = 120) 
		public void TS_GePG_89_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_89.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900002383");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
	
	
		@Test(priority = 121) 
		public void TS_GePG_90_In_Gepg_payment_Non_tiss_Within_Bank_Postpaid_invoice_No_Check_after_entering_the_invoice_No_and_click_the_Get_bill_details()
		  throws InterruptedException { 
			//TS_GePG_90."In Gepg payment : Non Tiss Invoice No. (within Bank) Enter the Non-Tiss Invoice number in the Invoice number field "
			  WebElement invoice_No = driver.findElement(By.id("billno"));
			  invoice_No.sendKeys("991900002805 Tiss = prepaid ");          //Tiss = prepaid 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900002805");
			  Thread.sleep(3000);
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("billdate"));          // ligh "Invoice Date"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  WebElement light_alert2 = driver. findElement(By.id("billamount"));          // ligh "Invoice Amount"
			  JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
			  jsExecutor2. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert2);
			  Thread.sleep(3000);
			  WebElement light_alert3 = driver. findElement(By.id("billcust"));          // ligh "Customer Name"
			  JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
			  jsExecutor3. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert3);
			  Thread.sleep(3000);
			  WebElement light_alert4 = driver. findElement(By.id("status"));          	// ligh "Payment status"
			  JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
			  jsExecutor4. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert4);
			  Thread.sleep(3000);
			  WebElement light_alert5 = driver. findElement(By.id("pplan"));          // ligh "Payment Type"
			  JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
			  jsExecutor5. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert5);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
		  //Result--It should auto fill  the below fields only with read only fields like Invoice Date, Invoice Amount,
		 //Customer Name, Payment status, Payment Type and Other fields had facility to edit
		
		}
	
	
		@Test(priority = 122) 
		public void TS_GePG_91_In_Gepg_payment_Tiss_Prepaid_Invoice_In__prepaid_Check_when_it_is_infinite_Type_means()
		  throws InterruptedException { 
			//TS_GePG_91.In Gepg payment : Tiss Prepaid Invoice  In Prepaid Check when it is  infinite Type means
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001391 Tiss = prepaid , infinite");          //Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001391");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It should able to access or edit the Payment Amount field
		
		}
	
		@Test(priority = 123) 
		public void TS_GePG_92_In_Gepg_payment_Tiss_Prepaid_invoice_Payment_type_Cash_Payment_mode_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_92.In Gepg payment : Non Tiss Prepaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001392 Tiss = prepaid , infinite");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001392");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("0",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero
		
		}
	
	
		@Test(priority = 124) 
		public void TS_GePG_93_In_Gepg_payment_Tiss_Prepaid_invoice_Check_whether_the_Outstanding_amount_presenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_93.In Gepg payment : Tiss Prepaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001393 Tiss = prepaid , infinite");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001393");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("193",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should be presenting value of subracting the payment amount from invoice amount (invoice amount - payment amount = Outstanding amount).
		
		}
	
	
		@Test(priority = 125) 
		public void TS_GePG_94_In_Gepg_payment_Prepaid_invoice_Entering_the_minus_value_in_payment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_41.In Gepg payment : Non Tiss Prepaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001394 Tiss = prepaid , infinite");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001394");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("-100",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert1 = driver. findElement(By.id("pamount"));          // ligh "Payment amount"
			  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
			  jsExecutor1. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert1);
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should leave a message "Payment amount will be greater than zero".
		
		}
	
	
		@Test(priority = 126) 
		public void TS_GePG_95_In_Gepg_payment_Tiss_Prepaid_invoice_After_entering_the_correct_payment_amount_and_click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_95.In Gepg payment : Tiss Prepaid invoice  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001395 Tiss = prepaid Authorize");          //Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001395");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btn = driver.findElement(By.id("submit"));
			  submit_btn.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No1R = driver.findElement(By.id("billno"));
			  invoice_No1R.sendKeys("991900001396 Tiss = prepaid Reject");          //Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2R = driver.findElement(By.id("billno"));
			  invoice_No2R.sendKeys("991900001396");
			  Thread.sleep(3000);			  
			  WebElement GBDR = driver.findElement(By.id("getbill"));
			  GBDR.click();
			  Thread.sleep(3000);
			  WebElement pay_modeR = driver.findElement(By.id("pmode"));
			  Select selectR = new Select(pay_modeR);
			  selectR.selectByVisibleText("TISS(Cash)");
			  Thread.sleep(3000);
			  WebElement pay_amountR = driver.findElement(By.id("pamount"));
			  pay_amountR.clear();
			  Thread.sleep(3000);
			  pay_amountR.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btnR = driver.findElement(By.id("submit"));
			  submit_btnR.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It will shown a message as "Record Successfully updated"
		
		}
	
	
	
		@Test(priority = 127) 
		public void TS_GePG_96_In_Gepg_payment_Tiss_Prepaid_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_96.In Gepg payment : Non Tiss Prepaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001395 Tiss = prepaid ,Infinite");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001395");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("description"));          // ligh "Bill is already in queue there!!!"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!! "
		
		}
		
		
		
	
		 //TS_GePG_97 ------- Not able to turn off the network
	
	
	
	
		@Test(priority = 128) 
		public void TS_GePG_98_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_CASH_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_98.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001395");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
		@Test(priority = 129) 
		public void TS_GePG_99_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_99.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900001395"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
	
		@Test(priority = 130) 
		public void TS_GePG_100_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_47.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001396");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
		
		@Test(priority = 131) 
		public void TS_GePG_101_In_Gepg_payment_Tiss_Prepaid_invoice_Payment_type_Transfer_Payment_mode_Infinite_After_entering_the_invoice_check_the_payment_amount()
		  throws InterruptedException { 
			//TS_GePG_101.In Gepg payment : Non Tiss Prepaid Invoice  In Prepaid Check when it is  infinite Type means
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001301 Tiss = prepaid , infinite");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001301");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("999",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Payment Amount"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- Payment amount should be editable in that field Payment amount should not equal to zero
		
		}
	
	
	
		@Test(priority = 132) 
		public void TS_GePG_102_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Check_whether_the_Outstanding_amount_presenting_the_right_balance_amount_or_Not()
		  throws InterruptedException { 
			//TS_GePG_102.In Gepg payment : Non Tiss Prepaid invoice Payment type - Cash Payment mode - Infinite. After entering the invoice check the payment amount.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001302 Non-Tiss = prepaid , infinite");          // Non-Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001302");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("149",Keys.TAB);         
			  Thread.sleep(3000);
			  Actions actions = new Actions(driver);
			  WebElement elementLocator = driver.findElement(By.id("outamount"));
			  actions.doubleClick(elementLocator).perform();
			  Thread.sleep(3000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should be presenting value of subracting the payment amount from invoice amount (invoice amount - payment amount = Outstanding amount).
		
		}
	
	
		@Test(priority = 133) 
		public void TS_GePG_103_In_Gepg_payment_Non_Prepaid_invoice_Entering_the_minus_value_in_payment_amount_field_and_after_click_the_sumbit()
		  throws InterruptedException { 
			//TS_GePG_103.In Gepg payment : Non Tiss Prepaid invoice. Entering the minus value in payment amount field and after click the sumbit.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001303 Tiss = prepaid , infinite");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001303");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("-150",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("pamount"));          // ligh "Bill is already in queue there!!!"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It should leave a message "Payment amount will be greater than zero".
		
		}
	
	
	
		@Test(priority = 134) 
		public void TS_GePG_104_In_Gepg_payment_Tiss_Prepaid_invoice_After_entering_the_correct_payment_amount_and_click_the_submit_button()
		  throws InterruptedException { 
			//TS_GePG_104.In Gepg payment : Non Tiss Prepaid invoice  After entering the correct payment amount and click the submit button.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001304 Tiss = prepaid Authorize");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001304");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement pay_mode = driver.findElement(By.id("pmode"));
			  Select select = new Select(pay_mode);
			  select.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amount = driver.findElement(By.id("pamount"));
			  pay_amount.clear();
			  Thread.sleep(3000);
			  pay_amount.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btn = driver.findElement(By.id("submit"));
			  submit_btn.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
			  WebElement invoice_No1R = driver.findElement(By.id("billno"));
			  invoice_No1R.sendKeys("991900001305 Tiss = prepaid Reject");          // Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2R = driver.findElement(By.id("billno"));
			  invoice_No2R.sendKeys("991900001305");
			  Thread.sleep(3000);			  
			  WebElement GBDR = driver.findElement(By.id("getbill"));
			  GBDR.click();
			  Thread.sleep(3000);
			  WebElement pay_modeR = driver.findElement(By.id("pmode"));
			  Select selectR = new Select(pay_modeR);
			  selectR.selectByVisibleText("TISS(Transfer)");
			  Thread.sleep(3000);
			  WebElement pay_amountR = driver.findElement(By.id("pamount"));
			  pay_amountR.clear();
			  Thread.sleep(3000);
			  pay_amountR.sendKeys("900",Keys.TAB);         
			  Thread.sleep(3000);
			  WebElement submit_btnR = driver.findElement(By.id("submit"));
			  submit_btnR.click();
			  Thread.sleep(4000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result--It will shown a message as "Record Successfully updated"
		
		}
	
	
		@Test(priority = 134) 
		public void TS_GePG_105_In_Gepg_payment_Non_Tiss_Prepaid_invoice_Re_submititing_the_same_invoice()
		  throws InterruptedException { 
			//TS_GePG_105.In Gepg payment : Non Tiss Prepaid invoice  Re-submititing the same invoice.
			  WebElement invoice_No1 = driver.findElement(By.id("billno"));
			  invoice_No1.sendKeys("991900001304 Tiss = prepaid ,Infinite");          //Tiss = postpaid , infinite 
			  Thread.sleep(2000);
			  driver.navigate().refresh();
			  Thread.sleep(2000);
			  WebElement invoice_No2 = driver.findElement(By.id("billno"));
			  invoice_No2.sendKeys("991900001304");
			  Thread.sleep(3000);			  
			  WebElement GBD = driver.findElement(By.id("getbill"));
			  GBD.click();
			  Thread.sleep(3000);
			  WebElement light_alert = driver. findElement(By.id("description"));          // ligh "Bill is already in queue there!!!"
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",light_alert);
			  Thread.sleep(6000);
			  driver.navigate().refresh();
			  Thread.sleep(3000);
		  //Result-- It will shown a message as ""Bill No" is already in queue there!!! "
		
		}
		
		
		
	
		 //TS_GePG_106 ------- Not able to turn off the network
	
	
	
		@Test(priority = 135) 
		public void TS_GePG_107_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Authorize_the_TRANSFER_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_107.In CHECKER OR ADMIN ROLE : In Approval page after Authourize the Gepg Invoice.
				WebElement Logoutimg = driver.findElement(By.id("userimg"));
				Logoutimg.click();
				Thread.sleep(3000);
				WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
				Logoutbutton.click();
				Thread.sleep(3000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("siva003");
				Thread.sleep(3000);
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001304");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Authorize = driver.findElement(By.id("auth"));
				Authorize.click();
				Thread.sleep(3000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(3000);
				Alert alertbox = driver.switchTo().alert(); 
				alertbox.accept();
				Thread.sleep(3000);
			//Result-- "It will successfully send the request to Hdpay"		
				
		}
	
		@Test(priority = 136) 
		public void TS_GePG_108_In_Approval_Page_Check_After_the_authorization_of_gepy_payment_check_whether_the_request_send_to_Hdpay_or_not()
		  throws InterruptedException { 
			//TS_GePG_108.In Approval Page: Check After the authorization of gepy payment check whether the request send to Hdpay or not
				((JavascriptExecutor) driver).executeScript("window.open('"+HDPAY_url+"','_blank');");
				Thread.sleep(5000);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				Thread.sleep(2000);
				WebElement UsernameField = driver.findElement(By.id("txtUserId"));
				UsernameField.sendKeys("ADMIN");
				WebElement PasswordField = driver.findElement(By.id("txtPwd"));
				PasswordField.sendKeys("Login@123");
				Thread.sleep(3000);
				PasswordField.sendKeys(Keys.ENTER);
				Thread.sleep(9000);
				WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Reports_Parentmenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
				Reports_Parentmenu.click(); 
				Thread.sleep(3000); 
				WebElement Trans_Report = driver.findElement(By.xpath("//*[@id=\"report\"]/ul/li[1]/a"));
				Trans_Report.click(); 
				Thread.sleep(5000);
				WebElement Search_field = driver.findElement(By.id("tst_search"));
				Search_field.sendKeys("991900001304"); 
				Thread.sleep(3000);
				WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[2]/div/div/div[2]"));
			    // Scroll to div's most right:
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
			//close the TabS
				driver.close();
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(3000);
			//Result-- The Request should be received in HDPAY
			
		}
	
		@Test(priority = 137) 
		public void TS_GePG_109_In_CHECKER_OR_ADMIN_ROLE_In_Approval_page_after_Reject_the_Gepg_Invoice()
		  throws InterruptedException { 
			//TS_GePG_109.In CHECKER OR ADMIN ROLE : In Approval page after Reject the Gepg Invoice.
				WebElement threedots = driver.findElement(By.id("nav_SB_Toggle"));
				threedots.click(); 
				Thread.sleep(3000); 
				WebElement Approval_parent = driver.findElement(By.id("approval_"));
				Approval_parent.click(); 
				Thread.sleep(3000); 
				WebElement Approval_child = driver.findElement(By.xpath("//*[@id=\"approval\"]/ul/li/a"));
				Approval_child.click();
				Thread.sleep(3000);
				WebElement Gepgpay = driver.findElement(By.id("txtPgmId")); 		
				Select selectDD = new Select (Gepgpay);
				selectDD.selectByVisibleText("GePG Payment");
				Thread.sleep(2000); 
				WebElement Search_field = driver.findElement(By.id("searchkey"));
				Search_field.sendKeys("991900001305");
				Thread.sleep(3000); 
				WebElement view_btn = driver.findElement(By.id("viewdata"));
				view_btn.click();
				Thread.sleep(3000); 
				WebElement view_close = driver.findElement(By.xpath("//*[@id=\"Modal3\"]/div/div/div[1]/h5/button"));
				view_close.click();
				Thread.sleep(3000);
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]"));
				checkbox.click();
				Thread.sleep(3000);
				WebElement Reject = driver.findElement(By.id("reject"));
				Reject.click();
				Thread.sleep(3000);
				WebElement textarea = driver.findElement(By.id("txtReason"));
				textarea.sendKeys("For Testing");   
				Thread.sleep(4000);
				WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"Modal\"]/div/div/div[3]/button"));
				submitbtn.click();
				Thread.sleep(5000);
				WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
				Yesbtn.click();
				Thread.sleep(5000);
			//Result-- "It will Not send the request to Hdpay"		
				
		}
		
		
		
		
		
		
		
		
		
		
		
		

		
		
	
	
	
	@AfterSuite
	public void closebrowser() {        
	 	driver.close();
	}	
	
	
	
	

}	
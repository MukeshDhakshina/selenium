package h2h_New;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



						//Before Run this File
						
						// * reject the record for invoice payment status ---TS_Maker-Reports_28
						// * just submit the record for pending invoice payment status  ---TS_Maker-Reports_28

public class MAKER {
	WebDriver driver;
	String H2H_url = "http://192.168.1.6:18080/H2H/";

	
	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver\\chromedriver(9.7).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(H2H_url);
		Thread.sleep(2000);
	}
	
											//TS_Maker-Dashboard_01 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_02 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_03 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_04 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_05 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_06 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_07 ---- Dashboard design scenarios
											//TS_Maker-Dashboard_08 ---- Dashboard design scenarios
											//TS_Maker-Reports_01   ---- Adminstrator menu is removed in H2H
	
	
	
	
	
	@Test(priority = 2)
	public void TS_Maker_Reports_02_click_to_verify_the_Reports_parent_menu()
		throws InterruptedException {
		//TS_Maker_Reports_02_click to verify the "Reports" parent menu
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("siva001");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(6000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();
			Thread.sleep(6000);
			WebElement reports = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[5]/a"));
			reports.click();
			Thread.sleep(3000);
		//Result --- It shows child menu - -"Receipt invoice Print", -"Invoice payment status", -"Report Generation".
	}
	
	
	@Test(priority = 3)
	public void TS_Maker_Reports_03_In_Reports_click_the_Receipt_invoice_Print_child_menu ()   
		throws InterruptedException {
		//TS_Maker_Reports_03."In Reports- click the ""Receipt invoice Print"" child menu."
			WebElement RIP = driver.findElement(By.xpath("//*[@id=\"rpt\"]/ul/li[1]/a"));
			RIP.click();
			Thread.sleep(3000);
		//Result --"It navigate ""Receipt invoice Print"" page"

	}
	
	@Test(priority = 4)
	public void TS_Maker_Reports_04_In_Receipt_invoice_Print_check_the_Invoice_Reciept_for_field()   
		throws InterruptedException {
		//TS_Maker_Reports_04."In Receipt invoice Print- check the ""Invoice Reciept for"" field"
			WebElement DP_field = driver.findElement(By.id("inrecfor"));
			DP_field.click();
			Thread.sleep(3000);
		//Result --"It will be a dropdown field"

	}
	
	@Test(priority = 5)
	public void TS_Maker_Reports_05_In_Receipt_invoice_Print_check_the_Invoice_Recipt_for_field_are_allow_manual_input_or_not()   
		throws InterruptedException {
		//TS_Maker-Reports_05."In Receipt invoice Print- check the ""Invoice Recipt for"" field are allow manual input or not."
			WebElement DP_field = driver.findElement(By.id("inrecfor"));
			DP_field.click();
			Thread.sleep(3000);
		//Result --It should not allow the manual input

	}
	
	@Test(priority = 6)
	public void TS_Maker_Reports_06_In_Receipt_invoice_Print_check_the_Customer_group_field() 
		throws InterruptedException {
		//TS_Maker-Reports_06."In Receipt invoice Print- check the ""Customer group"" field."() 
			WebElement customer_group = driver.findElement(By.id("custgroup"));
			customer_group.sendKeys("ABCDabcd123!@#");
			Thread.sleep(5000);
			customer_group.clear();
		//Result --It should be a text or keypad field.

	}
	
	@Test(priority = 7)
	public void TS_Maker_Reports_07_In_Receipt_invoice_Print_check__the_Invoice_Number_field() 
		throws InterruptedException {
		//TS_Maker-Reports_07."In Receipt invoice Print- check the ""Invoice Number"" field."() 
			WebElement Invoice_no = driver.findElement(By.id("invno"));
			Invoice_no.sendKeys("1234567890");
			Thread.sleep(5000);
			Invoice_no.clear();
		//Result --"It should be a number field and it should not allow any other text."

	}
	
	@Test(priority = 8)
	public void TS_Maker_Reports_08_In_Receipt_invoice_Print_check_the_Invoice_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Maker-Reports_08."In Receipt invoice Print- check the ""Invoice Date"" field whether it should allow manual input or not." 
			WebElement invoice_date = driver.findElement(By.id("invdate"));
			invoice_date.sendKeys("00000000");
			Thread.sleep(5000);
			invoice_date.clear();
		//Result --"It should be a number field and it should not allow any other text."

	}
	
	@Test(priority = 9)
	public void TS_Maker_Reports_09_In_Receipt_invoice_Print_check_the_Invoice_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Maker-Reports_09."In Receipt invoice Print- check the ""Invoice Date"" field whether it should allow manual input or not." 
			WebElement invoice_date = driver.findElement(By.id("invdate"));
			invoice_date.sendKeys("03022022");
			Thread.sleep(5000);
			invoice_date.clear();
		//Result --"It should be a number field and it should not allow any other text."

	}
	
											//TS_Maker_Reports_10 ------ future date check should be manual test
	  										//TS_Maker_Reports_11 ------ future date check should be manual test

	
	@Test(priority = 12)
	public void TS_Maker_Reports_12_In_Receipt_invoice_Print_Check_the_Pay_serial_field() 
		throws InterruptedException {
		//TS_Maker-Reports_12.""In Receipt invoice Print- Check the ""Pay serial"" field ."
			WebElement pay_srl = driver.findElement(By.id("paysral"));
			pay_srl.sendKeys("Editable field");
			Thread.sleep(3000);
			pay_srl.clear();
			Thread.sleep(3000);
		//Result --"It should be text input or keypad input."

	}
	
	@Test(priority = 13)
	public void TS_Maker_Reports_13_In_Receipt_invoice_Print_Check_the_Duplicate_field() 
		throws InterruptedException {
		//TS_Maker-Reports_13."In Receipt invoice Print- Check the ""Duplicate"" field ."
			WebElement check_box = driver.findElement(By.id("dup"));
			check_box.click();
			Thread.sleep(3000);
		//Result --"It should be check box field."

	}
	
	@Test(priority = 14)
	public void TS_Maker_Reports_14_In_Receipt_invoice_Print_Check_the_Duplicate_field_whether_it_allow_to_click_or_not() 
		throws InterruptedException {
		//TS_Maker-Reports_14."In Receipt invoice Print- Check the ""Duplicate"" field whether it allow to click or not."
			WebElement check_box = driver.findElement(By.id("dup"));
			check_box.click();
			Thread.sleep(3000);
			WebElement Reset_Tab = driver.findElement(By.id("reset"));
			Reset_Tab.click();
			Thread.sleep(3000);
		//Result --It should be allow to check or click.
	}
	
	@Test(priority = 15)
	public void TS_Maker_Reports_15_In_Receipt_invoice_Print_Check_the_Print_Button() 
		throws InterruptedException {
		//TS_Maker-Reports_15."In Receipt invoice Print- Check the ""Print"" Button."
			WebElement DP_field = driver.findElement(By.id("inrecfor"));
			Select selectDD = new Select (DP_field);
			selectDD.selectByVisibleText("GEPGPAY");      //GEPGPAY
			Thread.sleep(2000);    
			WebElement customer_group = driver.findElement(By.id("custgroup"));
			customer_group.sendKeys("GEPGPAY");
			Thread.sleep(3000);
			WebElement Invoice_no = driver.findElement(By.id("invno"));
			Invoice_no.sendKeys("991900002503");
			Thread.sleep(3000);
			Invoice_no.sendKeys(Keys.TAB);
			Thread.sleep(3000); 
			WebElement print_btn = driver.findElement(By.id("print"));
			print_btn.click();
			Thread.sleep(5000);
		//Result --It should download the receipt invoice in our system by pdf 

	}
	
	@Test(priority = 16)
	public void TS_Maker_Reports_16_In_Receipt_invoice_Print_Check_the_Reset_Button() 
		throws InterruptedException {
		//TS_Maker-Reports_16."In Receipt invoice Print- Check the ""Reset"" Button."
			WebElement reset_btn = driver.findElement(By.id("reset"));
			reset_btn.click();
			 Thread.sleep(5000);
		//Result --It should download the receipt invoice in our system by pdf 

	}
	
	@Test(priority = 17)
	public void TS_Maker_Reports_17_In_Reports_click_the_Invoice_Payment_Status_field() 
		throws InterruptedException {
		//TS_Maker-Reports_17."In Reports- click the ""Invoice Payment Status"" field."
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			threedots.click();
			Thread.sleep(3000);
			WebElement IPS = driver.findElement(By.xpath("//*[@id=\"rpt\"]/ul/li[2]/a/span"));
			IPS.click();
			Thread.sleep(3000);
		//Result --"It navigate ""Invoice Payment Status"" page"

	}
	
	@Test(priority = 18)
	public void TS_Maker_Reports_18_In_Invoice_Payment_Status_check_the_Invoice_Payment_Status_field() 
		throws InterruptedException {
		//TS_Maker-Reports_18."In Invoice Payment Status- check the ""Invoice Payment Status"" field."
			WebElement Dp_field = driver.findElement(By.id("s1"));
			Dp_field.click();
			Thread.sleep(3000);
		//Result --"It should be a dropdown suggestion fields."

	}
	
	@Test(priority = 19)
	public void TS_Maker_Reports_19_In_Invoice_Payment_Status_check_the_Invoice_Payment_Status_field() 
		throws InterruptedException {
		//TS_Maker-Reports_19."In Invoice Payment Status- check the ""Invoice Payment Status"" field."
			WebElement Dp_field = driver.findElement(By.id("s1"));
			Dp_field.click();
			Thread.sleep(3000);
		//Result --"It should not allow the manual input"

	}
	
	@Test(priority = 20)
	public void TS_Maker_Reports_20_In_Invoice_Payment_Status_check_the_Invoice_Type_field() 
		throws InterruptedException {
		//TS_Maker-Reports_20."In Invoice Payment Status- check the ""Invoice Type"" field."
			WebElement Invoice_type = driver.findElement(By.id("s2"));
			Invoice_type.click();
			Thread.sleep(3000);
		//Result --"It should be a dropdown suggestion fields."

	}
	
	@Test(priority = 21)
	public void TS_Maker_Reports_21_In_Invoice_Payment_Status_check_the_Invoice_Type_field() 
		throws InterruptedException {
		//TS_Maker-Reports_21."In Invoice Payment Status- check the ""Invoice Type"" field."
			WebElement Invoice_type = driver.findElement(By.id("s2"));
			Invoice_type.click();
			Thread.sleep(3000);
		//Result --"It should not allow the manual input"

	}
	
	@Test(priority = 22)
	public void TS_Maker_Reports_22_In_Invoice_Payment_Status_click_the_From_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Maker-Reports_22."In Invoice Payment Status- click the ""From Date"" field whether it should allow manual input or not."
			WebElement From_date = driver.findElement(By.id("d1"));
			From_date.click();
			Thread.sleep(3000);
		//Result --"It should be allow manual input through keyboard."

	}
	
	
	
													//TS_Maker_Reports_23 ------ future date check should be manual test
													//TS_Maker_Reports_24 ------ future date check should be manual test
	
	
	@Test(priority = 25)
	public void TS_Maker_Reports_25_In_Invoice_Payment_Status_check_the_To_Date_field_whether_it_should_allow_manual_input_or_not() 
		throws InterruptedException {
		//TS_Maker-Reports_25."In Invoice Payment Status- check the ""To Date"" field whether it should allow manual input or not."
			WebElement To_date = driver.findElement(By.id("d2"));
			To_date.click();
			Thread.sleep(3000);
		//Result --"It should be allow manual input through keyboard ."

	}
	
																//TS_Maker_Reports_26 ------ future date check should be manual test
																//TS_Maker_Reports_27 ------ future date check should be manual test
	
	
	
	@Test(priority = 28)
	public void TS_Maker_Reports_28_In_Invoice_Payment_Status_Check_the_Get_Bill_Detail_button() 
		throws InterruptedException {
		//TS_Maker-Reports_28."In Invoice Payment Status- Check the ""Get Bill Details"" button."
			WebElement IPS = driver.findElement(By.id("s1"));
			Select selectDD = new Select (IPS);
			selectDD.selectByVisibleText("Success");
			Thread.sleep(3000);
			WebElement IT = driver.findElement(By.id("s2"));
			Select selectDD1 = new Select (IT);
			selectDD1.selectByVisibleText("GEPGPAY");
			Thread.sleep(3000);
			WebElement From_Date = driver.findElement(By.id("d1"));
			From_Date.sendKeys("01112021");
			Thread.sleep(3000);
			WebElement To_Date = driver.findElement(By.id("d2"));
			To_Date.sendKeys("03022022");
			Thread.sleep(3000);
			WebElement GBD = driver.findElement(By.id("getBill"));
			GBD.click();
			Thread.sleep(7000);
			WebElement IPS1 = driver.findElement(By.id("s1"));
			Select selectDD2 = new Select (IPS1);
			selectDD2.selectByVisibleText("Reject");
			Thread.sleep(3000);
			GBD.click();
			Thread.sleep(7000);
			WebElement IPS2 = driver.findElement(By.id("s1"));
			Select selectDD3 = new Select (IPS2);
			selectDD3.selectByVisibleText("Pending");
			Thread.sleep(3000);
			GBD.click();
			Thread.sleep(5000);
		//Result --"It should be allow manual input through keyboard ."

	}
	
	
	@Test(priority = 29)
	public void TS_Maker_Reports_29_In_Invoice_Payment_Status_Check_the_Reset_button() 
		throws InterruptedException {
		//TS_Maker-Reports_29."In Invoice Payment Status- Check the ""Reset"" button."
			WebElement Reset = driver.findElement(By.xpath("//*[@id=\"tab_card\"]/div[3]/div/div/div[2]/div/input"));
			Reset.click();
			Thread.sleep(3000);
		//Result --It should clear all the above fields

	}
	
	         
									//TS_Maker_Reports_30 ------ Wrong scenario need to change sceanrio
	
	
	@Test(priority = 31)
	public void TS_Maker_Reports_31_In_Invoice_Payment_Status_Check_the_Download_button() 
		throws InterruptedException ,AWTException  {
		//TS_Maker-Reports_31."In Invoice Payment Status- Check the ""Download"" button."
			WebElement IPS = driver.findElement(By.id("s1"));
			Select selectDD = new Select (IPS);
			selectDD.selectByVisibleText("Success");
			Thread.sleep(3000);
			WebElement IT = driver.findElement(By.id("s2"));
			Select selectDD1 = new Select (IT);
			selectDD1.selectByVisibleText("GEPGPAY");
			Thread.sleep(3000);
			WebElement From_Date = driver.findElement(By.id("d1"));
			From_Date.sendKeys("01112021");
			Thread.sleep(3000);
			WebElement To_Date = driver.findElement(By.id("d2"));
			To_Date.sendKeys("03022022");
			Thread.sleep(3000);
			WebElement GBD = driver.findElement(By.id("getBill"));
			GBD.click();
			Thread.sleep(5000);
			WebElement EXCEL_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[1]"));
			EXCEL_btn.click();
			Thread.sleep(3000);
			WebElement PDF_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[2]"));
			PDF_btn.click();
			Thread.sleep(3000);
			WebElement CSV_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[3]"));
			CSV_btn.click();
			Thread.sleep(3000);
			WebElement Print_btn = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/div[2]/div/a[4]"));
			Print_btn.click();
			Thread.sleep(5000);
			//close the TabS
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);		
			Thread.sleep(8000);
		//Result --It should preview the status of Invoice in table by below order Success,Reject and Pending

	}
	
							//  TS_Maker-Reports_32 ------ old frame scenario need to change the scenario
							//  TS_Maker-Reports_33 ------ old frame scenario need to change the scenario
							//  TS_Maker-Reports_34 ------ old frame scenario need to change the scenario		
							//  TS_Maker-Reports_35 ------ old frame scenario need to change the scenario
							//  TS_Peer to Peer_01  ------ Adminstrator menu is removed in H2H
	
	
	
	@Test(priority = 37) 
	public void TS_Peer_to_Peer_02_click_to_verify_the_Peer_to_Peer_parent_menu()
	  throws InterruptedException { 
		//TS_Peer_to_Peer_02.click to verify the "Peer to Peer" parent menu
		  WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
		  threedots.click(); 
		  Thread.sleep(3000); 
		  WebElement peep_peer = driver.findElement(By.id("p2p_"));
		  peep_peer.click(); 
		  Thread.sleep(3000); 
	  //Result--It shows child menu - "Payment Bill" .
	
	}
	
	
							//TS_Peer to Peer_03 ---- old frame scenario need to change the scenario
							//TS_Peer to Peer_04 ---- old frame scenario need to change the scenario

	
	
	
	@Test(priority = 40) 
	public void TS_GePG_01_In_Gepg_payment_Check_the_Invoice_No_field_When_we_submit_the_Correct_Invoice_No()
	  throws InterruptedException { 
		//TS_GePG_01."In Gepg payment : Check the Invoice No. field When we submit the Correct Invoice No."
		  WebElement Gepgpayment = driver.findElement(By.xpath("//*[@id=\"p2p\"]/ul/li[1]/a/span"));
		  Gepgpayment.click(); 
		  Thread.sleep(2000);
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
		  Thread.sleep(3000);
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
		  WebElement Highlight_alert = driver. findElement(By.id("description"));          // Highligh "Bill is already in queue there!!!"
		  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		  jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",Highlight_alert);
		  Thread.sleep(6000);
		  driver.navigate().refresh(); 
	  //Result--It should Not able to auto complete the below respected fields based on the invoice no, it will show the message as "Bill details are not found"
	
	}
	
	
	@AfterSuite
	public void closebrowser() {        
	 	driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

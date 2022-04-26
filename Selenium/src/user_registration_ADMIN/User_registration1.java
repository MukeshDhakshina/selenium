package user_registration_ADMIN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class User_registration1 {
	
	WebDriver driver;
	String new_username = "vicky";
	String H2H_url = "http://192.168.1.6:18080/H2H/";
 

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.8).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(H2H_url);
	}

	
	@Test(priority = 0)
	public void Url_HealthTest() {
		System.out.println("TS_001 has been start");
		driver.get(H2H_url);
		try {
			System.out.println("Url_HealthTest");
		} catch (Exception e) {
			System.out.println("FAIL CASE - URL Health Test " + e);
		}
	}
	
	@Test(dependsOnMethods = "Url_HealthTest", priority = 1)
	public void Step_01()
	        throws InterruptedException {
		 // _01.Login with correct credentials
			WebElement UsernameField1 = driver.findElement(By.id("txtUserId"));
			UsernameField1.sendKeys(new_username);		
			Thread.sleep(3000);
			WebElement PasswordField1 = driver.findElement(By.id("txtPwd"));
			PasswordField1.sendKeys("passw0rd");
			Thread.sleep(3000);
			WebElement eye_icon = driver.findElement(By.id("toggle"));
			eye_icon.click();
			Thread.sleep(3000);
			PasswordField1.sendKeys(Keys.ENTER);
			Thread.sleep(5000);	
			UsernameField1.clear();
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("selenium_A");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("selenium");
			Thread.sleep(3000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		// Result --- It should navigate to Profile Image Upload page
		}
	
	@Test(priority = 2)
	public void Step_02()
	        throws InterruptedException {
		// _02.click the toggle button and go to user registration child menu in user registration parent menu
			WebElement tooglebtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button/i"));
			tooglebtn.click();
			Thread.sleep(7000);
			WebElement parent_Userreg= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a"));
			parent_Userreg.click();
			Thread.sleep(7000);
			WebElement child_Userreg= driver.findElement(By.xpath("//*[@id=\"userregistration\"]/ul/li[1]/a"));
			child_Userreg.click();
			Thread.sleep(3000);
			
		// Result --- It should navigate to User registration page
	}
	
	@Test(priority = 3)
	public void Step_03() 
		throws InterruptedException {
		//03. Send the required information for Submit the Button to confirm the entries.
		WebElement userid =  driver.findElement(By.id("tuserid"));             //userid
		userid.sendKeys(new_username);   
		Thread.sleep(1000);	

		WebElement username =  driver.findElement(By.id("tusernme"));          //username      
		username.sendKeys("Mukesh");   	
		Thread.sleep(1000);

		WebElement DOB =  driver.findElement(By.id("tbirthdate"));             //DOB
		DOB.sendKeys("18122000");   
		Thread.sleep(1000);

		WebElement Numvalue =  driver.findElement(By.id("tmobile"));		   //Mobile No 
		Numvalue.sendKeys("9299662515");   
		Thread.sleep(1000);

		WebElement Emailvalue =  driver.findElement(By.id("temail"));		   //Email ID
		Emailvalue.sendKeys("Mukesh@hdsoftwaresystems.com");
		Thread.sleep(1000);

		WebElement Passfield =  driver.findElement(By.id("tpwd"));             //password
		Passfield.sendKeys("passw0rd");
		Thread.sleep(1000);  
		WebElement toggle =  driver.findElement(By.id("toggle"));             //eye icon 
		toggle.click();
		Thread.sleep(1000);
		
		WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));   //Re-Enter password
		Re_Passfield.sendKeys("passw0rd");
		Thread.sleep(1000);   //toggle1
		WebElement Re_toggle =  driver.findElement(By.id("toggle1"));   //Eye icon 
		Re_toggle.click();
		Thread.sleep(1000);

		WebElement dropdownindex = driver.findElement(By.id("trolecd")); 		//Role Code - ADMIN
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(2);    
		Thread.sleep(1000);

		         // Create object of SimpleDateFormat class and decide the format
				 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				 
				 //get current date time with Date()
				 Date date = new Date(); 										// passing System current date (dd/MM/yyyy)
				 
				 // Now format the date
				 String date1= dateFormat.format(date);
				 
		WebElement RegDate =  driver.findElement(By.id("tregdate"));			//Current Date 
		RegDate.sendKeys(date1);   
		Thread.sleep(1000);

		WebElement dropdownbranchcd = driver.findElement(By.id("branchcd"));    //Branch Code
		Select selectDD1 = new Select (dropdownbranchcd);
		selectDD1.selectByIndex(1);    //1 -  EBTL, Exim Tower
		Thread.sleep(1000);		
		 WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[1]/button")); //Submit Button
		 submitbtn.click(); Thread.sleep(7000);
	}
	
	@Test(priority = 4)
	public void Step_04()
	        throws InterruptedException {
		// _04.click the toggle button and then go to Approval child menu in Setting parent menu
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button"));
			threedots.click();
			Thread.sleep(7000);
			WebElement setting = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[3]/a"));
			setting.click();
			Thread.sleep(5000);
			WebElement Approval = driver.findElement(By.xpath("//*[@id=\"setting\"]/ul/li[2]/a/span"));
			Approval.click();
			Thread.sleep(5000);
		// Result --- It should navigate to Approval page
	}
	
	@Test(priority = 5)
	public void Step_05() 
			throws InterruptedException {		
		// _05.In Approval- Click the user registration in "Program Name" Field.
		WebElement userregDD = driver.findElement(By.id("txtPgmId")); 		
		Select selectDD = new Select (userregDD);
		selectDD.selectByVisibleText("User Registration");
		Thread.sleep(3000);  
		WebElement search_field = driver.findElement(By.id("searchkey"));	
		search_field.sendKeys(new_username);
		Thread.sleep(3000);
		// Result --- It will shown the program name and informations.
	}
	
	@Test(priority = 6)
	public void Step_06() 
			throws InterruptedException {		
		// _06.In Approval- Check the box what you need to Authorize 
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[1]")); 		
		checkbox.click();
		// Result --- It should check the box for authorization.
	}
	
	@Test(priority = 7)
	public void Step_07()
			throws InterruptedException {
		// _07.In Approval- Authorize the selected User registration program 
			WebElement Authorize = driver.findElement(By.id("auth"));
			Authorize.click(); 	
			Thread.sleep(5000);
			WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
			Yesbtn.click();
			Thread.sleep(5000);
			WebElement Logoutimg = driver.findElement(By.id("userimg"));
			Logoutimg.click();
			Thread.sleep(5000);
			WebElement Logoutbutton = driver.findElement(By.id("sessionlogout"));
			Logoutbutton.click();
			Thread.sleep(5000);
		// Result --- It should check the box for authorization.
	}
	
	@Test(priority = 8)
	public void Step_08()
			throws InterruptedException {
		// _08.In Login Page - Send authorized user 
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys(new_username);
			Thread.sleep(6000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("passw0rd");
			Thread.sleep(6000);
			WebElement Eyeicon = driver.findElement(By.id("toggle"));
			Eyeicon.click();
			Thread.sleep(1000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(6000);
			WebElement Avatarimg = driver.findElement(By.id("userimg"));
			Avatarimg.click();
			Thread.sleep(6000);
			WebElement Highlight_username = driver. findElement(By.id("username"));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')",Highlight_username);
			Thread.sleep(6000);
		// Result --- It should login.
	}
	
	@AfterSuite
	public void closebrowser() {
	 	driver.close();
	}
	
	
	
	

}

package user_registration_ADMIN;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class User_registration {

	WebDriver driver;

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.8).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.2.11:18080/H2H/");
	}

	@Test(priority = 0)
	public void Url_HealthTest() {
		System.out.println("TS_001 has been start");
		driver.get("http://192.168.2.11:18080/H2H/");
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
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
			Thread.sleep(1000);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(6000);
		// Result --- It should navigate to Profile Image Upload page
		}
	
	@Test(priority = 2)
	public void Step_02()
	        throws InterruptedException {
		// _02.click the toggle button and go to user registration child menu in user registration parent menu
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button"));
			threedots.click();
			Thread.sleep(3000);
			WebElement parent_menu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[1]/a"));
			parent_menu.click();
			Thread.sleep(3000);
			WebElement Userregistration = driver.findElement(By.xpath("//*[@id=\"userregistration\"]/ul/li[1]/a/span"));
			Userregistration.click();
			Thread.sleep(3000);
		// Result --- It should navigate to User registration page
	}
	
	@Test(priority = 3)
	public void Step_03() 
		throws InterruptedException {
		//03. Send the required information for Submit the Button to confirm the entries.
		WebElement userid =  driver.findElement(By.id("tuserid"));             //userid
		userid.sendKeys("TestingADMIN");   
		Thread.sleep(1000);	

		WebElement username =  driver.findElement(By.id("tusernme"));          //username      
		username.sendKeys("Mukesh");   	
		Thread.sleep(1000);

		WebElement DOB =  driver.findElement(By.id("tbirthdate"));             //DOB
		DOB.sendKeys("18122000");   
		Thread.sleep(1000);

		WebElement Numvalue =  driver.findElement(By.id("tmobile"));		   //Mobile No 
		Numvalue.sendKeys("9087369066");   
		Thread.sleep(1000);

		WebElement Emailvalue =  driver.findElement(By.id("temail"));		   //Email ID
		Emailvalue.sendKeys("Mukesh@hdsoftwaresystems.com");
		Thread.sleep(1000);

		WebElement Passfield =  driver.findElement(By.id("tpwd"));             //password
		Passfield.sendKeys("Passw0rd");
		Thread.sleep(1000);  
		WebElement toggle =  driver.findElement(By.id("toggle"));             //eye icon 
		toggle.click();
		Thread.sleep(1000);
		
		WebElement Re_Passfield =  driver.findElement(By.id("tconfirmpwd"));   //Re-Enter password
		Re_Passfield.sendKeys("Passw0rd");
		Thread.sleep(1000);   //toggle1
		WebElement Re_toggle =  driver.findElement(By.id("toggle1"));   //Eye icon 
		Re_toggle.click();
		Thread.sleep(1000);

		WebElement dropdownindex = driver.findElement(By.id("trolecd")); 		//Role Code - ADMIN 
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(2);    
		Thread.sleep(1000);

		WebElement RegDate =  driver.findElement(By.id("tregdate"));			//Current Date 
		RegDate.sendKeys("200122");   
		Thread.sleep(1000);

		WebElement dropdownbranchcd = driver.findElement(By.id("branchcd"));    //Branch Code
		Select selectDD1 = new Select (dropdownbranchcd);
		selectDD1.selectByIndex(1);    //1 -  EBTL, Exim Tower
		Thread.sleep(1000);

		WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div[2]/div/div[1]/button"));   //Submit Button
		submitbtn.click();
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 4)
	public void Step_04()
	        throws InterruptedException {
		// _04.click the toggle button and then go to Approval child menu in Setting parent menu
			WebElement threedots = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/button"));
			threedots.click();
			Thread.sleep(3000);
			WebElement setting = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/ul/li[2]/a"));
			setting.click();
			Thread.sleep(3000);
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
		selectDD.selectByIndex(10);
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
		WebElement Authorize = driver.findElement(By.xpath("//*[@id=\'colour_body\']/div/div[2]/div[3]/div/div[1]/div/button"));
		Authorize.click();
		Thread.sleep(3000);
		WebElement Yesbtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[1]"));
		Yesbtn.click();
		Thread.sleep(3000);
		WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/a/div"));
		Logoutimg.click();
		Thread.sleep(3000);
		WebElement Logoutbutton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/ul/div/div[1]/li[2]/a"));
		Logoutbutton.click();
		Thread.sleep(3000);
		WebElement failbtn = driver.findElement(By.xpath("/html/fail"));
		failbtn.click();
		// Result --- It should check the box for authorization.
	}
	
	@Test(priority = 8)
	public void Step_08()
			throws InterruptedException {
		// _08.In Login Page - Send authorized user 
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("TestingADMIN");
		Thread.sleep(3000);
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("passw0rd");
		Thread.sleep(1000);
		WebElement Eyeicon = driver.findElement(By.id("toggle"));
		Eyeicon.click();
		Thread.sleep(1000);
		PasswordField.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		// Result --- It should login.
	}
	
	@AfterSuite
	public void closebrowser() {
	 	driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

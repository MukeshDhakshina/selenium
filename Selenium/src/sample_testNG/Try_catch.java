package sample_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Try_catch {

	
	WebDriver driver;
	long StartTime;
	long EndTime;

	@BeforeSuite
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		Thread.sleep(4000);

	}

	@Test(priority = 0)
	public void Url_HealthTest() {
		driver.get("http://192.168.3.252:8090/H2H_new/");
		try {
			System.out.println("Url_HealthTest");
		} catch (Exception e) {
			System.out.println("FAIL CASE - URL Health Test " + e);
		}
	}

	@Test(dependsOnMethods = "Url_HealthTest", priority = 1)
	public void TC_01() {
		// Starting time
		StartTime = System.currentTimeMillis();
		try {
			// _01.Make UserName and password empty and login
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			Thread.sleep(3000);
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("" + Keys.ENTER);
			// Result --- It shows User Id or Password Should Not Be Blank
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_01");
		} catch (Exception e) {
			System.out.println(
					"FAIL CASE - The fields login and password make empty and click login button or Press Enter. " + e);
		}
	}

	@Test(priority = 2)
	public void TC_02() {
		try {
			// _02.Make Correct User ID and leave the password field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login" + Keys.ENTER);
			// Result --- It shows User Id or Password Should Not Be Blank
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_02");
		} catch (Exception e) {
			System.out.println(
					"FAIL CASE - correct User ID and leave the password fied empty and click login button or Press Enter. "
							+ e);
		}
	}

	@Test(priority = 3)
	public void TC_03() {
		try {
			// _03.Make Correct password and leave the UserID field empty
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
			// Result --- It shows User Id or Password Should Not Be Blank
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_03");
		} catch (Exception e) {
			System.out.println(
					"FAIL CASE - leave the User ID field empty and enter the correct password and click login button or Press Enter. "
							+ e);
		}
	}

	@Test(priority = 4)
	public void TC_04() {
		try {
			// _04.Make Correct UserID and Wrong password field
			WebElement UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("123@Login" + Keys.ENTER);
			// Result --- It shows User Id or Password Should Not Be Blank
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_04");
		} catch (Exception e) {
			System.out.println(
					"FAIL CASE - input of correct User ID and wrong Password and click login button or Press Enter. "  + e);
		}
	}



	@Test(priority=5) public void TC_05() { 
		try { 
		//_05.Make Wrong UserID and Correct password field 
			WebElement UsernameField=driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ABCDE");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123"+Keys.ENTER);
		//Result --- It shows Either User Id or Password you entered is wrong
			UsernameField.clear();
			PasswordField.clear();
			System.out.println("PASS CASE - TC_05"); Thread.sleep(3000); } 
	    catch
			(Exception e) { System.out.
				println("FAIL CASE - input of wrong User ID and correct Password and click login button or Press Enter. " + e); } }


	@Test(priority = 6)
	public void TC_06() {
		try {

		// _06.Make Correct UserID and Correct password field
			WebElement UsernameField = driver.findElement(By.id(""));
			UsernameField.sendKeys("MAKER");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123" + Keys.ENTER);
		// Result --- Action leads to Navigate the DashBoard page
			Thread.sleep(3000);
			WebElement Logoutimg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/a/div/img"));
			Logoutimg.click();
			Thread.sleep(4000);
			WebElement Logoutbutton = driver
					.findElement(By.xpath("/html/body/div[1]/div[1]/nav/div/ul/li[6]/ul/div/div[1]/li[2]/a"));
			Logoutbutton.click();

			System.out.println("PASS CASE - TC_06");
		} catch (Exception e) {
			System.out.println(
					"FAIL CASE - input of correct (ADMIN) User ID and correct Password and click login button or Press Enter. "
							+ e);
		}
	}

	@Test(priority = 7)
	public void TC_07() {
			// _07.Make UserID and password field empty
			driver.get("http://192.168.3.252:8090/H2H_V2");
			WebElement UsernameField = driver.findElement(By.id(""));
			UsernameField = driver.findElement(By.id("txtUserId"));
			UsernameField.sendKeys("ADMIN");
			WebElement PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField = driver.findElement(By.id("txtPwd"));
			PasswordField.sendKeys("Login@123");
	
			WebElement cancelbutton = driver.findElement(By.xpath("//*[@id=\'loginForm\']/div[2]/div/div[3]/button"));
			cancelbutton.click();
			// Result --- It should Empty the User ID and Password fields
			System.out.println("PASS CASE - TC_07");
			
		}
	
	@Test(priority = 8)
    public void TC_08() {
		
	}
	
	
	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
		EndTime = System.currentTimeMillis();
		long TotalTime = EndTime - StartTime;
		System.out.println("The total time duration of running scenario as per milliseconds " + TotalTime);
	}

	
}

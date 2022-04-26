package sample_testNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_Tab {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver\\chromedriver(9.6).exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.3.252:8090/H2H_new/");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement UsernameField = driver.findElement(By.id("txtUserId"));
		UsernameField.sendKeys("MAKER");
		WebElement PasswordField = driver.findElement(By.id("txtPwd"));
		PasswordField.sendKeys("Login@123" + Keys.ENTER);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.open('"+"http://192.168.3.252:8090/H2H_new/"+"','_blank');");
		Thread.sleep(3000);
		//close the Tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.close();
		//Result ---- The system should be allow the second Tab to one or more users to the dashboard page

	}

}

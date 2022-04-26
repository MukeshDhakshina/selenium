package sample_notes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver","E:\\\\Selenium\\\\chromedriver(2).exe");
	      WebDriver driver = new ChromeDriver();
	      String u ="https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm";
	      driver.get(u);
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      // identify and click submit
	      WebElement t = driver.findElement(By.name("submit"));
	      t.click();
	      // Explicit wait condition for alert
	      WebDriverWait w = new WebDriverWait(driver, 5);
	      //alertIsPresent() condition applied
	      if(w.until(ExpectedConditions.alertIsPresent())==null)
	      System.out.println("Alert not exists");
	      else
	      System.out.println("Alert exists");
	      driver.close();
		
	}

}

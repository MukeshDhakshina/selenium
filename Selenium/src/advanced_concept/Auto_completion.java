package advanced_concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto_completion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");
 
		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/autoComplete.html");
		
	   WebElement input = driver.findElement(By.xpath("//*[@id=\'tags\']"));
	   input.sendKeys("s");
	   Thread.sleep(4000);   // for implicit wait
	   
	   List<WebElement> autocomplete = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
	   
	   for (WebElement webElement : autocomplete) {
		   if (webElement.getText().equals("Web Services")) {
			   
			   webElement.click();		   
			   System.out.println("If part");
			   break; 	
		} else {
			   System.out.println("else part");

		}
		   
		
	}

	   
	   
		
	}

}

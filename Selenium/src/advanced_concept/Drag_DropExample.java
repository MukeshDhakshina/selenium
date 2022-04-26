package advanced_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_DropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/drop.html");
		
		WebElement From =driver.findElement(By.id("draggable"));
		
		WebElement To =driver.findElement(By.id("droppable"));
		
		
		Actions actions = new Actions(driver);
		
		actions.dragAndDrop(From, To).build().perform();
		
	
		
	}

}

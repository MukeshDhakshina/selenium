package advanced_concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/selectable.html");
		
		List<WebElement> selectable = driver.findElements(By.xpath("//*[@id=\'selectable\']/li"));
		
        int Listsize = selectable.size();
        
        System.out.println(Listsize);
        
        
        Actions actions = new  Actions(driver);
        
        actions.keyDown(Keys.CONTROL)
        .click(selectable.get(0))
        .click(selectable.get(1))
        .click(selectable.get(2))
        .click(selectable.get(3))
        .click(selectable.get(4))
        .click(selectable.get(5))
        .click(selectable.get(6)).build().perform();
        
        /* 
        actions.clickAndHold(selectable.get(0));
        actions.clickAndHold(selectable.get(1));
        actions.clickAndHold(selectable.get(2));
        actions.clickAndHold(selectable.get(3));
        actions.clickAndHold(selectable.get(4));
        actions.clickAndHold(selectable.get(5));
        actions.clickAndHold(selectable.get(6));
        actions.build().perform();
        */

        
        
}
	
	
}
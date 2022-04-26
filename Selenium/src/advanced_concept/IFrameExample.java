package advanced_concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver(2).exe");

		// we open the new Chrome browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/frame.html");

		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.id("Click"));
		click.click();
		String clicktext = click.getText();
		System.out.println(clicktext);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");


		WebElement click1 = driver.findElement(By.id("Click1"));
		click1.click();
		String clicktext1 = click1.getText();
		System.out.println(clicktext1);

		driver.switchTo().defaultContent();

		List<WebElement> Totalframe = driver.findElements(By.tagName("iframe"));

		int sizeframe = Totalframe.size();

		System.out.println(sizeframe);


	}

}

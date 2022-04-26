package basic_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/radio.html");
		
		//1.click (yes) Radio Button
		WebElement clickyes =  driver.findElement(By.xpath("//*[@id=\"yes\"]"));
		
		clickyes.click();
		
		//2.check which radio button is checked
		
		WebElement unchecked = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/label[2]/input"));
		
		WebElement checked = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/label[3]/input"));
		
		
		boolean Status1 = unchecked.isSelected();
		boolean Status2 = checked.isSelected();

		System.out.println("Unchecked Status is "+Status1+"(whether the status is true=checked false=unchecked)");
		System.out.println("Checked Status is "+Status2+"(whether the status is true=checked false=unchecked)");

		//3.click (below20 years) Radio Button

		WebElement Below20  = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div/input[1]"));
		
		Below20.click();
		
	}

}

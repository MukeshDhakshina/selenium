package basic_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/checkbox.html");

		//1.Select the java CheckBox
		WebElement javabox  = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div[1]/input"));
		javabox.click();

		//2.check whether Selenium is checked or not
		WebElement Seleniumcheckbox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/input"));

		boolean Status = Seleniumcheckbox.isSelected();

		System.out.println("Selenium checkbox Status is "+Status+"(whether the status is true=checked false=unchecked)");

		//3.DeSelect all the selected CheckBox
		WebElement Firstcheckbox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div[1]/input"));

		if (Firstcheckbox.isSelected()) {
			Firstcheckbox.click();
		}
		
		WebElement Secondcheckbox = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div[2]/input"));

		if (Secondcheckbox.isSelected()) {
			Secondcheckbox.click();
		}

	}

}

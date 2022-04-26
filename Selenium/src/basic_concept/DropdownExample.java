package basic_concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\chromedriver(2).exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://leafground.com/pages/Dropdown.html");

		//1.select by using index

		WebElement dropdownindex = driver.findElement(By.id("dropdown1"));
		Select selectDD = new Select (dropdownindex);
		selectDD.selectByIndex(1);

		//2.select by using visibleText

		selectDD.selectByVisibleText("Selenium");

		//3.select by using value

		selectDD.selectByValue("2");

		//4.Get by Number of DropDown options

		List<WebElement> listofDD = selectDD.getOptions();

		int size = listofDD.size(); 

		System.out.println("Number of elements in dropdown field is "+size);

		//5.Using SendKeys to select

		dropdownindex.sendKeys("Selenium");

		//6.MultiSelect by using index or value or text.

		WebElement multiselect = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[6]/select"));

		Select multiselectbox = new Select(multiselect);

		multiselectbox.selectByIndex(1);
		multiselectbox.selectByIndex(3);


		//following code for gettext of dropdown

			//	WebElement dropdown = select.getFirstSelectedOption();
			//  String dropdownvalue = dropdown.getText();




	}

}

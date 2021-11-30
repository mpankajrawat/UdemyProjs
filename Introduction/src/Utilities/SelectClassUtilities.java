package Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassUtilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		selectStaticDropDownByValue(driver,By.id("ctl00_mainContent_DropDownListCurrency"), "USD");
		
	}
	public static void selectStaticDropDownByValue (WebDriver driver, By by, String value) {
		WebElement locator = driver.findElement(by);
		System.out.println(locator.getText());
		Select dropDown = new Select(driver.findElement(by));
		System.out.println("Selecting value " +value+ " from the dropdown list");
		dropDown.selectByValue(value);
		System.out.print("Dropdown value selected as: " +value );
	}
	
	public static void selectStaticDropDownByIndex (WebDriver driver, By by, int index) {
		WebElement locator = driver.findElement(by);
		Select dropDown = new Select(driver.findElement(by));
		System.out.println("Selecting value " +index+ " from the dropdown list");
		dropDown.selectByIndex(index);;
		System.out.print("Dropdown value selected as: " +index );
	}
	
	/*//static dropdown 
			WebElement by = driver.findElement(By.id(""));
			Select value = new Select(by);
			value.selectByValue("");
			System.out.println(value.getFirstSelectedOption().getText());
			
			//suggestive dropdown
			driver.findElement(By.id("")).sendKeys("");
			List<WebElement> options = driver.findElements(By.xpath(""));
			for(WebElement option : options) {
				String option_Name = option.getText();
				if(option_Name.equals("Text")) {
					driver.findElement(By.xpath("")).click();
				}
			}*/

}

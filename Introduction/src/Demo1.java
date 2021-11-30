import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.print(driver.getTitle());

		//static dropdown 
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
		}
		
		//
	}

}

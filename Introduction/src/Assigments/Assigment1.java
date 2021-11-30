package Assigments;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assigment1 {
	public static void main (String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1st clicking on checkbox
		/*driver.findElement(By.xpath("//input[@value='option1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		System.out.println("Validated the checkbox is selected");
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		System.out.println("Validated the checkbox is not selected");*/
		
		//2nd number of Checkboxes
		/*List<WebElement> number_Of_Checkboxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//fieldset//label"));
		int number_of_checkboxs = number_Of_Checkboxes.size();
		System.out.println(number_of_checkboxs);*/
		int number = driver.findElements(By.xpath("//div[@id='checkbox-example']//fieldset//label")).size();
		System.out.println(number);
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("")));
	}

}

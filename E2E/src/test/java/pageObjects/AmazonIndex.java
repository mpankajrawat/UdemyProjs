package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonIndex {
	
	WebDriver driver;
	public AmazonIndex(WebDriver driver) {
		this.driver=driver;
	}
	
	By userName = By.xpath("//div[@id='glow-ingress-block']//span[@id='glow-ingress-line1']");
	
	public WebElement UserName() {
		return driver.findElement(userName);
	}
}

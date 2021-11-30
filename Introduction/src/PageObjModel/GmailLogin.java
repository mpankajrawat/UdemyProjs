package PageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLogin {

	WebDriver driver;
	
	public GmailLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By username = By.xpath("");
	By password = By.xpath("");
	/*or*/
	@FindBy(xpath="")
	WebElement next;
	
	@FindBy(xpath="")
	WebElement loginButton;
	/*By next = By.xpath("");
	By loginButton = By.xpath("");*/
	
	public WebElement emailId(){
		return driver.findElement(username);
	}
	public WebElement pass() {
		return driver.findElement(password);
	}
	public WebElement subbmit() {
		return loginButton;
	}
	public WebElement next() {
		return next;
	}
}

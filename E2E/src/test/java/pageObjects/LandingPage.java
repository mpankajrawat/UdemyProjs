package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	//declaring webdriver
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//defining elements
	By sigIn_Button = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	By userName_TextFiield = By.xpath("//div//input[@id='ap_email']");
	By continue_Button = By.xpath("//input[@id='continue']");
	By password_TextField = By.xpath("//div//input[@id='ap_password']");
	By subbmit_Button = By.xpath("//input[@id='signInSubmit']");
	
	//finding webelements
	public WebElement signInLangingPage() {
		return driver.findElement(sigIn_Button);
	}
	
	public WebElement username() {
		return driver.findElement(userName_TextFiield);
	}
	
	public WebElement password() {
		return driver.findElement(password_TextField);
	} 
	
	public WebElement continueBtn() {
		return driver.findElement(continue_Button);
	}
	
	public WebElement submit() {
		return driver.findElement(subbmit_Button);
	}

}

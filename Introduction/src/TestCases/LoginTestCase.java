package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjModel.GmailLogin;

public class LoginTestCase {

	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		GmailLogin gm = new GmailLogin(driver);
		gm.emailId().sendKeys("");
		gm.pass().sendKeys("");
		gm.subbmit().click();
	}
}

package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLInsecureCertifications {

	public static void main(String[] args) {
		HandleInsecureCertifications(true);

	}
	public static void HandleInsecureCertifications( Boolean value) {
		ChromeOptions browserProfile = new ChromeOptions();
		browserProfile.setAcceptInsecureCerts(value);
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(browserProfile);
		driver.get("https://expired.badssl.com/");
	}

}

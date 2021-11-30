package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver initilizeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("D:\\Udmey\\E2E\\src\\test\\java\\resources\\baseData.properties");
		prop.load(file);
		String BrowserToUse = prop.getProperty("Browser");
		System.out.println(BrowserToUse+ " is the browser used for running test case");
		if(BrowserToUse.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\E2E\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (BrowserToUse.equals("Firefox")) {
			System.getProperty("driver.firefox.driver", "");
			driver = new FirefoxDriver();

		}
		else if (BrowserToUse.equals("IE")) {
			System.getProperty("driver.firefox.driver", "");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
}

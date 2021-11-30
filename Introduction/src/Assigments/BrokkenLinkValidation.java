package Assigments;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokkenLinkValidation {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		SoftAssert softassert = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String current_url= driver.getCurrentUrl();
		validatingBrokkenLinks(driver, softassert);

	}
	public static void validatingBrokkenLinks(WebDriver driver, SoftAssert softassert) throws MalformedURLException, IOException {
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links = footer.findElements(By.xpath("//li//a"));
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection urlObj = (HttpURLConnection) new URL(url).openConnection();
			urlObj.setRequestMethod("HEAD");
			urlObj.connect();
			int responseCode = urlObj.getResponseCode();
			System.out.println(link.getText()+ " : " + url+ " response code is "+responseCode);
			softassert.assertFalse(responseCode>400, "Response Code for "+link.getText()+ " : " + url+ " is greater then 400");
			
		}
		softassert.assertAll();
	}

}

package MavenJavaFramework.E2E;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AmazonIndex;
import pageObjects.LandingPage;
import resources.base;

public class AmazonLogin extends base {

	@Test(dataProvider = "getData")
	public static void navigateToAmazon(String username, String password, String userName) throws IOException {
		driver = initilizeBrowser();
		driver.get("https://www.amazon.com/");
		LandingPage amznLandingPage = new LandingPage(driver);
		amznLandingPage.signInLangingPage().click();
		amznLandingPage.username().sendKeys(username);
		amznLandingPage.continueBtn().click();
		amznLandingPage.password().sendKeys(password);
		amznLandingPage.submit().click();
		AmazonIndex aI = new AmazonIndex(driver);
		driver.findElement(By.xpath("")).isDisplayed();
		Assert.assertTrue(aI.UserName().getText().equalsIgnoreCase(userName));
	}
	@DataProvider
	public Object[][] getData() {
		//rowws=number of time test runs, column=number of arguments required for test
		Object[][] data = new Object[1][3];
		data[0][0] = "9811392039"; 
		data[0][1] = "july141994";
		data[0][2] = "Deliver to Pankaj";
		return data;
	}
}

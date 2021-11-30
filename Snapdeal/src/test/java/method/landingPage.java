package method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class landingPage extends base {

	 static WebDriver driver = null;
	 static String projectPath = System.getProperty("user.dir");
	 public static Properties prop;
	 static String cheapestElementName = null;
	 static ArrayList<String> searchResultPrice = new ArrayList<String>();
	 static String leatPriceProduct;
	 static int leastPrice;
	
	@Parameters("BrowserName")
	@BeforeTest
	public static void setUpTest(String Browser) throws IOException{
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		prop = new Properties();
		prop.load(new FileInputStream(projectPath+"\\src\\test\\java\\objects\\obj.properties"));
	}
	
	
	@Test(priority = 1)
	public static void indexPage(){
		driver.get(prop.getProperty("URL"));
		
	}
	
	@Test(priority = 2)
	public static void searchProduct() {
		driver.findElement(By.xpath("//div[@class='overlap']/following-sibling::input")).sendKeys("Samsung android phone");
		driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']/span")).click();
	}
	
	@Test(priority = 3)
	public static void setFilterOnSearchResults() {
		driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']/div/i")).click();
		driver.findElement(By.xpath("//ul//li[@class='search-li' and @data-index='2']")).click();
	}
	
	@Test(priority = 4)
	public static void getSearchElementsPriceAndSelect() {
		
		//xpath for price
		String productName; 
		int productPrice;
		HashMap<String, Integer> searchItemList = new HashMap<String, Integer>();
		ArrayList<String> productsNames = new ArrayList<String>();
		ArrayList<Integer> productsPrices = new ArrayList<Integer>();
		List<WebElement> elements = driver.findElements(By.xpath("//section[@data-dppos='1']//div[@class='product-tuple-description ']//p[@class='product-title ']"));
		for(WebElement e : elements) {
			productName = e.getText();
			productsNames.add(productName);
									
		}
		List<WebElement> priceelements = driver.findElements(By.xpath("//section[@data-dppos='1']//div[@class='product-tuple-description ']//div//span[contains(@class,'product-price')]"));
		for(WebElement e : priceelements) {
			String[] price = e.getText().split("Rs. ")[1].split(",");			
			productPrice =  Integer.parseInt(price[0]+price[1]);
			productsPrices.add(productPrice);
		}
		leastPrice=Collections.min(productsPrices);
		int i=0;
		for(int p : productsPrices) {
			if(p==leastPrice) {
				break;
			}
			i++;
		}
		leatPriceProduct=productsNames.get(i);
		
		String productxpath="//section[@data-dppos='1']//div[@class='product-tuple-description ']//p[@class='product-title ' and contains(text(),'PRODUCT_NAME')]".replace("PRODUCT_NAME", leatPriceProduct);
		driver.findElement(By.xpath(productxpath)).click();		
	}
	
	@Test(priority = 5) 
	public static void switchToTab() {
		switchToTabByIndex(driver, 1);
	}
	
	public static void switchToTabByIndex(WebDriver driver, int tabIndex) {
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		if (it.hasNext()){
			String tabId = null;
			for(int i = 0;i==tabIndex;i++) {
				tabId = it.next();
			}
			driver.switchTo().window(tabId);
		}
		
	}
	
	@Test(priority = 6)
	public static void addToCart() {
		String name = driver.findElement(By.xpath("//div[@class='col-xs-22']//h1")).getText();
		Assert.assertTrue(name.contains(leatPriceProduct));
		driver.findElement(By.xpath("//span[@class='intialtext' and contains(text(),'add to cart')]")).click();
	}
	
	@Test(priority = 7)
	public static void getFinalPriceOfCart() {
		String[] finalP = driver.findElement(By.xpath("//div[@class='you-pay']//span")).getText().split(",");
		int finalPrice=Integer.parseInt(finalP[0]+finalP[1]);
		if(finalPrice!=leastPrice) {
			int difference = finalPrice - leastPrice;
			System.out.print(difference);
		}
	}
	
	
	
}

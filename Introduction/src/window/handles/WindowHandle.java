package window.handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	}
	
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void setWindowSize(WebDriver driver, int height, int width) {
		Dimension size = new Dimension(height, width);
		driver.manage().window().setSize(size);
	}
	
	public static void handleWindowAlert(WebDriver driver, Boolean value) {
		if(value)
		{
			driver.switchTo().alert().accept();
		}
		else
		{
			driver.switchTo().alert().dismiss();
		}
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

}

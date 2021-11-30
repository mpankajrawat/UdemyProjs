import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {
	// JavaFunction for counting number of names starting with A (without using Java Stream)
	//@Test
	public static void withoutStream() {
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Anuj");
		nameList.add("Gaurav");
		nameList.add("Mohit");
		nameList.add("Prashant");
		nameList.add("anu");
		int count = 0;
		for (String name : nameList) {
			if(name.startsWith("A")) {
				count++;
				
			}
		}
		System.out.println(count);
	}
	//@Test
	public static void withStream() {
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Anuj");
		nameList.add("Gaurav");
		nameList.add("Mohit");
		nameList.add("Prashant");
		nameList.add("anu");
		long count = nameList.stream().filter(name->name.startsWith("A")).count();
		System.out.println(count);
		                //or
		nameList.stream().filter(name->name.startsWith("A")).forEach(name->System.out.println(name));
		               //or
		nameList.stream().filter(name->{
			name.startsWith("A");
			return true;
		}).forEach(name->System.out.println(name));
	}
	
	//@Test
	public static void withStreamMapUpperCase() {
		ArrayList<String> nameList = new ArrayList<String>();
		Stream.of("Anuj","Gaurav","Mohit","Prashant","anu").filter(name->name.startsWith("A")).map(name->name.toUpperCase()).forEach(name->System.out.println(name));
	
	}
	
	//@Test
	public static void withStreamConcatinateTwo() {
		ArrayList<String> nameList = new ArrayList<String>();
		Stream.of("Anuj","Gaurav","Mohit","Prashant","anu").filter(name->name.startsWith("A")).map(name->name.toUpperCase()).forEach(name->System.out.println(name));
		List<String> nameList1 = Arrays.asList("Anuj1","Gaurav1","Mohit1","Prashant1","anu1");
		Stream<String> namesList = Stream.concat(nameList.stream(), nameList1.stream());
		namesList.sorted().forEach(names->System.out.println(names));
	}
	
	//@Test
	public static void StreamCollect() {
		List<String> nameSortedFiltered = Stream.of("Anuj","Gaurav","Mohit","Prashant","anu").filter(name->name.startsWith("A")).map(name->name.toUpperCase()).collect(Collectors.toList());
		String firstName = nameSortedFiltered.get(0);
		System.out.print(firstName);
	}
	
	@Test
	public static void SortingTableUsingStream() {
		System.setProperty("webdriver.chrome.driver", "D:\\Udmey\\Introduction\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//table//thead/tr//th//span[contains(text(),'Veg/fruit name')]/parent::th")).click();
		List<WebElement> uiList = driver.findElements(By.xpath("//table//tbody/tr//td[1]"));
		List<String> listText = uiList.stream().map(s->s.getText()).collect(Collectors.toList());
		List <String> sortedList = listText.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(listText, sortedList,"List not sorted");
	}
	
}

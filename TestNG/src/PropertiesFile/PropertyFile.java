package PropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFile {

	@Test
	public static void PropertyFil() throws IOException{
		Properties prop = new Properties();
		FileInputStream readFile = new FileInputStream("D:\\Udmey\\TestNG\\src\\PropertiesFile\\PropertyFile.properties");
		prop.load(readFile);
		System.out.println(prop.getProperty("Browser"));
		prop.setProperty("Browser", "IE");
		FileOutputStream writeFile = new FileOutputStream("D:\\Udmey\\TestNG\\src\\PropertiesFile\\PropertyFile.properties");
		prop.store(writeFile, null);
	}
}

package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	protected static String baseUrlProperty = "baseurl";
	protected static WebDriver driver;
	protected static Config config;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, IOException {
		config = Config.getInstance();
		driver = DriverProvider.getDriver();
	}
	
	protected static String getUrl(String urlPath) {
		return config.getProperty(baseUrlProperty) + urlPath;
	}
	
	protected static void goToUrl(String urlPath) {
		driver.get(getUrl(urlPath));
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	protected Boolean elementExists(org.openqa.selenium.By arg0)
	{
		try {
			driver.findElement(arg0);
		} catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}
}

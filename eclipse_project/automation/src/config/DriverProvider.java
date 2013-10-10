package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
	
	private static String browserProperty = "browser";
	private static String firefoxValue = "firefox";
	private static String chromeValue = "chrome";
	private static String chromeWebDriverProperty = "webdriver.chrome.driver";
	private static String chromeWebDriverValue = "chromedriver.exe";
	
	public static WebDriver getDriver() {
		
		if (isChrome()) {
			System.out.println("is Chrome");
			return getChromeDriver();
		} else if(isFirefox()) {
			System.out.println("is firefox");
			return getFirefoxDriver();
		}

		//hay que hacer un throw
		System.out.println("Valor no valido de propiedad `browser`: " + getBrowser());
		System.exit(0);

		return null;
	}
	
	public static WebDriver getFirefoxDriver() {
		return new FirefoxDriver();
	}

	public static WebDriver getChromeDriver() {
		String value = Config.getInstance().getProperty(chromeWebDriverProperty);
		if (value == null) {
			//valor por defecto chromedriver.exe
			value = chromeWebDriverValue;
			System.out.println("configuration " + chromeWebDriverProperty + " not found, using " + value);
		}
		System.setProperty(chromeWebDriverProperty, value);
		return new ChromeDriver();
	}
	
	private static Boolean isChrome() {
		return getBrowser().equals(chromeValue);
	}
	
	private static Boolean isFirefox() {
		return getBrowser().equals(firefoxValue);
	}
	
	private static String getBrowser() {
		return Config.getInstance().getProperty(browserProperty);
	} 
	
}

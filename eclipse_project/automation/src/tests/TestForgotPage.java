package tests;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.BaseClass;

public class TestForgotPage extends BaseClass {

	protected static final String startPage = "RecoverAccount";
	
	@BeforeClass
	public static void goToStartPage()
	{
		goToUrl(startPage);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSome()
	{
		
	}
}

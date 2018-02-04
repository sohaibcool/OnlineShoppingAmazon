package com.shopping.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.shopping.qa.utils.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
	try{
		prop=new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\Mohammed Sohaib\\eclipse-workspace\\OnlineShopping\\src\\main\\java\\com\\shopping\\qa\\config\\config1.properties");
		prop.load(ip);
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();
	}
}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Live Project\\Rahul_classes\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println(browserName);
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Selenium Drivers\\firefox.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IExporer"))
		{
			System.setProperty("webdriver.Internet.driver", "/OnlineShopping/Drivers/IEDriverServer.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		
		
	}

}

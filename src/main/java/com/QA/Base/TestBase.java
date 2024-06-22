package com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties property;
	public static WebDriver driver;
	public static ChromeOptions option;
	
	public TestBase() {
		
		String path = System.getProperty("user.dir")+"src\\main\\java\\properties"+"config.properties";
		
		try {
			FileInputStream file = new FileInputStream(path);
			property = new Properties();
			property.load(file);
			}
		
			catch (FileNotFoundException e) {
			e.printStackTrace();
		    }
		    catch (IOException e) {
			e.printStackTrace();
		}}
	
	public static void initialiseBrowser() {
		
		String browsername = property.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			// driver = new FirefoxDriver();
		}
		else if(browsername.equals("edge")) {
			 driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
}

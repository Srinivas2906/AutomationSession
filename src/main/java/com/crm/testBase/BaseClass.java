package com.crm.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	public BaseClass() {
		
		String s = "D:\\Personal\\SeleniumDevelopment\\Workspace1\\AutomationSession\\AutomateFreeCRM\\config.properties";
		
		 prop = new Properties();
		 
		 try {
			FileInputStream fs = new FileInputStream(s);
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void launchBrowser(String browser)
	{
		
	if(browser.equalsIgnoreCase("chrome"))
	{
	
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		 
	}
	else if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver",prop.getProperty("fireFoxPath"));
		driver = new FirefoxDriver();
		
	}
	else{
		System.out.println("browser not conigured");
		
		}
		 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));

}
}

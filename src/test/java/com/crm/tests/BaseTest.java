package com.crm.tests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.testBase.BaseClass;

public class BaseTest extends BaseClass {
	BaseClass bc = new BaseClass();

	@BeforeTest
	@Parameters("browser")
	public void baseTest(String browserName)
	{
		launchBrowser(browserName);
		
	}
	
	@AfterTest
	public void tearDown()
	{
	driver.quit();	
	}
}

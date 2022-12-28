package com.baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetUpClass {
	
	public WebDriver driver;
	
	public void Chrome_PropertySetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	public void Firefox_PropertySetup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver(); 
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	public void Edge_PropertySetup()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\Drivers\\msedgedriver.exe");
		driver=new EdgeDriver(); 
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	public void OpenUrl() throws InterruptedException
	{
		driver.navigate().to("http://10.0.3.189:8000/");  
        driver.manage().window().maximize();  
	}
}

package com.epicLoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epicLogin.EPIC_Dashboard;
import com.epicLogin.EpicValidInput;
import com.toFetchTheData.FetchDataForLoginPage;

public class EpicValidLoginTest extends FetchDataForLoginPage{
	
	@BeforeClass
	@Parameters("Browser")
	public void Setup(String Browser) throws InterruptedException {
		if (Browser.equalsIgnoreCase("Chrome"))
			Chrome_PropertySetup();
		else if (Browser.equalsIgnoreCase("firefox"))
			Firefox_PropertySetup();
		else if (Browser.equalsIgnoreCase("edge"))
			Edge_PropertySetup();
	}
	@BeforeMethod
	public void OpenBrowser() throws InterruptedException
	{
		OpenUrl();
	}
	@Test
	public void Login_Valid_Test() throws EncryptedDocumentException, IOException, InterruptedException
	{
		EpicValidInput evi=new EpicValidInput(driver);
		evi.EnterU_Name(getData(1,0));
		evi.EnterPswd(getData(1,1));
		evi.ClickLoginWithLDAP();
		Capture1();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	}
	@AfterMethod
	public void CloseBrowser()
	{
		EpicValidInput evi=new EpicValidInput(driver);
		evi.ProfileIcon();
	}
	@AfterClass
	public void Cleanup() throws Throwable
	{
		driver.close();
		finalize();
	}
	

}

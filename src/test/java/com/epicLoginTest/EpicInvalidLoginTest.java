package com.epicLoginTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epicLogin.EPIC_Dashboard;
import com.epicLogin.EpicValidInput;
import com.toFetchTheData.FetchDataForLoginPage;

public class EpicInvalidLoginTest extends FetchDataForLoginPage {
	
	@BeforeClass
	public void Setup() throws InterruptedException
	{
		Chrome_PropertySetup();
	}
	@BeforeMethod
	public void OpenBrowser() throws InterruptedException
	{
		OpenUrl();
	}
	@DataProvider()
	public Object[][] getInvalidData() throws EncryptedDocumentException, IOException
	{
		Object data[][]=getDataforInvalidTest("Sheet1");
		return data;
	}
	@Test(dataProvider="getInvalidData")
	public void Login_InValid_Test(String Uname, String pwd) throws EncryptedDocumentException, IOException, InterruptedException
	{
		EpicValidInput evi1 = new EpicValidInput(driver);
				evi1.EnterU_Name(Uname);
				evi1.EnterPswd(pwd);
				evi1.ClickLoginWithLDAP();
				//Thread.sleep(5000);
	}
	@AfterMethod
	public void CloseBrowser() throws IOException
	{
		//Capture1();
	}
	@AfterClass
	public void Cleanup() throws Throwable
	{
		driver.close();
		finalize();
	}
	

}

package com.epicLoginTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epicLogin.EPIC_Dashboard;
import com.epicLogin.EpicValidInput;
import com.toFetchTheData.FetchDataForLoginPage;

public class DashboardFieldsTest extends FetchDataForLoginPage {

	EPIC_Dashboard ed;
	EpicValidInput evi;

	@BeforeClass
	public void Setup() throws InterruptedException {
		Chrome_PropertySetup();
		OpenUrl();
	}

	@BeforeMethod
	public void m1() {
	}

	@Test(priority = 0)
	public void Login_Valid_Test() throws EncryptedDocumentException, IOException, InterruptedException {
		evi = new EpicValidInput(driver);
		evi.EnterU_Name(getData(1, 0));
		evi.EnterPswd(getData(1, 1));
		evi.ClickLoginWithLDAP();
		// Capture1();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void EPIC_Dashboard_Test1() throws EncryptedDocumentException, IOException, InterruptedException {
		ed = new EPIC_Dashboard(driver);
		ed.EnterPatId(getDataforDashboardTest(1, 0));
		ed.SelectLocation();
		ed.SelectProvider();
		ed.StartDate(getDataforDashboardTest(1, 2));
		ed.EndDate();
		ed.ClickSearch();
		Thread.sleep(5000);
	}
	@Test(priority=2) 
	public void textTest() 
	{ 
		ed = new EPIC_Dashboard(driver);
		ed.LastUpdatedDateAndTime(); 
	}

	/*@Test(enabled=false,priority = 4)
	public void testDownloads() throws InterruptedException {
		ed = new EPIC_Dashboard(driver);
		ed.DownloadRecords();
	}*/

	@Test(priority = 3)
	public void Table_Test() {
		ed = new EPIC_Dashboard(driver);
		ed.TableData();
	}

	@Test(priority = 4)
	public void Table_Feedback() throws InterruptedException {
		ed = new EPIC_Dashboard(driver);
		ed.Thmbs_UpOrDown();
	}
	@Test(priority=5)
	public void checkAddCPT() throws InterruptedException
	{
		ed = new EPIC_Dashboard(driver);
		ed.AddCPT();
	}

	@AfterMethod
	public void m2() throws InterruptedException {
	
	}

	@AfterClass
	public void Cleanup() throws Throwable {
		//ed.cleardata();
		//ed = new EPIC_Dashboard(driver);
		ed.ProfileIcon();
		//driver.close();
		finalize();
	}
}

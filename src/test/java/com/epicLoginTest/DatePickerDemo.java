package com.epicLoginTest;

import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;

public class DatePickerDemo {
	
	public WebDriver driver;

	@BeforeClass
	public void openBrowser() throws InterruptedException
	{ 

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();  

		driver.get("http://10.0.3.189:8000/CPDS/recommendation"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input#mat-input-0")).sendKeys("267560");
		Thread.sleep(2000);
	}
	@Test(priority=0)
	public void FirstServDate() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement start_date=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		start_date.sendKeys(getDataforDashboardTest(1,0));	
		//start_date.clear();
		//Thread.sleep(4000);
		//start_date.sendKeys(getDataforDashboardTest(2,0));
		Thread.sleep(2000);
	}
	public String getDataforDashboardTest(int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\mujawar.mehboob\\Desktop\\Book1.xlsx");
		String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	

	/*@Test(priority=0)
	public void tripDetails() throws InterruptedException, AWTException
	{

	//Modify Wait time as per the Network Ability in the Thread Sleep method


	driver.findElement(By.xpath("(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[1]")).click();
	WebElement dateWidgetFrom = driver.findElement(By.xpath("//table[@class='mat-calendar-table']"));
	List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
	DatePickerDemo.clickGivenDay(columns, DatePickerDemo.getCurrentDay());
	}
	
	public static String getCurrentDay() {
	  Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      //Get Current Day as a number
      int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
      System.out.println("Today Int: " + todayInt + "\n");
      //Integer to String Conversion
      String todayStr = Integer.toString(todayInt);
      System.out.println("Today Str: " + todayStr + "\n");
      return todayStr;
  }
  //Get The Current Day plus days. You can change this method based on your needs.
  public static String getCurrentDayPlus(int days) {
      LocalDate currentDate = LocalDate.now();
      int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
      return Integer.toString(dayOfWeekPlus);
  }
  //Click to given day
  public static void clickGivenDay(List<WebElement> elementList, String day ) {
      //DatePicker is a table. Thus we can navigate to each cell
      //and if a cell matches with the current date then we will click it.
      /**Functional JAVA version of this method.*/
      /**elementList.stream()
          .filter(element -> element.getText().contains(day))
          .findFirst()
          .ifPresent(WebElement::click);
      /**Non-functional JAVA version of this method.
     * @throws IOException 
     * @throws EncryptedDocumentException */
      //for (
      //    WebElement cell : elementList) {
      //    String cellText = cell.getText();
      //    if (cellText.contains(day)) {
      //        cell.click();
      //        break;
      //    }
      //}
  

 @Test(priority=1)
	public void tripDetails1() throws InterruptedException, AWTException
	{

	//Modify Wait time as per the Network Ability in the Thread Sleep method


	driver.findElement(By.xpath("(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[2]")).click();
	WebElement dateWidgetFrom = driver.findElement(By.xpath("//table[@class='mat-calendar-table']"));
	List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
	DatePickerDemo.clickGivenDay1(columns, DatePickerDemo.getCurrentDay1());
	}
	
	public static String getCurrentDay1() {
	  Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //Get Current Day as a number
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("Today Int: " + todayInt + "\n");
    //Integer to String Conversion
    String todayStr = Integer.toString(todayInt);
    System.out.println("Today Str: " + todayStr + "\n");
    return todayStr;
}
//Get The Current Day plus days. You can change this method based on your needs.
public static String getCurrentDayPlus1(int days) {
    LocalDate currentDate = LocalDate.now();
    int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
    return Integer.toString(dayOfWeekPlus);
}
//Click to given day
public static void clickGivenDay1(List<WebElement> elementList, String day ) {
    //DatePicker is a table. Thus we can navigate to each cell
    //and if a cell matches with the current date then we will click it.
    /**Functional JAVA version of this method.*/
    elementList.stream()
        .filter(element -> element.getText().contains(day))
        .findFirst()
        .ifPresent(WebElement::click);
    /**Non-functional JAVA version of this method.*/
    //for (
    //    WebElement cell : elementList) {
    //    String cellText = cell.getText();
    //    if (cellText.contains(day)) {
    //        cell.click();
    //        break;
    //    }
    //}
}
@Test(priority=2)
public void checkAddCPT() throws InterruptedException
{
	
	driver.findElement(By.xpath("(//span[contains(text(),'Add Feedback')])[3]")).click();
	WebElement AddCPT=driver.findElement(By.cssSelector("input#mat-chip-list-input-0"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", AddCPT);
	AddCPT.click();
	Thread.sleep(4000);
	WebElement listofCPT=driver.findElement(By.xpath("//div[@id='mat-autocomplete-0']"));
	String List=listofCPT.getText();
	System.out.println("List of CPTs: \n"+List);
	/*List<WebElement> listofCPT=driver.findElements(By.xpath("//div[@id='mat-autocomplete-0']"));
	//String List=listofCPT.getText();
	//System.out.println("List of CPTs: \n"+listofCPT);
	System.out.println("Total noumber of CPTs: \n"+listofCPT.size());*/
	
	WebElement CPT1=driver.findElement(By.cssSelector("mat-option#mat-option-82"));
	CPT1.click();
	Thread.sleep(4000);
	AddCPT.click();
	WebElement CPT2=driver.findElement(By.cssSelector("mat-option#mat-option-86"));
	CPT2.click();
	Thread.sleep(4000);
	//Actions a=new Actions(driver);
	//a.moveToElement(CPT1).build().perform();
	driver.findElement(By.xpath("//mat-icon[contains(text(),'cancel')]")).click();
	//driver.findElement(By.xpath("//mat-option[@id='mat-option-82']")).click();
}
	@AfterMethod
	public void closeBrowser()
	{
	//driver.quit();
	}

}

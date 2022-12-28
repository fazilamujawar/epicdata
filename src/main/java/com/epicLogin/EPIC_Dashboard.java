package com.epicLogin;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EPIC_Dashboard {
	
	public WebDriver driver;
		
	@FindBy(xpath="//input[@id='mat-input-2']") private WebElement PatInfo;
	@FindBy(xpath="//mat-select[@id='mat-select-0']") private WebElement Location; //label[@id='mat-form-field-label-7']
	@FindBy(xpath="//div[@id='mat-select-0-panel']") private WebElement listBox;
	@FindBy(xpath="//mat-option[@id='mat-option-0']")private WebElement AllChkBox;
	@FindBy(xpath="//div[@id='mat-select-value-3']") private WebElement Provider;
	@FindBy(xpath="//mat-option[@id='mat-option-1']") private WebElement ProAllChkBox;
	
	//Date
	@FindBy(xpath="//input[@id='mat-input-3']")private WebElement Start_Date;
	@FindBy(xpath="(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[1]") 
	private WebElement datepicker1;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-calendar-period-button mat-button mat-button-base']")
	private WebElement SelectYear;
	@FindBy(xpath="//input[@id='mat-input-4']")private WebElement End_Date;
	@FindBy(xpath="(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[2]")
	private WebElement datepicker2;
	@FindBy(xpath="//table[@class='mat-calendar-table']") private WebElement dateWidgetFrom;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator search-button mat-flat-button mat-button-base mat-primary']")
	private WebElement SearchButton;
	@FindBy(xpath="//div[contains(text(),' Scheduled Job on ')]") private WebElement lastUpdate;
	@FindBy(xpath="//span[contains(text(),'Download')]") private WebElement dwnldButton;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base']")
	private WebElement AccountCircle;
	@FindBy(xpath="//mat-icon[contains(text(),'logout')]") private WebElement Logout;
	
	@FindBy(xpath="//span[contains(text(),'EPIC UI')]") private WebElement epicui;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/mat-drawer-container/mat-drawer-content/app-cpds-recommendation/div/div[3]/table/thead/tr")
	private WebElement TableHeading;
	@FindBy(xpath="/html/body/app-root/app-dashboard/mat-drawer-container/mat-drawer-content/app-cpds-recommendation/div/div[3]/table/tbody")
	private WebElement Row;
	
	@FindBy(xpath="(//span[contains(text(),'Add Feedback')])[3]") private WebElement FeedBackButton;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-button mat-stroked-button mat-button-base']")
	private WebElement CloseButton;
	@FindBy(xpath="//div[@class='feedback-entry-row feedback-entry-heading']")
	private WebElement ContentOnFeedback; // Not showing the contents
	@FindBy(xpath="/html/body/app-root/app-dashboard/mat-drawer-container/mat-drawer-content/app-cpds-recommendation/div/mat-drawer[1]/div/mat-card/mat-card-content/div[2]/div[3]/mat-icon[1]")
	private WebElement thumbs_up;
	@FindBy(xpath="/html/body/app-root/app-dashboard/mat-drawer-container/mat-drawer-content/app-cpds-recommendation/div/mat-drawer[1]/div/mat-card/mat-card-content/div[2]/div[3]/mat-icon[2]")
	private WebElement thumbs_down;
	@FindBy(xpath="//input[@id='mat-input-5']") private WebElement Remark;
	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c40-49']") private WebElement Remark1;
	
	@FindBy(css="input#mat-chip-list-input-0") private WebElement AddCPTCode;
	@FindBy(css="#mat-autocomplete-0")private WebElement listofCPT;
	@FindBy(xpath="(//span[@class='mat-option-text'])[2]")private WebElement CPT1;
	@FindBy(xpath="(//span[@class='mat-option-text'])[4]")private WebElement CPT2;
	@FindBy(xpath="//mat-icon[contains(text(),'cancel')]") private WebElement CancelCPT;
	
	@FindBy(xpath="//span[contains(text(),'Save')]") private WebElement Save_button;
	@FindBy(xpath="//span[contains(text(),'Cancel')]") private WebElement Cancel_button;

	
	public void EnterPatId(String pid)
	{
		PatInfo.sendKeys(pid);
	}
	public void SelectLocation()
	{
		Location.click();				
		//Select select=new Select(listBox);
		//select.selectByIndex(1);
		AllChkBox.click();
		//driver.switchTo().frame(0);
		//container.click();
	}
	public void SelectProvider() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.moveToElement(Provider).click().build().perform();
		Provider.click();  							// need to confirm as it is not accepting dropdown method
		//a.moveToElement(ProAllChkBox).click().build().perform();
		ProAllChkBox.click();
	
		a.moveToElement(SearchButton).click().build().perform();
		//SearchButton.click();
	}
	public void StartDate(String sdate)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(Start_Date).click().build().perform();
		Start_Date.click();
		Start_Date.sendKeys(sdate);								//it takes the date from excel
		Start_Date.clear();
	}
	public void EndDate()
	{
		datepicker2.click();
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		EPIC_Dashboard.clickGivenDay1(columns, EPIC_Dashboard.getCurrentDay1());
	}
	
	public static String getCurrentDay1() {
		  Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	    String todayStr = Integer.toString(todayInt);
	    return todayStr;
	}
	public static String getCurrentDayPlus1(int days) {
	    LocalDate currentDate = LocalDate.now();
	    int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
	    return Integer.toString(dayOfWeekPlus);
	}
	public static void clickGivenDay1(List<WebElement> elementList, String day ) {
	    elementList.stream()
	        .filter(element -> element.getText().contains(day))
	        .findFirst()
	        .ifPresent(WebElement::click);
	}
	
	public void ClickSearch()
	{
		Actions a=new Actions(driver);
		a.moveToElement(SearchButton).click().build().perform();
		//SearchButton.click();
	}
	public void LastUpdatedDateAndTime()
	{
		boolean updatedDateAndTime=lastUpdate.isDisplayed();
		if(updatedDateAndTime==true)
			System.out.println("Last update date and time is: "+lastUpdate.getText());
		else
			System.out.println("Error in last update date field");
	}

	public void DownloadRecords() throws InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(dwnldButton).click().build().perform();
		dwnldButton.click();
		Thread.sleep(5000);
		try {
			Alert al = driver.switchTo().alert();
			System.out.println("Alert text is: " + al.getText());
		} catch (NoAlertPresentException e) {

			System.out.println("Exception handled");
		}
	}
	public void TableData()
	{
		String tableHead=TableHeading.getText();
		System.out.println(tableHead);
		String rowsData=Row.getText();
		System.out.println(rowsData);
		FeedBackButton.click();
	}
	public void Thmbs_UpOrDown() throws InterruptedException
	{
		thumbs_up.click();
		Thread.sleep(2000);
		boolean tUp=thumbs_up.isEnabled();
		if(tUp==true)
			System.out.println("Thumbs Up is visibled in Green in color.");
		else
			System.out.println("Thumbs Up is not get visibled after a click ");
		Thread.sleep(2000);
		thumbs_down.click();
		boolean tDown=thumbs_up.isEnabled();
		if(tDown==true)
			System.out.println("Thumbs Down is visibled in Red in color.");
		else
			System.out.println("Thumbs Down is not get visibled after a click ");
		Thread.sleep(2000);
		Remark.sendKeys("Good");  
	}
	
	public void AddCPT() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Cancel_button);
		Thread.sleep(2000);
		AddCPTCode.click();
		Thread.sleep(2000);
		String List=listofCPT.getText();
		System.out.println("List of CPTs: \n"+List);
		CPT1.click();
		AddCPTCode.click();
		CPT2.click();
		Thread.sleep(3000);
		CancelCPT.click();
		Thread.sleep(3000);
		Save_button.click();
		
		Thread.sleep(3000);
		FeedBackButton.click();
		Thread.sleep(3000);
		Remark1.clear();
		js.executeScript("arguments[0].scrollIntoView();", Cancel_button);
		Thread.sleep(3000);
		Save_button.click();
		//Cancel_button.click();
	}
	public void ProfileIcon()
	{
		AccountCircle.click();
		Logout.click();
	}
	
	public void cleardata()
	{
		PatInfo.clear();
		Location.clear();
		Provider.clear();
		Start_Date.clear();
		End_Date.clear();
	}
	public EPIC_Dashboard(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

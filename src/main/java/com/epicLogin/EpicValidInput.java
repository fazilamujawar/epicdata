package com.epicLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EpicValidInput {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='username']") private WebElement Username;
	@FindBy(xpath="//input[@formcontrolname='password']") private WebElement Password;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']") 
	private WebElement LoginWithLDAP;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base']")
	private WebElement AccountCircle;
	@FindBy(xpath="//*[@id=\"mat-menu-panel-0\"]/div/button") private WebElement Logout;

	public void EnterU_Name(String u)
	{
		Username.sendKeys(u);
	}
	public void EnterPswd(String p)
	{
		Password.sendKeys(p);
	}
	public void ClickLoginWithLDAP()
	{
		LoginWithLDAP.click();
	}
	public void ProfileIcon()
	{
		AccountCircle.click();
		Logout.click();
	}
	public EpicValidInput(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}


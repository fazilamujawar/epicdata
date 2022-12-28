package com.captureCode;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseClass.SetUpClass;

public class LoginPage_ScreenShots extends SetUpClass{

		public void Capture1() throws IOException
		{
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-SS");
			LocalDateTime now=LocalDateTime.now();
			File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        File dest=new File("C:\\Users\\mujawar.mehboob\\eclipse-workspace\\EPICUI\\ScreenShots\\"+dt.format(now)+".jpg");
	        FileUtils.copyFile(Source,dest);
		}
}

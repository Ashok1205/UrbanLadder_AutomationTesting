package com.library.urbanLadder;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.Reports.urbanLadder.ExtentReport;

public class Screenshots extends ExtentReport{
	ExtentReport er=new ExtentReport();

	public static void TakeScreenShot(WebDriver driver) 
	{
		try
		{
			//Taking Screenshot for respective pages
			TakesScreenshot ts = (TakesScreenshot)driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File destinationFile= new File(System.getProperty("user.dir")+"\\Screenshots\\Screenshots"+System.currentTimeMillis()+".png");
			try 
			{
				FileHandler.copy(sourceFile, destinationFile);
			}
			catch (IOException e) 
			{

				e.printStackTrace();
			}

		}
		catch(Exception e)
		{
			System.out.println("Screenshots not taken");
		}
	}

}

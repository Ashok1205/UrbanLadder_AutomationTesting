package com.Reports.urbanLadder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static ExtentHtmlReporter reporter;
	public static ExtentReports rep;
	public static ExtentTest test1,test2,test3,test4;
	public WebDriver driver;


	public void extentReport() {
		try
		{

			reporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "./Reports/ExtentReport_urbanLadder.html");
			rep=new ExtentReports();
			rep.attachReporter(reporter);

			reporter.config().setDocumentTitle("UrbanLadder");
			reporter.config().setReportName("Urban_Ladder_Module");

			rep.setSystemInfo("OS", "Windows 10 Enterprise");
			rep.setSystemInfo("Environment", "urbanLadder");
			rep.setSystemInfo("Version", "95");
			rep.setSystemInfo("Browser","Chrome");


			test1=rep.createTest("BookShelves");
			test2=rep.createTest("Collections");
			test3=rep.createTest("StudyChairs");
			test4=rep.createTest("GiftCards");


		}
		catch(Exception e)
		{
			System.out.println("Error occured while printing the Extent Report");
		}

	}

}

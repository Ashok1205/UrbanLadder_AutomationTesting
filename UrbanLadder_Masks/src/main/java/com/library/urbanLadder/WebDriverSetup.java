package com.library.urbanLadder;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.Reports.urbanLadder.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {

	static WebDriver driver;

	public static WebDriver getWebDriver(String browserName)          //to get the browser name
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();

			//to customize chrome
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();

			//to customize firefox
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("start-maximized");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-infobars");

			driver = new FirefoxDriver(options);
		}
		else
		{

			driver = null;
			System.out.println("Please select a browser as Chrome or Firefox !");
			System.exit(0);
		}
		return  driver;
	}


}

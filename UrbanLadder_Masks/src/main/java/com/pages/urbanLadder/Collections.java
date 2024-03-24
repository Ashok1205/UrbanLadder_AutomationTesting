package com.pages.urbanLadder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Reports.urbanLadder.ExtentReport;
import com.aventstack.extentreports.Status;
import com.library.urbanLadder.Screenshots;

public class Collections  extends ExtentReport
{

	public WebDriver driver;
	ExtentReport er=new ExtentReport();
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[10]/span")
	WebElement cl;
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[10]/div/div/ul/li[3]/div/a")
	WebElement bs;
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[10]/div/div/ul/li[3]/ul/li")
	List<WebElement> list;



	public Collections(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//to click on collections
	public void clickCollections() throws InterruptedException 
	{
		try
		{
			Thread.sleep(3000);
			cl.click();

			test2.log(Status.PASS,"Collections is clicked" );

		}
		catch(Exception e) 
		{
			System.out.println("Error occured while clicking collections");
		}
	}

	//to hover the mouse over best sellers
	public void clickBestSellers() throws InterruptedException 
	{
		try
		{

			Thread.sleep(3000);
			Actions mouse1 = new Actions(driver);
			mouse1.moveToElement(bs);
			mouse1.build().perform();

			Screenshots.TakeScreenShot(driver);
			test2.log(Status.PASS,"Cursor moved to Best Sellers" );
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while moving the cursor to Best Sellers");
		}
	}

	//to print the list of best sellers
	public void listOfBestSellers() 
	{
		try
		{
			System.out.println("-------> Best Sellers <-------");

			int i=0;
			for(WebElement products : list) {
				i++;
				System.out.println( i + " -> " +products.getText().toString());
			}
			System.out.println(" ");

			test2.log(Status.PASS,"Best Sellers list is printed" );
			rep.flush();
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while printing the list of Best Sellers");
		}
	}
}



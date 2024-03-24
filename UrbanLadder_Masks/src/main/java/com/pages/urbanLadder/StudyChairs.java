package com.pages.urbanLadder;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Reports.urbanLadder.ExtentReport;
import com.aventstack.extentreports.Status;
import com.library.urbanLadder.ReusableMethods;
import com.library.urbanLadder.Screenshots;

public class StudyChairs extends ExtentReport {

	public WebDriver driver;
	static String[] data = new String [10];
	ReusableMethods rm = new  ReusableMethods(driver);
	ExtentReport er=new ExtentReport();

	@FindBy(xpath="//input[@id=\"search\" and @type=\"search\"]")
	WebElement search;
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]")
	WebElement category;
	@FindBy(id="filters_primary_category_Study_Chair")
	WebElement studyChair;
	@FindBy(xpath="//div[ @class=\"product-info-block\"] ")
	List<WebElement> list2;


	public StudyChairs(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void readData() throws IOException {
		data=rm.readExcelData("Search");
	}

	//to enter study chair in searchbar
	public void searchBar()
	{
		try 
		{
			Thread.sleep(3000);  
			search.sendKeys(data[0] + Keys.ENTER);                 

			test3.log(Status.PASS,"Study Chair is entered in search bar" );
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while entering study chair in search bar");
		}
	}

	//to select categories as study chairs
	public void category()
	{
		try 
		{
			category.click();
			studyChair.click();

			test3.log(Status.PASS,"Study Chair filter is selected" );
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while selecting the study chair filters");
			e.printStackTrace();
		}
	}

	//to print the list of study chairs
	public void listOfStudyChairs() throws InterruptedException
	{
		try
		{
			Thread.sleep(3000);
			System.out.println("-------> List of Study Chairs <-------");

			//List<WebElement> list2 = driver.findElements(By.xpath("//div[ @class=\"product-info-block\"] "));

			int i=0;
			for(WebElement products : list2) 
			{
				i++;
				String for3 = ( i + " -> " +products.getText().toString());
				if(i<4) 
				{
					System.out.println(for3);
					System.out.println(" ");
				}
				else 
				{
					break;
				}
			}

			Screenshots.TakeScreenShot(driver);
			//System.out.println("Study Chairs are printed");
			test3.log(Status.PASS,"Study Chairs are printed" );
			rep.flush();
		}
		catch(Exception e)
		{
			System.out.println("Error occured while printing the study chairs");
		}
	}

}

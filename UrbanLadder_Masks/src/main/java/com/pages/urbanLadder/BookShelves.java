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

public class BookShelves extends ExtentReport
{
	public WebDriver driver;
	ExtentReport er=new ExtentReport();

	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]/span")
	WebElement Study;
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]/div/div/ul/li[3]/div/a")
	WebElement storage;
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]/div/div/ul/li[3]/ul/li[1]/a/span")
	WebElement bookShelves;
	@FindBy(partialLinkText="Close")
	WebElement adPopup;
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]")
	WebElement price;
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div")
	WebElement slider;
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]")
	WebElement storageFilter;
	@FindBy(id="filters_storage_type_Open")
	WebElement filterOpen;
	@FindBy(xpath="//div[ @class=\"product-info-block\"] ")
	List<WebElement> list;
	@FindBy(id="filters_availability_In_Stock_Only")
	WebElement excludeOutOfStock;
	@FindBy(xpath="//div[ @class=\"product-info-block\"] ")
	List<WebElement> list1;



	public BookShelves(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//to select bookshelves from the top menu
	public void selectBookShelves() throws InterruptedException 
	{
		try
		{
			Study.click();                                              //to select study from header
			Thread.sleep(3000);
			Actions hover = new Actions(driver);                        
			hover.moveToElement(storage).build().perform();             //to move the cursor to storage
			Thread.sleep(3000);
			bookShelves.click();                                       // to click bookshelves

			test1.log(Status.PASS, "Bookshelves options is selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error occured while selecting Bookshelves");
		}
	}

	//to close the ad
	public void closePopUp() throws InterruptedException 
	{
		try
		{
			Thread.sleep(3000);
			adPopup.click();                                                       //to close popup

			test1.log(Status.PASS, "AD is closed");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while closing AD");
		}
	}

	//to select the price filter
	public void price() throws InterruptedException 
	{
		try
		{
			Thread.sleep(3000);
			price.click();                                               //to click on price
			int ywidth = slider.getSize().width;                         //to slide the slider to choose price
			Actions slider1 = new Actions(driver);
			slider1.dragAndDropBy(slider, ywidth*-11, 0);
			slider1.build().perform(); 
			Thread.sleep(3000);

			test1.log(Status.PASS, "Price filter selected");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while selecting price filter");
		}
	}


	public void storageFilter() 
	{
		try
		{
			storageFilter.click();                                              //to select the storage filter
			filterOpen.click();                                                //to click on open

			test1.log(Status.PASS, "Storage filter selected as open");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while selecting storage filter as open");
		}
	}

	//to print the bookshelves list including out of stock
	public void getBookShelvesListIncludingOutOfStock() 
	{
		try
		{
			System.out.println("-------> List of bookshelves Including out of stock <-------");

			int i=0;
			for(WebElement products : list) 
			{
				i++;
				String for1 = ( i + " -> " +products.getText().toString());
				if(i<4) 
				{
					System.out.println(for1);
					System.out.println(" ");
				}
				else 
				{
					break;
				}
			}
			Thread.sleep(3000);
			Screenshots.TakeScreenShot(driver);
			test1.log(Status.PASS, "Bookshelves including out of stock is printed");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while printing bookshelves including out of stock");
		}
	}

	//to print the bookshelves list excluding out of stock
	public void getBookShelvesListExcludingOutOfStock() throws InterruptedException 
	{
		try
		{
			excludeOutOfStock.click();
			Thread.sleep(3000);

			System.out.println("-------> List of bookshelves Excluding out of stock <-------");

			int i=0;
			for(WebElement products : list1) 
			{
				i++;
				String for2 = ( i + " -> " +products.getText().toString());
				if(i<4) 
				{
					System.out.println(for2);
					System.out.println(" ");
				}
				else 
				{
					break;
				}
			}

			Screenshots.TakeScreenShot(driver);
			test1.log(Status.PASS, "Bookshelves excluding out of stock is printed");
			rep.flush();
		}
		catch(Exception e)
		{
			System.out.println("Error occured while printing bookshelves excluding out of stock");
		}
	}

}

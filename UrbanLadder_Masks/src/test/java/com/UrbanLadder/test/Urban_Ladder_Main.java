package com.UrbanLadder.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Reports.urbanLadder.ExtentReport;
import com.library.urbanLadder.ReusableMethods;
import com.library.urbanLadder.WebDriverSetup;
import com.pages.urbanLadder.BookShelves;
import com.pages.urbanLadder.Collections;
import com.pages.urbanLadder.GiftCards;
import com.pages.urbanLadder.StudyChairs;
import com.pages.urbanLadder.Verification;
import com.library.urbanLadder.Screenshots;

public class Urban_Ladder_Main {
	static WebDriver driver;
	static Properties properties;

	ReusableMethods reuse = new ReusableMethods(driver); 
	ExtentReport er=new ExtentReport();

	//to open browser
	@BeforeSuite(groups= {"smoke","Regression"})
	public void browser()
	{
		properties = reuse.fileReader();

		driver = WebDriverSetup.getWebDriver(properties.getProperty("browser"));        //get browser from test data properties
		driver.navigate().to(properties.getProperty("url"));
		Verification vf= new Verification(driver);                                      //get url from test data properties
		vf.applicationVerification();
	}

	//extent report
	@BeforeTest(groups= {"smoke","Regression"})
	public void extentReport() {
		er.extentReport();
	}

	//Book shelves
	@Test(priority = 1,groups= {"smoke","Regression"})
	public void BookShelves() throws InterruptedException
	{
		BookShelves bs = new BookShelves(driver);
		bs.selectBookShelves();
		bs.closePopUp();
		bs.price();
		bs.storageFilter();
		bs.getBookShelvesListIncludingOutOfStock();
		bs.getBookShelvesListExcludingOutOfStock();     

	}

	//Collections
	@Test(priority = 2,groups= {"Regression"})
	public void collection() throws InterruptedException
	{
		Collections cl = new Collections(driver);
		cl.clickCollections();
		cl.clickBestSellers();
		cl.listOfBestSellers();
	}

	//Study Chairs
	@Test(priority = 3,groups= {"smoke","Regression"})
	public void study() throws IOException, InterruptedException
	{
		StudyChairs sc = new StudyChairs(driver);
		sc.readData();
		sc.searchBar();
		sc.category();
		sc.listOfStudyChairs();  
	}

	//GiftCards
	@Test(priority = 4,groups= {"Regression"})
	public void giftcards() throws InterruptedException, IOException
	{
		GiftCards gc = new GiftCards(driver);
		gc.readData();
		gc.giftCard();
		gc.giftCardForm();


	}

	//to close browser
	@AfterSuite(groups= {"smoke","Regression"})
	public void closeBrowser() {
		driver.quit();
	}

}

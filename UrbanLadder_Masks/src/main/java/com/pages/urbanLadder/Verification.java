package com.pages.urbanLadder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.library.urbanLadder.Screenshots;

public class Verification {

	public WebDriver driver;

	public Verification(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//to verify whether the entered application is UrbanLadder or another site
	public void applicationVerification() 
	{
		try
		{
			String PageTitle=driver.getTitle();
			if(PageTitle.contains("Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder"))
			{
				System.out.println("Entered Application is Urban Ladder");
				Screenshots.TakeScreenShot(driver);
			}
			else
			{
				System.out.println("Error occured the application is not Urban Ladder");
			}

		}
		catch(Exception e)
		{
			System.out.println("Error while opening the application");
		}
	}
}

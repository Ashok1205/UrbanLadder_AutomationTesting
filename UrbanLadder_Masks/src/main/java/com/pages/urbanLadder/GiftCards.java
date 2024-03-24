package com.pages.urbanLadder;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Reports.urbanLadder.ExtentReport;
import com.aventstack.extentreports.Status;
import com.library.urbanLadder.ReusableMethods;
import com.library.urbanLadder.Screenshots;

public class GiftCards extends ExtentReport{

	public WebDriver driver;
	static String[] data = new String [10];
	ReusableMethods rm = new  ReusableMethods(driver);
	ExtentReport er=new ExtentReport();

	@FindBy(xpath="//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement headerGiftCards;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[1]/ul/li[3]")
	WebElement bAndA;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[2]/div/section[2]/div[1]/button[1]")
	WebElement amount;
	@FindBy(id="ip_2251506436")
	WebElement amountEnter;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[2]/div/section[2]/div[4]/select[1]")
	WebElement monthAndYear;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[2]/div/section[2]/div[4]/select[2]")
	WebElement date;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[2]/div/section[2]/button")
	WebElement nextBtn;

	@FindBy(name="recipient_name")
	WebElement recName;
	@FindBy(name="recipient_email")
	WebElement recMail;
	@FindBy(name="customer_name")
	WebElement sendName;
	@FindBy(name="customer_email")
	WebElement sendMail;
	@FindBy(name="customer_mobile_number")
	WebElement sendPhone;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[3]/form/button")
	WebElement confirmBtn;


	public GiftCards(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void readData() throws IOException {
		data=rm.readExcelData("Giftcard");
	}

	//to select gift card as Anniversary/Birthday
	public void giftCard() throws InterruptedException {
		try {
			driver.navigate().to("https://www.urbanladder.com");

			Thread.sleep(3000);
			headerGiftCards.click();                                                //to select giftcards in the home page
			bAndA.click();                                                          //to select birthday and anniversary
			amount.click();                                                         //to select amount
			amountEnter.sendKeys("1500");                                           //to enter amount
			monthAndYear.click();                                                   //to select month and year
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}

			date.click();                                                               //to select date
			Robot robot1;
			try {
				robot1 = new Robot();
				robot1.keyPress(KeyEvent.VK_UP);
				robot1.keyRelease(KeyEvent.VK_UP);
				robot1.keyPress(KeyEvent.VK_ENTER);
				robot1.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			Screenshots.TakeScreenShot(driver);
			nextBtn.click();
			test4.log(Status.PASS,"Anniversary/Birthday gift card is selected and details entered" );
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while selecting Anniversary/Birthday gift card");
			e.printStackTrace();
		}

	}

	//to enter details in the gift card form
	public void giftCardForm() throws InterruptedException {

		try
		{
			Thread.sleep(3000);
			recName.sendKeys(data[0]);                                                //to enter the name of the recipient
			recMail.sendKeys(data[1]);                                               //to enter the mail of the recipient
			sendName.sendKeys(data[2]);                                               //to enter the name of the sender
			sendMail.sendKeys(data[3]);                                               //to enter the mail of the sender
			sendPhone.sendKeys(data[4]);                                              //to enter the phone number of the sender
			confirmBtn.click();                                                       //to click the confirm button

			Thread.sleep(2000);
			Screenshots.TakeScreenShot(driver);
			Thread.sleep(3000);

			test4.log(Status.PASS,"Form details are entered" );
			rep.flush();
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while entering form details");
		}
	}

}

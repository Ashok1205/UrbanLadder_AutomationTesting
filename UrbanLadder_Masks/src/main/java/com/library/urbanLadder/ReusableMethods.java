package com.library.urbanLadder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Reports.urbanLadder.ExtentReport;

public class ReusableMethods extends ExtentReport{
	public WebDriver driver;

	public ReusableMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public Properties fileReader() 
	{
		FileReader reader=null;

		//to read the test data properties file
		try 
		{
			reader= new FileReader(".\\Properties\\data.properties");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		//properties to load the file
		Properties properties = new Properties();

		//loading the test data properties file
		try 
		{
			properties.load(reader);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return properties;
	}

	//to read data from excel
	public String[] readExcelData(String sheetName) throws IOException {
		File file=new File("./Properties/Urbanladder.xlsx");
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet(sheetName);
		String [] Data = null;
		//to get data from sheet search
		if(sheetName=="Search") 
		{
			Data = new String[2];
			XSSFRow row = sheet.getRow(1);
			for(int i=0;i<2;i++)
			{
				XSSFCell cell = row.getCell(i);
				Data[i]=row.getCell(0).toString();
			}
		}
		//to get data from sheet gift cards
		else if(sheetName=="Giftcard") 
		{
			Data = new String[5];
			XSSFRow row = sheet.getRow(1);

			for (int i=0;i<5;i++)
			{
				XSSFCell cell = row.getCell(i);
				CellType type = cell.getCellType();

				if(type.equals("NUMERIC"))
				{
					Data[i]=row.getCell(i).getNumericCellValue()+"";
				}
				else
				{
					Data[i]=row.getCell(i).toString();
				}
			}
		}
		else
		{
			System.out.println("Invalid sheet name");	
		}

		return Data;

	}

}

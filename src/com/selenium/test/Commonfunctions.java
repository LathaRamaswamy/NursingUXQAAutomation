package com.selenium.test;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
//import java.security.Timestamp;
import java.sql.Timestamp;
import java.util.ArrayList;
//import javax.swing.JOptionPane;
import java.util.List;
import java.util.Date;

import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.codec.digest.DigestUtils;
/*import java.text.SimpleDateFormat;
 import java.util.Calendar;
 */
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.selenium.util.ReportAttributes;

public class Commonfunctions {
	static String startTime = null;
	public static WebDriver driver;
	public static String status;
	public static String SNo;
	public static String TCID;
	public static String TCName;
	public static String TCDescription;
	public static String FunctionName;
	public static String ElementType;
	public static String IdentifyBy;
	public static String Locator;
	public static String ValueToType;
	public static String RunMode;

	public static String countryName;
	
	public static FirefoxProfile fxProfile ;
    
	public static String basePath = System.getProperty("user.dir");

	/*public static String openbrowser_firefox(ReportAttributes ra)
			throws Exception {
		status = "Skip";
		driver = new FirefoxDriver();
		Thread.sleep(1000);
		try {
			status = "Pass";
		}

		catch (Exception e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}*/

	public static String openurl(ReportAttributes ra) {
		status = "Skip";

		try {
			System.out.println(" start Commonfunctions --> openurl");
			System.out.println(" start Commonfunctions --> openurl driver "+driver);
			driver.get(ra.getValueToType());
			Thread.sleep(1000);
			status = "Pass";
			System.out.println(" End Commonfunctions --> openurl");
		}

		catch (Throwable e) {
			
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(" Error Commonfunctions --> openurl"+e.getMessage());
		}
		return status;

	}

	public static String windowmaximise(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.manage().window().maximize();
			Thread.sleep(1000);
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String gettitle(ReportAttributes ra) {
		status = "Skip";
		try {
			String Title = driver.getTitle();
			System.out.println("The current Title of the page is :" + Title);
			status = "Pass";
		}

		catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println("Title not found");
		}
		return status;
	}

	public static String getcurrenturl(ReportAttributes ra) {
		status = "Skip";
		try {
			String URL = driver.getCurrentUrl();
			System.out.println("The current url of the page is :" + URL);
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println("URL not found");
		}
		return status;
	}

	/*public static String getPageReference(ReportAttributes ra)
	{
		status = "Skip";
				
		try 
		{
			String strVal = ra.getValueToType();
			String[] temp = strVal.split("~");
			String slideTitle = temp[1];
			String path = temp[0];
			System.out.println(slideTitle);
			System.out.println(path);
			
			//FileInputStream fi = new FileInputStream("E:\\S1HY_MASTER_INDEX_2014_04_17_JK.xls");
			FileInputStream fi = new FileInputStream(path);		
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet sheet = wb.getSheet(1);
			
			
			for (int i = 0; i < sheet.getRows(); i++) 
            {
                Cell cell = sheet.getCell(6, i);
                System.out.println(cell.getContents());
                //if (cell.getContents().contains("Neural Tube Defects"))
                if (cell.getContents().contains(slideTitle))               	
                	{
                	List slideList = new ArrayList();
                	
                	System.out.println("i value is " + i);	
                	Cell cellFirst=sheet.getCell(9, i);
                	String strFirst = "First Aid 2014: pp. "+ cellFirst.getContents();
                	slideList.add(strFirst);
                	System.out.println(strFirst);
                	
                	Cell cellSecond= sheet.getCell(10, i);
                	String strSecond = "First Aid 2013: pp. "+ cellSecond.getContents();
                	slideList.add(strSecond);
                	System.out.println(strSecond);
                	
                	Cell cellThird=sheet.getCell(11, i);
                	String strThird = "First Aid 2012: pp. "+ cellThird.getContents();
                	slideList.add(strThird);
                	System.out.println(strThird);
                	
                	Cell cellFourth= sheet.getCell(12, i);
                	String strFourth = "First Aid 2011: pp. "+ cellFourth.getContents();
                	slideList.add(strFourth);
                	System.out.println(strFourth);
                	
                	Cell cellFifth=sheet.getCell(13, i);
                	String strFifth = "MedEssentials 4th Ed: pp. "+ cellFifth.getContents();
                	slideList.add(strFifth);
                	System.out.println(strFifth);
                	
                	Cell cellSixth= sheet.getCell(14, i);
                	String strSixth = "MedEssentials 3rd ed: pp."+ cellSixth.getContents();
                	slideList.add(strSixth);
                	System.out.println(strSixth);
                	
                	Cell cellSeventh=sheet.getCell(15, i);
                	String strSeventh = "Pathoma: pp. "+ cellSeventh.getContents();
                	slideList.add(strSeventh);
                	System.out.println(strSeventh);
                	
                	                	
                	List<WebElement> itemList = driver.findElements(By.xpath(ra.getLocator()));
                	               	
                	for (int j = 0; j < slideList.size(); j++) 
                	{
                		if (itemList.get(i).getText()!=slideList.get(j).toString())
                		{
                			status = "Fail";
                			break;
                		}
                		
                	}
                	
                	break;
                	                		
                	}
                	}
			
			status = "Pass";
		} 
		catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println("pagesource not found");
			e.getMessage();
		}
		return status;

	}
*/
			
	public static String verify_Text(ReportAttributes ra) 
	{
		status = "Fail";

		try {
			Thread.sleep(4000);
			String element1 = ra.getValueToType().toString().trim();
			System.out.println("the element1 value here is........." + element1);

			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) 
			{

				String element2 = driver.findElement(By.xpath(ra.getLocator())).getText().toString().trim();
				System.out.println("the element2 value here is........."+ element2);
				
				if (element1.equalsIgnoreCase(element2)) 
				{
					
					status = "Pass";
				}

			}

			else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {

				String element2 = driver.findElement(By.id(ra.getLocator()))
						.getText();
				System.out.println("the element2 value here is........."
						+ element2);
				if (element1.equalsIgnoreCase(element2))
				{
					status = "Pass";
				}

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) 
				
				
			{

				String element2 = driver.findElement(By.name(ra.getLocator()))
						.getText();
				System.out.println("the element2 value here is........."
						+ element2);
				if (element1.equalsIgnoreCase(element2))
				{
					status = "Pass";
				}
			}

			System.out.println("Result is " + status);
			status = "Pass";
		} 
		
		catch (Exception e) 
		{
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
			
		}
		return status;

	}

	
	public static String compare_Files(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
						
			String[] input = ra.getValueToType().split("~");
			String candiadatefilepath = input[0];
			System.out.println(candiadatefilepath);
			String baselinefilepath = input[1];
			System.out.println(baselinefilepath);
			
			String checksum1 = DigestUtils.md5Hex(new FileInputStream(candiadatefilepath));
			System.out.println(checksum1);
			String checksum2 = DigestUtils.md5Hex(new FileInputStream(baselinefilepath));
			System.out.println(checksum2);
			if (checksum1.equalsIgnoreCase(checksum2))
			{
				status = "Pass";
			}
			else
				
			{
				status = "Fail";
			}
			
		} catch (Exception e) {
			status = "Fail";
			//takeScreenShotOnFailure(ra);
			//System.out.println(e.getMessage());
			//org.testng.Assert.fail("The Element is not available");
		}
		return status;

	}
	
		
	public static String verifyelement_isDisplayed(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				if (driver.findElement(By.xpath(ra.getLocator())).isDisplayed())
					;

			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				if (driver.findElement(By.id(ra.getLocator())).isDisplayed())
					;

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				if (driver.findElement(By.name(ra.getLocator())).isDisplayed())
					;
			}
			System.out.println("Result is " + status);
			status = "Pass";
		} catch (Exception e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
			org.testng.Assert.fail("The Element is not available");
		}
		return status;

	}
	
	
	public static String navigate_back(ReportAttributes ra) 
	{
		status = "Skip";
		try {
				Thread.sleep(4000);
				driver.navigate().back();
				status = "Pass";
			}
		catch (Exception e) 
		{
				status = "Fail";
				takeScreenShotOnFailure(ra);
				System.out.println(e.getMessage());
				org.testng.Assert.fail("The Page is not available");
		}
		return status;

	}

	public static String typeinEditbox(ReportAttributes ra) {
		status = "Skip";
//		if(ra.getValueToType().equalsIgnoreCase("Rajesh1"))
//		{
//			System.out.println("Debugg!!");
//			System.out.println("displayed="+driver.findElement(By.xpath(ra.getLocator())).isDisplayed());
//			System.out.println("displayed="+driver.findElement(By.xpath(ra.getLocator())).isEnabled());
//		}
		try {
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath(ra.getLocator())).clear();
				driver.findElement(By.xpath(ra.getLocator())).sendKeys(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				Thread.sleep(1000);
				driver.findElement(By.id(ra.getLocator())).clear();
				driver.findElement(By.id(ra.getLocator())).sendKeys(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				Thread.sleep(1000);
				driver.findElement(By.name(ra.getLocator())).clear();
				driver.findElement(By.name(ra.getLocator())).sendKeys(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("css")) {
				Thread.sleep(1000);
				driver.findElement(By.name(ra.getLocator())).clear();
				driver.findElement(By.name(ra.getLocator())).sendKeys(ra.getValueToType());
			}

			status = "Pass";

		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	
	
	public static String Select_Questions_Checkbox(ReportAttributes ra) 
	{
		status = "Skip";
	
		try 
		{
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) 
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath(ra.getLocator().replace("replace_this", ra.getValueToType()))).click();//ra.getValueToType()
			} 
			
			/*else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				Thread.sleep(1000);
				driver.findElement(By.id(ra.getLocator())).clear();
				driver.findElement(By.id(ra.getLocator())).sendKeys(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				Thread.sleep(1000);
				driver.findElement(By.name(ra.getLocator())).clear();
				driver.findElement(By.name(ra.getLocator())).sendKeys(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("css")) {
				Thread.sleep(1000);
				driver.findElement(By.name(ra.getLocator())).clear();
				driver.findElement(By.name(ra.getLocator())).sendKeys(ra.getValueToType());
			}*/

			status = "Pass";

		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String dropdown_selectCountry(ReportAttributes ra) {
		status = "Skip";
		try {
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				Select dropdown = new Select(driver.findElement(By.xpath(ra
						.getLocator())));
				// dropdown.selectByValue(ra.getValueToType());
				dropdown.selectByVisibleText(ra.getValueToType());
				dropdown.selectByValue(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				Select dropdown = new Select(driver.findElement(By.id(ra
						.getLocator())));
				// dropdown.selectByValue(ra.getValueToType());
				dropdown.selectByVisibleText(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				Select dropdown = new Select(driver.findElement(By.name(ra
						.getLocator())));
				// dropdown.selectByValue(ra.getValueToType());
				dropdown.selectByVisibleText(ra.getValueToType());
			}
			status = "Pass";

			countryName = ra.getValueToType();
			System.out.println("the element3 value here is........."
					+ countryName);

		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}

	public static String selectState(ReportAttributes ra) {

		status = "Skip";
		try {
			if (countryName.equalsIgnoreCase("United States")) {
				String getUSALocator = "ctl00_ContentPlaceHolder1_ucAddress_ddState";

				if (ra.getIdentifyBy().equalsIgnoreCase("xpath"))
				{
					Select dropdown = new Select(driver.findElement(By
							.xpath(getUSALocator)));
					// dropdown.selectByValue(ra.getValueToType());
					dropdown.selectByVisibleText(ra.getValueToType());
					dropdown.selectByValue(ra.getValueToType());
				} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
					Select dropdown = new Select(driver.findElement(By
							.id(getUSALocator)));
					// dropdown.selectByValue(ra.getValueToType());
					dropdown.selectByVisibleText(ra.getValueToType());
				} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
					Select dropdown = new Select(driver.findElement(By
							.name(getUSALocator)));
					// dropdown.selectByValue(ra.getValueToType());
					dropdown.selectByVisibleText(ra.getValueToType());
				}
			}
			else 
			{
				String getOtherLocator = "ctl00_ContentPlaceHolder1_ucAddress_txtState";
				if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath(getOtherLocator)).clear();
					driver.findElement(By.xpath(getOtherLocator)).sendKeys(
							ra.getValueToType());
				} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
					Thread.sleep(1000);
					driver.findElement(By.id(getOtherLocator)).clear();
					driver.findElement(By.id(getOtherLocator)).sendKeys(
							ra.getValueToType());
				} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
					Thread.sleep(1000);
					driver.findElement(By.name(getOtherLocator)).clear();
					driver.findElement(By.name(getOtherLocator)).sendKeys(
							ra.getValueToType());
				} else if (ra.getIdentifyBy().equalsIgnoreCase("css")) {
					Thread.sleep(1000);
					driver.findElement(By.name(getOtherLocator)).clear();
					driver.findElement(By.name(getOtherLocator)).sendKeys(
							ra.getValueToType());
				}

			}

			status = "Pass";

		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String Clear_Text(ReportAttributes ra) {
		status = "Skip";
		try {
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				Thread.sleep(1000);
				driver.findElement(By.xpath(ra.getLocator())).clear();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				Thread.sleep(1000);
				driver.findElement(By.id(ra.getLocator())).clear();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				Thread.sleep(1000);
				driver.findElement(By.name(ra.getLocator())).clear();

			}

			else if (ra.getIdentifyBy().equalsIgnoreCase("css")) {
				Thread.sleep(1000);
				driver.findElement(By.name(ra.getLocator())).clear();

			}
			status = "Pass";

		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	
	public static String clearFiles(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			File directory = new File(ra.getValueToType());
			System.out.println(ra.getValueToType());
			FileUtils.cleanDirectory(directory);
			System.out.println("File deleted");
	/*	if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(ra.getLocator())).click();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				driver.findElement(By.id(ra.getLocator())).click();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				driver.findElement(By.name(ra.getLocator())).click();
			} */
			status = "Pass"; 
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.fail("Unable to click on the " +
			// ra.getElementType());
			//takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}
	
		
	public static String WE_click(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			
			//System.out.println(ra.getLocator());
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(ra.getLocator())).click();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				driver.findElement(By.id(ra.getLocator())).click();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				driver.findElement(By.name(ra.getLocator())).click();
			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.fail("Unable to click on the " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String link_click(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(ra.getLocator())).click();

			}
			else if (ra.getIdentifyBy().equalsIgnoreCase("id")) 
			{
				//System.out.println(ra.getLocator()+"****************************");
				driver.findElement(By.id(ra.getLocator())).click();

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				driver.findElement(By.name(ra.getLocator())).click();
			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String dropdown_click(ReportAttributes ra) {
		//status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				//String j =ra.getValueToType();
				int j = Integer.valueOf(ra.getValueToType());
				
				for (int i = 0; i <= j; i++)
				{
					//System.out.println("i value " + j);
					//j = j + 1;
					driver.findElement(By.id(ra.getLocator())).click();
				}
				
				//listitem0innerListBoxjqxInstitution
			} 
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	
	public static String dropdown_select(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				Select dropdown = new Select(driver.findElement(By.xpath(ra
						.getLocator())));
				// dropdown.selectByValue(ra.getValueToType());
				System.out.println(ra.getLocator()+" Drop Down******************");
				dropdown.selectByVisibleText(ra.getValueToType());
				dropdown.selectByValue(ra.getValueToType());

			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				Select dropdown = new Select(driver.findElement(By.id(ra
						.getLocator())));
				// dropdown.selectByValue(ra.getValueToType());
				dropdown.selectByVisibleText(ra.getValueToType());
			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				Select dropdown = new Select(driver.findElement(By.name(ra
						.getLocator())));
				// dropdown.selectByValue(ra.getValueToType());
				dropdown.selectByVisibleText(ra.getValueToType());
			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}

		
	public static String get_Table_Contents(ReportAttributes ra) {
		status = "Skip";
		List<String> listExcel=null;
		List<String> listItems=null;
		List<String> listFailedExcel= null;
		List<String> listFailedItem = null;
		
		//List<String>itemList= null;
		try {
			Thread.sleep(4000);
			
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				
				//listItems = new ArrayList<String>();
				//List<String> listItems  = driver.findElements(By.xpath(ra.getLocator()));
				
				//for (int i = 0; i < listItems.size(); i++)
				//		System.out.println ("List of Items" + listItems.get(i).getText());
				WebElement tableElement = driver.findElement(By.xpath(ra.getLocator()));
				//List<WebElement> rows = tableElement.findElements(By.tagName("th"));
				//System.out.println(rows.get(1).getText());
				listItems = new ArrayList<String>();			
				List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
				for(WebElement row : rows){
					List<WebElement> columns = row.findElements(By.tagName("td"));
					for(WebElement column : columns) {
						 System.out.println("Table Data " + column.getText());
						 listItems.add(column.getText());
						 						 
					}
								
				}
	
				//Add Excel reading
				String[] input = ra.getValueToType().split("~");
				String path = input[0];
				System.out.println(path);
				String sheetname = input[1];
				System.out.println(sheetname);
				
				
				FileInputStream fi = new FileInputStream(path);
				Workbook w = Workbook.getWorkbook(fi);
				Sheet s = w.getSheet(sheetname);
				
				System.out.println("Rows  =" + s.getRows());
				
				int Noofcols = s.getColumns();
				int Noofrows = s.getRows();
				System.out.println("Cols  =" + Noofcols);
				
				listExcel = new ArrayList<String>();
				
				String celldata;
				
				for (int row = 1; row<= s.getRows() -1 ; row++) 
				{
				
				for (int col = 0; col <= s.getColumns() - 1; col++) 
					{
					 celldata = (s.getCell(col, row)).getContents().toString();
					System.out.println ("celldata  " + celldata);
					 				 
					 listExcel.add(celldata);
					}
					
				}
				//Comparison
				System.out.println(listExcel.size());
				System.out.println(listItems.size());
				listFailedExcel = new ArrayList<String>();
				listFailedItem = new ArrayList<String>();
				
				if (listExcel.size() == listItems.size())
					
				{
		
					//System.out.println(listExcel.size());
					//System.out.println(listItems.size());
				for (int k = 0; k < listExcel.size(); k++)
																
					//if (listExcel.get(k).toString().trim() == listItems.get(k).toString().trim())
					if (listExcel.get(k).toString().trim().equalsIgnoreCase(listItems.get(k).toString().trim()))
					{
						System.out.println("Pass"+ k);
						System.out.println(listExcel.get(k).toString());
						System.out.println(listItems.get(k).toString());
						if (status != "Fail")
							status = "Pass";
					}	
					else
					{
					//System.out.println("10");
					System.out.println("Excel " + listExcel.get(k).toString());
					System.out.println("Table " + listItems.get(k).toString());
					//tempExcel=listExcel.get(k).toString();
					//tempTable= listItems.get(k).toString();
					System.out.println("Fail"+ k);
					
					System.out.println(TCName);
					//listFailedExcel.add(tempExcel);
					listFailedExcel.add(listExcel.get(k).toString());
					//System.out.println(listExcel.get(k).toString());
					listFailedItem.add(listItems.get(k).toString());
					//System.out.println(listItems.get(k).toString());
					status= "Fail";
					System.out.println("Added Failed");
					//Commented for Failing Reports
					//break;
					//Commented for Failing Reports
					}
				
				 if (status == "Fail");
				 System.out.println("Inside Fail");
				 //System.out.println("Failed Excel" +listFailedExcel.size());
				 //System.out.println("Failed Item" + listFailedItem.size());
				 //System.out.println("Before Function");
				 write_Failed_Cells(listFailedExcel,listFailedItem,ra.getTCName());
				}
				else
				{
		
			//status= "Fail";
			//break;
				}	
									
					
			} 
			//status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}
	
	public static void write_Failed_Cells(List listFailedExcel, List listFailedItem, String TCName ) {
		//status = "Skip";
		try {
			//Thread.sleep(4000);
			java.util.Date date= new java.util.Date();
			Timestamp ts_now = new Timestamp(date.getTime());			
						
			String path = System.getProperty("user.dir")+ "\\Reports\\" + "Reports.xls";
			System.out.println("");
			File file = new File(path);
			WorkbookSettings wbSettings = new WorkbookSettings();
		    WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		    workbook.createSheet(TCName, 0);
		    WritableSheet excelSheet = workbook.getSheet(0);
		    createLabel(excelSheet);
		    createContent(excelSheet,listFailedExcel,listFailedItem,TCName);

		    workbook.write();
		    workbook.close();
					
			
		} catch (Exception e) {
			//status = "Fail";
			System.out.println(e.getMessage());
			}
		

	}
		
	public static void createLabel(WritableSheet sheet){
		
		try {
			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		    // Define the cell format
		    WritableCellFormat times = new WritableCellFormat(times10pt);
		    // Lets automatically wrap the cells
		    times.setWrap(true);
		    CellView cv = new CellView();
		    cv.setFormat(times);
		    CellFormat timesBoldUnderline = null;
			cv.setFormat(timesBoldUnderline);
		    cv.setAutosize(true);

		
	}
		catch (Exception e) {
			//status = "Fail";
			System.out.println(e.getMessage());
			}
	}
public static void createContent(WritableSheet sheet,List listFailedExcel, List listFailedItem, String TCName ){
		
	try {
		System.out.println("Inside createcontent");
		System.out.println(listFailedExcel.size());
		System.out.println(listFailedItem.size());
		int k=0;
		/*for (int i=0; i < listFailedExcel.size(); i++)
		{
			//System.out.println(listFailedExcel.get(i).toString());
			System.out.println(listFailedItem.get(i).toString());
		}*/	
			//addLabel(sheet,0,0,"#");
			addLabel(sheet,0,0,"Expected Value");
			addLabel(sheet,1,0,"Actual Value");
			//for (int n=0; n < listFailedExcel.size(); n++ );
				//addLabel(sheet,0,k+1,String.valueOf(k+1));
			
			for (int i=0; i < listFailedExcel.size(); i++)
				//System.out.println(listFailedExcel.get(i).toString());
				addLabel(sheet,0,i+1,listFailedExcel.get(i).toString());
				//addLabel(sheet,0,i+1,i+1);
				
			for (int j=0; j < listFailedItem.size(); j++)
				//System.out.println(listFailedItem.get(j).toString());
				addLabel(sheet,1,j+1,listFailedItem.get(j).toString());
		//}
		
			
	}
	catch (Exception e) {
		//status = "Fail";
		System.out.println(e.getMessage());
		}
	
}

private static void addLabel(WritableSheet sheet, int column, int row, String s){
	      //throws WriteException, RowsExceededException
	try {
	    Label label;
	    //label = new Label(column, row, s, times);
	    label = new Label(column, row, s);
	    //label= new Label(column,row,)
	    sheet.addCell(label);
	  }

	catch (Exception e) {
		//status = "Fail";
		System.out.println(e.getMessage());
		}
}

	public static String get_grid_Contents(ReportAttributes ra) {
		status = "Skip";
		List<String> listExcel=null;
		//List<String> listItems=null;
		List<String> listFailedExcel= null;
		List<String> listFailedItem = null;
		try {
			Thread.sleep(4000);
			List<WebElement> itemList = driver.findElements(By.xpath(ra.getLocator()));
			for (int i = 0; i < itemList.size(); i++)
			System.out.println ("Items " + itemList.get(i).getText());
			
			String[] input = ra.getValueToType().split("~");
			String path = input[0];
			System.out.println(path);
			String sheetname = input[1];
			System.out.println(sheetname);
			
			
			FileInputStream fi = new FileInputStream(path);
			Workbook w = Workbook.getWorkbook(fi);
			Sheet s = w.getSheet(sheetname);
			
			System.out.println("Rows  =" + s.getRows());
			
			int Noofcols = s.getColumns();
			int Noofrows = s.getRows();
			System.out.println("Cols  =" + Noofcols);
			
			listExcel = new ArrayList<String>();
			
			String celldata;
			
			for (int row = 1; row<= s.getRows() -1 ; row++) 
			{
			
			for (int col = 0; col <= s.getColumns() - 1; col++) 
				{
				 celldata = (s.getCell(col, row)).getContents().toString();
				System.out.println ("celldata  " + celldata);
				 				 
				 listExcel.add(celldata);
				}
				
			}
			//Comparison
			System.out.println("List excel Size" + listExcel.size());
			System.out.println("List Items Size" + itemList.size());
			listFailedExcel = new ArrayList<String>();
			listFailedItem = new ArrayList<String>();
			
			if (listExcel.size() == itemList.size())
				
			{
	
				//System.out.println(listExcel.size());
				//System.out.println(listItems.size());
			for (int k = 0; k < listExcel.size(); k++)
															
				//if (listExcel.get(k).toString().trim() == listItems.get(k).toString().trim())
				if (listExcel.get(k).toString().trim().equalsIgnoreCase(itemList.get(k).getText().trim()))
				{
					System.out.println("Pass"+ k);
					System.out.println(listExcel.get(k).toString());
					System.out.println(itemList.get(k).getText());
					//Code changed for Writing failed cells
					if (status!= "Fail")
					{
					status = "Pass";
					}
					//Code change
				}	
				else
				{
				
				System.out.println(listExcel.get(k).toString());
				System.out.println(itemList.get(k).getText());
				System.out.println("Fail"+ k);	
				status= "Fail";
				//Commented for writing failed cells
				//break;
				// Comment ends
				}
			
			if (status == "Fail");
			 System.out.println("Inside Fail");
			 //System.out.println("Failed Excel" +listFailedExcel.size());
			 //System.out.println("Failed Item" + listFailedItem.size());
			 //System.out.println("Before Function");
			 write_Failed_Cells(listFailedExcel,listFailedItem,ra.getTCName());

			
			}
			else
			{
	
		//status= "Fail";
		//break;
			}	
			
			
			//status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			System.out.println(e.getMessage());
		}
		return status;
	}

		
	public static String get_grid_Header(ReportAttributes ra) {
		status = "Skip";
		List<String> listExcel=null;
		//List<String> listItems=null;
		try {
			Thread.sleep(4000);
			//System.out.println (" Inside get grid header");
			List<WebElement> itemList = driver.findElements(By.xpath(ra.getLocator()));
			for (int i = 0; i < itemList.size(); i++)
			System.out.println ("Items " + itemList.get(i).getText());
			
			String[] input = ra.getValueToType().split("~");
			String path = input[0];
			System.out.println(path);
			String sheetname = input[1];
			System.out.println(sheetname);
			
			FileInputStream fi = new FileInputStream(path);
			Workbook w = Workbook.getWorkbook(fi);
			Sheet s = w.getSheet(sheetname);
						
			listExcel = new ArrayList<String>();
			
			String celldata;
			
			
			for (int col = 0; col <= s.getColumns() - 1; col++) 
				{
				 celldata = (s.getCell(col, 0)).getContents().toString();
				System.out.println ("celldata  " + celldata);
				 				 
				 listExcel.add(celldata);
				}
				
			//Comparison
			System.out.println("List excel Size" + listExcel.size());
			System.out.println("List Items Size" + itemList.size());
			
			if (listExcel.size() == itemList.size())
				
			{
	
				//System.out.println(listExcel.size());
				//System.out.println(listItems.size());
			for (int k = 0; k < listExcel.size(); k++)
															
				//if (listExcel.get(k).toString().trim() == listItems.get(k).toString().trim())
				if (listExcel.get(k).toString().trim().equalsIgnoreCase(itemList.get(k).getText().trim()))
				{
					System.out.println("Pass"+ k);
					System.out.println(listExcel.get(k).toString());
					System.out.println(itemList.get(k).getText());
					status = "Pass";
				}	
				else
				{
				//System.out.println("10");
				System.out.println(listExcel.get(k).toString());
				System.out.println(itemList.get(k).getText());
				System.out.println("Fail "+ k);	
				status= "Fail";
				break;
				}
			
			}
			else
			{
	
		status= "Fail";
		//break;
			}	
			
		//status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			System.out.println(e.getMessage());
		}
		
		
		return status;
	}
	
	public static String get_Header_Contents(ReportAttributes ra) {
		status = "Skip";
		List<String> listExcel=null;
		try {
			Thread.sleep(4000);
			//List<WebElement> itemList = driver.findElements(By.xpath(ra.getLocator()));
			
			WebElement tableElement = driver.findElement(By.xpath(ra.getLocator()));
			
			List<WebElement> itemList = tableElement.findElements(By.tagName("th"));
			System.out.println(itemList.size());
			for (int j = 0; j < itemList.size(); j++)
				
			{
				System.out.println (itemList.get(j).getText());
				
			} 
			
			//String path = ra.getValueToType();
			String[] Input = ra.getValueToType().split("~");
			
			String path =Input[0];
			String sheetname = Input[1]; 
			
			
			System.out.println(path);
			System.out.println(sheetname);
			
			FileInputStream fi = new FileInputStream(path);
			Workbook w = Workbook.getWorkbook(fi);
			//Sheet s = w.getSheet(0);
			Sheet s = w.getSheet(sheetname);
			
			System.out.println("Rows  =" + s.getRows());
			
			int Noofcols = s.getColumns();
			System.out.println("Cols  =" + Noofcols);
			
			listExcel = new ArrayList<String>();
			
			String celldata;
			
			for (int col = 0; col <= s.getColumns() - 1; col++) 
				{
				 celldata = (s.getCell(col, 0)).getContents().toString();
				 System.out.println ("celldata  " + celldata);
				 				 
				 listExcel.add(celldata);
				}
			
								
		//for (int k = 0; k < listExcel.size(); k++)
			
		//{
			//System.out.println (listExcel.get(k).toString());
			
	//	}
					
		//Stem.out.println (itemList.get(0).getText());
				//System.out.println (itemList.get(1).getText());
				//System.out.println (itemList.get(2).getText());
				//System.out.println (itemList.get(3).getText());
			
			
			//int k =0;
			//listExcel.get(k);
		/*System.out.println(listExcel.get(0).toString());
		System.out.println(itemList.get(0).getText());
		
		System.out.println(listExcel.get(1).toString());
		System.out.println(itemList.get(1).getText());
		
		
		System.out.println(listExcel.get(2).toString());
		System.out.println(itemList.get(2).getText());
		
		
		System.out.println(listExcel.get(3).toString());
		System.out.println(itemList.get(3).getText()); */
		
			System.out.println(listExcel.size());
			System.out.println(itemList.size());
		
			if (listExcel.size() == itemList.size())
				
					{
			
						//System.out.println(listExcel.size());
						//System.out.println(itemList.size());
					for (int k = 0; k < listExcel.size(); k++)
						//if !(listExcel.get(k).toString().trim().equalsIgnoreCase(""))
						//{
							if (listExcel.get(k).toString().trim().equalsIgnoreCase(itemList.get(k).getText()))
							{
								System.out.println("Pass"+ k);
								System.out.println(listExcel.get(k).toString());
								System.out.println(itemList.get(k).getText());
								status = "Pass";
							}	
							else
							{
						//System.out.println("10");
								//if (itemList.get(k).getText() == null)
								if (listExcel.get(k).toString().trim().contentEquals("__"))
								{
									//System.out.println("Inside loop");
									//if (listExcel.get(k).toString().trim().contentEquals("__"))
									//{	
									status = "Pass";
									//}
									//else
										
									//{
									//	status = "Fail";	
									//	break;
									//}
								}
								else
								{
								System.out.println(listExcel.get(k).toString());
								System.out.println(itemList.get(k).getText());
								System.out.println("Fail"+ k);	
								status= "Fail";
								break;
								
								}
							//}
							
						}
					
					}
			else
			{
			//	System.out.println(listExcel.size());
			//	System.out.println(itemList.size());
				//System.out.println("Fail"+ k);
				status= "Fail";
				//status = "Pass";
			}
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			//takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}
	
	
	public static String menu_DoubleClick(ReportAttributes ra) {
		status = "Skip";
		
		try {
			Thread.sleep(1000);
			 //Actions a =new Actions(driver);
			 //WebElement w=driver.findElement(By.xpath("//a[text()='Molecular Biology I']"));
			 //System.out.println(ra.getLocator()+ "Molecular Biology locator");
		     //a.moveToElement(w).doubleClick().perform();
		     //System.out.println("Double Clicked");
			 driver.findElement(By.xpath("//a[text()='Molecular Biology I']")).click();
			//driver.findElement(By.xpath(ra.getLocator())).click();
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}

	public static String compare_Product(ReportAttributes ra) {
		status = "Skip";
		
		try {
			Thread.sleep(4000);
			
			List<WebElement> itemList = driver.findElements(By.xpath(ra.getLocator()));
			for (int i = 0; i < itemList.size(); i++)
					System.out.println (itemList.get(i).getText());
								
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}
	
	public static String get_PageReference(ReportAttributes ra) {
		status = "Skip";
		
		try {
			Thread.sleep(4000);
			
			List<WebElement> itemList = driver.findElements(By.xpath(ra.getLocator()));
			for (int i = 0; i < itemList.size(); i++)
					System.out.println (itemList.get(i).getText());
								
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}
	
	
	public static String dropdown_div_select_test(ReportAttributes ra) {
		status = "Skip";
		
		try {
			Thread.sleep(4000);
			
			driver.findElement(By.id(ra.getLocator())).click();
			System.out.println (ra.getLocator());
			System.out.println (ra.getValueToType());
			driver.findElement(By.id(ra.getLocator())).sendKeys(ra.getValueToType()+Keys.RETURN);
			
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}
	
		
	
	public static String dropdown_div_select(ReportAttributes ra) {
		status = "Skip";
		
		try {
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(ra.getLocator())).click();
			System.out.println (ra.getLocator());
			System.out.println (ra.getValueToType());
			driver.findElement(By.xpath(ra.getLocator())).sendKeys(ra.getValueToType()+Keys.RETURN);
			
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}
	
	public static String dropdown_Product(ReportAttributes ra) {
		status = "Skip";
		String valuetoEnter=ra.getValueToType()+Keys.RETURN;
		try {
			Thread.sleep(4000);
			//driver.findElement(By.xpath("//div[@id='productName_chosen']")).click();
			driver.findElement(By.xpath("//div[@id='dropdownlistContentjqxInstitution']")).click();
			driver.findElement(By.xpath(ra.getLocator())).sendKeys(valuetoEnter);
			
								
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}

	
	public static String dropdown_selectbyindex(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) 
			{
				Select dropdown = new Select(driver.findElement(By.xpath(ra.getLocator())));
				dropdown.selectByIndex(0);
			} 
			else if (ra.getIdentifyBy().equalsIgnoreCase("id")) 
			{
				Select dropdown = new Select(driver.findElement(By.id(ra.getLocator())));
				dropdown.selectByIndex(0);
			} 
			else if (ra.getIdentifyBy().equalsIgnoreCase("name")) 
			{
				Select dropdown = new Select(driver.findElement(By.name(ra.getLocator())));
				dropdown.selectByIndex(0);
			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}

	public static String dropdown_selectbyvalue(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				Select dropdown = new Select(driver.findElement(By.xpath(ra
						.getLocator())));
				dropdown.selectByValue(ra.getValueToType());

			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				Select dropdown = new Select(driver.findElement(By.id(ra
						.getLocator())));
				dropdown.selectByValue(ra.getValueToType());

			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				Select dropdown = new Select(driver.findElement(By.name(ra
						.getLocator())));
				dropdown.selectByValue(ra.getValueToType());

			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.Fail("Unable to select an item in drop drop " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}
		return status;
	}

	public static String alert_accept(ReportAttributes ra) {
		status = "Skip";
		try {
			String AlertMessage = driver.switchTo().alert().getText();
			System.out.println("The alert message is :" + AlertMessage);
			driver.switchTo().alert().accept();
			status = "Pass";
		}

		catch (Throwable e) {
			status = "Fail";
			System.out.println("Alert not found");
			// org.testng.Assert.Fail("Unable to select ok button in alert box "
			// + ra.getElementType());
			takeScreenShotOnFailure(ra);

		}
		return status;
	}

	public static String alert_dismiss(ReportAttributes ra) {
		status = "Skip";
		try {
			String AlertMessage = driver.switchTo().alert().getText();
			System.out.println("The alert message is :" + AlertMessage);
			driver.switchTo().alert().dismiss();
			status = "Pass";

		} catch (Throwable e) {
			status = "Fail";
			System.out.println("Alert not found");
			// org.testng.Assert.Fail("Unable to select delete button in alert box "
			// + ra.getElementType());
			takeScreenShotOnFailure(ra);

		}

		return status;
	}

	public static String label_verify(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				if (driver.findElement(By.xpath(ra.getLocator())).isDisplayed())
					;
			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				if (driver.findElement(By.id(ra.getLocator())).isDisplayed())
					;
			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				if (driver.findElement(By.name(ra.getLocator())).isDisplayed())
					;
			}
			status = "Pass";
			System.out.println("Result is " + status);

		} catch (Exception e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
			// org.testng.Assert.Fail("The Element is not available");

		}

		return status;
	}

	public static String navigate_SubMenu(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			WebElement we = driver.findElement(By.xpath(ra.getLocator()));
			driver.navigate().to(we.getAttribute("href"));
			
			status = "Pass";
			System.out.println("Result is " + status);

		} catch (Exception e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
			// org.testng.Assert.Fail("The Element is not available");

		}

		return status;
	}

	
	
	public static String mouse_Over(ReportAttributes ra) {
		status = "Skip";
		try {
			Thread.sleep(4000);
			//old code
			//Actions action = new Actions(driver);
			//WebElement we = driver.findElement(By.id(ra.getLocator()));
			//action.moveToElement(we).build().perform();
			//old code
			//New code
			WebElement we = driver.findElement(By.xpath(ra.getLocator()));
			System.out.println(we.getAttribute("href"));
			System.out.println("Hello");
			driver.navigate().to(we.getAttribute("href"));
			
			//New code
			
			status = "Pass";
			System.out.println("Result is " + status);

		} catch (Exception e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
			// org.testng.Assert.Fail("The Element is not available");

		}

		return status;
	}

	
	
	public static String closepage(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.close();
			status = "Pass";

		} catch (Exception e) {
			status = "Fail";
			e.getMessage();
			takeScreenShotOnFailure(ra);
			System.out.println("Page is not closed");
		}
		return status;
	}

	public static String quitbrowser(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.quit();
			status = "Pass";

		} catch (Exception e) {
			status = "Fail";
			e.getMessage();
			takeScreenShotOnFailure(ra);
			System.out.println("browser is not closed");

		}
		return status;
	}

	public static String Refresh(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.navigate().refresh();
			status = "Pass";
		} catch (Throwable e) 
		{
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());

		}

		return status;
	}

	public static void Wait() throws Exception 
	{
		status = "Pass";
		Thread.sleep(2000);

	}
	
	public static void longWait() throws Exception 
	{
		status = "Pass";
		Thread.sleep(5000);

	}
	
	public static void LongWait() throws Exception 
	{
		status = "Pass";
		Thread.sleep(50000);

	}
	
	
	

	public static void takeScreenShotOnFailure(ReportAttributes ra) 
	{
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
			{
				FileUtils.copyFile(image,new File(System.getProperty("user.dir")+ "//Screenshots_On_Failure//" + ra.getTCName()+ "-" + ra.getTCSTEPNO() + ".jpg"));
			} 
		catch (Throwable e) 
			{
				e.printStackTrace();
			}
	}

	/*
	 * public static void takeScreenShotOnFailure(String filename) { File image
	 * = ((TakesScreenshot) driver) .getScreenshotAs(OutputType.FILE); try {
	 * FileUtils.copyFile(image, new File(System.getProperty("user.dir") +
	 * "//screenshots_on_Failure//" + filename + "_" + datetime("MMddyyhhmmss")
	 * + ".jpg")); } catch (Throwable e) { e.printStackTrace(); } }
	 */

	/*
	 * public static String datetime(String dateFormat) { Calendar cal =
	 * Calendar.getInstance(); SimpleDateFormat sdf = new
	 * SimpleDateFormat(dateFormat); return sdf.format(cal.getTime()); }
	 */
	/*
	 * public static void verifyElementExist(WebDriver driver, final By locator,
	 * String elementType) { try {
	 * element=getWebElement(driver,locator,elementType);
	 * 
	 * if (element.isDisplayed()) { if (element.isEnabled()) { return; } else {
	 * Assert.assertTrue(false,"The "+elementType+" is disabled"); } } else {
	 * Assert.assertTrue(false, "The "+ elementType + " not dispalyed"); }
	 * 
	 * } catch(Exception e) {
	 * org.testng.Assert.Fail("The"+elementType+"is not available"); } }
	 * 
	 * 
	 * 
	 * 
	 * public static void verifyDataFromSearch(WebDriver driver,final By
	 * locator,String elementType) { element=
	 * getWebElement(driver,locator,elementType); }
	 * 
	 * 
	 * 
	 * 
	 * public static Select verifyDataOfDropDown(WebDriver driver,final By
	 * locator,String elementType) {
	 * 
	 * 
	 * dropdown= new Select(GenericValidations.getWebElement(driver, locator,
	 * elementType)); if(dropdown.getOptions().size()==0)
	 * org.testng.Assert.Fail("No data avialable under "+elementType); else
	 * Assert.assertTrue(isDataInDropdownBoxSelected(dropdown),
	 * "No Default value selected in"+elementType); return dropdown; }
	 * 
	 * 
	 * 
	 * public static void verifyServiceLevelDropDownAndSelectSL(WebDriver
	 * driver,final By locator,String serviceLevel,String elementType) {
	 * 
	 * dropdown= new Select(GenericValidations.getWebElement(driver, locator,
	 * elementType));
	 * 
	 * if(dropdown.getOptions().size()==0)
	 * 
	 * org.testng.Assert.Fail("No data avialable under "+elementType); else
	 * 
	 * Assert.assertTrue(isDataInDropdownBoxSelected(dropdown),
	 * "No Default value selected in"+elementType);
	 * 
	 * if(dropdown.getFirstSelectedOption().getAttribute("value").equalsIgnoreCase
	 * ("None")) { try { dropdown.selectByValue(serviceLevel); } catch(Throwable
	 * t) { org.testng.Assert.Fail("Unable to select the Serive Level "
	 * +serviceLevel+" , as its not available under the dropdown"); }
	 * 
	 * } else return;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public static boolean isDataInDropdownBoxSelected(Select dropdown) {
	 * if(dropdown.getFirstSelectedOption().getText() != null) return true; else
	 * return false; }
	 */

	/*
	 * public static String verify_Text(ReportAttributes ra) { status = "Skip";
	 * try { Thread.sleep(4000); if
	 * (ra.getIdentifyBy().equalsIgnoreCase("xpath")) { if
	 * (driver.findElement(By
	 * .xpath(ra.getLocator())).getText().equalsIgnoreCase(
	 * ra.getValueToType()));
	 * 
	 * } else if (ra.getIdentifyBy().equalsIgnoreCase("id")) { if
	 * (driver.findElement
	 * (By.xpath(ra.getLocator())).getText().equalsIgnoreCase(
	 * ra.getValueToType()));
	 * 
	 * } else if (ra.getIdentifyBy().equalsIgnoreCase("name")) { if
	 * (driver.findElement
	 * (By.xpath(ra.getLocator())).getText().equalsIgnoreCase(
	 * ra.getValueToType())); } System.out.println("Result is " + status);
	 * status = "Pass"; } catch (Exception e) { status = "Fail"; //
	 * status="Fail"; takeScreenShotOnFailure(ra);
	 * System.out.println(e.getMessage());
	 * org.testng.Assert.Fail("The Text is not available"); } return status;
	 * 
	 * }
	 */
/*
	public static String navigate_forward(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.navigate().forward();
			String URL = driver.getCurrentUrl();
			System.out.println("The current url of the page is :" + URL);
			status = "Pass";
		}

		catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String navigate_back(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.navigate().back();
			String URL = driver.getCurrentUrl();
			System.out.println("The current url of the page is :" + URL);
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println("URL not found");
		}
		return status;
	}

	public static String drag_and_drop(ReportAttributes ra) {
		status = "Skip";
		try {

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);

			Actions act = new Actions(driver);
			WebElement src = driver.findElement(By
					.xpath("//div[@id='items']/div[1]"));
			WebElement des = driver.findElement(By.id("trash"));

			act.clickAndHold(src).build().perform(); // For each action we need
														// to build and Perform
			act.moveToElement(des).build().perform();
			act.release(des).build().perform();

			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);

		}
		return status;
	}

	public static String multiple_select_dropdown(ReportAttributes ra) {
		status = "Skip";
		try {
			if (ra.getIdentifyBy().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
				Select dropdown = new Select(driver.findElement(By.xpath(ra
						.getLocator())));
				dropdown.selectByIndex(0);
				dropdown.selectByIndex(100);
			} else if (ra.getIdentifyBy().equalsIgnoreCase("id")) {
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
				Select dropdown = new Select(driver.findElement(By.xpath(ra
						.getLocator())));
				dropdown.selectByIndex(0);
				dropdown.selectByIndex(100);
			} else if (ra.getIdentifyBy().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
				Select dropdown = new Select(driver.findElement(By.xpath(ra
						.getLocator())));
				dropdown.selectByIndex(0);
				dropdown.selectByIndex(100);
			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String Frames(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			java.util.List<WebElement> frames = driver.findElements(By
					.tagName("iframe")); // Frame List
			System.out.println(frames.size());
			for (int i = 0; i < frames.size(); i++) {
				System.out.println(frames.get(i).getAttribute("src"));
			}
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.fail("Unable to select frame " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String Particular_Frame(ReportAttributes ra) {
		status = "Skip";
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			java.util.List<WebElement> frames = driver.findElements(By
					.tagName("iframe"));
			System.out.println(frames.size());
			driver.switchTo().frame(0);
			driver.findElement(By.id("clicktripad")).click();
			status = "Pass";
		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.fail("Unable to select particular frame " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static String Windows_Hnadles(ReportAttributes ra) 
	{
		status = "Skip";

		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			java.util.Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> it = windowHandles.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				status = "Pass";
			}

		} catch (Throwable e) {
			status = "Fail";
			// org.testng.Assert.fail("Unable to select particular frame " +
			// ra.getElementType());
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
		}
		return status;
	}*/

	
	/*
	 * public static String Proxy_settings(ReportAttributes ra) { status =
	 * "Skip";
	 * 
	 * try { FirefoxProfile profile = new FirefoxProfile(); String PROXY =
	 * "xx.xx.xx.xx:xx"; Proxy proxy = new Proxy(); proxy.HttpProxy=PROXY;
	 * proxy.FtpProxy=PROXY; proxy.SslProxy=PROXY;
	 * profile.SetProxyPreferences(proxy); FirefoxDriver driver = new
	 * FirefoxDriver(profile);
	 * 
	 * 
	 * } catch (Throwable e) { status = "Fail";
	 * //org.testng.Assert.fail("Unable to select particular frame " +
	 * ra.getElementType()); takeScreenShotOnFailure(ra);
	 * System.out.println(e.getMessage()); } return status; }
	 */
	
	
	public static String Answer_Questions(ReportAttributes ra) 
	{
		
		   status = "Skip";
		
		   
		   try 
		   {
				   String str1 = ra.getValueToType();
				   String[] temp1;
				 
				 
				  /* delimiter */
				  String delimiter = "//";
				  
				  /* given string will be split by the argument delimiter provided. */
				  temp1 = str1.split(delimiter);
				  
			 
			  
				  for(int i =0; i < temp1.length ; i++)
				  {
					    System.out.println( i + "element is " +temp1[i]);
				  }
				  
			
				  for(int j=1 ; j<=5 ;j++)
				  {
					  
			    	//Text
			    
					    	try
						    	{
								 if(driver.findElement(By.xpath("//*[@type='text']")).isDisplayed())
									{
										System.out.println("Text started");
										System.out.println("the element type is text");
										driver.findElement(By.id("tx")).clear();
									    driver.findElement(By.id("tx")).sendKeys(temp1[0]);
									    driver.findElement(By.id("btnNext")).click();
									    System.out.println("Text ended");
									    continue;
									}
						    	}
					    	catch(Exception e)
						    	{
						    		System.out.println("not text");
						    	}
					    	
		    	//Radio Button
		    	
					    	try
						    	{
									if(driver.findElement(By.xpath("//*[@type='radio']")).isDisplayed())
									{
										System.out.println("Radio button started");
										System.out.println("the element type is radio");
										driver.findElement(By.id(temp1[1])).click();
									    driver.findElement(By.id("btnNext")).click();
									    System.out.println("Radio button ended");
									    continue;
									}
						    	}
					    	catch(Exception e)
						    	{
						    		System.out.println("not radio");
						    	}
					    	
					    	
		    	
		    	
		    	
		    	//Check Box
		    	
					    	try
						    	{
								 if(driver.findElement(By.xpath("//*[@type='checkbox']")).isDisplayed())
									{
											System.out.println("Check box Started");
											System.out.println("the element type is check box");
											driver.findElement(By.id(temp1[2])).click();
										    driver.findElement(By.id(temp1[3])).click();
										    driver.findElement(By.id("btnNext")).click();
										    System.out.println("Check box Ended");
										    continue;
									}
							    }
						    catch(Exception e)
						    	{
						    		System.out.println("not check box");
						    	}
		    	
		    	//Drag and Drop
		    	
					    	try{
							
								 if(driver.findElement(By.xpath("//*[@class='connectedSortable ui-sortable']")).isDisplayed())
									{
										 System.out.println("Sort Started");
										 System.out.println("the element type is sort");
										 
										 
										 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[4]))).click();
										 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
										 
										 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[5]))).click();
										 //driver.findElement(By.xpath(".//*[@id='sortable1']/li[2]/div")).click();
										 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
										 
										 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[6]))).click();
										 //driver.findElement(By.xpath(".//*[@id='sortable1']/li[3]/div")).click();
										 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
										 
										 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[7]))).click();
										// driver.findElement(By.xpath(".//*[@id='sortable1']/li[4]/div")).click();
										 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
										 
										 if(driver.findElement(By.xpath(".//*[@id='btnRight']")).isEnabled());
										 {
											 driver.findElement(By.xpath(".//*[@id='btnNext']")).click();
										 }
										 System.out.println("Sort Ended");
									     continue;
									}
					    		}
					    	
					    	catch(Exception e)
					    		{
					    			System.out.println("not sort");
					    		}
							
		    	
		    	//Hot Stop
		    	
				    	try
					    	{
						    	if(driver.findElement(By.xpath("//canvas")).isDisplayed())
									{
						    		
						    			System.out.println("Canvas Started");
						    			System.out.println("the element type is canvas");
										//org.openqa.selenium.Point coordinates =driver.findElement(By.xpath("//canvas")).getLocation();
										org.openqa.selenium.Point coordinates =driver.findElement(By.xpath(".//*[@id='resumeCanvasResponse']")).getLocation();
										
										System.out.println("Co-ordinates"+coordinates);	
										
										Robot robot = new Robot();
									
										
										 System.out.println(  "element is " +temp1[8]);
										 System.out.println(  "element is " +temp1[9]);
										 
										int newcoordinates1 = coordinates.getX()+Integer.parseInt(temp1[8]) ;
										int newcoordinates2 = coordinates.getY()+Integer.parseInt(temp1[9])  ;
												
										
										robot.mouseMove(newcoordinates1,newcoordinates2); 
										robot.mousePress(InputEvent.BUTTON3_MASK);
									    robot.mouseRelease(InputEvent.BUTTON3_MASK);
		
										
										driver.findElement(By.xpath(".//*[@id='btnNext']")).click();
										System.out.println("Canvas Ended");
										
										
										continue;
									}
					    	}
				    	catch(Exception e)
					    	{
					    		System.out.println("not sort");
					    	}
				  }
				  status = "Pass";
		   }
	
		   catch(Exception e)
	    	{
			    status = "Fail";
				takeScreenShotOnFailure(ra);
				System.out.println(e.getMessage());
	    	}
		return status;
	}



/*public static String Answer_2Questions(ReportAttributes ra) 
{
	
	   status = "Skip";
	
	   
	   try 
	   {
			   String str1 = ra.getValueToType();
			   String[] temp1;
			 
			 
			   delimiter 
			  String delimiter = "//";
			  
			   given string will be split by the argument delimiter provided. 
			  temp1 = str1.split(delimiter);
			  
		 
		  
			  for(int i =0; i < temp1.length ; i++)
			  {
				    System.out.println( i + "element is " +temp1[i]);
			  }
			  
		
			  for(int j=1 ; j<=2 ;j++)
			  {
				  
		    	//Text
		    
				    	try
					    	{
							 if(driver.findElement(By.xpath("//*[@type='text']")).isDisplayed())
								{
									System.out.println("Text started");
									System.out.println("the element type is text");
									driver.findElement(By.id("tx")).clear();
								    driver.findElement(By.id("tx")).sendKeys(temp1[0]);
								    driver.findElement(By.id("btnNext")).click();
								    System.out.println("Text ended");
								    continue;
								}
					    	}
				    	catch(Exception e)
					    	{
					    		System.out.println("not text");
					    	}
				    	
	    	//Radio Button
	    	
				    	try
					    	{
								if(driver.findElement(By.xpath("//*[@type='radio']")).isDisplayed())
								{
									System.out.println("Radio button started");
									System.out.println("the element type is radio");
									driver.findElement(By.id(temp1[1])).click();
								    driver.findElement(By.id("btnNext")).click();
								    System.out.println("Radio button ended");
								    continue;
								}
					    	}
				    	catch(Exception e)
					    	{
					    		System.out.println("not radio");
					    	}
				    	
				    	
	    	
	    	
	    	
	    	//Check Box
	    	
				    	try
					    	{
							 if(driver.findElement(By.xpath("//*[@type='checkbox']")).isDisplayed())
								{
										System.out.println("Check box Started");
										System.out.println("the element type is check box");
										driver.findElement(By.id(temp1[2])).click();
									    driver.findElement(By.id(temp1[3])).click();
									    driver.findElement(By.id("btnNext")).click();
									    System.out.println("Check box Ended");
									    continue;
								}
						    }
					    catch(Exception e)
					    	{
					    		System.out.println("not check box");
					    	}
	    	
	    	//Drag and Drop
	    	
				    	try{
						
							 if(driver.findElement(By.xpath("//*[@class='connectedSortable ui-sortable']")).isDisplayed())
								{
									 System.out.println("Sort Started");
									 System.out.println("the element type is sort");
									 
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[4]))).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[5]))).click();
									 //driver.findElement(By.xpath(".//*[@id='sortable1']/li[2]/div")).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[6]))).click();
									 //driver.findElement(By.xpath(".//*[@id='sortable1']/li[3]/div")).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[7]))).click();
									// driver.findElement(By.xpath(".//*[@id='sortable1']/li[4]/div")).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 if(driver.findElement(By.xpath(".//*[@id='btnRight']")).isEnabled());
									 {
										 driver.findElement(By.xpath(".//*[@id='btnNext']")).click();
									 }
									 System.out.println("Sort Ended");
								     continue;
								}
				    		}
				    	
				    	catch(Exception e)
				    		{
				    			System.out.println("not sort");
				    		}
						
	    	
	    	//Hot Stop
	    	
			    	try
				    	{
					    	if(driver.findElement(By.xpath("//canvas")).isDisplayed())
								{
					    		
					    			System.out.println("Canvas Started");
					    			System.out.println("the element type is canvas");
									//org.openqa.selenium.Point coordinates =driver.findElement(By.xpath("//canvas")).getLocation();
									org.openqa.selenium.Point coordinates =driver.findElement(By.xpath(".//*[@id='resumeCanvasResponse']")).getLocation();
									
									System.out.println("Co-ordinates"+coordinates);	
									
									Robot robot = new Robot();
								
									
									 System.out.println(  "element is " +temp1[8]);
									 System.out.println(  "element is " +temp1[9]);
									 
									int newcoordinates1 = coordinates.getX()+Integer.parseInt(temp1[8]) ;
									int newcoordinates2 = coordinates.getY()+Integer.parseInt(temp1[9])  ;
											
									
									robot.mouseMove(newcoordinates1,newcoordinates2); 
									robot.mousePress(InputEvent.BUTTON3_MASK);
								    robot.mouseRelease(InputEvent.BUTTON3_MASK);
	
									
									driver.findElement(By.xpath(".//*[@id='btnNext']")).click();
									System.out.println("Canvas Ended");
									
									
									continue;
								}
				    	}
			    	catch(Exception e)
				    	{
				    		System.out.println("not sort");
				    	}
			  }
			  status = "Pass";
	   }

	   catch(Exception e)
    	{
		    status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
    	}
	return status;
	}*/

public static String Answer_3Questions(ReportAttributes ra) 
{
	
	   status = "Skip";
	
	   
	   try 
	   {
			   String str1 = ra.getValueToType();
			   String[] temp1;
			 
			 
			  /* delimiter */
			  String delimiter = "//";
			  
			  /* given string will be split by the argument delimiter provided. */
			  temp1 = str1.split(delimiter);
			  
		 
		  
			  for(int i =0; i < temp1.length ; i++)
			  {
				    System.out.println( i + "element is " +temp1[i]);
			  }
			  
		
			  for(int j=1 ; j<=3 ;j++)
			  {
				  
		    	//Text
		    
				    	try
					    	{
							 if(driver.findElement(By.xpath("//*[@type='text']")).isDisplayed())
								{
									System.out.println("Text started");
									System.out.println("the element type is text");
									driver.findElement(By.id("tx")).clear();
								    driver.findElement(By.id("tx")).sendKeys(temp1[0]);
								    driver.findElement(By.id("btnNext")).click();
								    System.out.println("Text ended");
								    continue;
								}
					    	}
				    	catch(Exception e)
					    	{
					    		System.out.println("not text");
					    	}
				    	
	    	//Radio Button
	    	
				    	try
					    	{
								if(driver.findElement(By.xpath("//*[@type='radio']")).isDisplayed())
								{
									System.out.println("Radio button started");
									System.out.println("the element type is radio");
									driver.findElement(By.id(temp1[1])).click();
								    driver.findElement(By.id("btnNext")).click();
								    System.out.println("Radio button ended");
								    continue;
								}
					    	}
				    	catch(Exception e)
					    	{
					    		System.out.println("not radio");
					    	}
				    	
				    	
	    	
	    	
	    	
	    	//Check Box
	    	
				    	try
					    	{
							 if(driver.findElement(By.xpath("//*[@type='checkbox']")).isDisplayed())
								{
										System.out.println("Check box Started");
										System.out.println("the element type is check box");
										driver.findElement(By.id(temp1[2])).click();
									    driver.findElement(By.id(temp1[3])).click();
									    driver.findElement(By.id("btnNext")).click();
									    System.out.println("Check box Ended");
									    continue;
								}
						    }
					    catch(Exception e)
					    	{
					    		System.out.println("not check box");
					    	}
	    	
	    	//Drag and Drop
	    	
				    	try{
						
							 if(driver.findElement(By.xpath("//*[@class='connectedSortable ui-sortable']")).isDisplayed())
								{
									 System.out.println("Sort Started");
									 System.out.println("the element type is sort");
									 
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[4]))).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[5]))).click();
									 //driver.findElement(By.xpath(".//*[@id='sortable1']/li[2]/div")).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[6]))).click();
									 //driver.findElement(By.xpath(".//*[@id='sortable1']/li[3]/div")).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 driver.findElement(By.xpath(ra.getLocator().replace("replace_this", temp1[7]))).click();
									// driver.findElement(By.xpath(".//*[@id='sortable1']/li[4]/div")).click();
									 driver.findElement(By.xpath(".//*[@id='btnRight']")).click();
									 
									 if(driver.findElement(By.xpath(".//*[@id='btnRight']")).isEnabled());
									 {
										 driver.findElement(By.xpath(".//*[@id='btnNext']")).click();
									 }
									 System.out.println("Sort Ended");
								     continue;
								}
				    		}
				    	
				    	catch(Exception e)
				    		{
				    			System.out.println("not sort");
				    		}
						
	    	
	    	//Hot Stop
	    	
			    	try
				    	{
					    	if(driver.findElement(By.xpath("//canvas")).isDisplayed())
								{
					    		
					    			System.out.println("Canvas Started");
					    			System.out.println("the element type is canvas");
									//org.openqa.selenium.Point coordinates =driver.findElement(By.xpath("//canvas")).getLocation();
									org.openqa.selenium.Point coordinates =driver.findElement(By.xpath(".//*[@id='resumeCanvasResponse']")).getLocation();
									
									System.out.println("Co-ordinates"+coordinates);	
									
									Robot robot = new Robot();
								
									
									 System.out.println(  "element is " +temp1[8]);
									 System.out.println(  "element is " +temp1[9]);
									 
									int newcoordinates1 = coordinates.getX()+Integer.parseInt(temp1[8]) ;
									int newcoordinates2 = coordinates.getY()+Integer.parseInt(temp1[9])  ;
											
									
									robot.mouseMove(newcoordinates1,newcoordinates2); 
									robot.mousePress(InputEvent.BUTTON3_MASK);
								    robot.mouseRelease(InputEvent.BUTTON3_MASK);
	
									
									driver.findElement(By.xpath(".//*[@id='btnNext']")).click();
									System.out.println("Canvas Ended");
									
									
									continue;
								}
				    	}
			    	catch(Exception e)
				    	{
				    		System.out.println("not sort");
				    	}
			  }
			  status = "Pass";
	   }

	   catch(Exception e)
    	{
		    status = "Fail";
			takeScreenShotOnFailure(ra);
			System.out.println(e.getMessage());
    	}
	return status;
	}

/*.....................Reports.....................*/
public static void savexls_tests(ReportAttributes ra)
{
	
	fxProfile = new FirefoxProfile();
	fxProfile.setPreference("browser.download.folderList",2);
    fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
    fxProfile.setPreference("browser.download.dir",ra.getValueToType());
    fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","image/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf");
    driver = new FirefoxDriver(fxProfile);
}

public static String CompareTableData_Reports(ReportAttributes ra)
{
	status = "Skip";

	try 
	{
		String TableText =driver.findElement(By.xpath(ra.getLocator())).getText();
		TableText=TableText.replace(" ", "");
		System.out.println("TableText" +TableText);
		String[]sTable=TableText.split("\n");
		System.out.println("sTable" +sTable);
	
	
			List<String> sExcel=GetExcelInfo_StudentReport(ra.getValueToType());
			for(int i=0;i<=sExcel.size()-2;i++)
			{
				try
				{
							if(sTable[i+1].trim().contentEquals(sExcel.get(i))==false)
							{
								System.out.println("FAIL !! \n:Table Data="+sTable[i+1]+"\nexcel data="+sExcel.get(i));
								throw new Exception("FAIL !! \n:Table Data="+sTable[i+1]+"\nexcel data="+sExcel.get(i));
	
							}
							else
							{
								System.out.println("PASS \nTable Data="+sTable[i+1]+"\nexcel data="+sExcel.get(i));
							}
				}
				catch(Exception d)
				{
						System.out.print("sTable="+sTable[i+1]+"\n excel="+sExcel.get(i)+"\ni="+i);
				}
			}
			status = "Pass";
			//DriverScript.APPLICATION_LOGS.info("Compared data Found ");	
	} 
	catch (Exception e)
	{
		status = "Fail";
		//DriverScript.APPLICATION_LOGS.info(e.getMessage());
		System.out.println(e.getMessage());
		//takeScreenShotOnFailure(ra);		
	}
	return status;
	
}

	
public static List<String> GetExcelInfo_StudentReport(String path)
	{
//		List<String> module = new ArrayList<String>();
		List<String> list=null;
			try
			{
				//String path = "C:\\downloads\\StudentReportCard.xls";    C:\\Users\\LSeshaiyerRamaswa\\Downloads\\StudentReportCard.xls
			
				FileInputStream fi = new FileInputStream(path);
				Workbook w = Workbook.getWorkbook(fi);
				Sheet s = w.getSheet(0);
				
				System.out.println("Rows  =" + s.getRows());
				
				int Noofcols = s.getColumns();
				System.out.println("Cols  =" + Noofcols);
				
				list = new ArrayList<String>();
				
				String celldata;
				
				for(int i = 10; i <= s.getRows()-1; i=(i+4))
				{				
					celldata ="";
						for (int col = 0; col <= s.getColumns() - 1; col++) 
						{
							 celldata = celldata+(s.getCell(col, i)).getContents();
						}
					celldata=celldata.replace(" ", "");
					list.add(celldata.trim());
				}
			
			}
					
			catch (Throwable e) 
			{
				System.out.println("Excel sheet not found");
			}
		return list;
	}
	

/*/.......................Cohorts......................../*/
public static void savexls_cohorts(ReportAttributes ra)
{
	
	fxProfile = new FirefoxProfile();
	fxProfile.setPreference("browser.download.folderList",2);
    fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
    fxProfile.setPreference("browser.download.dir",ra.getValueToType());
    fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","image/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf");
    driver = new FirefoxDriver(fxProfile);
}

public static String CompareTableData_cohorts(ReportAttributes ra)
{
	status = "Skip";

	try 
	{
		String TableText =driver.findElement(By.xpath(ra.getLocator())).getText();
		TableText=TableText.replace(" ", "");
		
		String[]sTable=TableText.split("\n");
		System.out.println("sTable" +sTable);
	
	
			List<String> sExcel=GetExcelInfo_cohorts();
			for(int i=0;i<=sExcel.size()-2;i++)
			{
				try
				{
							if(sTable[i+1].trim().contentEquals(sExcel.get(i))==false)
							{
								System.out.println("FAIL !! \n:Table Data="+sTable[i+1]+"\nexcel data="+sExcel.get(i));
								throw new Exception("FAIL !! \n:Table Data="+sTable[i+1]+"\nexcel data="+sExcel.get(i));
	
							}
							else
							{
								System.out.println("PASS \nTable Data="+sTable[i+1]+"\nexcel data="+sExcel.get(i));
							}
				}
				catch(Exception d)
				{
						System.out.print("sTable="+sTable[i+1]+"\n excel="+sExcel.get(i)+"\ni="+i);
				}
			}
			status = "Pass";
			DriverScript.APPLICATION_LOGS.info("Compared data Found ");	
	} 
	catch (Exception e)
	{
		status = "Fail";
		DriverScript.APPLICATION_LOGS.info(e.getMessage());
		takeScreenShotOnFailure(ra);		
	}
	return status;
	
}

	
public static List<String> GetExcelInfo_cohorts()
	{
//		List<String> module = new ArrayList<String>();
		List<String> list=null;
			try
			{
				String path = "C:\\downloads\\CohortByTest.xls";
			
				FileInputStream fi = new FileInputStream(path);
				Workbook w = Workbook.getWorkbook(fi);
				Sheet s = w.getSheet(0);
				
				System.out.println("Rows  =" + s.getRows());
				
				int Noofcols = s.getColumns();
				System.out.println("Cols  =" + Noofcols);
				
				list = new ArrayList<String>();
				
				String celldata;
				
				for(int i = 10; i <= s.getRows()-1; i=(i+4))
				{				
					celldata ="";
						for (int col = 0; col <= s.getColumns() - 1; col++) 
						{
							 celldata = celldata+(s.getCell(col, i)).getContents();
						}
					celldata=celldata.replace(" ", "");
					list.add(celldata.trim());
				}
			
			}
					
			catch (Throwable e) 
			{
				System.out.println("Excel sheet not found");
			}
		return list;
	}
	
}
		   
		  
	
	    
		  
		
	
	


package com.selenium.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.selenium.reports.ReportUtil;
import com.selenium.reports.TestUtil;
import com.selenium.util.FileUtils;
import com.selenium.util.TestDetails;

public class DriverScript 
{

	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
	//public static Map<String,WebDriver> driverMap=null;
	//public static Map<String,String> browserMap=null;
	
	public String browser=null;
	private List<String> modules = null;
	public static WebDriver driver =null;
	public FirefoxProfile fxProfile ;
	
	String startTime = null;
	String basePath = System.getProperty("user.dir");
	
	String os = System.getProperty("os.name"); 
	String osVersion = System.getProperty("os.version");	
	String userName = System.getProperty("user.name"); 
	
	public String environment = os + " Version " + osVersion + " User " + userName ;
	public static String VersionNumber;
	
	

	@BeforeSuite

	public void startTesting() 
	{
		//driverMap=new HashMap<String,WebDriver>();
		//browserMap=new HashMap<String,String>();
		createDirectories("CustomOutput");
		FileUtils.clearDirectory(basePath + "//screenshots_on_failure");
		
		if(driver !=null)
		{
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			System.out.println(" cap.getVersion() ----------------------->"+cap.getVersion());
			VersionNumber =cap.getVersion();	
			
			APPLICATION_LOGS.info("Version Number" +VersionNumber);
			
		}
	}

	@BeforeClass
	public void initialize() throws IOException, NoSuchMethodException,SecurityException, InterruptedException, IllegalAccessException,IllegalArgumentException, InvocationTargetException 
	{
		System.out.println("Initialization Started");
	}

	@Test
	public void start() throws IllegalAccessException,IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException, Exception, IOException 	
	{
		List<Map<String, HashMap<String, TestDetails>>> summaryList=new ArrayList<Map<String, HashMap<String, TestDetails>>>();
		try
		{
			Commonfunctions.driver=driver;
			
	
			for (String module : modules) 
			{ // iterate modules
				
				//Commonfunctions.driver=driverMap.get(module);
				ReportUtil.startTesting(System.getProperty("user.dir")+ "/CustomOutput/" + module + "//Index.html",TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),environment,browser,VersionNumber, 1.1);
				ReportUtil.startFailedTestReport(System.getProperty("user.dir")+ "/CustomOutput/" + module + "//Failed.html",environment);
				System.out.println("Module "+module+" File :"+module + ".xls");
				
				
				APPLICATION_LOGS.debug("Execution Started Now");
				APPLICATION_LOGS.debug(".............................................");
				
				Map<String, HashMap<String, TestDetails>> summary=ConnectToModuleExcel.launchexcel(basePath + "//ExcelFiles//"+ module + ".xls", basePath + "\\CustomOutput\\"+ module + "\\" + module,module); 
				APPLICATION_LOGS.debug("..............................................");
				
				
				summaryList.add(summary);	// specific module with status yes
				
				APPLICATION_LOGS.debug("..............................................");
				
			}
			
			Commonfunctions.driver.close();
			Commonfunctions.driver.quit();
			APPLICATION_LOGS.debug("Execution Ended Now");
			ReportUtil.summaryReport(summaryList,  basePath + "\\CustomOutput\\SummaryReport.html");
			ReportUtil.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),basePath + "\\CustomOutput\\SummaryReport.html");
		
		}

		catch (SecurityException e) 
		{
			e.printStackTrace();
		}

		catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
		}

	}

	private void createDirectories(String parent)
	{
		FileUtils.clearDirectory(parent); // delete content from parent directory
		modules = CreateModules(parent);
		for (String module : modules)  // iterate main .xls file to create appropriate directories
			FileUtils.createDirectory(basePath + "//" + parent + "//" + module);
		
	}

	private List<String> CreateModules(String parent) 
	{
		List<String> module = new ArrayList<String>();
		try
		{
			String path = System.getProperty("user.dir")+ "\\ExcelFiles\\MainExcel.xls";
			
			FileInputStream fi = new FileInputStream(path);
			Workbook w = Workbook.getWorkbook(fi);
			Sheet s = w.getSheet(0);
			
			int Noofrows = s.getRows();
			System.out.println("Rows  =" + Noofrows);
			
			int Noofcols = s.getColumns();
			System.out.println("Cols  =" + Noofcols);
			
			int row, col;
			
			List<String> list = null;
			
			for (row = 1; row <= Noofrows - 1; row++) 
			{
				list = new ArrayList<String>();
				for (col = 0; col <= Noofcols - 1; col++) 
				{
					String celldata = (s.getCell(col, row)).getContents();
					System.out.println("function name :" + celldata);
					list.add(celldata);

				}
				System.out.println("List:list0:" + list.get(0) + "::list1:: "+ list.get(1) + ":: list2::" + list.get(2) + ":: list3::" + list.get(3) );

				String RunMode = list.get(2);
				System.out.println("RunMode:::" + RunMode +" Browser ::: "+list.get(3));	
				if(driver == null && browser == null)
				{
				browser =list.get(3);	
				driver =getDriver(browser);	
				}				
				if (RunMode.equalsIgnoreCase("yes"))
				{
					module.add(list.get(1));
				
				}
			}

		} 
		
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Excel sheet not found");
		}
		return module;
	}

	@AfterClass
	public static void endScript() 
	{
		//ReportUtil.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),);
	}


	private WebDriver getDriver(String name)
	
	
	{
		System.out.println("ITS COMING HERE");
		if(name.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

		else if(name.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
				driver = new ChromeDriver();
			}					
		else
			{
				
				fxProfile = new FirefoxProfile();
				fxProfile.setPreference("browser.download.folderList",2);
		        fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		        fxProfile.setPreference("browser.download.dir","C:\\Downloads");
		        fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","image/jpg, text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf");
		        driver = new FirefoxDriver(fxProfile);
			}

		return driver;

	}

}



package com.selenium.reports;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.selenium.util.ReportAttributes;
import com.selenium.util.TestDetails;

public class ReportUtil 
{

			public static int scriptNumber = 1;
			public static String indexResultFilename;
			public static String failedFilename;
			public static String currentDir;
			public static String currentSuiteName;
			
			
			public static String sTestStartTime;
			public static String sEnv;
			public static String sBrowser;
			public static String sVersionNumber;
			public static double sRel;
		
			public static ArrayList<String> TCID = new ArrayList<String>();;
			public static ArrayList<String> TCName = new ArrayList<String>();;
			public static ArrayList<String> TCDescription = new ArrayList<String>();;
			public static ArrayList<String> screenShotPath = new ArrayList<String>();;
			private static int srno = 1;
		
			public static double passNumber;
			public static double failNumber;
			public static boolean newTest = true;
	

	public static void startTesting(String filename, String testStartTime,String env,String Browser ,String VersionNumber, double rel) 
		{
				indexResultFilename = filename;
				sTestStartTime =testStartTime;
				sEnv=env;
				sBrowser=Browser;
				sVersionNumber=VersionNumber;
				sRel=rel;
		
				currentDir = indexResultFilename.substring(0,indexResultFilename.lastIndexOf("//"));
		
				FileWriter fstream = null;
				BufferedWriter out = null;

				try 
				{
					// Create file

						fstream = new FileWriter(filename);
						out = new BufferedWriter(fstream);
			
						String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
			
						String ENVIRONMENT = env;// SeleniumServerTest.ConfigurationMap.getProperty("environment");
						double Release = rel;// SeleniumServerTest.ConfigurationMap.getProperty("release");
			
						out.newLine();
			
						out.write("<html>\n");
						out.write("<HEAD>\n");
						out.write(" <TITLE>Automation Test Results</TITLE>\n");
						out.write("</HEAD>\n");
			
						out.write("<body>\n");
						out.write("<h4 align=center><FONT COLOR=660066 FACE=AriaL SIZE=6><b><u> Automation Test Results</u></b></h4>\n");
			
						out.write("<table  border=1 cellspacing=1 cellpadding=1 >\n");
						out.write("<tr>\n");
			
						out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> <u>Test Details :</u></h4>\n");
						out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run Date</b></td>\n");
			
						out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"+ RUN_DATE + "</b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
			
						out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Start</b></td>\n");
			
						out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"+ testStartTime + "</b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
						// out.newLine();
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>End</b></td>\n");
						out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b> END_TIME  </b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
						// out.newLine();
			
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
						out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ ENVIRONMENT + "</b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
			
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Browser</b></td>\n");
						out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ Browser + "</b></td>\n");
						out.write("</tr>\n");
						
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>BrowserVersion </b></td>\n");
						out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ VersionNumber + "</b></td>\n");
						out.write("</tr>\n");
						
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Release</b></td>\n");
						out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ Release + "</b></td>\n");
						out.write("</tr>\n");
						
			
						out.write("</table>\n");
			
						out.close();
				} 
				
				catch (Exception e) 
					{
						// Catch exception if any
						System.err.println("Error: " + e.getMessage());
					} 
				finally 
					{
						fstream = null;
						out = null;
					}
	}

	public static void startFailedTestReport(String filename, String env) 
	{
		failedFilename = filename;
		currentDir = failedFilename.substring(0,failedFilename.lastIndexOf("//"));

		FileWriter fstream = null;
		BufferedWriter out = null;
		String ENVIRONMENT = env;
				try 
				{
					// Create file
		
					fstream = new FileWriter(filename);
					out = new BufferedWriter(fstream);
		
					String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
		
					out.newLine();
		
					out.write("<html>\n");
					out.write("<HEAD>\n");
					out.write(" <TITLE>Automation Test Results - FAILED cases </TITLE>\n");
					out.write("</HEAD>\n");
		
					out.write("<body>\n");
					out.write("<h4 align=center><FONT COLOR=660066 FACE=AriaL SIZE=6><b><u> Automation Test Results - FAILED cases</u></b></h4>\n");
					out.write("<table  border=1 cellspacing=1 cellpadding=1 >\n");
					out.write("<tr>\n");
		
					out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> <u>Test Details :</u></h4>\n");
					out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run Date</b></td>\n");
					out.write("<td width=150 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"
							+ RUN_DATE + "</b></td>\n");
					out.write("</tr>\n");
					out.write("<tr>\n");
		
					out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
					out.write("<td width=150 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"
							+ ENVIRONMENT + "</b></td>\n");
					out.write("</tr>\n");
					out.write("<tr>\n");
		
					out.write("</table>\n");
		
					out.close();
				} 
				catch (Exception e)
					{
						// Catch exception if any
						System.err.println("Error: " + e.getMessage());
					} 
				finally 
					{
						fstream = null;
						out = null;
					}
	}

	public static void updateEndTime(String endTime,String fileName) 
	{
		
		System.out.println(" updateEndTime "+endTime +" fileName :: "+fileName);
		StringBuffer buf = new StringBuffer();
		try
			{
				// Open the file that is the first
				// command line parameter
				FileInputStream fstream = new FileInputStream(fileName);
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
	
				// Read File Line By Line

				while ((strLine = br.readLine()) != null) 
				{
					if (strLine.indexOf("END_TIME") != -1)
					{
						strLine = strLine.replace("END_TIME", endTime);
					}
					buf.append(strLine);

				}
				// Close the input stream
				in.close();
				System.out.println(buf);
				FileOutputStream fos = new FileOutputStream(fileName);
				DataOutputStream output = new DataOutputStream(fos);
				output.writeBytes(buf.toString());
				fos.close();

			} 
			catch (Exception e) 
			{
				// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}

	}

	public static void addTestCase(List<ReportAttributes> ReportAttributesList,String Modulepath) 
	{
		File f = null;
		System.out.println("The data is comming here***********************************************"+ srno);
		String basePath = System.getProperty("user.dir");
		FileWriter fstream = null;
		BufferedWriter out = null;
		FileWriter fstreamF = null;
		BufferedWriter outF = null;

		try 
		{

				fstreamF = new FileWriter(failedFilename, true);
				outF = new BufferedWriter(fstreamF);
				// Creating new File
				if (f == null) 
				{
					f = new File(Modulepath);
					f.createNewFile();
				}
				// Adding Headers to Template
			
			
			
					fstream = new FileWriter(f);
					out = new BufferedWriter(fstream);
					out.write("<html>");
					out.write("<head>");
					out.write("<title>");
					out.write(TCName + " Detailed Reports");
					out.write("</title>");
					out.write("</head>");
					out.write("<body>");
		
					out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> Detailed Report :</h4>");
					out.write("<table  border=1 cellspacing=1    cellpadding=1 width=100%>");
					out.write("<tr> ");
		
					out.write("<td align=center width=10%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>Step No</b></td>");
					out.write("<td align=center width=10%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>TestCase ID</b></td>");
					out.write("<td align=center width=10%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>TestCase StepNo</b></td>");
					out.write("<td align=center width=25% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>TestCase Name</b></td>");
					out.write("<td align=center width=35% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>TestCase Description</b></td>");
					out.write("<td align=center width=10% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>Result</b></td>");
					out.write("<td align=center width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2><b>Screen Shot</b></td>");
					out.write("</tr>");
		
					for (ReportAttributes ra : ReportAttributesList) 
					{
		
						out.write("<tr> ");
						out.write("<td align=center width=10%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"
								+ ra.getSNo() + "</b></td>");
						
						out.write("<td align=center width=10%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"
								+ ra.getTCID() + "</b></td>");
						
						out.write("<td align=center width=10%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"
								+ ra.getTCSTEPNO() + "</b></td>");
						
						out.write("<td align=center width=25%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"
								+ ra.getTCName() + "</b></td>");
						
						out.write("<td align=center width=35%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"
								+ ra.getTCDescription() + "</b></td>");
						
		
						if (ra.getStatus().equalsIgnoreCase("Pass")) 
						{
							out.write("<td width=10% align= center  bgcolor=#BCE954><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+ (ra.getStatus()) + "</b></td>\n");
						} 
						else 
						{
							out.write("<td width=10% align= center  bgcolor=Red><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>"+ (ra.getStatus()) + "</b></td>");
							out.write("<td align=center width=30%><a href='file:///"+basePath + "\\screenshots_on_failure\\"+ra.getTCName()+"-"+ra.getTCSTEPNO()+".jpg'>view</a></td>");
						
						}
						out.write("</tr>");
		
					}
		
				} 
		
			catch (IOException e)
			{
			e.printStackTrace();
			} 
		
			finally 
			{
				try 
					{
						out.close();
						outF.close();
					} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

	}
	
	
	public static void addTestReport(Map<String, HashMap<String, TestDetails>> mtd,String Modulepath) 
	{
				File f = null;
				//indexResultFilename = filename;
				System.out.println("The data is comming here***********************************************"+ srno);
				@SuppressWarnings("unused")
				String basePath = System.getProperty("user.dir");
				FileWriter fstream = null;
				BufferedWriter out = null;
				FileWriter fstreamF = null;
				BufferedWriter outF = null;
				String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
				
				currentDir = indexResultFilename.substring(0,indexResultFilename.lastIndexOf("//"));
				try
						{
				
							fstreamF = new FileWriter(failedFilename, true);
							outF = new BufferedWriter(fstreamF);
							// Creating new File
							if (f == null) 
								{
									f = new File(Modulepath);
									f.createNewFile();
								}
			
						
						
						// Adding Headers to Template
						fstream = new FileWriter(f);
						out = new BufferedWriter(fstream);
						
						out.write("<html>");
						out.write("<head>");
						out.write("<title>");
						out.write(TCName + " Module Wise Reports");
						out.write("</title>");
						out.write("</head>");
						out.write("<body>");
			
						out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> Module Wise Report :</h4>");
						//Start INDEX INFO
						out.write("<table  border=1 cellspacing=1 cellpadding=1 >\n");
						out.write("<tr>\n");
			
						
						out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run Date</b></td>\n");
			
						out.write("<td width=250 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"+ RUN_DATE + "</b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
			
						out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Start</b></td>\n");
			
						out.write("<td width=250 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"+ sTestStartTime + "</b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
						// out.newLine();
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>End</b></td>\n");
						out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b> END_TIME  </b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
						// out.newLine();
			
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
						out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ sEnv + "</b></td>\n");
						out.write("</tr>\n");
						out.write("<tr>\n");
			
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Browser</b></td>\n");
						out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ sBrowser + "</b></td>\n");
						out.write("</tr>\n");
						
						out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>BrowserVersion </b></td>\n");
						out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ sVersionNumber + "</b></td>\n");
						out.write("</tr>\n");
						
						
						
			
						out.write("</table>\n");
						//End of index Info
						
						out.write("\n");
						out.write("\n");
						out.write("\n");
						out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5>  Report Details :</h4>");
						
						out.write("<table  border=1 cellspacing=1    cellpadding=1 width=80%>");
						
						out.write("<tr> ");
						out.write("<td align=center width=10%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>#</b></td>");
						out.write("<td align=center width=20%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>TestCase ID</b></td>");
						out.write("<td align=center width=30% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>TestCase Name</b></td>");
						out.write("<td align=center width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Status</b></td>");
						out.write("</tr>");
						
						long count=0;
						for (Entry<String, HashMap<String, TestDetails>> entry : mtd.entrySet())
						{				
							HashMap<String, TestDetails> data = entry.getValue();
							for (Entry<String, TestDetails> entrydata : data.entrySet())
							{	
								TestDetails td=entrydata.getValue();	
								
								out.write("<tr> ");
								out.write("<td align=center width=10%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+  ++count + "</b></td>");
								//TestCase ID logic here
								
								out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+ td.getId() + "</b></td>");
								
								out.write("<td align=center width=30%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+ td.getName() + "</b></td>");
								
								if (td.getStatus().equalsIgnoreCase("Pass")) 
								{
									out.write("<td width=20% align= center  bgcolor=#BCE954><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+ (td.getStatus()) + "</b></td>\n");
								}
								else 
								{
									out.write("<td width=20% align= center  bgcolor=Red><FONT COLOR=#153E7E FACE= Arial  SIZE=2><b>"+ (td.getStatus()) + "</b></td>");
								}
								
								out.write("</tr>");
								
							}			
						}
						

		} 
		catch (IOException e)
				{
					e.printStackTrace();
		
				} 
		finally 
		{
			try 
				{
					out.close();
					outF.close();
				} 
			catch (IOException e) 
				{
					e.printStackTrace();
				}
		}

	}
	
	public static void summaryReport(List<Map<String, HashMap<String, TestDetails>>> summaryList,String Modulepath)
	  {
		//start
		File f = null;
		//indexResultFilename = filename;
		System.out.println("The data is comming here***********************************************"+ srno);
		@SuppressWarnings("unused")
		String basePath = System.getProperty("user.dir");
		FileWriter fstream = null;
		BufferedWriter out = null;
		FileWriter fstreamF = null;
		BufferedWriter outF = null;
		String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
		
		currentDir = indexResultFilename.substring(0,indexResultFilename.lastIndexOf("//"));
		try
				{
		
					fstreamF = new FileWriter(failedFilename, true);
					outF = new BufferedWriter(fstreamF);
					// Creating new File
					if (f == null) 
						{
							f = new File(Modulepath);
							f.createNewFile();
						}
	
				
				
				// Adding Headers to Template
				fstream = new FileWriter(f);
				out = new BufferedWriter(fstream);
				
				out.write("<html>");
				out.write("<head>");
				out.write("<title>");
				out.write(TCName + " Final Summary Report");
				out.write("</title>");
				out.write("</head>");
				out.write("<body>");
	
				out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5>Final Summary Report :</h4>");
				//Start INDEX INFO
				out.write("<table  border=1 cellspacing=1 cellpadding=1 >\n");
				out.write("<tr>\n");
	
				
				out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run Date</b></td>\n");
	
				out.write("<td width=250 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"+ RUN_DATE + "</b></td>\n");
				out.write("</tr>\n");
				out.write("<tr>\n");
	
				out.write("<td width=150 align=left bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Start</b></td>\n");
	
				out.write("<td width=250 align=left><FONT COLOR=#153E7E FACE=Arial SIZE=2.75><b>"+ sTestStartTime + "</b></td>\n");
				out.write("</tr>\n");
				out.write("<tr>\n");
				// out.newLine();
				out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>End</b></td>\n");
				out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b> END_TIME  </b></td>\n");
				out.write("</tr>\n");
				out.write("<tr>\n");
				// out.newLine();
	
				out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
				out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ sEnv + "</b></td>\n");
				out.write("</tr>\n");
				out.write("<tr>\n");
	
				out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Browser</b></td>\n");
				out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ sBrowser + "</b></td>\n");
				out.write("</tr>\n");
				
				out.write("<td width=150 align= left  bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>BrowserVersion </b></td>\n");
				out.write("<td width=250 align= left ><FONT COLOR=#153E7E FACE= Arial  SIZE=2.75><b>"+ sVersionNumber + "</b></td>\n");
				out.write("</tr>\n");
				
				
				
	
				out.write("</table>\n");
				//End of index Info
				
				out.write("\n");
				out.write("\n");
				out.write("\n");
				out.write("<h4> <FONT COLOR=660000 FACE=Arial SIZE=4.5> Summary Report Details :</h4>");
				
				out.write("<table  border=1 cellspacing=1 cellpadding=1 width=100%>");
				
				out.write("<tr> ");
				out.write("<td align=center width=20%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>#</b></td>");
				out.write("<td align=center width=20%  align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Module Name</b></td>");
				out.write("<td align=center width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Total Executed</b></td>");
				out.write("<td align=center width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Test Case Passed</b></td>");
				out.write("<td align=center width=20% align=center bgcolor=#153E7E><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Test Case Failed</b></td>");
				out.write("</tr>");
				
				long count=0;
				long grandTotal=0;
				long grandPassTotal=0;
				long grandFailTotal=0;
				
				for(Map<String, HashMap<String, TestDetails>> mtd:summaryList)
				{
					long passCount=0;
					long failCount=0;
					long total=0;
					String module=null;
					
				for (Entry<String, HashMap<String, TestDetails>> entry : mtd.entrySet())
				{			
					module=entry.getKey();
					HashMap<String, TestDetails> data = entry.getValue();
					for (Entry<String, TestDetails> entrydata : data.entrySet())
					{	
						TestDetails td=entrydata.getValue();
						if(td.getStatus().equals("Fail"))
						++failCount;
						else
						++passCount;
						
				
					}	
					total=passCount+failCount;
					grandTotal+=total;
					grandPassTotal+=passCount;
					grandFailTotal+=failCount;
					
				}
				
				
				out.write("<tr> ");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+  ++count + "</b></td>");				
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+module + "</b></td>");				
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+total + "</b></td>");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+passCount + "</b></td>");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+failCount + "</b></td>");			
				out.write("</tr>");			
				}
				
				out.write("<tr> ");
				
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b> &nbsp </b></td>");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>	Total </b></td>");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+grandTotal + "</b></td>");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+grandPassTotal + "</b></td>");
				out.write("<td align=center width=20%><FONT COLOR=#153E7E FACE=Arial SIZE=2><b>"+grandFailTotal + "</b></td>");			
				out.write("</tr>");	
				
				out.write("</table> ");
				
				

} 
catch (IOException e)
		{
			e.printStackTrace();

		} 
finally 
{
	try 
		{
			out.close();
			outF.close();
		} 
	catch (IOException e) 
		{
			e.printStackTrace();
		}
}
		//end
	}

}

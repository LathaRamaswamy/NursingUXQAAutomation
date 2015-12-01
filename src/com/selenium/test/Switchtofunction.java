package com.selenium.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.selenium.util.ReportAttributes;

public class Switchtofunction 
{

	public static WebDriver driver;
	public static String status;
	
	public static String mainfunction(ReportAttributes ra) throws Exception 
	{
		switch (ra.getFunctionName()) 
		{
		
				/*case "openbrowser_firefox":
					
					System.out.println("Opening Firefox Browser -------------==================");
					status = Commonfunctions.openbrowser_firefox(ra);
					break;*/
				
				case "openurl":
		
					status = Commonfunctions.openurl(ra);
					break;
				
			   case "windowmaximise":
		
					status = Commonfunctions.windowmaximise(ra);
					break;
					
			   case "gettitle":
		
					status = Commonfunctions.gettitle(ra);
					break;
					
			   case "getcurrenturl":
		
					status = Commonfunctions.getcurrenturl(ra);
					break;
				
			  /* case "getpagesource":
	
					status = Commonfunctions.getPageReference(ra);
					break;*/
					
			   case "get_grid_Header":
				   status = Commonfunctions.get_grid_Header(ra);
					break;
					
			   case "get_Table_Contents":
				   status = Commonfunctions.get_Table_Contents(ra);
					break;
					
			   case "get_grid_Contents":
			   		status = Commonfunctions.get_grid_Contents(ra);
				break;
				
			   case "get_Header_Contents":
			   		status = Commonfunctions.get_Header_Contents(ra);
				break;
				
			   case "compare_Files":
				   status = Commonfunctions.compare_Files(ra);
				   break;
				   
			   case "CompareTableData_Reports":
				   status = Commonfunctions.CompareTableData_Reports(ra);
				   break;
				   
			   case "clearFiles":
				   status = Commonfunctions.clearFiles(ra);
				   break;
				   
			   case "dropdown_click":
				   status = Commonfunctions.dropdown_click(ra);
				   break;
			   				
				case "verifyelement_isDisplayed":
		
					status = Commonfunctions.verifyelement_isDisplayed(ra);
					break;
	
					
				case "verify_Text":
					
					status = Commonfunctions.verify_Text(ra);
					break;
					
				case "typeinEditbox":
		
					status = Commonfunctions.typeinEditbox(ra);
					break;
				
				case "WE_click":
		
					status = Commonfunctions.WE_click(ra);
					break;
					
					
				case "link_click":
		
					status = Commonfunctions.link_click(ra);
					break;
				case "dropdown_div_select_test":
					status = Commonfunctions.dropdown_div_select_test(ra);
				
				case "dropdown_select":
		
					status = Commonfunctions.dropdown_select(ra);
					break;
					
				case "dropdown_div_select":
					status = Commonfunctions.dropdown_div_select(ra);
					break;
					
				case "dropdown_selectbyvalue":
		
					status = Commonfunctions.dropdown_selectbyvalue(ra);
					break;
					
				case "dropdown_selectbyindex":
		
					status = Commonfunctions.dropdown_selectbyindex(ra);
					break;
					
				case "alert_accept":
		
					status = Commonfunctions.alert_accept(ra);
					break;
		
				case "alert_dismiss":
		
					status = Commonfunctions.alert_dismiss(ra);
					break;
				
				case "Clear_Text":
		
					status = Commonfunctions.Clear_Text(ra);
					break;
		
				case "Refresh":
		
					status = Commonfunctions.Refresh(ra);
					break;
				
				case "Wait":
	
					Commonfunctions.Wait();
					break;
					
				case "longWait":
					
					Commonfunctions.longWait();
					break;
					
				case "LongWait":
					
					Commonfunctions.LongWait();
					break;
					
					
				case "selectState":
					
					status = Commonfunctions.selectState(ra);
					break;
					
				case "dropdown_selectCountry":
					
					status = Commonfunctions.dropdown_selectCountry(ra);
					break;
					
				case "Select_Questions_Checkbox":
					
					status = Commonfunctions.Select_Questions_Checkbox(ra);
					break;	
					
				case "Answer_Questions":
					
					status = Commonfunctions.Answer_Questions(ra);
					break;
					
				case "Answer_3Questions":
					
					status = Commonfunctions.Answer_3Questions(ra);
					break;
					
				case "dropdown_Product":
					
					status = Commonfunctions.dropdown_Product(ra);
					break;
					
				case "compare_Product":
					
					status = Commonfunctions.compare_Product(ra);
					break;
					
				
				case "menu_DoubleClick":
	
					status = Commonfunctions.menu_DoubleClick(ra);
					break;
					
				case "navigate_back":
					
					status = Commonfunctions.navigate_back(ra);
					break;
										
				/*case "Answer_2Questions":
	
					status = Commonfunctions.Answer_2Questions(ra);
					break;*/
				
				case "closepage":
	
					status = Commonfunctions.closepage(ra);
					break;
				
				case "quitbrowser":
	
					status = Commonfunctions.quitbrowser(ra);
					break;
					
			}
			return status;
		
		}

	
	public static String datetime(String dateFormat) 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());

	}

}

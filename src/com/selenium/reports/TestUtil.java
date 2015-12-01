package com.selenium.reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestUtil 
	{
			public static String now(String dateFormat)
			{
			    Calendar cal = Calendar.getInstance();
			    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			    return sdf.format(cal.getTime());
		
			}
	}

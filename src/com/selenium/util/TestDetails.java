package com.selenium.util;

public class TestDetails
{
	
	public TestDetails(String id, String name, String status, String Testdesc) 
		{
				super();
				this.id = id;
				this.name = name;
				this.status = status;
				this.Testdesc =Testdesc;
		}
	
	private String id;
	private String name;
	private String status;
	private String Testdesc;
			public String getId()
			{
				return id;
			}
			public void setId(String id)
			{
				this.id = id;
			}
			public String getName() 
			{
				return name;
			}
			public void setName(String name) 
			{
				this.name = name;
			}
			public String getStatus() 
			{
				return status;
			}
			public void setStatus(String status)
			{
				this.status = status;
			}
			public String getTestdesc() 
			{
				return Testdesc;
			}
			public void setTestdesc(String testdesc) 
			{
				Testdesc = testdesc;
			}
			
}

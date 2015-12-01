package com.selenium.util;

public class ReportAttributes 
{

	private String SNo;
	private String TCID;
	private String TCSTEPNO;
	private String TCName;
	private String TCDescription;
	private String FunctionName;
	private String ElementType;
	private String IdentifyBy;
	private String Locator;
	private String ValueToType;
	//Debugging Logic Starts Here
//	private String RunMode;
	//Debugging Logic Ends Here
	private String Status;
	
	public ReportAttributes(
			String sNo, 
			String tCID,
			String tCStepno , 
			String tCName,
			String tCDescription, 
			String functionName, 
			String elementType,
			String identifyBy, 
			String locator, 
			String valueToType,
			//Debugging Logic Starts Here
			String runMode,
			//Debugging Logic Ends Here
			String status) 
			{
					super();
					SNo = sNo;
					TCID = tCID;
					TCSTEPNO = tCStepno;
					TCName = tCName;
					TCDescription = tCDescription;
					FunctionName = functionName;
					ElementType = elementType;
					IdentifyBy = identifyBy;
					Locator = locator;
					ValueToType = valueToType;
			/*		//Debugging Logic Starts Here
					RunMode = runMode ;
				*/	//Debugging Logic Ends Here
					Status = status;
			}

					public String getSNo() 
					{
						return SNo;
					}
		
					public void setSNo(String sNo) 
					{
						SNo = sNo;
					}
		
					public String getTCID()
					{
						return TCID;
					}
		
					public void setTCID(String tCID) 
					{
						TCID = tCID;
					}
				
					
					public String getTCSTEPNO() 
					{
						return TCSTEPNO;
					}
				
					public void setTCSTEPNO(String tCStepno)
					{
						TCSTEPNO = tCStepno;
					}
					public String getTCName()
					{
						return TCName;
					}
				
					public void setTCName(String tCName) 
					{
						TCName = tCName;
					}
				
					public String getTCDescription()
					{
						return TCDescription;
					}
				
					public void setTCDescription(String tCDescription)
					{
						TCDescription = tCDescription;
					}
				
					public String getFunctionName() 
					{
						return FunctionName;
					}
				
					public void setFunctionName(String functionName) 
					{
						FunctionName = functionName;
					}
				
					public String getElementType()
					{
						return ElementType;
					}
				
					public void setElementType(String elementType) 
					{
						ElementType = elementType;
					}
				
					public String getIdentifyBy() 
					{
						return IdentifyBy;
					}

					public void setIdentifyBy(String identifyBy) 
					{
						IdentifyBy = identifyBy;
					}
				
					public String getLocator() 
					{
						return Locator;
					}
				
					public void setLocator(String locator) 
					{
						Locator = locator;
					}
				
					public String getValueToType() 
					{
						return ValueToType;
					}
				
					public void setValueToType(String valueToType)
					{
						ValueToType = valueToType;
					}
				
				
					public String getStatus() 
					{
						return Status;
					}
				
					public void setStatus(String status)
					{
						Status = status;
					}
					
					//Debugging Logic Starts Here
			/*	
					public String getRunMode()
					{
						return RunMode;
					}
				
					public void setRunMode(String runMode) 
					{
						RunMode = runMode;
					}
				*/	// Debugging Logic Ends Here
}

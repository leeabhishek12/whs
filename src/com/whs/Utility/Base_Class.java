package com.whs.Utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.whs.Utility_Log.Log;

public class Base_Class {
	
	
	public static WebDriver driver;   // driver object 
	static String url = "http://208.112.88.220/WhStaging/";  //Application url
			
	//openApplication Method will open the Application
	
	
	
			public static void openApplication(){
				
			
		
				driver = new FirefoxDriver();
				
				driver.navigate().to(url);
				
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
				
				
	      }
			
			//closeApplication Method will close the Application
			
			public static void closeApplication(){
				
				driver.close();
				
				
				
				
			}

}

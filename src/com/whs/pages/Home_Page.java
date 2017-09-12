package com.whs.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.whs.Utility.Base_Class;

public class Home_Page extends Base_Class  {
	
	
	
	static By ShopAll = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Shop All']");
	static By Beanies = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Beanies']");
	static By CamouflageHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Camouflage Hats']");
	static By FlexfitHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Flexfit™ Hats']");
	static By SnapBackHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Snap Back Hats']");
	static By TruckerHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Trucker Hats']");
	static By WinterHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Winter Hats']");
	
	
	
	public static void verifyPageTitle(){
		
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		String currentTitle = driver.getTitle();
		String ExpectedTitle = "WholeSaleHats: Home";
		
		if(currentTitle.equalsIgnoreCase(ExpectedTitle)){
			
			
			logger.info("Title Verified");
			System.out.println("Title verified:"+currentTitle);
		}
		
	}
	
	public static void verifyDepartment() throws InterruptedException {
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.findElement(ShopAll).click();
		
		Thread.sleep(5000);
		String ShopAllDept = driver.getTitle();
		System.out.println(ShopAllDept);
		
		
		
	
	}
	
	public static void verifyCategory(){
		
		
		
	}
	
	public static void verifyImages(){
		
	}
	
	public static void verifyText(){
		
		
	}
	
	
	public static void verifySignUpEmail(){
		
		
	}
	
	
	public static void verifyFooter(){
		
	}
	
	
	
	
	
	
}

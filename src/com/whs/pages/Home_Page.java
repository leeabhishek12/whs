package com.whs.pages;



import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		
		Logger logger=Logger.getLogger("Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
	/*	String currentTitle = driver.getTitle();
		String ExpectedTitle = "WholeSaleHats: Home";
		
		if(currentTitle.equalsIgnoreCase(ExpectedTitle)){
			
			
			logger.info("Title Verified"+currentTitle);
			//System.out.println("Title verified:"+currentTitle);
		}*/
		assertTrue(driver.getTitle().matches("WholeSaleHats: Home"), "Page Title does not match"+driver.getTitle());
		logger.info("Title Verified via assert which is :"+driver.getTitle());
		
		
		
	}
	
	public static void verifyDepartment() throws InterruptedException {
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		Actions builder = new Actions(driver);
		
		
		WebElement ele = driver.findElement(ShopAll);
		builder.moveToElement(ele).build().perform();
		
		Thread.sleep(2000);
		builder.click(ele).build().perform();
		
		
		String ShopAllDept = driver.getCurrentUrl();
		
		logger.info("Shop All Department URL :" +ShopAllDept);
		
		if(ShopAllDept.contains("shopall")){
			
			logger.info("Shop All Department verified");
			
			
		}
		
		
		
	
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

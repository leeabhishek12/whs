package com.whs.pages;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;
import com.whs.Utility.Base_Class;

public class Home_Page extends Base_Class  {
	
	static By ShopAll = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Shop All']");
	static By Beanies = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Beanies']");
	static By CamouflageHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Camouflage Hats']");
	static By FlexfitHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Flexfit™ Hats']");
	static By SnapBackHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Snap Back Hats']");
	static By TruckerHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Trucker Hats']");
	static By WinterHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Winter Hats']");
	static By HomePageImg = By.xpath("//img[@src='/WhStaging/img/frontend/logoNew.png']");
	static By HomePageSearch = By.xpath("//img[@src='/WhStaging/img/frontend/cartnew.png']");
	static By PatrioticHatsCategory = By.xpath("//a[text()='Patriotic Hats']");
	static By TextHeading1 = By.xpath(".//*[contains(text(), 'Family')]");
	static By TextUnderHeading1= By.xpath(".//*[contains(text(),'selling')]");
	static By HomeLogo = By.xpath("//img[@src='/WhStaging/img/frontend/logoNew.png']");
	
	
	
	//verify home page title
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
	
	//verify department
	public static void verifyDepartment() throws InterruptedException {
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		Actions builder = new Actions(driver);
		
		
		WebElement ShopAllele = driver.findElement(ShopAll);
		
	
		
		builder.moveToElement(ShopAllele).build().perform();
		
		
		builder.click(ShopAllele).build().perform();
		Thread.sleep(4000);
		
		
		
		
		String ShopAllDept = driver.getCurrentUrl();
		
		logger.info("Shop All Department URL :" +ShopAllDept);
		
		
		
	/*	builder.moveToElement(HomePageSearchele).build().perform();
		builder.click(HomePageSearchele).build().perform();*/
		
		
		if(ShopAllDept.contains("shopall")){
			
			logger.info("Shop All Department verified");
			
			
		}
		
		
	
	
	}
	
	//verify category
	
	public static void verifyCategory() throws InterruptedException  {
		
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		Actions builder = new Actions(driver);
		WebElement ShopAllele = driver.findElement(ShopAll);
		builder.moveToElement(ShopAllele).build().perform();
		WebElement PatrioticHatsCategoryele = driver.findElement(PatrioticHatsCategory);
		builder.moveToElement(PatrioticHatsCategoryele).build().perform();
		builder.click(PatrioticHatsCategoryele).build().perform();
		Thread.sleep(4000);
		String PatrioticHatsCat =   driver.getCurrentUrl();
		
		if(PatrioticHatsCat.contains("Patriotic")){
			
			logger.info("Patriotic Hats Category verified");
			
		}
		
		
	}
		
	
	
	public static void verifyImages(){
		
	}
	
	public static void verifyText() throws Exception {
		
		Logger logger=Logger.getLogger("Verify_Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		driver.findElement(HomeLogo).click();
		
		Thread.sleep(5000);
		
        ((JavascriptExecutor)driver).executeScript("scroll(0,1100)");
		
		WebElement ele = driver.findElement(TextHeading1);
		ele.click();
		 
		 String h4heading1 = ele.getText();
		 
		 if (h4heading1.contains("Family Owned and Operated With Family Values and Pride Since 1979!"))	{
			 
			 logger.info("heading verified");
		 }
		
		
		WebElement ele1 = driver.findElement(TextUnderHeading1);
		String h4heading1undertext = ele1.getText();
		
		if(h4heading1undertext.contains("We've been selling wholesale hats, wholesale caps, and fashion headwear")){
			
			logger.info("text under heading verified");
		}
		
}	
	
	public static void verifySignUpEmail(){
		
		
	}
	
	
	public static void verifyFooter(){
		
	}
	
	
	
	
	
	
}

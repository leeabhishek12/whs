package com.whs.pages;
import static org.testng.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;
import com.whs.Utility.Base_Class;
import com.whs.Utility_Log.verifyLink;

public class Home_Page extends Base_Class  {
	
	static By ShopAll = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Shop All']");
	static By Beanies = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Beanies']");
	static By CamouflageHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Camouflage Hats']");
	static By FlexfitHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Flexfit� Hats']");
	static By SnapBackHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Snap Back Hats']");
	static By TruckerHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Trucker Hats']");
	static By WinterHats = By.xpath("//a[@class='dropdown-toggle DeskTopUrl'][text()='Winter Hats']");
	static By HomePageImg = By.xpath("//img[@src='/WhStaging/img/frontend/logoNew.png']");
	static By HomePageSearch = By.xpath("//img[@src='/WhStaging/img/frontend/cartnew.png']");
	static By PatrioticHatsCategory = By.xpath("//a[text()='Patriotic Hats']");
	static By TextHeading1 = By.xpath(".//*[contains(text(), 'World')]");
	static By TextUnderHeading1= By.xpath(".//*[contains(text(),'decades')]");
	static By HomeLogo = By.xpath("//img[@src='/WhStaging/img/frontend/logoNew.png']");
	static By Email = By.xpath("//input[@id='email']");
	static By Submit = By.xpath("//button[text()='Submit']");
	static By MessageforSignUPEmail = By.xpath(".//*[text()= 'You have subscribed successfully']");
	
	
	
	
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
		Thread.sleep(3000);
		 
		 String h4heading1 = ele.getText();
		 
		 if (h4heading1.contains("There's A Reason We've Sold More Wholesale Hats"))	{
			 
			 logger.info("heading verified");
		 }
		 
		 else{
			 logger.info("heading not verified");
		 }
		
		
		WebElement ele1 = driver.findElement(TextUnderHeading1);
		String h4heading1undertext = ele1.getText();
		
		if(h4heading1undertext.contains("For more than three decades, we've been fulfilling wholesale hat orders")){
			
			logger.info("text under heading verified");
		}
		
		else {
			
			logger.info("text under heading not verified");
			
		}
		
		Thread.sleep(4000);
		ele.click();
}	
	
	public static void verifySignUpEmail() throws Exception{
		
		
		Logger logger=Logger.getLogger("Home_Page");
		PropertyConfigurator.configure("Log4j.properties");
		
		((JavascriptExecutor)driver).executeScript("scroll(0,1600)");
		
		Thread.sleep(2000);
		
		// java.util.UUID.randomUUID() will generate random unique no.
		
		driver.findElement(Email).sendKeys(java.util.UUID.randomUUID()+"@gmail.com");
		driver.findElement(Submit).click();
		String messverify = driver.findElement(MessageforSignUPEmail).getText();
		
		if (messverify.contains("You have subscribed successfully")){
			
			logger.info("Sign up for news and offers successfull");
		}
		
	
		else if (messverify.contains("You have subscribed already")){
			
			logger.info("Sign up for news and offers already subscribed");
		}
		
	}
	
	
	//verify all link present in home page
	
	public static void VerifyLinks(){
		
		
        List <WebElement> links= driver.findElements(By.tagName("a"));
		
		
		//List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			
			//call method in verifylink class
			verifyLink.verifyLinkActive(url);
			
		}
	}
	
	
	
	
	
	
	
	
	public static void verifyFooter(){
		
	}
	
	
	
	
	
	
}

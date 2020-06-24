/*
 * Author = Shridhar 
 * Module = Stock Management
*/

package Sigma;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class stockManagement extends Testbase{
	
	//@Test(dataProviderClass = Testbase.class,dataProvider = "dp", priority = 1)
	public static void stockAdjustment(String Location, String Product, String Authorized, String Adjusted, String AdjustType, String Date, String Reasoncode, String Comments,String Unit,String Lot, String Bin, String Expirydate
) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.xpath(OR.getProperty("AppLauncher"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder=\"Search apps and items...\"]")).sendKeys("Stock Management Modules");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder=\"Search apps and items...\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("stadjmod"))).click();
		Thread.sleep(3000);
		
		WebElement location = driver.findElement(By.xpath(OR.getProperty("stadjloc")));
		location.sendKeys(Location);
		Thread.sleep(3000);
        WebElement loc = driver.findElement(By.xpath("//ul[@role='listbox']/child::li/span/span[2]/span"));
        if (loc.isDisplayed()) {
        	Thread.sleep(4000);
        	loc.click();
        	Thread.sleep(2000);
        }
        boolean staleElement = true;
		WebElement Prodt = driver.findElement(By.xpath(OR.getProperty("stadjprd")));
		Prodt.sendKeys(Product);
		Thread.sleep(3000);
        WebElement prod = driver.findElement(By.xpath("//ul[@role='listbox']/child::li"));
        if (prod.isDisplayed()) {
        	Thread.sleep(4000);
        	//prod.click();
        	 
        	while(staleElement){
        	  try{
        	     prod.click();
        	     staleElement = false;
        	  } catch(StaleElementReferenceException e){
        	    staleElement = true;
        	  }
        	}
        	Thread.sleep(2000);
        }

        //Clicking on Search Button        
        driver.findElement(By.xpath(OR.getProperty("stadjsea"))).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        
        //Clicking on Stock Adjustment Button 
        driver.findElement(By.xpath(OR.getProperty("stadjbut"))).click();
        Thread.sleep(2000);
                
        WebElement avlqnty = driver.findElement(By.xpath("//table/tbody/tr/td/div[@title='Available Quantity']/input"));
        String AvailableQty = avlqnty.getText();
        System.out.println("AvailableQty"+AvailableQty);
        
			
		
	        Select type = new Select(driver.findElement(By.xpath(OR.getProperty("stadjtyp"))));
	        Thread.sleep(2000);
	        type.selectByVisibleText(AdjustType);
	        Thread.sleep(2000);
	        

	        
	        Select reason = new Select(driver.findElement(By.xpath(OR.getProperty("stadjres"))));
	        Thread.sleep(2000);
	        reason.selectByVisibleText(Reasoncode);
	        Thread.sleep(2000);
	        
			if(AdjustType.contains("Increase Stock")){
				
				WebElement uni = driver.findElement(By.xpath(OR.getProperty("stadjunit")));
				uni.sendKeys(Unit);
				Thread.sleep(3000);
			}
	        
	        
			WebElement author = driver.findElement(By.xpath(OR.getProperty("stadjaut")));
			author.click();
			Thread.sleep(2000);
			author.sendKeys(Authorized);
			Thread.sleep(3000);
			
	        WebElement aut = driver.findElement(By.xpath("//ul[@role='presentation']/descendant::li/a/div/span[2]"));
	        if (aut.isDisplayed()) {
	        	Thread.sleep(4000);
	        	aut.click();
	        	Thread.sleep(2000);
	        }
	        	      
	        WebElement Qty =driver.findElement(By.xpath("//label[text()='Original Qty']/following::input[1]"));
	        Thread.sleep(2000);       
	        String OriginalQty = Qty.getText();
	        System.out.println("OriginalQty"+OriginalQty);
	        Thread.sleep(2000);
	        
	        WebElement qnty =driver.findElement(By.xpath(OR.getProperty("stadjqnt")));
	        Thread.sleep(2000);       
	        qnty.sendKeys(Adjusted);
	        Thread.sleep(2000);
			
	        WebElement date = driver.findElement(By.xpath(OR.getProperty("stadjdat")));
	        Thread.sleep(2000);
	        date.sendKeys(Date);
	        Thread.sleep(2000);
	        
	        WebElement Cmts = driver.findElement(By.xpath(OR.getProperty("stadjcom")));
	        Thread.sleep(2000);
	        Cmts.sendKeys(Comments);
	        Thread.sleep(2000);
	        
	        WebElement plot = driver.findElement(By.xpath(OR.getProperty("stadjlot")));
	        
	        
	        if(!Lot.isEmpty()) {
	        	plot.sendKeys(Lot);
		        WebElement lot = driver.findElement(By.xpath("//ul[@role='presentation']/descendant::li"));
		        if (lot.isDisplayed()) {
		        	Thread.sleep(4000);
		        	lot.click();
		        	Thread.sleep(2000);
		        }
	        	
	        }
	        

	        WebElement bin1 = driver.findElement(By.xpath(OR.getProperty("stadjbin")));
	        
	        if(!Bin.isEmpty()) {
	        	bin1.sendKeys(Bin);
		        WebElement bin = driver.findElement(By.xpath("//ul[@role='presentation']/descendant::li"));
		        if (bin.isDisplayed()) {
		        	Thread.sleep(4000);
		        	bin.click();
		        	Thread.sleep(2000);
		        }
	        }
	        
	        // Expiry Date
	        WebElement exp = driver.findElement(By.xpath(OR.getProperty("stadjexp")));
	        
	        if(!Expirydate.isEmpty()) {
	        	exp.sendKeys(Expirydate);
	        }

	}
	
	//@Test(dataProviderClass = Testbase.class,dataProvider = "dp", priority = 2)
	public static void stockMovemet(String FromLocation, String	FromBin, String	Product, String	PickQty) throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.xpath(OR.getProperty("AppLauncher"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder=\"Search apps and items...\"]")).sendKeys("Stock Management Modules");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder=\"Search apps and items...\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("stmovetab"))).click();
		Thread.sleep(3000);
		
		WebElement fromloc = driver.findElement(By.xpath(OR.getProperty("stmovefrm")));
		fromloc.sendKeys(FromLocation);
		Thread.sleep(3000);
		boolean staleElement = true;
        WebElement loc = driver.findElement(By.xpath("//ul[@role='presentation']/child::li//div/span[2]"));
        if (loc.isDisplayed()) {
        	Thread.sleep(4000);
        	//loc.click();
        	Thread.sleep(2000);
        	while(staleElement){
          	  try{
          		loc.click();
          	     staleElement = false;
          	  } catch(StaleElementReferenceException e){
          	    staleElement = true;
          	  }
          	}
          	Thread.sleep(2000);
        }
        
		WebElement bin = driver.findElement(By.xpath(OR.getProperty("stmovebin")));
		bin.sendKeys(FromBin);
		Thread.sleep(3000);
        WebElement frmbin = driver.findElement(By.xpath("//ul[@role='listbox']/child::li/span/span[2]"));
        if (frmbin.isDisplayed()) {
        	Thread.sleep(4000);
        	frmbin.click();
        	Thread.sleep(2000);
        }
        List<WebElement> product1 = driver.findElements(By.xpath("//span[@title='Section Title']"));  
        if (product1.contains(Product)) {
        	Thread.sleep(4000);
        	//product1.click();
        	Thread.sleep(2000);
        }
		
	}
	

	@Test(dataProviderClass = Testbase.class,dataProvider = "dp", priority = 3)
	public static void stockCheck(String CheckDate, String VerifyingUser, String LocationName, String Product) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.xpath(OR.getProperty("AppLauncher"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder=\"Search apps and items...\"]")).sendKeys("Stock Management Modules");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder=\"Search apps and items...\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("stchktab"))).click();
		Thread.sleep(3000);
		
		WebElement dat = driver.findElement(By.xpath(OR.getProperty("stchkdat")));
		dat.sendKeys(CheckDate);
		
		WebElement wb = driver.findElement(By.xpath("//div[@class='slds-col slds-size--1-of-5 slds-p-horizontal--Small']//input[@class='slds-input input uiInput uiInputText uiInput--default uiInput--input']"));
		wb.sendKeys(VerifyingUser);
		Thread.sleep(3000);
        WebElement use = driver.findElement(By.xpath("//ul[@role='presentation']/child::li//a//span[2]"));
        if (use.isDisplayed()) {
        	Thread.sleep(4000);
        	use.click();
        	Thread.sleep(2000);
        }
		
	}

}

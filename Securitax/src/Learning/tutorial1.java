package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Sigma.Testbase;

public class tutorial1 extends TestClass {
	
	@Test(priority=1)
	public static void login () throws InterruptedException {
		
		
		
		driver.findElement(By.xpath(Shridhar.getProperty("Username"))).sendKeys("shridharashok@gmail.com");
		Thread.sleep(8000);
		driver.findElement(By.xpath(Shridhar.getProperty("Password"))).sendKeys("password-10");
		Thread.sleep(8000);
		driver.findElement(By.xpath(Shridhar.getProperty("Login"))).click();
		Thread.sleep(8000);
		
		try
	    {
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//nav[@class='appLauncher slds-context-bar__icon-action']//button[1]")).isDisplayed(); //lightning element
	    {
	    Thread.sleep(8000);
	    System.out.println("Switching Lightntning Page Button");
	    }
	    }
	    catch(Exception e)
	    {
	    e.printStackTrace();
	    driver.findElement(By.xpath("//div/a[text()='Switch to Lightning Experience']")).isDisplayed(); //classic element
	      {    
	    Thread.sleep(8000);
	    System.out.println("before click");
	    driver.findElement(By.xpath("//div/a[text()='Switch to Lightning Experience']")).click();  
	    System.out.println("clicked");
	    Thread.sleep(8000);
	   
	    }
	    }
		
		//------Ends here------
		
		 log.debug("login successfull");
		 
		 System.out.println("login successfull");
	}
	@Test(dataProviderClass = TestClass.class, dataProvider = "dp", priority=2)
	public static void purchaseorder(String vendor, String OrderDate, String ExpectedDate, String product, String Quantity,
			String ExpectedDeliveryDate,String Test) throws InterruptedException
	{
		System.out.println("purchaseorder");
		
		driver.findElement(By.xpath(OR1.getProperty("AppLauncher"))).click();
		Thread.sleep(8000);
		System.out.println("AppLauncher");		
		//click on SigmaERP
		driver.findElement(By.xpath(OR1.getProperty("viewAll"))).click();
		Thread.sleep(8000);	
		
		driver.findElement(By.xpath("//div[@data-name='Service']")).click();
		//driver.findElement(By.xpath(OR1.getProperty("SigmaErp"))).sendKeys("SigmaERP 365");
		Thread.sleep(9000);
		System.out.println("SigmaErp");
		//purchase order tab
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='Account']")).click();
		Thread.sleep(5000);
		System.out.println("PurchaseOrdertab");
		 List<WebElement> myElements = driver.findElements(By.xpath(
				"//table[@class=\"slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable\"]//tbody/tr"));
		 System.out.println("List of Accounts"+myElements.size());
		 int count = 0;

		System.out.println("index 1:" + myElements.get(1).getText());
		String tempTD = myElements.get(0).getText();
		System.out.println("tempTD::" + tempTD);
		String lines[] = tempTD.split("\\r?\\n");

		//excel.setCellData("purchaseorder","Test", 2, lines[1]);
		//excel.addSheet("Test");
		//excel.removeSheet("Test");
		//excel.removeColumn("purchaseorder",9);
	}
}

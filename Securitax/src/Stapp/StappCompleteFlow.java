package Stapp;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class StappCompleteFlow extends Testbase
{
	
		  @Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 1,alwaysRun = true)
			public static void Account (String AccountType, String AccountName,String CustomerType,String Emailaddress,String Phone,String Shippingstreet,String Shippingcity,String ShippingZip,String ShippingState,String Shippingcountry,String  Billingstreet,String Billingcity ,String BillingZip ,String BillingState ,String  BillingCountry,String FirstName,String LastName,String Mobile,String Email) throws InterruptedException
			{

					Thread.sleep(8000);
					
					System.out.println("clicks on Accounts tab");
					//click on locations tab
					//driver.findElement(By.xpath("(//div[@class=\"slds-grid slds-has-flexi-truncate navUL\"]//span[@class=\"slds-truncate\"])[9]")).click();
					driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[2]")).click();
					Thread.sleep(4000);
					System.out.println("Account clicked");
					
					System.out.println(" Clicking on new Button");
					//click on new button
					driver.findElement(By.xpath("(//ul[@class='branding-actions slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//li)[1]")).click();
					Thread.sleep(5000);
					System.out.println("Done with clicking new");
					
					if(AccountType.equals("Customer"))
				{
						
						System.out.println(" Clicking on Customer Button");
						driver.findElement(By.xpath("(//div[@class='changeRecordTypeRow']/descendant::span[@class='slds-radio--faux'])[1]")).click();
						Thread.sleep(5000);
						System.out.println("Done with clicking on Customer Button");
					
						System.out.println(" Clicking on next  Button");
						driver.findElement(By.xpath("//span[text()='Next']")).click();
						Thread.sleep(3000);
						System.out.println("Done with clicking on next button");
					 
						System.out.println(" Clicking on Account Button");
						WebElement  w1= driver.findElement(By.xpath("((//div[@class='slds-form-element__control'])//input)[2]"));
						w1.sendKeys(AccountName);
						Thread.sleep(3000);
						System.out.println(" Done with Clicking on Account Button");
					 
						System.out.println("licking on Customer type Menu");
						driver.findElement(By.xpath("(//div[@class='uiMenu'])[7]")).click();
						Thread.sleep(3000);
						System.out.println(" Done with  Clicking Customer type Menu");
					 
					 
						System.out.println("Selecting  Customer type value"); 
						List<WebElement> lst1 = driver.findElements(By.xpath("(//div[@class='select-options']//ul)[3]//li"));
						System.out.println(lst1);
						for (WebElement we : lst1)
						{
						 if (we.getText().contains(CustomerType))
						 	{
							 		Thread.sleep(5000);
							 		we.click();
							 		

						 	}
						}
						Thread.sleep(3000);
						System.out.println("Done with Selecting  Customer type value"); 
					 
					 
						System.out.println("Providing Email");
						WebElement  w12= driver.findElement(By.xpath("//label[.='Email address']/following::input[1]"));
						w12.sendKeys(Emailaddress);
						Thread.sleep(3000);
					 
						System.out.println("Providing PhoneNO");
						WebElement  w13= driver.findElement(By.xpath("//label[.='Phone']/following::input[1]"));
						w13.sendKeys(Phone);
						Thread.sleep(3000);
					 
						 
						//scroll down
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,250)", "");
						Thread.sleep(8000);
					 
						// driver.findElement(By.xpath("(//div[@class='select-options popupTargetContainer uiPopupTarget uiMenuList uiMenuList--default uiMenuList--left uiMenuList--short']//div[@class='select-options']//ul)[3]")).click();
					
					 
						WebElement w2 = driver.findElement(By.xpath("(//div[@class='form-element__row'][1])[1]//descendant::textarea"));
						System.out.println("Shippingstreet");
						w2.sendKeys(Shippingstreet);
						Thread.sleep(3000);
					 
					 
						WebElement w3 = driver.findElement(By.xpath("(//div[@class='form-element__row'][2])[1]//descendant::input[1]"));
						System.out.println("Shippingcity");
						w3.sendKeys(Shippingcity);
						Thread.sleep(3000);
					
						WebElement w4 = driver.findElement(By.xpath("((//div[@class='form-element__row'][3])[1]//descendant::input)[1]"));
						System.out.println("ShippingZip");
						w4.sendKeys(ShippingZip);
						Thread.sleep(3000);
					 
						WebElement w5 = driver.findElement(By.xpath("((//div[@class='form-element__row'][2])[1]//descendant::input)[2]"));
						System.out.println("ShippingState");
						w5.sendKeys(ShippingState);
					 	Thread.sleep(3000);
					 
					 	WebElement w6 = driver.findElement(By.xpath("(//div[@class='form-element__row'][3])[1]/descendant::input[2]"));
					 	System.out.println("Shippingcountry");
					 	w6.sendKeys(Shippingcountry);
					 	Thread.sleep(3000);
					 
					 
					 	WebElement w7 = driver.findElement(By.xpath("(//div[@class='form-element__row'][1])[2]//descendant::textarea"));
					 	System.out.println("Billingstreet");
					 	w7.sendKeys(Billingstreet);
					 	Thread.sleep(3000);
					 
					 	WebElement w8 = driver.findElement(By.xpath("(//div[@class='form-element__row'][2])[2]//descendant::input"));
					 	System.out.println("Billingcity");
					 	w8.sendKeys(Billingcity);
					 	Thread.sleep(3000);
					 
					 	WebElement w9 = driver.findElement(By.xpath("((//div[@class='form-element__row'][3])[2]/descendant::input)[1]"));
					 	System.out.println("BillingZip");
					 	w9.sendKeys(BillingZip);
					 	Thread.sleep(3000);
					 
					 	WebElement w10 = driver.findElement(By.xpath("((//div[@class='form-element__row'][2])[2]/descendant::input)[2]"));
					 	System.out.println("BillingState");
					 	w10.sendKeys(BillingState);
					 	Thread.sleep(3000);
					 
					 	WebElement w11 = driver.findElement(By.xpath("(//div[@class='form-element__row'][3])[2]/descendant::input[2]"));
					 	System.out.println("BillingCountry");
					 	w11.sendKeys(BillingCountry);
					 	Thread.sleep(3000);
					 
					 	System.out.println("clicking on save Button");
					 	//clicking on save Button
					 	driver.findElement(By.xpath("(//button/following::span[.='Save'])[2]")).click();
					 	Thread.sleep(5000);
					 	System.out.println("done with clicking on save Button");
					 	Thread.sleep(8000);
					
					System.out.println("click on related");
					//click on related
					//driver.findElement(By.xpath("(//div[@class='uiTabBar']//ul//li//span[text()='Related'])[3]")).click();
					Thread.sleep(5000);
					System.out.println("Done with click on related ");
						
						
					 	System.out.println(" Clicking on new Button of Contacts");
					 	//click on new button
					 	driver.findElement(By.xpath("(//span[@title='Contacts']//following::div//ul//li/descendant::div[.='New'])[3]")).click();
					 	Thread.sleep(5000);
					 	System.out.println("Done with clicking new");
					 	Thread.sleep(5000);
					
					
					 	System.out.println(" Providing First name");
					 	WebElement w14 = driver.findElement(By.xpath("//label[.='First Name']/following::input[1]"));
					 	w14.sendKeys(FirstName);
					 	Thread.sleep(5000);
					

					 	System.out.println(" Providing Last name");
					 	WebElement w15 = driver.findElement(By.xpath("//label[.='First Name']/following::input[2]"));
					 	w15.sendKeys(LastName);
					 	Thread.sleep(5000);
					
					 	System.out.println(" Providing Mobile Number");
					 	WebElement w16 = driver.findElement(By.xpath("(//label[.='Mobile']/following::input)[1]"));
					 	w16.sendKeys(Mobile);
					 	Thread.sleep(5000);
					
					 	System.out.println(" Providing Email");
					 	WebElement w17 = driver.findElement(By.xpath("(//label[.='Email']/following::input)[1]"));
					 	w17.sendKeys(Email);
					 	Thread.sleep(5000);
					
					 	System.out.println(" Clicking on save");
					 	driver.findElement(By.xpath("(//button/following::span[.='Save'])[2]")).click();
					 	Thread.sleep(15000);
					
				}
					
				else
						if(AccountType.equals("Vendor"))
					{
							Thread.sleep(5000);
							System.out.println(" Clicking on Vendor Button");
							driver.findElement(By.xpath("(//div[@class='changeRecordTypeRow']/descendant::span[@class='slds-radio--faux'])[3]")).click();
							Thread.sleep(5000);
							System.out.println("Done with clicking on Customer Button");
							
							
							System.out.println(" Clicking on next  Button");
							 driver.findElement(By.xpath("//span[text()='Next']")).click();
							 Thread.sleep(3000);
							 System.out.println("Done with clicking on next button");
							
							

							 System.out.println(" Providing  Account name");
							 WebElement  v1= driver.findElement(By.xpath("((//div[@class='slds-form-element__control'])//input)[2]"));
							 v1.sendKeys(AccountName);
							 Thread.sleep(3000);
							 System.out.println(" Done with Clicking on Account Button");
							
							
							 System.out.println("Providing PhoneNO");
							 WebElement v2 = driver.findElement(By.xpath("(//label[.='Phone']/following::input)[1]"));
							 v2.sendKeys(Phone);
							 Thread.sleep(3000);
							
							 
							 System.out.println("Providing Email");
							 WebElement v3= driver.findElement(By.xpath("//label[.='Email address']/following::input[1]"));
							 v3.sendKeys(Emailaddress);
							 Thread.sleep(3000);
							
							 WebElement  v4 = driver.findElement(By.xpath("(//div[@class='form-element__row'][1]//descendant::textarea)[1]"));
							 v4.sendKeys(Shippingstreet);
							 Thread.sleep(3000);
							 
							 
							 WebElement  v5 = driver.findElement(By.xpath("(//div[@class='form-element__row'][2])[1]//descendant::input"));
							 v5.sendKeys(Shippingcity);
							 Thread.sleep(3000);
							
							 WebElement  v6 = driver.findElement(By.xpath("((//div[@class='form-element__row'][3])[1]//descendant::input)[1]"));
							 v6.sendKeys(ShippingZip);
							 Thread.sleep(3000);
							 
							 WebElement  v7 = driver.findElement(By.xpath("((//div[@class='form-element__row'][2])[1]//descendant::input)[2]"));
							 v7.sendKeys(ShippingState);
							 Thread.sleep(3000);
							 
							 WebElement  v8 = driver.findElement(By.xpath("(//div[@class='form-element__row'][3])[1]/descendant::input[2]"));
							 v8.sendKeys(Shippingcountry);
							 Thread.sleep(3000);
							 
							 
							 WebElement  v9 = driver.findElement(By.xpath("(//div[@class='form-element__row'][1])[2]//descendant::textarea"));
							 v9.sendKeys(Billingstreet);
							 Thread.sleep(3000);
							 
							 WebElement  v10 = driver.findElement(By.xpath("(//div[@class='form-element__row'][2])[2]//descendant::input"));
							 v10.sendKeys(Billingcity);
							 Thread.sleep(3000);
							 
							 WebElement  v11 = driver.findElement(By.xpath("((//div[@class='form-element__row'][3])[2]/descendant::input)[1]"));
							 v11.sendKeys(BillingZip);
							 Thread.sleep(3000);
							 
							 WebElement  v12 = driver.findElement(By.xpath("((//div[@class='form-element__row'][2])[2]/descendant::input)[2]"));
							 v12.sendKeys(BillingState);
							 Thread.sleep(3000);
							 
							 WebElement  v13 = driver.findElement(By.xpath("(//div[@class='form-element__row'][3])[2]/descendant::input[2]"));
							 v13.sendKeys(BillingCountry);
							 Thread.sleep(3000);
							 
							 System.out.println("clicking on save Button");
							//clicking on save Button
							 driver.findElement(By.xpath("(//button/following::span[.='Save'])[2]")).click();
							 Thread.sleep(5000);
							System.out.println("done with clicking on save Button");
							Thread.sleep(8000);
							
							System.out.println(" Clicking on new Button of Contacts");
							//click on new button
							driver.findElement(By.xpath("(//span[@title='Contacts']//following::div//ul//li/descendant::div[.='New'])[1]")).click();
							Thread.sleep(5000);
							System.out.println("Done with clicking new");
							Thread.sleep(5000);
							
							
							System.out.println(" Providing First name");
							WebElement w14 = driver.findElement(By.xpath("//label[.='First Name']/following::input[1]"));
							w14.sendKeys(FirstName);
							Thread.sleep(5000);
							

							System.out.println(" Providing Last name");
							WebElement w15 = driver.findElement(By.xpath("//label[.='First Name']/following::input[2]"));
							w15.sendKeys(LastName);
							Thread.sleep(5000);
							
							System.out.println(" Providing Mobile Number");
							WebElement w16 = driver.findElement(By.xpath("(//label[.='Mobile']/following::input)[1]"));
							w16.sendKeys(Mobile);
							Thread.sleep(5000);
							
							System.out.println(" Providing Email");
							WebElement w17 = driver.findElement(By.xpath("(//label[.='Email']/following::input)[1]"));
							w17.sendKeys(Email);
							Thread.sleep(5000);
							
							System.out.println(" Clicking on save");
							driver.findElement(By.xpath("(//button/following::span[.='Save'])[2]")).click();
							Thread.sleep(15000l);
							
					}
			}
		   
		   

	
	// -----------------------------------------CREATE PRODUCT--------------------------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 2,alwaysRun = true)
	public static void product(String RecordType, String ProductName, String AttributeType, String ProductCode,String UOM, String Price) throws InterruptedException
	{
		
		System.out.println("Enters Product");
		
		// Products tab
		// driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		 Thread.sleep(8000);
		 //driver.findElement(By.xpath("//button[text()='View All']")).click();
		 Thread.sleep(8000);			
		 //driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Stapp");
		 Thread.sleep(8000);			
		 //driver.findElement(By.xpath("//div[@data-name=\"Stapp\"]")).click();
		//driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[3]")).click();
		Thread.sleep(5000l);

		// New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//driver.findElement(By.xpath("(//div[@class=\"slds-grid\"])[3]//div[@title=\"New\"]")).click();
		Thread.sleep(5000l);

		// Record type
		if (RecordType.equals("BOM"))
		{
			driver.findElement(By.xpath("(//span[@class='slds-radio--faux'])[1]")).click();
			Thread.sleep(3000);
		} 
		else 
		{
			driver.findElement(By.xpath("(//span[@class='slds-radio--faux'])[2]")).click();
			Thread.sleep(3000);
		}

		// Next button
		driver.findElement(By.xpath("//div[@class=\"forceChangeRecordTypeFooter\"]/button[2]")).click();
		Thread.sleep(3000);

		// Product name field
		driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input'])[1]//input"))
				.sendKeys(ProductName);
		Thread.sleep(3000);

		// Attribute type
		driver.findElement(By.xpath("//span[text()='Attribute Type']/following::a[1]")).click();
		if (AttributeType.equals("BULK"))
		{
			driver.findElement(By.xpath("//a[@title='BULK']")).click();
		} 
		else 
		{
			driver.findElement(By.xpath("//a[@title='SERIALIZED']")).click();
		}

		// Product code
		// driver.findElement(By.xpath("(//div[@class='uiInput uiInputText
		// uiInput--default
		// uiInput--input'])[2]//input")).sendKeys(ProductCode);
		driver.findElement(By.xpath("(//span[text()='Product Code'])[2]/following::input[1]")).sendKeys(ProductCode);
		Thread.sleep(3000);

		// Active button click
		driver.findElement(By.xpath("//span[text()='Active']//following::input[1]")).click();
		// driver.findElement(By.xpath("(//div[@class='uiInput uiInputCheckbox
		// uiInput--default uiInput--checkbox'])[1]//input")).click();
		Thread.sleep(3000);

		// Stock item click
		// driver.findElement(By.xpath("(//div[@class='uiInput uiInputCheckbox
		// uiInput--default uiInput--checkbox'])[3]//input")).click();
		driver.findElement(By.xpath("//span[text()='Stock Item']//following::input[1]")).click();
		Thread.sleep(3000);

		// clicking on dimension tag
		driver.findElement(By.xpath("(//a[@class='select'])[4]")).click();
		driver.findElement(By.xpath("//a[@title='Yes']")).click();
		Thread.sleep(3000);

		// UOM
		driver.findElement(By.xpath("(//span[text()=\"UOM\"]/following::a)[1]")).click();
		Thread.sleep(5000);
		List<WebElement> lst1 = driver.findElements(By.xpath("(//div[@class=\"select-options\"])[7]/descendant::li"));
		System.out.println(lst1);
		for (WebElement we : lst1)
		{
			if (we.getText().contains(UOM)) 
			{
				Thread.sleep(5000);
				we.click();

			}
		}

		// Clicks on save button
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(7000);

		// Goes to related list
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//a[@data-tab-name='relatedListsTab']")));
		//driver.findElement(By.xpath("//a[@data-tab-name='relatedListsTab']")).click();
		//WebElement relate = driver.findElement(By.xpath("//span[text()='Related']"));
		Thread.sleep(3000);
		myDynamicElement.click();
		Thread.sleep(5000);

		// clicks on add standard price book button
		driver.findElement(By.xpath("//div[text()='Add Standard Price']")).click();
		Thread.sleep(5000);

		// entering value of list price
		driver.findElement(By.xpath("//span[text()='List Price']/following::input[1]")).sendKeys(Price);
		Thread.sleep(5000);

		// clicking on save button
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(10000);

		System.out.println("product creation sucessfull");
	}

	

	// ----------------------------------------PURCHASE ORDER------------------------------------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority =3,alwaysRun = true)
	public static void transactions(String PURCHASEORDERTYPE, String ACCOUNT, String CONTACT, String PRODUCT, String QTY) throws InterruptedException {
		Thread.sleep(18000);

		System.out.println("entered transaction tab");

		// clicks on Transaction tab
		driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[4]")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//div[@class=\"bBottom\"]/descendant::span[text()='Transactions']")).click();
		
		 // driver.findElement(By.xpath("//a//span[text()='Transactions']")).
		  //click(); Thread.sleep(5000);
		 

		// clicks on New
		driver.findElement(By.xpath("//a[@class='forceActionLink'][@title='New']/ancestor::li")).click();
		Thread.sleep(3000);

		// select purchase order type
		WebElement POT1 = driver.findElement(By.xpath("//label[text()='Transaction Type']/following::input[1]"));
		POT1.click();
		Thread.sleep(3000);
		POT1.sendKeys(PURCHASEORDERTYPE);
		Thread.sleep(5000);

		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class=\"slds-show slds-lookup__menu\"]/ul/li"));
		for (WebElement we : list2)
		{
			if (we.getText().contains(PURCHASEORDERTYPE)) 
			{
				Thread.sleep(5000);
				we.click();
			}
		}
		Thread.sleep(5000);
        // clicks on accept button
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		Thread.sleep(10000);
		// select account
		driver.findElement(By.xpath("//label[text()='Account']/following::input[1]")).sendKeys(ACCOUNT);
		Thread.sleep(5000);

		
		List<WebElement> list3 = driver.findElements(By.xpath("(//div[@class=\"scrollable uiScrollerWrapper\"])[2]//ul/li"));
		for (WebElement we : list3) {
			System.out.println("We"+we.getText());
			if (we.getText().contains(ACCOUNT)) 
			{
				Thread.sleep(5000);
				we.click();
			}
		}

		// select contact
/*		driver.findElement(By.xpath("//label[text()='Contact']/following::input[1]")).sendKeys(CONTACT);
		Thread.sleep(5000);

		List<WebElement> list4 = driver
				.findElements(By.xpath("(//div[@class=\"scrollable uiScrollerWrapper\"])[3]//ul/li"));
		for (WebElement we : list4) {
			if (we.getText().contains(CONTACT)) {
				Thread.sleep(5000);
				we.click();
			}
		}*/

		// clicks on Save button
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(18000);

		// scroll down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(6000);

		// adding product
		driver.findElement(By.xpath("(//div[@title='Product']/following::input)[3]")).sendKeys(PRODUCT);
		Thread.sleep(5000);

		List<WebElement> list5 = driver.findElements(By.xpath("(//div[@class=\"slds-form-element__control slds-input-has-icon slds-input-has-icon_right\"])[6]//following::ul/li"));
		for (WebElement we : list5) 
		{
			if (we.getText().contains(PRODUCT)) 
			{
				we.click();
				Thread.sleep(7000);
				
			}
		}

		Thread.sleep(10000);
	
		//try{
		// enter quantity
		
				
		driver.findElement(By.xpath("(//div[@title='Quantity']/following::input)[5]")).clear();
		driver.findElement(By.xpath("(//div[@title='Quantity']/following::input)[5]")).sendKeys(QTY);
	
		
		System.out.println("Clicks on Qty field");
		
		
		
		//clicks on save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(10000);

		//clicks on Transaction tab to get TD number
		driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[4]")).click();
		Thread.sleep(5000);

		List<WebElement> myElements = driver.findElements(By.xpath("//table[@class=\"slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable\"]/descendant::tbody/tr"));
		   int count=0;
		   
		   System.out.println("index 1:"+myElements.get(1).getText());
		   String tempTD = myElements.get(0).getText();
		   System.out.println("tempTD::"+tempTD);
		   String lines[] = tempTD.split("\\r?\\n");
		  
		   excel.setCellData("stockreceiving", "TDNO", 2, lines[1]);
	}


	// ----------------------------------STOCK RECEIVING--------------------------------------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 4, alwaysRun = true)
	public static void stockreceiving(String Vendor, String Company, String Warehouse, String TDNO,
			String Quantity, String Bin) throws InterruptedException 
	{

		Thread.sleep(10000);

		// clicks on SR tab
		// driver.findElement(By.xpath("//a[@title=\"Stock
		// Receiving\"]")).click();
		driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[5]")).click();
		Thread.sleep(5000);

		// clicks on new
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(5000);

		// clicks on vendor
		driver.findElement(By.xpath("//label[text()=\"Vendor\"]/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()=\"Vendor\"]/following::input[1]")).sendKeys(Vendor);
		Thread.sleep(5000);
		WebElement vendorclick = driver.findElement(By.xpath(
				"(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"])[1]/li[1]"));

		if (vendorclick.isDisplayed()) 
		{
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"])[1]/li[1]")).click();
			Thread.sleep(6000);
		}
		Thread.sleep(6000);
		
/*		//click on company
		//WebElement Comp1 = driver.findElement(By.xpath("(//label[text()='Company']/following::input)[1]"));
		//Comp1.click();
		Thread.sleep(2000);
		//Comp1.sendKeys(Company);
		Thread.sleep(5000);
		
		WebElement CompanyClick = driver.findElement(By.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"])[3]/li[1]"));	
		
		if (CompanyClick.isDisplayed()) 
		{
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"])[3]/li[1]")).click();
			Thread.sleep(6000);
		}
		Thread.sleep(5000);*/

		// clicks on warehouse
		//driver.findElement(By.xpath("(//button[@class=\"slds-button slds-pill__remove slds-button_icon-bare\"])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()=\"Warehouse Location\"]/following::input[1]")).clear();
		driver.findElement(By.xpath("//label[text()=\"Warehouse Location\"]/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()=\"Warehouse Location\"]/following::input[1]")).sendKeys(Warehouse);
		Thread.sleep(5000);
		WebElement warehouse = driver.findElement(By.xpath("(//ul[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds'])[4]/li"));

		if (warehouse.isDisplayed()) 
		{
			Thread.sleep(5000);

			driver.findElement(By.xpath("(//ul[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds'])[4]/li")).click();
		}
		Thread.sleep(5000);

		// enter receive date
		driver.findElement(By.xpath("//span[text()='Receiving DateTime']//following::input[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(6000);

		// click on add more products
		driver.findElement(By.xpath("//button[text()='Add more transactions']")).click();
		Thread.sleep(5000);

		// select transaction
		driver.findElement(By.xpath("//label[text()='Select Transaction']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='Select Transaction']/following::input[1]")).sendKeys(TDNO);
		//List<WebElement> td = driver.findElements(By.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"])[5])"));
		
		
	  
	     Actions action=new Actions(driver);	
	     
	     WebElement ele1= new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-aura-class=\"stappStockReceivingLineItem\"]/descendant::ul")));
	    driver.findElement(By.xpath("//div[@data-aura-class=\"stappStockReceivingLineItem\"]/descendant::ul"));
	    Thread.sleep(5000);
	     ele1.click();
	     System.out.println("Select transaction");
	     action.click();
	 	action.build().perform();			
		
		
		//till here
		Thread.sleep(6000);

		// quantity
		driver.findElement(By.xpath("//td[@data-label='Receiving QTY']/input")).clear();
		driver.findElement(By.xpath("//td[@data-label='Receiving QTY']/input")).sendKeys(Quantity);
		Thread.sleep(6000);

		// selecting bin
		driver.findElement(By.xpath("(//span[@title=\"record\"])[3]/following::input[1]")).sendKeys(Bin);
		WebElement bin = driver.findElement(By.xpath("(//ul[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds'])[3]"));

		if (bin.isDisplayed()) 
		{
			Thread.sleep(6000);

			driver.findElement(By.xpath("(//ul[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds'])[3]")).click();
		}
		Thread.sleep(6000);

		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		Thread.sleep(3000);

	}

	/*// ----------------------------------STAPP ORDER--------------------------------------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 5,alwaysRun = true)
	public void stappOrder(String CustomerOrderNumber, String Customer, String OrderSource, String Status,
			String Currency, String Contact) throws InterruptedException
	{

		Thread.sleep(20000);

		// New Stapp Order
		// driver.findElement(By.xpath("//one-app-nav-bar/descendant::li/descendant::span[text()=\"Stapp
		// Orders\"]")).click();
		driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[6]")).click();
		System.out.println("Click on Stapp Order Tab");

		// New Button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role=\"banner\"]/div[1]/descendant::li[2]")).click();
		System.out.println("Click on New Button");

		// Customer Order Number
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class=\"slds-card__body\"]/descendant::input[1]"))
				.sendKeys(CustomerOrderNumber);
		System.out.println("Customer Order Number");

		// Customer Name
		Thread.sleep(5000);
		
		WebElement wd1 = driver.findElement(By.xpath("//label[text()=\"Customer\"]/following::input[1]"));
		Thread.sleep(3000);
		wd1.click();
		wd1.sendKeys(Customer);
		Thread.sleep(5000);
		
		
		WebElement Customer1 = driver.findElement(By.xpath("//label[text()='Customer']/following::ul[1]/li[1]"));

		if (Customer1.isDisplayed()) 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[text()='Customer']/following::ul[1]/li[1]")).click();
			Thread.sleep(3000);
		}
		
		driver.findElement(By.xpath("//label[text()=\"Customer\"]/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()=\"Customer\"]/following::input[1]")).sendKeys(Customer);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title=\"Automation Testing-Customer\"]")).click();
		System.out.println("Customer Name");

		
		// Status
		
		  Thread.sleep(5000); driver.findElement(By.
		  xpath("//div[@class=\"slds-grid slds-wrap paddingAround\"]/div[6]")).
		  click(); List<WebElement> status = driver.findElements(By.xpath(
		 "(//div[@class=\"select-options\"])[4]/descendant::li"));
		  System.out.println("ListofFrames::+"+status); for (WebElement we :
		  status) {
		  
		  if (we.getText().equalsIgnoreCase(Status)) {
		  
		  Thread.sleep(5000l); Actions act1 = new Actions(driver);
		  act1.click(we); act1.build().perform();
		  
		  } }
		 

		// status
		WebElement we4 = driver.findElement(By.xpath("//span[text()='Status']//following::select[3]"));
		Select option1 = new Select(we4);
		option1.selectByVisibleText(Status);

		// Contact LookUp
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()=\"Contact\"]/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()=\"Contact\"]/following::input[1]")).sendKeys(Contact);
		Thread.sleep(3000);
		
		
		WebElement CustContact = driver.findElement(By.xpath("//label[text()='Contact']/following::ul[1]/li[1]"));		
		System.out.println("Contact Lookup");

		if (CustContact.isDisplayed()) 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[text()='Customer']/following::ul[1]/li[1]")).click();
			Thread.sleep(3000);
		}
		// Clicks on Ready for picking
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux'])[3])")).click();
		Thread.sleep(3000);

	}

	// --------------------------------------StappOrderLine-----------------------------------------------------
	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 6,alwaysRun = true)

	public void stapporderline(String PRODUCT, String QTY) throws InterruptedException 
	{
		Thread.sleep(10000);
		
	    int k,j;
	   
		int Rowcount = Testbase.row;
		System.out.println("Rowcount=="+Rowcount);
		int NumberofOrderLines= Rowcount-1;
		System.out.println("NumberofProducts=="+NumberofOrderLines);
		
		
		
		//int Columncount = Testbase.col;
		//System.out.println("Columncount=="+Columncount);
		
	    Scroll(); 
	
		Stapporderline();
				
		for(k=1,j=4;k<=NumberofOrderLines;k=k+1,j=j+2)	
		{
		// adding product
		driver.findElement(By.xpath("//tr ["+k+"][@class=\"stappStappOrderLines\"]/descendant::input[2]")).sendKeys(PRODUCT);
       System.out.println("//tr ["+k+"][@class=\\\"stappStappOrderLines\\\"]/descendant::input[2]");
		Thread.sleep(3000);
		
		Scroll();
		
		
		 Actions action=new Actions(driver);	
		 
		 WebElement ele1= new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title=\"PRODUCT\"]/following::ul["+j+"]/descendant::li[1]")));
		 System.out.println("//div[@title=\\\"PRODUCT\\\"]/following::ul["+j+"]/descendant::li[1]");
		 driver.findElement(By.xpath("//div[@title=\"PRODUCT\"]/following::ul[1]/descendant::li[1]"));
         ele1.click();
        System.out.println("Select Stapp order");
        action.click();
	    action.build().perform();

	
	    
	    
		// Quantity
		driver.findElement(By.xpath("(//td[@data-label=\"QTY\"])["+k+"]/input")).sendKeys(QTY);
		System.out.println("Click on Quantity");
		Thread.sleep(5000);

		// AutoAllocation Button
		driver.findElement(By.xpath("//button[text()=\"A\"]")).click();
		System.out.println("Click on Allocation Button");
		Thread.sleep(5000);

		// AutoAllocation Button
		Alert alert = driver.switchTo().alert();
		alert.accept();
		

		Thread.sleep(5000);
		 Actions actions = new Actions(driver);
		 actions.moveToElement(Element);
		 actions.perform();
	
		
		if( NumberofOrderLines > 1 )
		{
			Thread.sleep(5000);
			Scroll();
			Stapporderline();
			
		}
		
		
		//NumberofOrderLines--;
		
			}
		
		// Save Button
				Thread.sleep(5000);
			   driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
				System.out.println("Clicked Save");

	}
	public boolean Stapporderline() throws InterruptedException
	{
	// Add Stapp OrderLines
	driver.findElement(By.xpath("//button[text()=\"Add Order Lines\"]")).click();
	System.out.println("Click on Add Order Lines");
	Thread.sleep(5000);
	
	return true;
	}
		
	public String Scroll() throws InterruptedException
	{
		// Scroll upto the Element Found
				WebElement ele = driver.findElement(By.xpath("//button[text()=\"Add Order Lines\"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
				Thread.sleep(500);
       return "Sucess";
	}
	

	
		
	

	// ----------------------------------------Create Picking-----------------------------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 7,alwaysRun = true)
	public void picking(String StappOrder, String BasketPickingNo, String PickedQty) throws InterruptedException {

		Thread.sleep(1000);

		// clicks on Transaction tab
		Click("//button[@class=\"slds-button\"]");
		Thread.sleep(5000);
		driver.findElement(By
				.xpath("//div[@class=\"modal-header slds-modal__header\"]/descendant::div[@class=\"uiInput uiInputText uiInput--default uiInput--input\"]/input"))
				.sendKeys("Picking");
		Thread.sleep(3000);
		Click("(//ul[@class=\"slds-grid slds-grid--pull-padded slds-wrap list\"]/descendant::mark[text()=\"Picking\"])[1]");

		Thread.sleep(10000);
		// Stapp Order
		driver.findElement(By.xpath("(//label[text()=\"Stapp Order\"]/following::input)[1] ")).sendKeys(StappOrder);
		// Lookup Items
		Thread.sleep(5000);
		driver.findElement(By
				.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"]/descendant::li)[1]"))
				.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=\"Start Picking\"]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()=\"Basket Picking No\"]/following::input)[1]"))
				.sendKeys(BasketPickingNo);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[@id=\"rowData_0\"]/descendant::input")).sendKeys(PickedQty);

		Thread.sleep(5000);
		// driver.findElement(By.xpath("//button[text()=\"Alt
		// Pick\"]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();

	}

	// ----------------------------------------Create Package-----------------------------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 8,alwaysRun = true)
	public void packages(String Customer, String SelectSO) throws InterruptedException
	{

		Thread.sleep(10000);

		// clicks on App launcher
		
		  Click("//button[@class=\"slds-button\"]"); Thread.sleep(5000);
		  driver.findElement(By.
		  xpath("//div[@class=\"modal-header slds-modal__header\"]/descendant::div[@class=\"uiInput uiInputText uiInput--default uiInput--input\"]/input"
		  )).sendKeys("Package"); Thread.sleep(3000);
		  Click("//ul[@class=\"slds-grid slds-grid--pull-padded slds-wrap list\"]/descendant::mark[text()=\"Package\"]"
		  ); Thread.sleep(10000);
		 

		// clicks on package tab
		driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[7]")).click();
		Thread.sleep(8000);

		// New Button
		driver.findElement(By.xpath("//div[@title=\"New\"]")).click();
		Thread.sleep(8000);

		// Customer Lookup Items and sends customer name
		driver.findElement(By
				.xpath("(//article[@class=\"slds-card stappPackage\"]/descendant::label[text()=\"Customer\"]/following::input)[1]"))
				.sendKeys(Customer);
		Thread.sleep(5000);
		// select's customer from list
		driver.findElement(By
				.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"]/descendant::li)[1]"))
				.click();
		Thread.sleep(5000);

		// selects SO
		driver.findElement(By.xpath("//label[text()=\"Select SO\"]/following::input")).sendKeys(SelectSO);
		Thread.sleep(5000);
		// select SO from list
		driver.findElement(By
				.xpath("(//ul[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-lookup__menu slds\"]/descendant::span)[1]"))
				.click();
		Thread.sleep(10000);
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//button[text()='Save']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 

		
		//xpath for save button --- //button[@class=\"slds-button slds-button_brand buttonOverlay\"]
		//xpath for proceed to shipment button --- driver.findElement(By.xpath("//button[text()=\"Proceed To Shipment\"]"));
		
		// clicks on Proceed to Shipment button
		WebElement element = driver
				.findElement(By.xpath("//button[text()=\"Proceed To Shipment\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(8000);

		// Again clicks on package tab
		// driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[7]")).click();
		// Thread.sleep(5000);

		// to get package number
		List<WebElement> myElements = driver.findElements(By.xpath(
				"//table[@class=\"slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable\"]/descendant::tbody/tr"));
		System.out.println("pacakge NO::" + myElements);
		int count = 0;
		// for(WebElement e : myElements) {
		// System.out.print(count);
		// System.out.println(e.getText());
		// count++;
		// }
		System.out.println("index 1:" + myElements.get(1).getText());
		String tempPK = myElements.get(0).getText();
		System.out.println("tempPK::" + tempPK);
		String lines[] = tempPK.split("\\r?\\n");
		System.out.println(lines[1]);

		// writing package number to shipment excel sheet
		excel.setCellData("shipments", "Package", 2, lines[1]);

	}

	// ---------------------------------------SHIPMENTS-----------------------------------------------
	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 9,alwaysRun = true)

	public static void shipments(String Package, String Carrier, String WayBill, String Status, String Notes)
			throws InterruptedException {

		// Shipment Tab
		Thread.sleep(8000);
		// driver.findElement(By.xpath("//ul[@class=\"slds-grid
		// slds-has-flexi-truncate
		// navUL\"]/descendant::span[text()=\"Shipments\"]")).click();
		//tab
		//driver.findElement(By.xpath("(//one-app-nav-bar/descendant::one-app-nav-bar-item-root)[8]")).click();

		// New Button
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@class=\"slds-grid\"]/descendant::a[@title=\"New\"]")).click();

		// Package
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@data-label=\"Package\"]/descendant::input")).sendKeys(Package);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@id=\"listbox-option-unique-id-01\"]/span[2]/span)[1]")).click();

		// Carrier
		
		driver.findElement(By.xpath("//label[text()=\"Carrier\"]/following::input[1]")).sendKeys(Carrier);
		Thread.sleep(3000);

		// Way Bill
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()=\"WayBill\"]/following::input)[1] ")).sendKeys(WayBill);

		// Status PickList
		Thread.sleep(5000);
		driver.findElement(By.xpath("((//label[text()=\"Status\"])[2]/following::div)[3]")).click();
		List<WebElement> status = driver.findElements(By.xpath("//ul[@class=\"scrollable\"]/li"));
		System.out.println("ListofFrames::+" + status);
		for (WebElement we : status) 
		{
			if (we.getText().equalsIgnoreCase(Status))
			{

				Thread.sleep(5000l);
				Actions act1 = new Actions(driver);
				act1.click(we);
				act1.build().perform();

			}
		}

		// Notes TextField
		Thread.sleep(5000);
		driver.findElement(By.xpath("//textarea")).sendKeys(Notes);

		// Save Button
		WebElement element = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		
		System.out.println("Shipment created ");
		
	}*/

}

	
	
	
	


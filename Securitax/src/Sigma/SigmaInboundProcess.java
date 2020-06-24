//Author = Shridhar 

package Sigma;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SigmaInboundProcess extends Testbase {

	// --------sigma order---------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 5)
	public static void sigmaorder(String CustomerName, String Billingperson, String Currency)
			throws InterruptedException {

		Thread.sleep(2000);
		// driver.manage().window().maximize();
		Thread.sleep(8000);

		// app launcher
		driver.findElement(By.xpath(OR.getProperty("AppLauncher"))).click();
		Thread.sleep(8000);

		// click on SigmaERP
		driver.findElement(By.xpath(OR.getProperty("SigmaErp"))).click();
		Thread.sleep(8000);

		System.out.println("sigmaorder");

		// sigma order
		driver.findElement(By.xpath(OR.getProperty("SigmaOrdertab"))).click();
		Thread.sleep(5000);

		// switching to frame
		WebElement fr = driver.findElement(By.xpath(OR.getProperty("SOframe")));
		driver.switchTo().frame(fr);
		System.out.println(" switching  to frame");
		Thread.sleep(6000);

		// sales order
		// driver.findElement(By.xpath(OR.getProperty("SalesOrder"))).click();
		driver.findElement(By.xpath("(//table/tr/td[@class='zoom'])[1]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@name='Sales Order']")).click();
		Thread.sleep(5000);

		// customer name
		WebElement c = driver.findElement(By.xpath(OR.getProperty("Customername")));
		Thread.sleep(5000);

		Actions a1 = new Actions(driver);
		a1.click(c);
		a1.sendKeys(CustomerName);
		Thread.sleep(4000);
		a1.build().perform();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("(//span[@class=\"slds-listbox__option-text slds-listbox__option-text_entity\"])[1]")).click();

		// billing person
		if (!Billingperson.isEmpty()) {
			WebElement b = driver.findElement(By.xpath(OR.getProperty("BillingPerson")));
			Thread.sleep(5000);

			Actions a2 = new Actions(driver);
			a2.click(b);
			Thread.sleep(6000);
			a2.sendKeys(Billingperson);
			Thread.sleep(8000);
			a2.build().perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//span[@class='slds-media__body'])[2]")).click();

		}

		// currency
		WebElement c1 = driver.findElement(By.xpath(OR.getProperty("Currency")));
		// c1.click();
		// c1.clear();
		Thread.sleep(5000);

		Actions a4 = new Actions(driver);
		a4.click(c1);
		Thread.sleep(6000);
		// a4.sendKeys(Currency);
		Thread.sleep(8000);
		// a4.build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='slds-media__body'])[3]")).click();
	}

	public static int firstIndex = 4;
	public static int secondIndex = 1;

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 6)
	public static void sigmaorderline(String Product, String Quantity, String Discount) throws InterruptedException {
		int Rowcount = Testbase.row;

		System.out.println("Rowcount==" + Rowcount);
		int NumberofOrderLines = Rowcount - 1;
		System.out.println("NumberofProducts==" + NumberofOrderLines);

		// add product
		driver.findElement(By.xpath(OR.getProperty("SOAddproduct"))).click();
		Thread.sleep(5000);

		// product
		WebElement pr = driver.findElement(
				By.xpath(("(//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon--right'])["
						+ firstIndex + "]//input")));
		Thread.sleep(5000);

		Actions a3 = new Actions(driver);
		a3.click(pr);
		a3.sendKeys(Product);
		Thread.sleep(4000);
		a3.build().perform();
		Thread.sleep(8000);
		// driver.findElement(By.xpath("(//span[@class='slds-media__body'])["+firstIndex+"]")).click();
		driver.findElement(By.xpath("(//span[@class='slds-listbox__option-text slds-listbox__option-text_entity'])[3]"))
				.click();

		// quantity
		// driver.findElement(By.xpath("(//td[@data-label='Quantity']/input)["+secondIndex+"]")).clear();
		// driver.findElement(By.xpath("(//td[@data-label='Quantity']/input)["+secondIndex+"]")).sendKeys(Quantity);

		driver.findElement(By.xpath("(//td[@data-label='Quantity']/input)[1]")).clear();
		driver.findElement(By.xpath("(//td[@data-label='Quantity']/input)[1]")).sendKeys(Quantity);
		Thread.sleep(5000);

		// discount
		System.out.println("Discount==" + Discount);
		if (Discount.toString().isEmpty()) {

		}

		if (!Discount.toString().isEmpty()) {
			if (Discount.toString().equals("0")) {
				System.out.println("Discountis zero==" + Discount);
			} else {
				System.out.println("Discountis not zero==" + Discount);
			}

		} else {
			driver.findElement(
					By.xpath("(//td[@data-label='DISCOUNT']//div[@class='slds-form-element__control slds-grow']/input)["
							+ secondIndex + "]"))
					.sendKeys(Discount);
			// Discount = "0";
		}
		System.out.println("Final Discountis==" + Discount);

		// add to orders
		// driver.findElement(By.xpath(OR.getProperty("SOAddtoorders"))).click();
		Thread.sleep(5000);

		// next
		// driver.findElement(By.xpath(OR.getProperty("SONext"))).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(10000);

		Alert aa1 = driver.switchTo().alert();
		aa1.accept();

		// driver.findElement(By.xpath("//button[@class='slds-button']"));
		Thread.sleep(8000);

		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		firstIndex = firstIndex + 1;
		secondIndex = secondIndex + 1;

	}

	@Test(priority = 7)
	public static void sigmaordersave() throws InterruptedException {
		// save
		// driver.findElement(By.xpath(OR.getProperty("SOSave"))).click();
		Thread.sleep(5000);

		// sigma order
		driver.findElement(By.xpath(OR.getProperty("SigmaOrdertab"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//table/tr/td[@class='zoom'])[1]")).click();
		Thread.sleep(5000);

		// Alert aa = driver.switchTo().alert();
		// aa.accept();

		// driver.switchTo().defaultContent();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//tbody/tr[1]/th/span/div/a")).click();

		System.out.println("Clicking on SO");
		Thread.sleep(10000);

		// WebElement wb =
		// driver.findElement(By.xpath("//div[@id='sectionContent-196']//force-record-layout-item[1]//div[1]//div[1]//div[2]//span[1]//slot[1]//slot[1]//lightning-formatted-text[1]"));
		// String st1 = wb.getText();
		// System.out.println("Total Amount " + st1);
		// String total = st1.substring(1);
		// proceed payment
		driver.findElement(By.xpath("//button[text()='Proceed to Payment']")).click();
		Thread.sleep(8000);

		// cash
		driver.findElement(By.xpath("//div[@class=\"payment-img Cash\"]")).click();
		Thread.sleep(8000);

		WebElement wb1 = driver.findElement(By
				.xpath("(//input[@class='slds-input input uiInput uiInputText uiInput--default uiInput--input'])[1]"));
		System.out.println("wb1" + wb1);
		String st = wb1.getText();
		System.out.println("Total Amount " + st);
		Thread.sleep(5000);
		WebElement wb2 = driver.findElement(By.xpath("(//label[@class=\"slds-size--2-of-5\"])[4]"));
		wb2.click();
		Thread.sleep(5000);
		wb2.sendKeys(st);
		// skip payment
		// driver.findElement(By.xpath(OR.getProperty("SkipPayment"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=\"Save Payment\"]")).click();

		Alert aa2 = driver.switchTo().alert();
		aa2.accept();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
	}

	public static String Scroll() throws InterruptedException {
		// Scroll upto the Element Found
		WebElement ele = driver.findElement(By.xpath("//button[text()='Add Order Lines']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(500);
		return "Success";
	}

	// ---------------------------Pick---------------------------------------

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 8)
	public void picking(String SigmaOrder, String User, String PickedQty) throws InterruptedException {

		driver.manage().window().maximize();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//nav[@class='appLauncher slds-context-bar__icon-action']//button[1]")).click();
		Thread.sleep(6000);

		driver.findElement(By.xpath(
				"//div[@class='modal-header slds-modal__header']/descendant::div[@class='uiInput uiInputText uiInput--default uiInput--input']/input"))
				.sendKeys("Pick");
		Thread.sleep(3000);

		Click("(//span/mark[.='Pick'])[1]");
		Thread.sleep(10000);

		// enter so no
		WebElement c = driver.findElement(By.xpath(OR.getProperty("SigmaOrder")));
		Thread.sleep(5000);

		Actions a1 = new Actions(driver);
		a1.click(c);
		a1.sendKeys(SigmaOrder);
		Thread.sleep(2000);
		a1.build().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='slds-media__body']")).click();
		Thread.sleep(3000);

		// select so driver.findElement(By.xpath(OR.getProperty("SelectSO"))).click();
		Thread.sleep(3000);

		// allocate user
		Select dd1 = new Select(driver.findElement(By.xpath(OR.getProperty("AllocateUser"))));
		dd1.selectByVisibleText(User);
		Thread.sleep(8000);

		// allocate driver.findElement(By.xpath(OR.getProperty("Allocate"))).click();
		Thread.sleep(3000);

		// submit alert Alert a = driver.switchTo().alert(); a.accept();

		// enter so no
		WebElement c1 = driver.findElement(By.xpath(OR.getProperty("SigmaOrder")));
		Thread.sleep(5000);

		Actions a2 = new Actions(driver);
		a2.click(c1);
		a2.sendKeys(SigmaOrder);
		Thread.sleep(2000);
		a2.build().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='slds-media__body']")).click();
		Thread.sleep(3000);

		// select so driver.findElement(By.xpath(OR.getProperty("SelectSO"))).click();
		Thread.sleep(3000);

		// click on pick driver.findElement(By.xpath(OR.getProperty("Pick"))).click();
		Thread.sleep(3000);

		// start picking
		driver.findElement(By.xpath(OR.getProperty("StartPicking"))).click();

		Thread.sleep(3000);

		// input picked qty
		driver.findElement(By.xpath(OR.getProperty("PickedQty"))).sendKeys(PickedQty);
		Thread.sleep(3000);

		// submit driver.findElement(By.xpath(OR.getProperty("PickSubmit"))).click();
		Thread.sleep(6000);

	}

/*	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 9)
	public void Package() throws InterruptedException {
		// app launcher
		driver.findElement(By.xpath("//nav[@class='appLauncher slds-context-bar__icon-action']//button[1]")).click();
		Thread.sleep(6000); // select
		// packages
		// tab//
		driver.findElement(By.xpath(
				"//div[@class='modal-header slds-modal__header']/descendant::div[@class='uiInput uiInputText uiInput--default uiInput--input']/input"))
				.sendKeys("Packages");
		Thread.sleep(3000);
		Click("//span/mark[.='Packages']");
		Thread.sleep(10000); // click
								// on
								// new
		driver.findElement(By.xpath(OR.getProperty("PackageNew"))).click();
		Thread.sleep(6000); // select customer
							// WebElement c =
		driver.findElement(By.xpath(OR.getProperty("PackageCustomer")));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.click();
		act.sendKeys("Goldfinch Paving");
		Thread.sleep(2000);
		act.build().perform();
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//span[@class='slds-media__body'])[1]")).click();
		Thread.sleep(8000); // select
							// so
							// WebElement
							// s
							// =
		driver.findElement(By.xpath("//div[@class='slds-show']//input"));
		Thread.sleep(5000);
		Actions so = new Actions(driver);
		so.click();
		so.sendKeys("SO-3305");
		Thread.sleep(2000);
		so.build().perform();
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//li[@class='slds-listbox__item'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='slds-show']//input")).sendKeys("SO-3305");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='input-230']")).clear();
		driver.findElement(By.xpath("//input[@id='input-230']")).sendKeys("2");
		Thread.sleep(10000);
		// save
		// //driver.findElement(By.xpath(OR.getProperty("PackageSave"))).click();
		Thread.sleep(10000);
	}

	@Test(dataProviderClass = Testbase.class, dataProvider = "dp", priority = 10)
	public void shipment(String LogisticsName,
			String DeliveryNote,String TruckNo,String Waybill,String DeliveryPerson,String ShipmentDate,String Status1,String ConsignmentNo,String TrackingUrl,String PackageNumber,String ShipmentDeliveryDate,String Status2)throws InterruptedException { 
		
driver.findElement(By.xpath("//nav[@class='appLauncher slds-context-bar__icon-action']//button[1]")).click();
Thread.sleep(6000);
// select
																																						// packages tab
driver.findElement(By.
		xpath("//div[@class='modal-header slds-modal__header']/descendant::div[@class='uiInput uiInputText uiInput--default uiInput--input']/input")).sendKeys("Shipments");
Thread.sleep(3000);
		Click("//span/mark[.='Shipments']");
		Thread.sleep(10000); // new
																																																																// driver.findElement(By.xpath(OR.getProperty("ShipmentNew"))).click();
		Thread.sleep(6000); // switch to frame 
		WebElement sf =
		driver.findElement(By.xpath(OR.getProperty("ShipmentFrame")));
		driver.switchTo().frame(sf);System.out.println("switching  to frame");
		Thread.sleep(6000); // select
																																										// logistics
Select dd2 = new Select(driver.findElement(By.xpath(OR.getProperty("Logisticsname"))));
		dd2.selectByVisibleText(LogisticsName);
		Thread.sleep(4000);
		// delivery
																																				// note
		driver.findElement(By.xpath(OR.getProperty("DeliveryNote"))).sendKeys(DeliveryNote);
		Thread.sleep(3000); 
		// truck
																													// number
		driver.findElement(By.xpath(OR.getProperty("Truck"))).sendKeys(TruckNo);
		Thread.sleep(3000);
		// waybill
		driver.findElement(By.xpath(OR.getProperty("Waybill"))).sendKeys(Waybill);
		Thread.sleep(3000);
		// delivery
																											// person
		driver.findElement(By.xpath(OR.getProperty("DeliveryPerson"))).sendKeys(DeliveryPerson);
		Thread.sleep(3000);
		// shipment
																														// date
		driver.findElement(By.xpath(OR.getProperty("ShipmentDate"))).sendKeys(ShipmentDate);
		Thread.sleep(5000);
		// header
																													// status
																													 Select
																													 dd3
																													 =
																													 new
		Select(driver.findElement(By.xpath(OR.getProperty("Status1"))));
		dd3.selectByVisibleText(Status1);
		Thread.sleep(4000);
		// consignment
																																	// number
		driver.findElement(By.xpath(OR.getProperty("ConsignmentNo"))).sendKeys(ConsignmentNo);
		Thread.sleep(3000); 
		
		// tracking
																													// url
		driver.findElement(By.xpath(OR.getProperty("TrackingUrl"))).sendKeys(TrackingUrl);
		Thread.sleep(5000);
		// add
																													// shipment
																													// products
		driver.findElement(By.xpath(OR.getProperty("AddShipmentProd"))).click();
		Thread.sleep(8000); // package
																										// number
																										 WebElement pn
																										 =
		driver.findElement(By.xpath(OR.getProperty("PackageNumber")));
		Thread.sleep(5000);
		Actions action2=new Actions(driver);
		action2.moveToElement(pn);
		action2.click();
		action2.sendKeys(PackageNumber);
		action2.build().perform();
		Thread.sleep(9000);
		List<WebElement>list=driver.findElements(By.xpath("//ul[@class='slds-lookup__list']/li"));
		System.out.println("list");
       if(w.getText().contains(PackageNumber))
		{
			Thread.sleep(5000l);
		w.click();
		}
		}
	// shipment delivery date
		driver.findElement(By.xpath(OR.getProperty("ShipmentDeliveryDate"))).sendKeys*(ShipmentDeliveryDate);Thread.sleep(5000);** // shipment
																																	// status
																																	 Select
																																	 dd4
																																	 =
 new
		Select(driver.findElement(By.xpath(OR.getProperty("Status2"))));*dd4.selectByVisibleText(Status2);Thread.sleep(8000);** // click
																																	// on
																																	// submit
		driver.findElement(By.xpath(OR.getProperty("ShipmentSubmit"))).click();*Thread.sleep(8000);** // final submit
		driver.findElement(By.xpath(OR.getProperty("LastSubmit"))).click();*Thread.sleep(8000);** // switch back
																									// driver.switchTo().defaultContent();
																									// Thread.sleep(8000);
		System.out.println("Shipment succesful");
	}*/

}

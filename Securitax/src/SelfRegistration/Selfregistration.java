package SelfRegistration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import InitialDriverRegistration.ExcelReading;
import InitialDriverRegistration.securitaxLogin;

public class Selfregistration {
    
    WebDriver driver;
    static ExcelReading excel = new ExcelReading("E:\\Shridhar Workspace\\Securitax\\TestData\\TestData.xlsx");

@Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp")
public void driverSelfregistration(String Name,String ServiceType,String BankName,String Nameofaccountholders,String Accountnumber,String Sortcode,String BicNumber,
                                   String BankCode,String NationalBankCode,String IBANChecksum,String VATNumber,String CompantyName,String SubSearch,String UTR,String NameChange,String UKresident,
                                   String OutsideEu,String HMRCSelf,String OtherBusiness,String PrevName,String DateofNameChange,String Reason,String PrevDate,String Nationality,String VAT,
                                   String PrevAddress,String PrevAddress2,String PrevTown,String PrevCode,String PrevDate1) throws InterruptedException {
		   System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
	   
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   
	   //SelfRegistration Link
	   String baseurl = "https://sagedev-stcommunity.cs86.force.com/DriverCommunity/SecuritaxCommunityPage?Id=a2U7E000000VKiV";
	   System.out.println("URL Valid");
	   driver.navigate().to(baseurl);
	   
	   
	   driver.findElement(By.xpath("//input[@value=\"Proceed\"]")).click();
	   Thread.sleep(8000);
	   
	   		
	   //Video Section
	   WebElement VideoButtons = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	   if(VideoButtons.isDisplayed()) {
	     VideoButtons.click();
	   }
	   Thread.sleep(3000);
	 
		 //Service Type 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,1750)", "");
		 Thread.sleep(8000);
		 jse.executeScript("window.scrollBy(0,750)", "");
		 System.out.println("ServiceType >>>> "+ServiceType);
		 Thread.sleep(8000);
		 //String type = ServiceType.trim();
		 
		 
		 // Sole Trader
		 if (ServiceType.contains("Sole Trader")) {	
		 System.out.println("Inside Sole trader if");
		 Thread.sleep(8000);
		 driver.findElement(By.xpath("(//input[@value=\"Select\"])[1]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//div[@class='modal-footer']/input[@type='submit'])[2]")).click();
		 jse.executeScript("window.scrollBy(0,1750)", "");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@value=\"Next\"]")).click();
		 jse.executeScript("window.scrollBy(0,1750)", "");
		 Thread.sleep(3000);
		 
		 // DSP Contract 
		 driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		 jse.executeScript("window.scrollBy(0,1750)", "");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[6]")).click();
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[6]")).sendKeys(Name);
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@value=\"NEXT\"]")).click();
		 
		 // Agreement Section 
		 Thread.sleep(3000);
		 jse.executeScript("window.scrollBy(0,750)", "");
		 driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).click();
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys(Name);
		 
		 // Name Change 
		 if(NameChange.contains("No")) {
		 Thread.sleep(3000);
		 jse.executeScript("window.scrollBy(0,750)", "");
		 driver.findElement(By.xpath("(//input[@value=\"No\" and @type=\"radio\"])[1]")).click();
		 }else {
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//input[@value=\"Yes\" and @type=\"radio\"])[1]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//label[text()=\"Previous name in full\"]/following::input[1]")).click();
		 driver.findElement(By.xpath("//label[text()=\"Previous name in full\"]/following::input[1]")).sendKeys(Name);
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//label[text()=\"Date of name change\"]/following::input[1]")).click();
		 driver.findElement(By.xpath("//label[text()=\"Date of name change\"]/following::input[1]")).sendKeys(DateofNameChange);
		 }
		 
		 //Prev Address Date	
		 jse.executeScript("window.scrollBy(0,250)", "");
		 driver.findElement(By.xpath("(//input[@type=\"date\"])[2]")).sendKeys(PrevDate);
		 Thread.sleep(2000);
		  WebElement address = driver.findElement(By.xpath("//label[text()=\"Prev Address\"]/following::input[1]"));
		  if(address.isDisplayed()) {
		  driver.findElement(By.xpath("//label[text()=\"Prev Address\"]/following::input[1]")).sendKeys(PrevAddress);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//label[text()=\"Prev Address Line 2\"]/following::input[1]")).sendKeys(PrevAddress2);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//label[text()=\"Prev Town\"]/following::input[1]")).sendKeys(PrevTown);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//label[text()=\"Prev Postcode\"]/following::input[1]")).sendKeys(PrevCode);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//label[text()=\"Please provide the date you moved in\"]/following::input[1]")).sendKeys(PrevDate1);
		  Thread.sleep(2000);
		  }
		  
		  // Nationality
		  Select national = new Select(driver.findElement(By.xpath("//label[text()=\"Nationality\"]/following::select[1]")));
		  Thread.sleep(2000);
		   national.selectByVisibleText("British");
		   // UK Resident 
		   if(UKresident == "Yes") {
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//input[@value=\"Yes\" and @type=\"radio\"])[2]")).click();
		   }else {
		       Thread.sleep(3000);
		       driver.findElement(By.xpath("(//input[@value=\"No\" and @type=\"radio\"])[2]")).click();
		   }
		   jse.executeScript("window.scrollBy(0,250)", "");
		   //OutSide EU
		   if (OutsideEu == "Yes") {
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//input[@value=\"Yes\" and @type=\"radio\"])[3]")).click();
		   
		   }else {
		       Thread.sleep(3000);
		       driver.findElement(By.xpath("(//input[@value=\"No\" and @type=\"radio\"])[3]")).click();
		   
		   }
		   
		   //HMRC Registered 
		   if (HMRCSelf == "Yes") {
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//input[@value=\"Yes\" and @type=\"radio\"])[4]")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[text()=\"Unique Tax Reference Number\"]/following::input[1]")).click();
		   driver.findElement(By.xpath("//label[text()=\"Unique Tax Reference Number\"]/following::input[1]")).sendKeys(UTR);				
		   
		   }else {
		       Thread.sleep(3000);
		       driver.findElement(By.xpath("(//input[@value=\"No\" and @type=\"radio\"])[4]")).click();
		   
		   }
		   jse.executeScript("window.scrollBy(0,250)", "");
		   //Other Business Involvement  
		   if (OtherBusiness == "Yes") {
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//input[@value=\"Yes\" and @type=\"radio\"])[5]")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[text()=\"Business/Company name:\"]/following::input[1]")).click();
		   driver.findElement(By.xpath("//label[text()=\"Business/Company name:\"]/following::input[1]")).sendKeys(CompantyName);				
		   
		   }else {
		       Thread.sleep(3000);
		       driver.findElement(By.xpath("(//input[@value=\"No\" and @type=\"radio\"])[5]")).click();
		   
		   }
		   
		   // VAT Status 
		   if(VAT.contains("Not Registered")) {
		   Select VatStatus = new Select(driver.findElement(By.xpath("(//select[@class=\"slds-select\"])[5]")));
		   Thread.sleep(3000);
		   VatStatus.selectByVisibleText("Not Registered");
		   
		   }else {
		       Select VatStatus = new Select(driver.findElement(By.xpath("(//select[@class=\"slds-select\"])[5]")));
		   Thread.sleep(3000);
		   VatStatus.selectByVisibleText("Registered");				
		   driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[13]")).click();
		   driver.findElement(By.xpath("(//input[@class=\"slds-input\"])[13]")).sendKeys(VATNumber);
		   }
		   
		   
		   // Bank Section
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[text()=\"Bank or building society name\"]/following::input[1]")).click();
		   driver.findElement(By.xpath("//label[text()=\"Bank or building society name\"]/following::input[1]")).clear();
		   driver.findElement(By.xpath("//label[text()=\"Bank or building society name\"]/following::input[1]")).sendKeys(BankName);
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[text()=\"Name of account holders\"]/following::input[1]")).click();
		   driver.findElement(By.xpath("//label[text()=\"Name of account holders\"]/following::input[1]")).clear();
		   driver.findElement(By.xpath("//label[text()=\"Name of account holders\"]/following::input[1]")).sendKeys(Nameofaccountholders);
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[text()=\"8 Digit Bank account number\"]/following::input[1]")).click();
		   driver.findElement(By.xpath("//label[text()=\"8 Digit Bank account number\"]/following::input[1]")).clear();
		   driver.findElement(By.xpath("//label[text()=\"8 Digit Bank account number\"]/following::input[1]")).sendKeys(Accountnumber);
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[text()=\"6 Digit Sort code\"]/following::input[1]")).click();
		   driver.findElement(By.xpath("//label[text()=\"6 Digit Sort code\"]/following::input[1]")).clear();
		   driver.findElement(By.xpath("//label[text()=\"6 Digit Sort code\"]/following::input[1]")).sendKeys(Sortcode);
		   
		   
		   // Agreement checkbox
		   jse.executeScript("window.scrollBy(0,250)", "");
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[4]")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[5]")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[6]")).click();
		   
		   driver.findElement(By.xpath("//input[@value=\"NEXT\" and @type=\"submit\"]")).click();
		   
		   //HMRC Contract 
		   Thread.sleep(2000);
		   jse.executeScript("window.scrollBy(0,750)", "");
		   //driver.findElement(By.xpath("//input[@value=\"REGISTER\"]")).click();
		   
		   
		   }
		   
		   //Own Accountant
		   else if(ServiceType=="Own Accountant") {
		   System.out.println("Inside Own Accountant if");
		   driver.findElement(By.xpath("(//input[@value=\"Select\"])[2]")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("(//div[@class='modal-footer']/input[@type='submit'])[3]")).click();
		   }
		   
		   
		   //Limited Company
		   else if(ServiceType.contains("Limited Company")) {
		   System.out.println("Inside Limited Company if");
		   driver.findElement(By.xpath("(//input[@value=\"Select\"])[3]")).click();
		   Thread.sleep(4000);
		   driver.findElement(By.xpath("//div[@class='modal-body']/input[@class='slds-input']")).sendKeys(CompantyName);
		   Thread.sleep(3000);
	   driver.findElement(By.xpath("(//div[@class='modal-footer']/input[@type='submit'])[4]")).click();
	   
	   }
	   System.out.println("Inside Unsure if");
	   driver.findElement(By.xpath("(//input[@value=\"Select\"])[4]")).click();
	   
	   
	   }
	   
	   }

package InitialDriverRegistration;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DiverLog {
	WebDriver driver;
	
	static ExcelReading excel = new ExcelReading("E:\\Shridhar Workspace\\Securitax\\TestData\\TestData.xlsx");
	
@Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp", priority = 1)	
public void DriverLogin(String URL, String USERNAME, String PASSWORD) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();

	driver.manage().window().maximize();

	driver.get(URL);
	Thread.sleep(2000);
	
	Thread.sleep(5000);
	driver.get(URL);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='username']")).click();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(USERNAME);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//Input[@id='password']")).click();
	driver.findElement(By.xpath("//Input[@id='password']")).sendKeys(PASSWORD);		
	Thread.sleep(5000);
	driver.findElement(By.xpath("//Input[@id='Login']")).click();
	
}
/*
@Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp", priority = 1)
public void driverContracts (WebDriver driver) throws InterruptedException{
	System.out.println("Inside Driver Contract method");	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Contracts']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[1]")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[2]")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[3]")).click();
	Thread.sleep(10000);
	
}
    @Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp", priority = 1)
	public void driverMessage (WebDriver driver) throws InterruptedException{
	
	System.out.println("Inside Driver message method");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Messsage Board']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[text()='Raise Query']")).click();
	Thread.sleep(2000);
	Select sub = new Select(driver.findElement(By.id("37:2;a")));
	sub.selectByVisibleText("Sales Invoice Query");
	sub.selectByIndex(1);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='55:2;a']")).click();
	driver.findElement(By.xpath("//input[@id='55:2;a']")).sendKeys("Query related to DSP");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//textarea[@class='slds-textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")).click();
	driver.findElement(By.xpath("//textarea[@class='slds-textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")).sendKeys("need some more clarity on my sales invoice");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[text()='Raise Query']")).click();
	Thread.sleep(2000);
	Select sub1 = new Select(driver.findElement(By.id("37:2;a")));
	sub1.selectByVisibleText("Payment query");	
	sub1.selectByIndex(2);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='55:2;a']")).click();
	driver.findElement(By.xpath("//input[@id='55:2;a']")).sendKeys("Query related to Securitax");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//textarea[@class='slds-textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//textarea[@class='slds-textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")).sendKeys("need some more clarity on my Payment");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[1]")).click();
	Thread.sleep(2000);
	
		
		
	}
	@Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp", priority = 1)
	public void driverInvoice(WebDriver driver) throws InterruptedException{
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Invoices']")).click();
		Thread.sleep(5000);
		
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Thread.sleep(8000);
		/*WebElement about = driver.findElement(By.id("//div[@class='slds-card__body']"));
		jse.executeScript("arguments[0].scrollIntoView();",about);
		Thread.sleep(1000);
		//Scroll horizontally
		//jse.executeScript("window.scrollBy(1000,0)", "");
		//jse.executeScript("window.scrollBy(-600,0)", "");
		
	    //driver.findElement(By.xpath("(//button[@class='slds-button slds-button_neutral'])[1]")).click();
	    
		
		
	}
	@Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp", priority = 1)
	public void driverUpload(WebDriver driver) throws InterruptedException{
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Upload']")).click();
		
		try{
			ExcelLib xllib3 = new ExcelLib();
			int RowCounts=xllib3.getRowCount("Expenses");
		System.out.println("Upload file Count:" +RowCounts);
		System.out.println("Upload file initialized ");
		
		
		for(i=1; i <= RowCounts; i++){
			Thread.sleep(7000);
			driver.findElement(By.xpath("//span[text()='Home']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='Upload']")).click();
			Type=xllib3.getExcelData("Expenses", i, 0);
			GrossAmount=xllib3.getExcelData("Expenses", i, 1);
			VATAmount=xllib3.getExcelData("Expenses", i, 2);
			NetAmount=xllib3.getExcelData("Expenses", i, 3);
			Path=xllib3.getExcelData("Expenses", i, 4);
			Reference=xllib3.getExcelData("Expenses", i, 5);
			IncludeonVATReturn=xllib3.getExcelData("Expenses", i, 6);
			
			UploadStatus=loadExpenses(driver,Type,GrossAmount,VATAmount,NetAmount,Path,Reference,IncludeonVATReturn);
			System.out.println("Expenses:"+i);
		}
		}
		catch(Exception e){
	        System.out.println("Upload Failed");
	        e.printStackTrace();
		}

		
	}
	*/
	
	@Test(dataProviderClass = securitaxLogin.class, dataProvider = "dp", priority = 2)
	public void Expenses(String Type, String GrossAmount, String VATAmount,String NetAmount,String Path,String Reference,String IncludeonVATReturn ) throws InterruptedException, IOException{

		Thread.sleep(5000);
		driver.findElement(By.xpath("//nav[@role=\"navigation\"]/ul/li[3]")).click();
/*		Thread.sleep(5000);
		System.out.println("Enter Type");		
		driver.findElement(By.xpath("//select[@id='35:2;a']")).click();
		driver.findElement(By.xpath("//select[@id='35:2;a']")).sendKeys(Type);
		
		System.out.println("Enter Gross Amount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='input-1']")).clear();
		driver.findElement(By.xpath("//input[@id='input-1']")).click();
		driver.findElement(By.xpath("//input[@id='input-1']")).sendKeys(GrossAmount);
		System.out.println("Enter VAT Amount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='input-2']")).clear();
		driver.findElement(By.xpath("//input[@id='input-2']")).click();
		driver.findElement(By.xpath("//input[@id='input-2']")).sendKeys(VATAmount);
		System.out.println("Enter Net Amount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='input-3']")).clear();
		driver.findElement(By.xpath("//input[@id='input-3']")).click();
		driver.findElement(By.xpath("//input[@id='input-3']")).sendKeys(NetAmount);
		Thread.sleep(8000);
		//upload button
		
		if("Expenses".equals(Type)){
			Thread.sleep(5000);
			System.out.println("Type is Expenses");			
			driver.findElement(By.xpath("//input[@id='input-5']")).click();
			driver.findElement(By.xpath("//input[@id='input-5']")).sendKeys(Reference);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
			//driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).sendKeys(IncludeonVATReturn);	
		}*/
		System.out.println("Type is not Expense");
		Thread.sleep(5000);
		/*WebElement element= driver.findElement(By.xpath("//span[@class='slds-file-selector__button slds-button slds-button_neutral']"));
		element.click();
		System.out.println("Upload Initiated");
		Thread.sleep(10000);
    	Runtime.getRuntime().exec(Path);*/
		//Selecting file to upload
		driver.findElement(By.name("file")).sendKeys(Path);
    	System.out.println("Upload1 Done");
    	Thread.sleep(8000);
    	//driver.findElement(By.xpath("//Button[@class='slds-button slds-button_brand slds-button slds-button_brand slds-size_1-of-1']")).click();
    	Thread.sleep(25000);
		
		
	}

}

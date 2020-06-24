package InitialDriverRegistration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class securitaxLogin {
	
	static ExcelReading excel = new ExcelReading("E:\\Shridhar Workspace\\Securitax\\TestData\\TestData.xlsx");
	
	@Test(dataProviderClass= securitaxLogin.class, dataProvider ="dp")
	
	public void launchBrowser() throws InterruptedException, IOException
	{
		
		//String test = "UserName";
		System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		JavascriptExecutor javascript = (JavascriptExecutor) driver;

		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);

		javascript.executeScript("alert('Entering User Name');");
		Alert alert= driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		//String print = alert.getText();
		System.out.println("text alert :::::::");
		
		//alert.sendKeys(test);
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='username']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("simon@securitax.co.uk.sagedev");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SageDev-123");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);
		
		TakesScreenshot t = (TakesScreenshot)driver;
		
		File src =t.getScreenshotAs(OutputType.FILE);
		System.out.println("Source File Is : "+src);
		File dist = new File("E://ScreenShot//Test.png");
		System.out.println("Destination File Is : "+dist);
		//FileUtils.copyFile(src,dist);
		FileHandler.copy(src, dist);
		driver.findElement(By.xpath("//div[@id='userNavButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
	} 
	 @DataProvider(name = "dp")
		public static Object[][] getdata(Method m) {
		String sheetname = m.getName();
		int	rowno = excel.getRowCount(sheetname);
		int colno = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rowno - 1][colno];
		for ( int row = 2; row <= rowno; row++) {
		for (int col = 0; col < colno; col++) {
		System.out.println(rowno + "," + colno);
		data[row - 2][col] = excel.getCellData(sheetname, col, row);
		System.out.println(data[row - 2][col]);

		}

		}
		return data;

		}
}

package InitialDriverRegistration;

import java.awt.AWTException;
import java.util.Date;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty9.util.IO;
import org.testng.annotations.Test;

public class Testing {
	private static final IO FileUtils = null;
	WebDriver driver;
	
	/*@Test
	public void Method() throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
		 Clearing Chrome Hostory
		//ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("start-maximized");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Sridhar/Desktop/test.html");
		driver.get("chrome://settings/clearBrowserData");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();		
		WebElement wb = driver.findElement(By.name("Browsers"));
		Select sel = new Select(wb);
		sel.selectByIndex(1);
		Thread.sleep(4000);
		sel.selectByVisibleText("FireFox");
		
		driver.findElement(By.xpath("//input[@value=\"Bike\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Car\"]")).click();
		Thread.sleep(4000);
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		Thread.sleep(4000);
		driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(4000);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
	
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(1)); 
		Thread.sleep(4000);
		driver.get("https://www.google.co.in/");
		
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_T);
		Thread.sleep(4000);
		r1.keyRelease(KeyEvent.VK_T);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		driver.switchTo().window((String) tabs.get(2)); 
		Thread.sleep(4000);
		driver.get("https://www.google.co.in/");
		
	}*/
	@Test
	public void Method1() throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.xpath("//input[@name='q']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Test");
		driver.findElement(By.xpath("html/body/div[1]/div[7]/span/center/div[1]")).click();
		driver.findElement(By.xpath("//input[@name=\"q\"]/following::input[3]")).click();
		

		Date d = new Date();
		System.out.println("Date "+d.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("src"+src);
		try {
		// now copy the  screenshot to desired location using copyFile //method
			System.out.println("Try");
		FileUtils.copyFile(src, new File("D:\\TestData\\"+sdf.format(d)+".png"));
			}

			catch (IOException e)
		{
		System.out.println(e.getMessage());

		}
	}

}

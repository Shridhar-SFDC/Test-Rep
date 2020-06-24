package Learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Sigma.ExcelReading;
import Sigma.Testbase;



public class TestClass {
	public static WebDriver driver;
	public static int row;
	public static FileInputStream fis;
	public static Properties Shridhar = new Properties();
	public static Properties OR1 = new Properties();
	public static Logger log = Logger.getLogger(TestClass.class);
	public static ExcelReading excel = new ExcelReading("E:\\Shridhar Workspace\\Securitax\\TestData\\SigmaTestData123.xlsx");
	
	@BeforeSuite
	public static void setup() throws IOException, InterruptedException  {
		
		System.out.println(System.getProperty("user.dir"));
		if (driver == null) {
			
			fis = new FileInputStream("E:\\Shridhar Workspace\\Securitax\\Shridhar");
		 
			Shridhar.load(fis);
            log.debug("loading config file");
			
			fis = new FileInputStream("E:\\Shridhar Workspace\\Securitax\\OR1");
			
			OR1.load(fis);
			log.debug("loading or file");
			
			System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			
			driver.navigate().to(OR1.getProperty("URL_SD"));
			
				
	
		}
	
	}
	
	@DataProvider(name = "dp")
	public static Object[][] getdata(Method m) {
		String sheetname = m.getName();
	int	 rowno = excel.getRowCount(sheetname);
		int colno = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rowno - 1][colno];
		for ( row = 2; row <= rowno; row++) {
			for (int col = 0; col < colno; col++) {
				System.out.println(rowno + "," + colno);
				data[row - 2][col] = excel.getCellData(sheetname, col, row);
				System.out.println(data[row - 2][col]);

			}

		}
		return data;

	}
}

package TestNGLearning;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoggerDemo {
	
	WebDriver driver;
    @Test
	public  void Login1() {
		// TODO Auto-generated method stub
		
		Logger logger=Logger.getLogger("LoggerDemo");
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "E:\\Shridhar Workspace\\Securitax\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Browser Opened2");

	}

}

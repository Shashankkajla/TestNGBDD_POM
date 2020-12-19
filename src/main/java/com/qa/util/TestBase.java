package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase()
	{
		prop = new Properties();
		
		try{
		FileInputStream ip = new FileInputStream("D:\\FrameWorks\\CRMTestNGBDD\\src\\main\\java\\com"
				+ "\\qa\\config\\config.properties");
		prop.load(ip);
		}
	    catch(FileNotFoundException e){
	    e.printStackTrace();
	    }
	    catch(IOException e){
	    e.printStackTrace();
	    }
	}

	public static void initilization()
	{
		String browsername = prop.getProperty("browser");
	   
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\FrameWorks\\CRMTestNGBDD\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			/*System.setProperty("webdriver.gecko.driver", "D:\\Driv\\geckodriver.exe");
			driver = new FirefoxDriver();*/
			
		}
	    
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	    
	}
		
	
}

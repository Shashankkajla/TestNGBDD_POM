package com.qa.util;

import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static WebDriver driver;

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	
	public static void frame()
	{
		driver.switchTo().frame("mainPanel");
	}
 	
	
}
	

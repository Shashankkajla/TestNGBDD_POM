package com.qa.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.page.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends TestBase{
	TestBase testBase; 
	LoginPage loginPage;
	
	 /*public LoginStepDefinition()
	 {super();}*/
	 
	 
	@Given("^user open browser and comes to crm login page$")
	public void user_open_browser_and_comes_to_crm_login_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\FrameWorks\\CRMTestNGBDD\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
		LoginPage loginPage = new LoginPage();
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String un, String pwd) throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.loginCred(un, pwd);
		
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyHomePage();
	}

	@Then("^user comes to Home Page$")
	public void user_comes_to_Home_Page() throws Throwable {
	       String title = driver.getTitle();
	       Assert.assertEquals(title, "CRMPRO");
	}

	@Then("^close the Browser$")
	public void close_the_Browser() throws Throwable {
		
		driver.quit();
	}

}

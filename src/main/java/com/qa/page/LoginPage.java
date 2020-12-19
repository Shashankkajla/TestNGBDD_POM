package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase {
	
	// OR
	@FindBy(xpath="//input[@name='username']")
	WebElement  userName;
	
	@FindBy(xpath="//input[@name='password' and @type = 'password']")
	WebElement  userPass;
	
	@FindBy(xpath="//body/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]")
	WebElement  clickBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public void loginCred(String un, String pw)
	{
		userName.sendKeys(un);
		userPass.sendKeys(pw);
	}
	public void verifyHomePage()
	{
		clickBtn.click();
	}
	

}

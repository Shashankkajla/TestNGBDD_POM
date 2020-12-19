package com.qa.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(  
		features = "D:\\FrameWorks\\CRMTestNGBDD\\src\\main\\java\\com\\qa\\features", 
		          // The path of the feature file, 
		glue = {"com.qa.stepdefinitions"}, 
		//tags = {"~@Ignore"},
		format = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty", 
				"json:target/cucumber-reports/CucumberTestReport.json", 
				"rerun:target/cucumber-reports/rerun.txt"},
		plugin = "json:target/cucumber-reports/CucumberTestReport.json", 	 // want to add json plugin also
		
		// Run Maven from Terminal and report is generated inside Cucumber-reports > advance report 
					
		dryRun = false, 
		strict = true,
        monochrome = true 		
		)


public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner; 
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass()); // this.getClass() will return the obj of same class
	}
	
	@Test(groups ="cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature)
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	
	@DataProvider
	public Object[][] features() // how many feature files need to be execute through testNG
	{
		return testNGCucumberRunner.provideFeatures();
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception
	{
		testNGCucumberRunner.finish();
		
	}
	
	

}

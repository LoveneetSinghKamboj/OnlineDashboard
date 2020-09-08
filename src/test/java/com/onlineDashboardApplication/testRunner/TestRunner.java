

package com.onlineDashboardApplication.testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import java.io.*;


import org.testng.annotations.AfterClass;


import com.cucumber.listener.Reporter;


@CucumberOptions(features = {"src/test/resources/features" },
                 glue = { "com.onlineDashboardApplication.stepDefination"},
                 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
                 tags= {"@Registration,@SLp,@Dashboard"},
                 monochrome = true,
                 dryRun=false
		) 

public class TestRunner extends AbstractTestNGCucumberTests
{ 
	@AfterClass
	 public static void writeExtentReport() 
	 {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	 }
}

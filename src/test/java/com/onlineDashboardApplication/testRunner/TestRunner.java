

package com.onlineDashboardApplication.testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.onlineDashboardApplication.stepDefination.Form;


@CucumberOptions(features = {"src/test/resources/features" },
                 glue = { "com.onlineDashboardApplication.stepDefination"},
                 tags= {"@Registration,@SLp"},
                 monochrome = true,
                 dryRun=false
		) 

public class TestRunner extends AbstractTestNGCucumberTests
{
 
}

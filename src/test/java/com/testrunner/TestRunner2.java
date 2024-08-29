package com.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//Integrating TestNG with Cucumber and doing the parallel execution 
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resource/"},glue = {"com.steps"},plugin = {"pretty","html:target/test-output.html"},monochrome = true)
public class TestRunner2 extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
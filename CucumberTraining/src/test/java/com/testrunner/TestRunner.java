package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resource/"},glue = {"com.steps"},plugin = {"pretty","html:target/test-output.html"},monochrome = true, 
tags = "@Regression" )
public class TestRunner {

}
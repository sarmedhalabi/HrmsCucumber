package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/nameValidationsinDB.feature"
           , glue = "com/hrms/steps"
           , dryRun = true
           , monochrome = true
           , plugin = {
		"pretty",                              // prints gharkin steps in console
		"html:target/cucumber-default-report","json:target/cucumber.json",
		
"rerun:target/failed.txt"}// create basic html report in in specified location
          
       // ,tags="smoke"
           

)

public class TestRunner {

}

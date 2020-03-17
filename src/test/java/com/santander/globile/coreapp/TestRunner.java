package com.santander.globile.coreapp;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"} 
							, glue= {"com.santander.globile.coreapp.steps"}
							//, tags = {"@validCredentialIOS"}
							, plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/MobileBDDReport.html"}
				)

public class TestRunner {
 	
    @AfterClass
    public static void setup() {
	    Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	    Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	    //Reporter.setSystemInfo("User Name", "YINO");
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Application Name", "GlobileHub Portal");
	    Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	    Reporter.setSystemInfo("Environment", "Develop");
	    Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }    
    
}


package com.santander.globile.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hooks {
	//private static WebDriver driver;
	private static AndroidDriver<WebElement> driver;
	private final String PACKAGE = "com.santander.globile.coreapp";
	
	public static AndroidDriver<WebElement> getDriver() {
		return driver;
	}
	
	@Before
	//@Before("@createApplication, @modifyApplication")
	//@Before("@createApplication")
    public void beforeScenario() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "8");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		capabilities.setCapability("appPackage", PACKAGE);
		capabilities.setCapability("appActivity", ".MainActivity");
		//capabilities.setCapability("appWaitPackage", PACKAGE); 
		//capabilities.setCapability("appWaitActivity", ".view.TestFields");
		 
		capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ynavarro\\Downloads\\coreapp.apk");
		
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
    }	
	
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
		if (driver != null) {
			driver.quit();
		}
    }
}

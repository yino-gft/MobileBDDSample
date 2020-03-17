package com.santander.globile.coreapp.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CoreAppStepDefinition {
	
	private WebDriver driver;
	private final String PACKAGE = "com.santander.globile.coreapp";
	//private final String SEARCH_ACTIVITY = ".Login";
	
	@Before
	public void before(Scenario scenario) throws MalformedURLException {
		System.out.println("Scenario " + scenario.getName() + " starting");
		if (scenario.getName().contains("Android")) {
			System.out.println("**** Android ****");
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
			//driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
		}else {
			System.out.println("**** iOS ****");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
			capabilities.setCapability(MobileCapabilityType.VERSION, "10.3");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			
			//capabilities.setCapability(MobileCapabilityType.APP,"classpath:/GlobileMobileBDDSample/src/test/resources/apps/ios/Archetype.app.zip");
			capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ynavarro\\Downloads\\Archetype.app.zip");
			
			driver = new IOSDriver<WebElement>(new URL("http://192.168.1.43:4723/wd/hub"),capabilities);
			//driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
		}
	}	

	@Given("^Open login page$")
	public void open_login_page() throws Throwable {
    	
    	
	}

	@When("^Enter user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_user_name_as_and_password_as(String arg1, String arg2) throws Throwable {
		System.out.println("Driver name: " + driver.getClass().getName());
		if(driver.getClass().getName().equals("io.appium.java_client.android.AndroidDriver")) {
			//driver.findElementById("com.santander.globile.coreapp:id/userField").sendKeys(arg1);
	    	//driver.findElementById("com.santander.globile.coreapp:id/test").sendKeys(arg2);
			driver.findElement(By.id("com.santander.globile.coreapp:id/userField")).sendKeys(arg1);
			driver.findElement(By.id("com.santander.globile.coreapp:id/test")).sendKeys(arg2);
		}else {
			//driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Archetype\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")).sendKeys(arg1);
			System.out.println("iOs .... : ");
		}
	}

	@When("^Submit login page$")
	public void submit_login_page() throws Throwable {
		if(driver.getClass().getName().equals("io.appium.java_client.android.AndroidDriver")) {
			//driver.findElementById("com.santander.globile.coreapp:id/loginButton").click();
			driver.findElement(By.id("com.santander.globile.coreapp:id/loginButton")).click();
		} else {
			System.out.println("iOs .... : ");
		}
	}

	@Then("^Rediret to user dashboard home page$")
	public void rediret_to_user_dashboard_home_page() throws Throwable {
		if(driver.getClass().getName().equals("io.appium.java_client.android.AndroidDriver")) {
	    	AndroidElement titleText = (AndroidElement) new WebDriverWait(driver, 30)
	                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.santander.globile.coreapp:id/globalPositionHelloField")));
	    	System.out.println("title: "+titleText.getText());
	    	Assert.assertEquals(titleText.getText(), "Hello Hanna");
		} else {
			System.out.println("iOs .... : ");
		}
	}

	@Then("^Return to login page$")
	public void return_to_login_page() throws Throwable {
		if(driver.getClass().getName().equals("io.appium.java_client.android.AndroidDriver")) {
			AndroidElement titleText =(AndroidElement) new WebDriverWait(driver, 30)
	        .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.santander.globile.coreapp:id/logo")));
			System.out.println("title visualised: "+titleText.isDisplayed());
		} else {
			System.out.println("iOs .... : ");
		}	
	}

	@After
    public void afterScenario(Scenario scenario){
        System.out.println("Scenario " + scenario.getName() + " finished");
		if (driver != null) {
			driver.quit();
		}
    }
}

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

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GlobalPositionStepDefinition {
	//private AndroidDriver<WebElement> driver;
	
	//private AndroidDriver<WebElement> driver;
	private WebDriver driver;
	private final String PACKAGE = "com.santander.globile.coreapp";
	//private final String SEARCH_ACTIVITY = ".Login";
	
    //@Before
	public void setUp() throws MalformedURLException {
		
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


	@Given("^Log on santander mobile application with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void log_on_santander_mobile_application_with_user_and_password(String arg1, String arg2) throws Throwable {
		//driver = Hooks.getDriver();
		/*
		driver.findElementById("com.santander.globile.coreapp:id/userField").sendKeys(arg1);
    	driver.findElementById("com.santander.globile.coreapp:id/test").sendKeys(arg2);
    	driver.findElementById("com.santander.globile.coreapp:id/loginButton").click();
    	*/
		
		driver.findElement(By.id("com.santander.globile.coreapp:id/userField")).sendKeys(arg1);
    	driver.findElement(By.id("com.santander.globile.coreapp:id/test")).sendKeys(arg2);
    	driver.findElement(By.id("com.santander.globile.coreapp:id/loginButton")).click();
    	
    	AndroidElement titleText = (AndroidElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.santander.globile.coreapp:id/globalPositionHelloField")));
    	
    	System.out.println("title: "+titleText.getText());
    	
    	Assert.assertEquals(titleText.getText(), "Hello Hanna");
	}

	@When("^Access to global position$")
	public void access_to_global_position() throws Throwable {
		//driver.findElementById("com.santander.globile.coreapp:id/global_position").click();
		driver.findElement(By.id("com.santander.globile.coreapp:id/global_position")).click();
 	}

	@Then("^Validate global position page$")
	public void validate_global_position_page() throws Throwable {
		AndroidElement globalPositionText = (AndroidElement) new WebDriverWait(driver, 30)
		        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView")));
		System.out.println("title: "+globalPositionText.getText());
		Assert.assertEquals(globalPositionText.getText(), "Manage what to show on your Global Position");
	}

	//@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
		if (driver != null) {
			driver.quit();
		}
    }
}

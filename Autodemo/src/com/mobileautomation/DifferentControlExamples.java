package com.mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class DifferentControlExamples {
	
public AndroidDriver<AndroidElement> driver;
	
	@Test
	public void DifferentControls() throws MalformedURLException, InterruptedException
	{
		 DesiredCapabilities caps = new DesiredCapabilities();
	        
	        //Details given as part of your device
	        caps.setCapability("deviceName", "emulator-5554");
	        caps.setCapability("platformName", "Android");
	        
	        caps.setCapability("platformVersion", "9.0");
	        caps.setCapability("noReset", "true");
	        
	        //Provide the details for launching the app in the emulator, for launching the app
	        //We have to provide "Package name" and "activty name"
	        
	        caps.setCapability("appPackage", "io.appium.android.apis");
	        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	        
	        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
	        
	        Thread.sleep(2000);
	        TouchAction action = new TouchAction(driver);
	        
	        //X value 170
	        //Y value 2064
	        
	        action.press(PointOption.point(170, 2064)).release().perform();
	        
	        //X value 300
	        // Y value 796
	        
	        action.press(PointOption.point(246, 1079)).release().perform();
	        
	        driver.findElementByAccessibilityId("2. Dark Theme").click();
	        
	        Thread.sleep(2000);
	        
	        driver.findElementByAccessibilityId("Checkbox 1").click();
	        
	        driver.findElementByAccessibilityId("RadioButton 1").click();
	        
	        driver.findElementById("io.appium.android.apis:id/edit").sendKeys("Karthik");
                  driver.hideKeyboard();
                  
                  
                  Thread.sleep(2000);
                  
                  driver.findElementById("android:id/text1").click();
                  
                  Thread.sleep(2000);
                  
                  //X Value 846
                  
                  //Y value 784
                  
                  action.press(PointOption.point(846, 588)).release().perform();


	}

}

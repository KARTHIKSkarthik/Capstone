package com.mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ExpandableListExample {
	
public AndroidDriver<AndroidElement> driver;
	
	@Test
	public void ExpandableListExamples() throws MalformedURLException, InterruptedException
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
	        driver.findElementsById("android:id/text1").get(10).click();
	        driver.findElementByAccessibilityId("Expandable Lists").click();
	        
	        driver.findElementByAccessibilityId("1. Custom Adapter").click();
	        
	        List<AndroidElement> values = driver.findElementsByClassName("android.widget.TextView");
	        
	        System.out.println("The total number of Expandable list are" +values.size());
	        
	        for(AndroidElement elements:values)
	        {     try {
	        	System.out.println(elements.getText());
	        
	            
	            
	            if(elements.getText().equalsIgnoreCase("Dog Names"))
	            {
	                elements.click();
	            }
	        }
	        
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	
	}
	        
	   
	}
}

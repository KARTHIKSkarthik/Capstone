package com.mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AlertDemo {
	
	public AndroidDriver<AndroidElement> driver;
	@Test
	public void HandlePopup() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities 
		caps = new DesiredCapabilities();
		//Provide  Device Name
		
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
	    caps.setCapability("noReset", "true");
	//Usually the app package name and app activity will be provided by the devlopers
	    
	    caps.setCapability("appPackage","io.appium.android.apis");
	    caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
	    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
	    Thread.sleep(4000);
	    
        
        //Here we are finding the elements based on the resource id and giving the index value to click on the unique element
        driver.findElementsById("android:id/text1").get(2).click();
        int size = driver.findElementsById("android:id/text1").size();
        System.out.println("The total Resource ID's" +size);
        driver.findElementsById("android:id/text1").get(3).click();
        Thread.sleep(4000);
	    driver.findElementById("io.appium.android.apis:id/two_buttons").click();
        //To print the message in the pop up
	    Thread.sleep(2000);
	    String message = driver.findElementById("android:id/alertTitle").getText();
	    System.out.println("The message displayed in the pop up"+message);
	    driver.findElementById("android:id/button1").click();
    }


	    
	}
	



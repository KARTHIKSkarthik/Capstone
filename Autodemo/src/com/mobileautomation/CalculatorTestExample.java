package com.mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorTestExample {
	public static AndroidDriver<AndroidElement> driver;
	@BeforeTest
	
	public void LaunchApp() throws MalformedURLException
	{
		DesiredCapabilities 
		caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
	    caps.setCapability("noReset", "true");
	//Usually the app package name and app activity will be provided by the devlopers
	    
	    caps.setCapability("appPackage","com.android.calculator2");
	    caps.setCapability("appActivity","com.android.calculator2.Calculator");
	    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
	
	}
	
	@Test
	public void LaunchCalculator() throws InterruptedException
	{
		System.out.println("Launch Calculator");
		
        AndroidElement eight = driver.findElementById("com.android.calculator2:id/digit_8");
        
        eight.click();
        
        AndroidElement additon = driver.findElementById("com.android.calculator2:id/op_add");
        
        additon.click();
        
        AndroidElement two = driver.findElementById("com.android.calculator2:id/digit_2");
        
        two.click();
        
        AndroidElement equals = driver.findElementById("com.android.calculator2:id/eq");
        equals.click();
        
        Thread.sleep(3000);
AndroidElement Result = driver.findElementById("com.android.calculator2:id/result");
        
        System.out.println("The output is "+Result.getText());
        
        /*if(Result.getText().equals(10))
        {
            System.out.println("The calucator is working fine");
        }
        else
        {
            System.out.println("Problem with output");
        }*/
        
        
        
        
        Assert.assertEquals(Result.getText(),10);






   

		
	}

}

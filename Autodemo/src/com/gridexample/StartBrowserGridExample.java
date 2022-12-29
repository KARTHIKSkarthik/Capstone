package com.gridexample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class StartBrowserGridExample {

	
	public AndroidDriver<WebElement> driver;	    
    public static String firstDeviceName ="emulator-5554";
    public static String secondDeviceName = "emulator-5556";	
    
    
    @BeforeClass
    @Parameters({"port","deviceID"})
    public void StartTest(String port, String device_id) throws MalformedURLException, InterruptedException
    {
    	DesiredCapabilities caps = new DesiredCapabilities();	        
        if(device_id.equalsIgnoreCase(firstDeviceName))
        {
            System.out.println("The Device ID is" +device_id);
            System.out.println(port + "-" +System.currentTimeMillis());
            System.out.println(device_id + "-" +System.currentTimeMillis()); 
            caps.setCapability("browserName","chrome");
            caps.setCapability("deviceName", firstDeviceName);
            caps.setCapability("udid", firstDeviceName);
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "9.0");	            
           	            	            
        }
        else if(device_id.equalsIgnoreCase(secondDeviceName))
        {   	
            System.out.println("The Device ID is" +device_id);
            System.out.println(port + "-" +System.currentTimeMillis());
            System.out.println(device_id + "-" +System.currentTimeMillis());
            caps.setCapability("browserName","chrome");
            caps.setCapability("deviceName", secondDeviceName);
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "9.0");            
           
    }
    driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);    
    Thread.sleep(5000);
    }
    
    @Test
    
    public void Testcase() throws InterruptedException
    {
    	driver.get("https://www.flipkart.com/");
        
        System.out.println("The URL is navigated successfuly" +driver.getSessionId());
        
        WebElement searchBox = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-9kzrz9 r-18u37iz r-102gzdx r-tpsn5c']"));
        
        searchBox.click();
        
        Thread.sleep(4000);
        
        WebElement InputSearchBox = driver.findElement(By.id("input-searchsearchpage-input"));
        
        InputSearchBox.sendKeys("Shirts");


    }
}

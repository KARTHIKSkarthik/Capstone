package com.gridexample;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartAppGridExample {
	
public AndroidDriver<AndroidElement> driver;	    
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
	            caps.setCapability("deviceName", firstDeviceName);
	            caps.setCapability("udid", firstDeviceName);
	            caps.setCapability("platformName", "Android");
	            caps.setCapability("platformVersion", "9.0");	            
	            caps.setCapability("appPackage", "com.android.calculator2");
	            caps.setCapability("appActivity", "com.android.calculator2.Calculator");	            	            
	        }
	        else if(device_id.equalsIgnoreCase(secondDeviceName))
	        {
	            System.out.println("The Device ID is" +device_id);
	            System.out.println(port + "-" +System.currentTimeMillis());
	            System.out.println(device_id + "-" +System.currentTimeMillis());	            
	            caps.setCapability("deviceName", secondDeviceName);
	            caps.setCapability("platformName", "Android");
	            caps.setCapability("platformVersion", "9.0");            
	            caps.setCapability("appPackage", "com.android.calculator2");
	            caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	    }
	    driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);    
	    Thread.sleep(5000);
	    }
	    @Test
	    public void CaclulateTest()
	    {	        
	        AndroidElement eight = driver.findElementById("com.android.calculator2:id/digit_8");        
	        eight.click();        
	        AndroidElement additon = driver.findElementById("com.android.calculator2:id/op_add");	        
	        additon.click();	        
	        AndroidElement two = driver.findElementById("com.android.calculator2:id/digit_2");	        
	        two.click();	        
	        AndroidElement equals = driver.findElementById("com.android.calculator2:id/eq");	        
	        equals.click();
	    }
}
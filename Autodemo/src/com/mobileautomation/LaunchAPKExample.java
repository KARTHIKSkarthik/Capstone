package com.mobileautomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchAPKExample {
	public static AndroidDriver<AndroidElement> driver;
	
	@Test
	public void LaunchAppExample() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		//Define the App directory of the APK file
		File appdir = new File("src/com/mobileautomation");
		File app = new File(appdir,"ApiDemos-debug.apk");
       
        //provide the exact or absolute path of the apk file location in the machine
        
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                caps.setCapability("platformName", "Android");
                caps.setCapability("platformVersion", "9.0");
                          caps.setCapability("noReset","true");
                        //Usually the app package name and app activity will be provided by the devlopers
                  	    
                  	    caps.setCapability("appPackage","io.appium.android.apis");
                  	    caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");
                  	    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
                  	}
	
	@AfterClass
	public void closeApp()
	{
		//driver.quit();
		driver.removeApp("io.appium.android.apis");
	}
	}




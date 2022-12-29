package com.failscreenshotexample;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ScreenshotUtility.class})
public class SampleTestCase {
	public static AndroidDriver<AndroidElement> driver;	
	@Test
	public void TestCase() throws MalformedURLException, InterruptedException
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
    Thread.sleep(3000);
    driver.findElementByAccessibilityId("Graphics").click();
}
}
	
	



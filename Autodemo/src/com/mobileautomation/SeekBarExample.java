package com.mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;




public class SeekBarExample {

	public AndroidDriver<AndroidElement> driver;
	
	@Test
	public void SeekBarExampleScenario() throws MalformedURLException, InterruptedException
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
	        
	        MobileElement Seekbar = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
	                + "new UiSelector().description(\"Seek Bar\"));"));
	        
	        Seekbar.click();
	        
	        AndroidElement SeekBarSection = driver.findElementById("io.appium.android.apis:id/seek");
	        
	        //Step get the location of the Starting X
	        
	        int StartX = SeekBarSection.getLocation().getX();
	        
	        int StartY = SeekBarSection.getLocation().getY();
	        
	        int EndX =SeekBarSection.getSize().getWidth();
	        
	        int SeekDirectionMedium = (int) (EndX*0.6);
	        int SeekDirectionEnd = (int) (EndX*0.9);
	        
	        TouchAction act = new TouchAction(driver);
	        
	        act.press(PointOption.point(StartX,StartY)).moveTo(PointOption.point(SeekDirectionMedium,StartY)).release().perform();
	        
	        Thread.sleep(2000);
	        
	        String progressValue = driver.findElementById("io.appium.android.apis:id/progress").getText();
	        String trackingValue = driver.findElementById("io.appium.android.apis:id/tracking").getText();
	        
	        
	        System.out.println(progressValue);
	        System.out.println(trackingValue);
	        
	        Thread.sleep(2000);
	        
	        act.press(PointOption.point(StartX,StartY)).moveTo(PointOption.point(SeekDirectionEnd,StartY)).release().perform();
	        
	        String progressValueEnd = driver.findElementById("io.appium.android.apis:id/progress").getText();
	        String trackingValueEnd = driver.findElementById("io.appium.android.apis:id/tracking").getText();
	        
	        
	        System.out.println(progressValueEnd);
	        System.out.println(trackingValueEnd);




	}
}

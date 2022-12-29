package com.gesturesexample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MultiGestureActions {
	
public AndroidDriver<AndroidElement> driver;

	
	@Test
    
    public void Testcase() throws MalformedURLException, InterruptedException
    {
    
    DesiredCapabilities caps = new DesiredCapabilities();
    
    //Provide Device Name and OS details
    
    caps.setCapability("deviceName", "emulator-5554");
    caps.setCapability("platformName", "Android");
    caps.setCapability("platformVersion", "9.0");
    caps.setCapability("noReset", "true");
    
    //Usually the App package name and the App activity will be provided by the devlopers
    
    caps.setCapability("appPackage", "com.google.android.apps.maps");
    caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
    
    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    
    Thread.sleep(7000);
    
    //AndroidElement content = driver.findElement(By.xpath("android:id/content"));
    
    //Rectangle mapCordinates = content.getRect();

   TouchAction singletap = new TouchAction(driver);
    
    singletap.tap(PointOption.point(411, 197)).perform();
    
    Thread.sleep(2000);
    
    AndroidElement searchBox = driver.findElementById("com.google.android.apps.maps:id/search_omnibox_edit_text");
    
    searchBox.sendKeys("Bangalore");
    
    Thread.sleep(5000);
    
    //988 2177
    
    singletap.tap(PointOption.point(1320, 2825)).perform();
    
    
    //AndroidElement content = driver.findElement(By.xpath("android:id/content"));
    
    //Rectangle mapCordinates = content.getRect();
    
    //Simuilating the action for 1 finger
    
    //1 finger actions X 484, Y 784 X 521 Y 471
    
    TouchAction a1 = new TouchAction(driver).press(PointOption.point(181,1807))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(728, 187));
    
    //Simulatring 2 nd finger interaction x 500 776 588 580
    
    
    TouchAction a2 = new TouchAction(driver).press(PointOption.point(257,2404))
    		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(728, 187));


    
    //Combine the both Touch actions
    
    MultiTouchAction mt= new MultiTouchAction(driver);
    
    Thread.sleep(3000);
    
    
    mt.add(a1).add(a1).perform();




    
    }


}

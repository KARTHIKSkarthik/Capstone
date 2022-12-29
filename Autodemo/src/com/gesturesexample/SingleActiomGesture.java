package com.gesturesexample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class SingleActiomGesture {
	
	public class SampleTestCase{
		
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
    
    Thread.sleep(3000);
    
    //driver.findElementByAccessibilityId("Graphics").clic

    TouchAction a1 = new TouchAction(driver);
    
    a1.tap(PointOption.point(892, 788)).perform();
    
    Thread.sleep(3000);
    
    AndroidElement HamMenu = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Menu\"]/android.widget.ImageView");
    
    a1.tap(TapOptions.tapOptions().withElement(ElementOption.element(HamMenu))).perform();
    
    //X Axis 988, Y Axis 746
    
    a1.tap(PointOption.point(1314, 1057)).perform();
    
    Thread.sleep(5000);
    
    //To verify copy address is coming on the screen using long press
    
    //x Axis 520 Y axis 828
    
    a1.longPress(PointOption.point(520,828)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).release().perform();



}
	}
}

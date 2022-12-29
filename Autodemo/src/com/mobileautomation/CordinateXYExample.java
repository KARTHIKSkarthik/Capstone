package com.mobileautomation;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

//import javax.print.DocFlavor.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CordinateXYExample {
	public AndroidDriver<AndroidElement> driver;
	@Test
    
    public void OpenApp() throws MalformedURLException, InterruptedException
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
       
    


        
        driver.findElementByAccessibilityId("Views").click();
        
        Thread.sleep(2000);
        MobileElement item = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().description(\"Rating Bar\"));"));
        
        Thread.sleep(2000);
        item.click();
        
//Identifying the 3 star element
        
AndroidElement threestar = driver.findElementById("io.appium.android.apis:id/ratingbar1");
        
        int startX = threestar.getLocation().getX();
        
        int endX = threestar.getSize().getWidth();
        
        int yaxis = threestar.getLocation().getY();
        
        System.out.println(startX);
        System.out.println(yaxis);
        
        /* int TapValue = (int) (endX*0.3);
        
        TouchAction Action = new TouchAction(driver);
        
        Action.press(PointOption.point(TapValue,yaxis )).release().perform(); */
        
        int onestarRating = (int) (endX*0.3);
        int middlestarRating = (int) (endX*0.6);
        int topstarRating = (int) (endX*0.9);
        
        TouchAction Action = new TouchAction(driver);
        
        Action.press(PointOption.point(onestarRating,yaxis )).release().perform();
        Thread.sleep(2000);
        Action.press(PointOption.point(middlestarRating,yaxis )).release().perform();
        Thread.sleep(2000);
        Action.press(PointOption.point(topstarRating,yaxis )).release().perform();






        
        //driver.findElementByAccessibilityId("Rating Bar").click();

	
    }
}

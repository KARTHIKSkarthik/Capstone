package com.mobileautomation;



import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;




public class FirstTestCase {
	
	public AndroidDriver<AndroidElement> driver;
@Test
public void openDevice() throws MalformedURLException


{
	
    //Step 1 is to create a object for Desiredcapbailies class
    
    DesiredCapabilities caps = new DesiredCapabilities();
    
    //Details given as part of your device
    
    caps.setCapability("platformName", "Android");
    caps.setCapability("deviceName", "emulator-5554");
    caps.setCapability("platformVersion", "9.0");
    caps.setCapability("noReset", "true");
    
    //Provide the details for launching the app in the emulator, for launching the app
    //We have to provide "Package name" and "activty name"
    
    caps.setCapability("appPacakage", "io.appium.android.apis");
   
    caps.setCapability("appActivity", "io.appium.android.apiDemos");
    
  driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);

}

@Test
    
    public void Testcase1() throws InterruptedException
    {
        System.out.println("Starting application");
        
        Thread.sleep(3000);
        
        driver.findElementByAccessibilityId("OS").click();
        
    



	
}
	
}

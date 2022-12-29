package com.gridexample;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class DesktopGridExample {
	
public static RemoteWebDriver driver;
    
    @Test
    
    public void OpenBrowser() throws MalformedURLException
    {
        String url = " http://192.168.1.101:4444/wd/hub";
        
        ChromeOptions options = new ChromeOptions();
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        
        caps.setPlatform(Platform.WINDOWS);
        caps.setBrowserName("chrome");
        
        options.merge(caps);
        
        driver = new RemoteWebDriver(new URL(url),options);
        
        driver.get("https://www.rediff.com/");

    }

}

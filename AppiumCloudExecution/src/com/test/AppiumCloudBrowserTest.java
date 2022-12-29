package com.test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class AppiumCloudBrowserTest {
    
	public static RemoteWebDriver driver;
    public static final String username="karthiks_dnkjQ2";
    public static final String key ="N8jGV6xZhUdfATBnYwUs";
    public static final String url ="https://" +username+":"+key+"@hub-cloud.browserstack.com/wd/hub";
    
    
    
    
    @Test
    
    public void MobileCloudTest() throws MalformedURLException, InterruptedException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("os_version", "16");
        caps.setCapability("deviceName", "iPhone 14");
        caps.setCapability("browser", "safari");
        
        // We have to define the name for our Automation test
        
        caps.setCapability("name", "iOS Safari Test");
        
        driver = new RemoteWebDriver(new URL(url), caps);
        
      /*  driver.get("http://www.google.com");
        
        WebElement SearchBox = driver.findElement(By.name("q"));
        
        SearchBox.sendKeys("Simplilearn");
        
        WebElement SearchElement = driver.findElement(By.xpath("(//div[@class='pcTkSc'])[1]"));
        
        SearchElement.click();
         driver.quit();   */
      
        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);
        
        WebElement searchBox = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1jkafct r-13awgt0 r-18u37iz r-1a8msfu']"));
        
        searchBox.click();
        
        Thread.sleep(3000);
        
        WebElement laptoplink = driver.findElement(By.xpath("//div[text()='laptops']"));
        
        laptoplink.click();
        
        String url = driver.getCurrentUrl();
        
        if(url.contains("laptops"))
        {
            System.out.println("the user has navigated to laptop page");
        }
        
        else
        {
            System.out.println("navigation error");
        }
        
        System.out.println(driver.getTitle());
        
        driver.quit();



      
        
        
        
}
}
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class TestSwiggy {
	public static AndroidDriver<AndroidElement> driver;
	MobileElement foundElem;
	@BeforeMethod
	public void OpenApp() throws MalformedURLException
	{
		DesiredCapabilities 
		caps = new DesiredCapabilities();
		//Provide  Device Name
		
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
	    caps.setCapability("noReset", "true");    
	    caps.setCapability("appPackage","in.swiggy.android");
	    caps.setCapability("appActivity","in.swiggy.android.activities.HomeActivity");
	    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
	}	
	@Test
	public void Testcase() throws InterruptedException
	{
		System.out.println("Start Test");
		Thread.sleep(18000);
		driver.findElementById("in.swiggy.android:id/title_tv").click();
		Thread.sleep(9000);	
		driver.findElementById("in.swiggy.android:id/search_query_edittext").sendKeys("Thoppumpadi junction");
		Thread.sleep(6000);
		driver.findElementById("in.swiggy.android:id/tv_area_description").click();
		Thread.sleep(9000);	
		driver.findElementById("in.swiggy.android:id/google_place_search_title_text1").click();
		Thread.sleep(9000);
		driver.findElementById("in.swiggy.android:id/negatvieCta").click();
		Thread.sleep(9000);
		driver.findElementById("in.swiggy.android:id/placeholder_description_tv").click();
		Thread.sleep(19000);	
		driver.pressKey(new KeyEvent(AndroidKey.P));
		driver.pressKey(new KeyEvent(AndroidKey.I));
		driver.pressKey(new KeyEvent(AndroidKey.Z));
		driver.pressKey(new KeyEvent(AndroidKey.Z));
		driver.pressKey(new KeyEvent(AndroidKey.A));
		Thread.sleep(9000);		
		driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"Dish\"])[1]")).click();	
		Thread.sleep(9000);
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"add button\"])[1]/android.view.ViewGroup/android.widget.TextSwitcher/android.widget.TextView")).click();	
		Thread.sleep(9000);
		AndroidElement Result = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView"));
		
		// verification of correct item added in the cart  
        System.out.println("The  Added Pizza is  "+Result.getText());
        Assert.assertEquals(Result.getText(),"Sausage Pizza");
        
	}
	}



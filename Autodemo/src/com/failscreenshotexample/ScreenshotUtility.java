package com.failscreenshotexample;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotUtility implements ITestListener

{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		try {
			captureScreenshot(result,"pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		ITestListener.super.onTestFailure(result);
		try {
			captureScreenshot(result,"fail");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	public void captureScreenshot(ITestResult result, String status) throws IOException
    {
        
        String destDir = "./Screenshot/FailedScreenshots";
        String destPassDir = "./Screenshot/PassedScreenshots";
        
        
        //Define the code for capturing the screenshot
        
        File srcFile = ((TakesScreenshot)SampleTestCase.driver).getScreenshotAs(OutputType.FILE);
        
        //Setting file name for the screenshot
        
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY__hh_mm_ssaa");
        
        new File(destDir).mkdirs();
        
        String destFile = dateFormat.format(new Date(0))+ ".png";
        if(status.equalsIgnoreCase("pass"))
        {FileUtils.copyFile(srcFile, new File(destPassDir +"/" +destFile));
        }
        	
        
	else if (status.equalsIgnoreCase("fail"))
			
		{
            
            FileUtils.copyFile(srcFile, new File(destDir +"/" +destFile));
        }
        
       
        
        
    }


	

}

package com.stock.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import com.stock.qa.util.TestUtil;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	static String projectpath = System.getProperty("user.dir");

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(projectpath+ "/src/main/java/com/stock/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
		try {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", projectpath+"/Drivers/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", projectpath+"/Drivers/geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}	
	public void FailedTestCase(String testMethodName) throws IOException {

		File scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(projectpath+"/ScreenShots/"+testMethodName+".jpg"));
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}


//	public static void CaptureScreenshots(WebDriver driver, String ScreenShotName) 
//	{
//		TakesScreenshot ts= (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		//to create screenshot file with .png extension
//		try 
//		{
//			FileUtils.copyFile(source, new File("./ScreenShots/"+ScreenShotName+".png"));
//		} 
//		catch (Exception e)
//		{
//			System.out.println("Exception while taking ScreentShot"+e.getMessage());
//			System.out.println("Exception cause:" +e.getCause());
//		}
//	}
//}

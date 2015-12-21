package Tmall_One.Get_mall;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PcServices.PcServices;





public class ParallelClassesTestTWO
{   public static  AndroidDriver driver ;
    String ip="127.0.0.1";
    String port ="4724";
    @BeforeClass
    public void beforeClass() throws MalformedURLException, InterruptedException {
    	PcServices.AppiumServices(ip,port);
    	Thread.sleep(8000);
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class. Thread id is: " + id);
        DesiredCapabilities capabilities = new DesiredCapabilities(); 
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName", "38f8d32d");
        capabilities.setCapability("udid", "38f8d32d");
        capabilities.setCapability("platformVersion", "4.4");  
        capabilities.setCapability("appPackage", "com.sds.android.ttpod");  
        capabilities.setCapability("appActivity", "com.sds.android.ttpod.EntryActivity");
        driver = new AndroidDriver(new URL("http://"+ip+":"+port+"/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    @Test
    public void testMethodOne() throws InterruptedException {
    	 ParallelClasses.Case(driver);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-class2. Thread id is: " + id);
        driver.quit();
    }
}
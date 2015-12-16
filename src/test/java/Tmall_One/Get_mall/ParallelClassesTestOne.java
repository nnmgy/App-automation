package Tmall_One.Get_mall;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ParallelClassesTestOne
{   public static  AndroidDriver driver ;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class. Thread id is: " + id);
        DesiredCapabilities capabilities = new DesiredCapabilities(); 
        capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName", "192.168.153.101:5555");
        capabilities.setCapability("udid", "192.168.153.101:5555");
        capabilities.setCapability("platformVersion", "4.3");  
        capabilities.setCapability("appPackage", "com.taobao.taobao");  
        capabilities.setCapability("appActivity", "com.taobao.tao.welcome.Welcome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
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
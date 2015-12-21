package AppiumCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import PcServices.PcServices;

public class capabilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void SartUp(AndroidDriver driver,String ip ,String port) throws MalformedURLException, InterruptedException {
	    	PcServices.AppiumServices(ip,port);
	    	Thread.sleep(10000);
	        long id = Thread.currentThread().getId();
	        System.out.println("Before test-class. Thread id is: " + id);
	        DesiredCapabilities capabilities = new DesiredCapabilities(); 
	        capabilities.setCapability("device","Android");
	        capabilities.setCapability("deviceName", "192.168.82.101:5555");
	        capabilities.setCapability("udid", "192.168.82.101:5555");
	        capabilities.setCapability("platformVersion", "4.4");  
	        capabilities.setCapability("appPackage", "com.sds.android.ttpod");  
	        capabilities.setCapability("appActivity", "com.sds.android.ttpod.activities.MainActivity");
	        driver = new AndroidDriver(new URL("http://"+ip+":"+port+"/wd/hub"), capabilities);
		    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     
	    }
}

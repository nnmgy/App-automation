package Tmall_One.Get_mall;

import io.appium.java_client.android.AndroidDriver;

public class ParallelClasses {

	 public static void Case(AndroidDriver driver) throws InterruptedException {
	    	String Action="{\"aspectRatio\":\"0.302\",\"pressEffect\":\"false\"}";
	    	String Action1="刷新";
	        System.out.println("test.......three");	  
	        driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\""+Action+"\")").click();
	    	Thread.sleep(20000);
	        System.out.println("test.......three");	
	        Thread.sleep(25000);
	        for(int i=0;i<10000000;i++)
	        {
	        	try
	        	{
	        		if(i%50==0)
	        		{
			        	 driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\""+Action1+"\")").click();
			        	 Thread.sleep(9000);
			             driver.tap(1, 529,1306, 200);	
	        		}
	        	 
	             
	        	  Thread.sleep(3000);	
	        	  driver.tap(1, 363,1362, 200);
	        	}
	        	catch(Exception E)
	        	{
	        		 Thread.sleep(800);
	        		 driver.tap(1, 363,1362, 200);
	        	}
	        	
	        }
	    }
	
}

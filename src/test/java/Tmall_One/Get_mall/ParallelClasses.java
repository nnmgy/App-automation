package Tmall_One.Get_mall;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class ParallelClasses {

	 public static void Case(AndroidDriver driver) throws InterruptedException {
		 for(int i=0;i<99;i++){
           driver.findElement(By.id("com.sds.android.ttpod:id/layout_local_music")).click();
           driver.findElement(By.id("com.sds.android.ttpod:id/no_data_action_view")).click();
           driver.findElement(By.name("我的")).click();
		 }
           
	 }
	
}

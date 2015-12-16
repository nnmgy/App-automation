package Tmall_One.Get_mall;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class ActionPara {

	public static AndroidDriver driver;


    public static void Staup(String Action) throws Exception
    {		
        String prot=null;
		DesiredCapabilities capabilities = new DesiredCapabilities(); 
	    capabilities.setCapability("device","Android");
	//  capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	//    capabilities.setCapability("deviceName", "MSM8926");
	    capabilities.setCapability("deviceName", "emulator-5554");				 
	//  capabilities.setCapability("deviceName", "52c7c049");
	//  capabilities.setCapability("deviceName", "614ad249");
	    capabilities.setCapability("platformVersion", "4.3");  
	    capabilities.setCapability("platformName", "Android");  
	//  capabilities.setCapability("app", app.getAbsolutePath());
//		capabilities.setCapability("appPackage", "com.tencent.mm");  
//	    capabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
	    capabilities.setCapability("appPackage", "com.fanli.android.apps");  
	    capabilities.setCapability("appActivity", Action);
/*	    capabilities.setCapability("appActivity", "com.fanli.android.activity.SplashActivity");   */
	    driver = new AndroidDriver(new URL("http://127.0.0.1:"+prot+"/wd/hub"), capabilities);    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
   }			    
	
	
	
	// Xpathclick
	public static void Xpath(String Xpath)

	{
	 driver.findElement(By.xpath(Xpath)).click();;

	}

	// XpathInput
	public static void XpathInput(String Xpath,String value1)

	{
		driver.findElement(By.xpath(Xpath)).clear();
		driver.findElement(By.xpath(Xpath)).sendKeys(value1);

	}

	// Name
	public static void Name(String Name)

	{
		String fexo="new UiSelector().textContains(\""+Name+"\")";
		driver.findElementByAndroidUIAutomator(fexo).click();	 
	}

	

	// classNameid
	public static void Classid(String className,String id)

	{
		
		 driver.findElement(By.className(className)).findElements(By.id(id)).get(0).click();	 
	}
	

	//classNameindex

	public static void classNameindex(String className,int i)

	{
		
		 driver.findElements(By.className(className)).get(i).click();	 
	}
	
	//classNameindextxt

		public static void classNameindextxt(String className,int i,String value)

		{
			
			 driver.findElements(By.className(className)).get(i).sendKeys(value);	 
		}
	
	
	
	//classNametagname

	public static void classtagname(String className,String tagname,int i)

	{
		
		 driver.findElement(By.className(className)).findElements(By.tagName(tagname)).get(i).click();	 
	}
	//classNametagnametxt
	public static String classtagnametxt(String className,String tagname,int i)

	{
		
		return driver.findElement(By.className(className)).findElements(By.tagName(tagname)).get(i).getText();	 
	}
	
	//classNametagnametxt
	public static String idtagtxt(String id,String tagname,int i)

	{
		
		return driver.findElement(By.id(id)).findElements(By.tagName(tagname)).get(i).getText();	 
	}
	
	

	
	//idtagname

		public static void idtagname(String id,String tagname,int i)

		{
			
			 driver.findElement(By.id(id)).findElements(By.tagName(tagname)).get(i).click();	 
		}
	

	
	// ID
	public static void ID(String ID)

	{
		 driver.findElement(By.id(ID)).click();
		
	}
	// IDindex
		public static void idindex(String ID,int i)

		{
			 driver.findElements(By.id(ID)).get(i).click();
			
		}

		
	// IDinput
	public static void Inputid(String Inputid,String value)

	{
		
		driver.findElement(By.id(Inputid)).click();
		driver.findElement(By.id(Inputid)).sendKeys(value);
	

	}
	
	// check
	public static int checkfind(String xpath)
	 { 
	        try { 
	               driver.findElement(By.xpath(xpath)); 
	               return 0; 
	        } catch (NoSuchElementException e) { 
	            return 1; 
	        } 
	    } 
	
	

	// IDinput
	public static void Inputname(String name, String value)

	{
		driver.findElement(By.id(name)).sendKeys(value);

	}

	// LINKTXT
	public static void Linktxt(String txt) {
		driver.findElement(By.linkText(txt)).click();;
		
	}

	// tagName

	public static void tagNameClassname(String className, String tag, int index) {
		driver.findElement(By.className(className)).findElements(By.tagName(tag)).get(index).getText();

	}

	// Windows Alert

	public static void Alert(String Y) throws InterruptedException {

		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		if (Y == "Y") {
			alert.accept();
		}

		else if (Y == "Y2") {
			alert = driver.switchTo().alert();
			alert.accept();
			alert = driver.switchTo().alert();
			alert.accept();
		} else {
			alert.dismiss();
		}

	}

	public static void Select1(String id, int x) throws InterruptedException {

		// 点击下拉列表的第几项
		Select selectAge = new Select(driver.findElement(By.id(id)));
		selectAge.selectByIndex(x);// Select.selectByIndex

	}

	public static void Select2(String id, String value)
			throws InterruptedException {

		// 点击下拉列表的第几项
		Select selectShen = new Select(driver.findElement(By.id(id)));
		selectShen.selectByValue(value);// Select.selectByValue

	}

	public static void Select3(String id, String value)
			throws InterruptedException {

		// 点击下拉列表的某个文字
		Select selectTown = new Select(driver.findElement(By.id("User_Town")));
		selectTown.selectByVisibleText(value);// Select.selectByVisibleText

	}

	public static void refresh(int k) throws InterruptedException {

		// 点击下拉列表的某个文字
		for (int i = 0; i < k; i++) {
			driver.navigate().refresh();
		}
	}

	public static void wait(int i) throws InterruptedException {

		Thread.sleep(i * 1000);
	}

	// Txt

	public static String txt(String value, String k)

	{

		String txt = null;

		if (k == "id") {
			txt = driver.findElement(By.id(value)).getText();

		}

		if (k == "name") {
			txt = driver.findElement(By.name(value)).getText();

		}

		if (k == "xpath") {
			txt = driver.findElement(By.xpath(value)).getText();

		}

		if (k == "classname") {
			txt = driver.findElement(By.className(value)).getText();

		}
		if (k == "ct") {
			txt = driver.findElement(By.className(value))
					.findElement(By.tagName(value)).getText();

		}
		return txt;

	}

	// 当前时间
	public static String Time()

	{

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"MM_dd_HH_mm_ss");// 可以方便地修改日期格式
		String hehe = dateFormat.format(now);
	/*	System.out.println(hehe);*/
		return hehe;

	}

	// list ID
	/*public static String list() {

		List<WebElement> list = driver.findElements(By.className("lh-wrap"));

		return list.get(0).getText();
	}*/

	// list ID
	/***
	 * 
	 * @param P
	 * @param value
	 * @param tagname
	 * @return
	 * @param i
	 */
	public static String classNameTagname(String k, String value,String tagname, int i) 
	{
		
		
		String txt=null;

		if (k == "id") {
			txt = driver.findElement(By.id(value)).findElements(By.tagName(tagname)).get(i).getText();

		}

		if (k == "name") {
			txt = driver.findElement(By.name(value)).findElements(By.tagName(tagname)).get(i).getText();

		}

		if (k == "xpath") {
			txt = driver.findElement(By.xpath(value)).findElements(By.tagName(tagname)).get(i).getText();

		}

		if (k == "classname") {
			txt = driver.findElement(By.className(value)).findElements(By.tagName(tagname)).get(i).getText();

		}
	

		
	
		return txt;
		
		
		
//
//		switch (P) {
//		case "id":
//			return driver.findElement(By.id(value))
//					.findElements(By.tagName(tagname)).get(i).getText();
//
//		case "classname":
//			return driver.findElement(By.className(value))
//					.findElements(By.tagName(tagname)).get(i).getText();
//
//		case "name":
//			return driver.findElement(By.name(value))
//					.findElements(By.tagName(tagname)).get(i).getText();
//
//		case "xpath":
//			return driver.findElement(By.xpath(value))
//					.findElements(By.tagName(tagname)).get(i).getText();
//
//		default:
//
//			return null;
//			// List<WebElement> list =
//			// driver.findElements(By.className("lh-wrap"));
//		}
	}

	// 截图保存至文件
	public static void snapshot() {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		String filename = Time() + ".jpg";
		String currentPath = ("D:/log/snapshot"); // get current work folder
		System.out.println(currentPath);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:" + currentPath + "/"
					+ filename);
			FileUtils
					.copyFile(scrFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {

			System.out.println("screen shot finished");
		}
	}
	
	//切入混合网页
	public static void Webgo(AndroidDriver driver) {
	try {
	      Set<String> contextNames = driver.getContextHandles();
	      for (String contextName : contextNames) {
	        // 用于返回被测app是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型App
	        if(contextName.contains("WEBVIEW")||contextName.contains("webview")){
	        	contextName=contextName.substring(0, contextName.indexOf("_"));
	        	System.out.println(contextName); 
	        	driver.context(contextName);
	        	System.out.println("跳转到web页 开始操作web页面 "+driver.getCurrentUrl()); 
	        	break;
	        }
	      }
	 }catch (Exception e) {
	      e.printStackTrace();
	 }
	}
	
	
	public boolean doesWebElementExist(String selector)
	{ 

	        try 
	        { 
	               driver.findElement(By.id(selector)); 
	               return true; 
	        } 
	        catch (NoSuchElementException e) 
	        { 
	                return false; 
	        } 
	}
	
	/***
	* 切换APP页面查找元素
	*/
	public static void switchtoApp(){
		try {
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
			System.out.println(contextName); 
			// 用于返回被测app是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型App
				if(contextName.contains("NATIVE_APP")){
					driver.context(contextName);
				    System.out.println("跳转到App页 开始操作App页面"); 
				    break;
				}
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    /***
	 * 切换WEB页面查找元素
	 */
	public static void switchtoWeb(){
		try {
		      Set<String> contextNames = driver.getContextHandles();
		      for (String contextName : contextNames) {
		        // 用于返回被测app是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型App
		        if(contextName.contains("WEBVIEW")||contextName.contains("webview")){
		        	contextName=contextName.substring(0, contextName.indexOf("_"));
//		        	System.out.println(contextName); 
		        	driver.context(contextName);
		        	System.out.println("跳转到web页 开始操作web页面"); 
		        	break;
		        }
		      }
		 }catch (Exception e) {
		      e.printStackTrace();
		 }
	}
	
    /***
	 * 切换tab
	 */
	public static void switchtoTab(){
		try {

			 Set<String> winSet = ActionPara.driver.getWindowHandles();
		     List<String> winList = new ArrayList<String>(winSet);
		     //String oldTab = winList.get(0);
		     String newTab = winList.get(winList.size() - 1);
		     ActionPara.driver.switchTo().window(newTab); 

		      
		 }catch (Exception e) {
		      e.printStackTrace();
		 }
	}
	 /***
		 * 切换tab1
		 */
		public static void switchtoTab1(){
			try {

				 Set<String> winSet = ActionPara.driver.getWindowHandles();
			     List<String> winList = new ArrayList<String>(winSet);
			     //String oldTab = winList.get(0);
			     String newTab = winList.get(winList.size() - 1);
			     ActionPara.driver.switchTo().window(newTab); 

			      
			 }catch (Exception e) {
			      e.printStackTrace();
			 }
		}
	

	
}

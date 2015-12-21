package PcServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import PcServices.AppiumSevices.StreamDrainer;

public class PcServices {
	static String result=null;

public  static void  main(String []args) throws InterruptedException{
	//DosCommand("adb shell getprop ro.build.version.release ");
	AppiumServices("127.0.0.1","4723");
}	
	
public  static void  AppiumServices(String ip,String port) throws InterruptedException{
	System.out.println("-------开始分配端口-----");
	result=DosCommand("netstat -ano|findstr \""+port+"\"");
	System.out.println(result);
	System.out.println("----检查端口是否被占用");
	if(result.isEmpty()==true){
		System.out.println(DosCommand("taskkill /f /t /im  "+"adb.exe"));
		StreamDrainer.appium(ip,port);
		}else{ 
			String strArr=result.substring(result.indexOf("LISTENING")+10,result.length()).trim();
			System.out.println(strArr);
			System.out.println(DosCommand("taskkill /f /t /im  "+strArr));
			System.out.println(DosCommand("taskkill /f /t /im  "+"adb.exe"));
			StreamDrainer.appium(ip,port);
		}
}
/*cmd封装*/
public static String  DosCommand(String cmmd) {
	String result=new String ();
	BufferedReader br = null;
    try {String[] cmd = new String[] { "cmd.exe", "/C", cmmd };
        Process process = Runtime.getRuntime().exec(cmd); 
        br = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
        	stringBuffer.append(line+" ");
        	System.out.println(line+" ");
            }result=stringBuffer.toString();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {if (br != null) {
            try {br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } return result;
}


/*cmd封装*/
public static String AdbCommand(String Command) throws  InterruptedException, IOException  {
	  	String str3=null;
	    Runtime runtime = Runtime.getRuntime();
	    Process proc = runtime.exec(Command);
	    try { if (proc.waitFor() != 0) {
	            System.err.println("exit value = " + proc.exitValue());
	        }
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                proc.getInputStream()));
	        StringBuffer stringBuffer = new StringBuffer();
	        String line = null;
	        while ((line = in.readLine()) != null) {
	            stringBuffer.append(line+" ");   
	        }        
	        str3=stringBuffer.toString();	
	    } catch (InterruptedException e) {
	        System.err.println(e);
	    }finally{
	        try {
	            proc.destroy();
	        } catch (Exception e2) {
	        }
	    }   
	  return str3 ;
	  }
}




    

package PcServices;

import java.io.IOException;



public class GetEnvironmentVariable {
	
	
	public  static  void  main (String []args) throws InterruptedException, IOException
	{
		System.out.println(DevicesNameListpo ("192.168.82.101:5555"));
	}
	
	public  String DevicesVersion (){
		System.out.println("-------开始获取设备Version-----");
		return PcServices.DosCommand("adb shell getprop ro.build.version.release");
	}
	
	public  String[] DevicesNameList (){
		
		System.out.println("-------开始获取设备List----");
		String  DevicesList=PcServices.DosCommand("adb devices");
		DevicesList=DevicesList.replace("List of devices attached", "");
		DevicesList=DevicesList.replace("device", ",");
		String List[] =DevicesList.split(",");
		return List;
	}
	
	
	public static  String DevicesNameListpo (String DevicesKeys) throws IOException, InterruptedException{
		System.out.println("-------开始获取设备名----");
		return PcServices.AdbCommand("adb -s " +DevicesKeys+" shell cat /system/build.prop | grep \"product.brand\"").replace("ro.product.brand=", "");
	}

}

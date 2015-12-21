package PcServices;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class AppiumSevices {

static class StreamDrainer implements Runnable {
    private InputStream ins;

    public StreamDrainer(InputStream ins) {
        this.ins = ins;
    }
    public static void appium(String ip,String port) {
    	System.out.println("Ip:"+ip+"  prot"+port);
        String[] cmd = new String[] { "cmd.exe ", "/C","appium -a "+ip+" -p  "+port  +" -bp "+(Integer.parseInt(port)+3)};
        try { Process process = Runtime.getRuntime().exec(cmd);
            new Thread(new StreamDrainer(process.getInputStream())).start();
            new Thread(new StreamDrainer(process.getErrorStream())).start();    
            process.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public void run() {
		// TODO Auto-generated method stub
		try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(ins,"gbk"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
}
    

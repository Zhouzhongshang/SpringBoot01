package cn.Test.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * 读取敲的命令
 * @author 007
 * 网络：流 文件
 *
 *1.一次读取一行考虑：BufferedReader --InputStreamReader--
 *                                 --FileReader--
 */
public class TestSocket {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         InetAddress localHost = InetAddress.getLocalHost();
         String hostAddress = localHost.getHostAddress();
         System.out.println(hostAddress+":主机地址");
         
        Process exec = Runtime.getRuntime().exec("ping "+"192.168.2.219");
        BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        String path="G:/a/";
        String name="name"+System.currentTimeMillis();
        String temp=path+name+".txt";
        File file = new File(temp);
        if(!file.exists()){
     	   file.createNewFile();
     	   System.out.println("创建文件成功");
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
      
        /**
       * 死循环每次读取一行，返回的是数据
       */
        StringBuilder line=new StringBuilder();
        String s=null;
        while((s=in.readLine())!=null){
        	line.append(s+"\r\n");
        	out.write(s+"\r\n");
        	out.flush();
        }
        in.close();
        out.close();
       String b = line.toString();
       System.out.println(b);
	}
}

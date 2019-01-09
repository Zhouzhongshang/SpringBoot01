package cn.Test.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;


public class TestManyIpTong {
	private static final Logger log=Logger.getLogger(TestManyIpTong.class);
	public static void main(String[] args) throws UnknownHostException {
		/**
		 * 1.获取IP本机
		 * 2.本网段是0-255
		 *   运用多线程执行：
		 * 3.执行ping的命令一个一个ping
		 *    成功的就统计输出
		 */
		InetAddress localHost = InetAddress.getLocalHost();
         String ip = localHost.getHostAddress();  
         log.info("IP:"+ip);
         String substring = ip.substring(0, ip.lastIndexOf("."));
         log.info("网段："+substring);
      /* Executors.callable(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	});*/
         
         ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60,
					TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
         final ArrayList<String> arrayList = new ArrayList();
         for (int i = 0; i < 256; i++) {
        	 final String testIp=substring+"."+i;
        	 log.info("测试的IP:"+testIp);
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					/**
					 * 线程去执行任务
					 */
					//Boolean flag=isGet(testIp);
					Boolean flag = null;
					try {
						flag = is(testIp);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(flag){
						arrayList.add(testIp);
						log.info("添加："+testIp);
					}
				}
			});
			
		}
         threadPool.shutdown();
         for (String b : arrayList) {
			System.out.println(b.toString());
		}
	}
       
	public static Boolean is(String ip) throws IOException{
		/**
		 * 1执行命令获取结果
		 * 2判断结果 返回
		 */
		 Boolean flag=false;
		 Process p = Runtime.getRuntime().exec("ping -n 1 " + ip);
		 BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 
		 String a=null;
		 StringBuilder s=new StringBuilder();
		 while((a=in.readLine())!=null){
			 s.append(a+"\r\n");
		 }
		 in.close();
		 String reslut = s.toString();
		// log.info("输出结果为："+reslut);
		 if(reslut.contains("TTL")){
			 //return flag;
			 log.info("ip:"+ip);
			 flag=true;
		 }else{
			 return flag;
		 }
		 return flag;
	}
}

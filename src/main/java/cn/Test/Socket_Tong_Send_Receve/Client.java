package cn.Test.Socket_Tong_Send_Receve;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
       Socket s = new Socket("localhost", 8887);
      System.out.println("客户端准备发送数据");
       //启动发送和接受线程 
       new SendThread(s).start();
       new ReceiveThread(s).start();
	}

}

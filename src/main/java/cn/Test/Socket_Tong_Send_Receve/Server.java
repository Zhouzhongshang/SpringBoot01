package cn.Test.Socket_Tong_Send_Receve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
/**
 * 一个线程代表一个功能；
 *   a---b b---a b
 *   a---b a---b 
 *   实现
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		System.out.println("server开启端口8888 准备接收数据");
		ServerSocket s = new ServerSocket(8887);
		Socket ss = s.accept();
	
		//启动接受线程和发送线程
		new SendThread(ss).start();
	    new ReceiveThread(ss).start();
	}

}

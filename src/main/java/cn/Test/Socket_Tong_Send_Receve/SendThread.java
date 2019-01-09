package cn.Test.Socket_Tong_Send_Receve;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 具有发送文字的功能的线程
 * @author 007
 *
 */
public class SendThread extends Thread {

	private Socket s;
	
	//需要构造 就给它构造
	public SendThread(Socket s){
		this.s=s;
	}
	
	@Override
	public void run(){
		try {
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			while(true){
				
				String nextLine = new Scanner(System.in).nextLine();
				out.writeUTF(nextLine);
				System.out.println("客户端发送数据："+nextLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

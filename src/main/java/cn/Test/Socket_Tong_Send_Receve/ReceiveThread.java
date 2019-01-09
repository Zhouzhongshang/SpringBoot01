package cn.Test.Socket_Tong_Send_Receve;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 具有接受文字的功能的线程
 * @author 007
 *
 */
public class ReceiveThread extends Thread {
 private Socket s;
	
	//需要构造 就给它构造
	public ReceiveThread (Socket s){
		this.s=s; 
	}
	
	@Override
	public void run(){
		try {
			DataInputStream in = new DataInputStream(s.getInputStream());
			//String nextLine = new Scanner(System.in).nextLine();
			//in.writeUTF(nextLine);
			while(true){
				String readUTF = in.readUTF();
				System.out.println("服务端接收到数据："+readUTF);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

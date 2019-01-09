package cn.Test.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 字节流：
 * @author 007
 * 
 * 服务端：端口，开始接受，流接受数据
 * 客户端：连接，流发送数据
 * 
 * 
 * 实现客户端和服务端互相聊
 */

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
        Socket socket = new Socket("127.0.0.1", 8888);
        //使用数据流来读写数据
        OutputStream out = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        //读取键盘输入的字
        while(true){
        	System.out.println("请输入：");
        	 Scanner scanner = new Scanner(System.in);
             String nextLine = scanner.nextLine();
             dataOutputStream.writeUTF(nextLine);
             dataOutputStream.flush();
             
             String readUTF = in.readUTF();
            System.out.println("回复："+readUTF);
        }
	}
}

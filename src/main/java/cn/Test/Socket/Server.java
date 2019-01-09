package cn.Test.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.Test.Socket.pojo.dictionary;

public class Server {

	/**
	 * InputStream 读取返回的是字节 0-255 之间 。
	 * DataInputStream readUTF() 返回的是字符串。
	 *  BufferedReader readLine() 也是读的字符串。
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
        
		 List<String> list=new ArrayList<String>();
		 list.add("听求不懂啊");
		 list.add("说人话");
		 list.add("再说一遍？");
		 list.add("大声点");
		 list.add("老子在忙，一边玩儿去");
		 
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("服务端开启端口8888:");
		System.out.println("服务端正在接收数据：");
		Socket accept = serverSocket.accept();
		InputStream in = accept.getInputStream();
		DataInputStream in1 = new DataInputStream(in);
		DataOutputStream out = new DataOutputStream(accept.getOutputStream());
		
		/**
		 * 服务端解析客户端的信息
		 * 然后输出发送给客户端
		 * 
		 * 集合是用list.size()>0判断的
		 */
		while(true){
			String readUTF = in1.readUTF();
			System.out.println("收到："+readUTF);
			List<dictionary> dao = new DictionaryDao().query(readUTF);
			//System.out.println("收到："+dao.get);
			if(dao.size()>0){
				for (dictionary i : dao) {
					
					out.writeUTF(i.getResponse());
					System.out.println("回复："+i.getResponse());
					out.flush();
				}
			}
				/*Random random = new Random();
				random.*/
				String response = list.get(4);
				System.out.println("回复："+response);
				out.writeUTF(response);
				out.flush();
			
			
			
			//System.out.println("A："+readUTF);
			//System.out.println("请输入：");
			//String nextLine = new Scanner(System.in).nextLine();
			//out.writeUTF(nextLine);
		
		}
       	//int read = in1.read();	
		/*String s = in1.readUTF();
       	System.out.println("收到数据："+s);
       	in1.close();
       	accept.close();
       	serverSocket.close();*/
	}
}

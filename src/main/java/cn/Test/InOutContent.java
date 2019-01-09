package cn.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * int i=0;
 * byte [] a=new byte[1024];
 * while((i=in.read(a))!=-1){
 *    Sys...... new String(a,0,i);
 *    out.write(a)
 * }
 * @author 007
 * 
 * new byte[in.available()]
 * in.read(byte)
 *
 */
public class InOutContent {
	private static final Logger log=Logger.getLogger(InOutContent.class);
      public static void main(String[] args) throws IOException {
    	
    	  /**
    	   * 0.先创建一个目录的txt文件叫做b
    	   */
		/**
		 *1 用流将文件txt写信息，然后将其读出来，输出到控制台
		 */
    	  
    	  String path="G:/test/result/";
    	  String name="b";
    	  String file=path+name+".txt";
    	  File file2 = new File(file);
    	  File file3 = new File("G:/test/result/c.txt");
    	  file3.createNewFile();//直接创建文件
    	  File file4 = new File("G:/test/result/d.txt");
    	  file4.mkdirs();//创建文件的目录
    	  log.info("创建文件成功");
    	  if(!file2.exists()){
    		  file2.createNewFile();
    	  }
    	  
	}
      
      @Test
      public void test(){
    	  /**
    	   * 1.0创建文件
    	   * 2.0用流将数据写在文件中
    	   * 3.0用流读取数据处理后输出
    	   */
    	  String path="G:/test/result01/";
    	  String name="Zhou";
    	  new File(path+name).mkdirs();
    	  log.info("创建目录成功");
    	  String tempFile=path+name+".txt";
    	  File file = new File(tempFile);
    	  if(!file.exists()){
    		  try {
				file.createNewFile();
				log.info("文件创建成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  }
    	  
    	  //FileOutPutStream out = new FileOutPutStream(new OutPutStream(file));
    	  String b="aaaaaaaaaaa\nbbbbbbbb喔沃";
    	  byte[] bytes = b.getBytes();
    	  FileOutputStream fileOutputStream;
    	  FileInputStream fileInputStream;
    	 try {
		  fileOutputStream = new FileOutputStream(file);
			
			try {
				fileOutputStream.write(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 try {
			fileInputStream= new FileInputStream(file);
			try {
				/*int i;
				while((i=fileInputStream.read())!=-1){
					///fileInputStream.read(b);
					//int available = fileInputStream.available();
					
					System.out.println(i);
				}*/
				byte [] c=new byte[4096];
				int i=0;
				while((i=fileInputStream.read(c))!=-1){
					System.out.println(new String(c,0,i));
					//System.out.println(new String(c));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
}

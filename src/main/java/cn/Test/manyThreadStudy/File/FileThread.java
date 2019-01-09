package cn.Test.manyThreadStudy.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileThread implements Runnable {

	private File file;
	private String a;
	
	public FileThread(File file,String a){
		this.file=file;
		this.a=a;
	}
	@Override
	public void run() {
		/**
		 * 将java文件的内容读取出来。
		 */
		String conten=read(file);
		if(conten.contains(a)){
			System.out.println(conten);
		}
        
	}
	private String read(File file2) {
		// TODO Auto-generated method stub
		String d=null;
		try {
			FileReader fileReader = new FileReader(file2);
			int length = (int) file2.length();
			char [] c=new char[length];
			try {
				while(fileReader.read(c)!=-1){
					 d = new String(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return d;
	}

}

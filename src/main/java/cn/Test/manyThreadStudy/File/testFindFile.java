package cn.Test.manyThreadStudy.File;

import java.io.File;

public class testFindFile {

	
	public static void search(File file,String content){
		/**
		 * 判断是否是文件是： new 线程执行
		 *          是目录：获取所有的文件迭代
		 *          继续执行方法
		 */
		if(file.isFile()){
			if(file.getName().toLowerCase().endsWith(".java")){
				FileThread fileThread = new FileThread(file, content);
				Thread thread = new Thread(fileThread);
				thread.start();
				System.out.println(file.getName());
			}
		}
		if(file.isDirectory()){
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				//File file3 = new File(file2);
				search(file2,content);
			}
		}
	}
	
	public static void main(String[] args) {
		/**
		 * 运用多线程查找，java文件
		 */
       // new File();
		String path="F:\\workspace\\SpringBoot01";
		String content="static";
		File file = new File(path);
		search(file,content);
	}
}

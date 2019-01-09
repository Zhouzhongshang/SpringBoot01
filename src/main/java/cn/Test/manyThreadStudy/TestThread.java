package cn.Test.manyThreadStudy;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero h1 = new Hero();
         Hero gaiLun = new Hero("盖伦",100.0,8);
         Hero timo = new Hero("提莫",100.0,8);
         Hero JH = new Hero("剑豪",100.0,10);
         Hero ms = new Hero("盲僧",100.0,8);
         
         /**
          * 利用线程去执行方法
          */
         KillThread killThread = new KillThread(gaiLun,timo);
         Thread thread1 = new Thread(killThread);
         thread1.start();
         KillThread killThread2 = new KillThread(JH,ms);
         Thread thread2 = new Thread(killThread2);
         thread2.start();
	}
}

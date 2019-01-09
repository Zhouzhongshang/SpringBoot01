package cn.Test.manyThreadStudy;

public class KillThread implements Runnable{
  
	/**
	 * 击杀的任务
	 */
	private Hero h1;
	private Hero h2;
	
	public KillThread(Hero h1, Hero h2) {
		// TODO Auto-generated constructor stub
		this.h1=h1;
		this.h2=h2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(h2.hp>=0){
			h1.att(h2);
		}
	}
      
}

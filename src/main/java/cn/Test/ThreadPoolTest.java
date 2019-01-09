package cn.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class ThreadPoolTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 线程池循环运行16个线程
	 */
	@Test
	public void test(){
		//工作队列
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);
		//线程池
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
	    for(int i=0;i<16;i++){
	    	//拼接
	    	//"cares".concat("s") returns "caress"
	    	// "to".concat("get").concat("her") returns "together"

	    	threadPool.execute(new Thread(new ThreadPoolTest(),"Thread".concat(i+"")));
	    	System.out.println("线程池中活跃的线程数："+threadPool.getPoolSize());
	    	if(queue.size()>0){
	    		System.out.println(queue.size()+":个队列中的线程在deng'dai");
	    	}
	    }
	    threadPool.shutdown();
	}
	
	@Test
	public void test1(){
		/**
		 * 设置饱和策略：多余的线程直接丢弃掉
		 * 1.工作队列 有大小
		 * 2.设置丢弃方式
		 * 3.创建线程池
		 * 4.执行多线程任务
		 */
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);
		ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
		//这个类其实是线程池对象
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, queue, discardPolicy);
		//threadPool.execute(new Thread(new ThreadPoolTest(),"Thread".concat(i+"")));
		for(int i=1;i<=10;i++){
			threadPool.execute(new Thread(new ThreadPoolTest(),"Thread".concat(i+"")));
			System.out.println("线程池中活跃的线程数："+threadPool.getPoolSize());
			if(queue.size()>0){
				System.out.println("队列中阻赛的线程数："+queue.size());
			}
		}
		threadPool.shutdown();
	}
	
}

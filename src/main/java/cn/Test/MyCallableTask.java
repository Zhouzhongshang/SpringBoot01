package cn.Test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class MyCallableTask implements Callable<Integer>{
   //定义一个callbale的任务
	@Override
	public Integer call() throws Exception {
            System.out.println("callable do something");
            Thread.sleep(5000);
		return new Random().nextInt(100);
	}
	
	@Test
	public void test() throws InterruptedException, ExecutionException{
		//callbale任务
		MyCallableTask callable = new MyCallableTask();
		//异步callable的结果
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		Thread thread = new Thread(future);
		thread.start();
		Thread.sleep(100);
		//取消对任务的执行
		//future.cancel(true);
		System.out.println("future is cancel:"+future.isCancelled());
		if(!future.isCancelled()){
			System.out.println("future is cancelled");
		}
		//判断任务是否完成  由于取消导致的任务完成
		System.out.println("future is done:"+future.isDone());
		if(!future.isDone()){
			System.out.println("future get="+future.get());//返回的结果，会等结果执行完成再返回
		}else{
			//任务完成
			System.out.println("task id Done");
		}
	}
     
}

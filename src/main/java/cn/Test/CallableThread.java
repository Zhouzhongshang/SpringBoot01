package cn.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;
/**
 * callable与future
 * @author 007
 *  
 */

public class CallableThread implements Callable<String> {
/**
 * 定义任务
 */
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis()+"：进入call方法，开始休眠，休眠时间");
		Thread.sleep(10000);
		return "今天停电";
	}
	
	@Test
	public void test01() throws InterruptedException, ExecutionException{
		//线程池 执行器
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		//任务
		CallableThread callableThread = new CallableThread();
		//返回的结果
		Future<String> submit = newSingleThreadExecutor.submit(callableThread);
		newSingleThreadExecutor.shutdown();
		//主线程休眠5秒
		Thread.sleep(5000);
		System.out.println("主线程休眠5秒："+System.currentTimeMillis());
		String a = submit.get();
		System.out.println(a);
	}
	
	@Test
	public void test02() throws InterruptedException, ExecutionException{
		        //线程池 执行器
				ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
				//任务
				CallableThread callableThread = new CallableThread();
				//异步结果
				FutureTask<String> futureTask = new FutureTask<String>(callableThread);
				//直接处理返回的结果：等待结果返回再get()
				newSingleThreadExecutor.submit(futureTask);
				newSingleThreadExecutor.shutdown();
				Thread.sleep(5000);
				System.out.println("主线程等待5秒："+System.currentTimeMillis());
				String a = futureTask.get();
				System.out.println(a);
	}
}

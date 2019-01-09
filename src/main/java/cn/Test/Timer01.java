package cn.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * 定时器：Timer()
 * timerTask()接口
 * schedule()方法   延迟多久 隔多少时间执行
 * @author 007
 *
 */
public class Timer01 {
	private static final Logger log=Logger.getLogger(Timer01.class);
	public static void main(String[] args) {
		Timer01 timer01 = new Timer01();
		timer01.testTimer();
	}
	public void testTimer(){
		Timer timer = new Timer();
	    TimerTask	task=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				long currentTimeMillis = System.currentTimeMillis();
				log.info("你好我将在1秒后，每隔2秒执行一次:"+currentTimeMillis);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				String format = sdf.format(date);
				log.info(format);
			}
		};
		timer.schedule(task, 1000, 2000);
	}
   
}

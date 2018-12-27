package cn.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.HelloApplication;
import cn.service.Handler_Excell;

public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloApplication.class);
		Handler_Excell service = context.getBean(Handler_Excell.class);
		List<String> handle = service.handle();
		for (String i : handle) {
			System.out.println(i);
		}
	}
}

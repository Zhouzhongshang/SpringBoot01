package cn.config;

import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

import com.github.pagehelper.PageHelper;

@Configuration
@ComponentScan(value = "cn")
public class Config {
	/**
	 *Spring容器管理的对象，用的时候就初始化。
	 */
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		/**
		 * 
		 */
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
	
	/**
	 * 自定义消息转化器  springBoot将其管理起来 
	 * 一般有默认的
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter(){
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
		return stringHttpMessageConverter ;
	}
	
	/**
	 * 也可以自定义一个拦截器，来扩展功能的 ，用的到的时候再说
	 */
}

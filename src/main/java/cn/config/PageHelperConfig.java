package cn.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfig {
    /**
     * 这个类来作为配置类 相当于一个xml文件
     * 把这个对象让spring管理起来
     */
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties p= new Properties();
		/**
		 * 
		 */
		 p.setProperty("offsetAsPageNum", "true");
	     p.setProperty("rowBoundsWithCount", "true");
	     p.setProperty("reasonable", "true");
	     pageHelper.setProperties(p);
		return pageHelper;
	}
}

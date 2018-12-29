package cn.Test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import cn.config.Config;
import cn.dao.CategoryMapper;
import cn.pojo.Category;
import cn.service.Handler_Excell;

/**
 * 单元测试需要这几个注解：
 * @RunWith(SpringRunner.class)
 * @SpringBootTest
 * @Test
 * @author 007
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAll {
	private static final Logger log=Logger.getLogger(TestAll.class);
	@Autowired
    private CategoryMapper mapper;
	@Test
	public void find(){
		//测试mapper 数据
		List<Category> findAll = mapper.findAll();
		log.info("mapper:*********:"+mapper);
		for (Category category : findAll) {
			System.out.println(category.getName());
		}
	}
	
	/*@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Handler_Excell service = context.getBean(Handler_Excell.class);
		System.out.println("mapper:"+service);
	}*/
}

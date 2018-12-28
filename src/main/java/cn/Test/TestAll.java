package cn.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.dao.CategoryMapper;
import cn.pojo.Category;

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
	@Autowired
    private CategoryMapper mapper;
	@Test
	public void find(){
		//测试mapper 数据
		List<Category> findAll = mapper.findAll();
		for (Category category : findAll) {
			System.out.println(category.getName());
		}
	}
}

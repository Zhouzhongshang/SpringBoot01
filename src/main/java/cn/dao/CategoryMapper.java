package cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.pojo.Category;

@Mapper
public interface CategoryMapper {

	/**
	 * 查询所有记录：分页查询
	 * @return
	 */
	@Select("select * from Category_")
	List<Category> findAll();

	/**
	 * 增删改查操作 #sql注入问题有效的防止
	 * insert into biao (name) values (#{name})
	 * select * from biao where id=#{id}
	 * delete from biao where id=#{id}
	 * update biao set name = #{name} where id=#{id} 
	 */
	@Insert("insert into category_ (name) values (#{name})")
	public int save(Category ca);

	@Delete("delete from category_ where id=#{id} ")
	public void delete(int id);

	@Select("select * from category_ where id= #{id} ")
	public Category get(int id);

	@Update("update category_ set name=#{name} where id=#{id} ")
	public int update(Category category);
}

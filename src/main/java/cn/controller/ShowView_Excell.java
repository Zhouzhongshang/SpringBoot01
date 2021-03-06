package cn.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.dao.CategoryMapper;
import cn.pojo.Category;
import cn.service.Handler_Excell;

@Controller
public class ShowView_Excell {
   
	@Autowired
	private Handler_Excell service;
	@Autowired
	private CategoryMapper mapper;
    
	/**
	 * 展示jsp页面的例子
	 * @param m
	 * @return
	 */
     @RequestMapping("/hello")
     public String hello(Model m) {
    	 //jsp:取值是${now}
         m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
         return "index";
     }
     
     /**
      * 查询数据库的例子
      * @param model
      * @return
      */
     @GetMapping("/categories")
     public String listCategory(Model model 
    		 ,@RequestParam(value="Size" , defaultValue = "2") int Size
    		 , @RequestParam(value="start" , defaultValue = "0")int Start){
    	 PageHelper.startPage(Start, Size, "id desc");
    	 List<Category> findAll = mapper.findAll();
    	 //有参构造 ：页面对象
    	 PageInfo<Category> pageInfo = new PageInfo<>(findAll);
    	 
        /* for (Category category : findAll) {
			System.out.println(category.getName().toString());
		}*/
    	 model.addAttribute("page",pageInfo);
    	 return "index";
     }
     
     /**
      * 增删改查的例子
      * @param c
      * @return
      */
     //添加
     @PostMapping("/categories")
     public String add(Category c){
    	 mapper.save(c);
    	 return "redirect:/categories";
     }
     //删除
     @DeleteMapping("/categories/{id}")
     public String delete(Category c){
    	 mapper.delete(c.getId());
    	 return "redirect:/categories";
     }
     
     //更新
     @PutMapping("/categories/{id}")
     public String dpdate(Category c){
    	 mapper.update(c);
    	return "redirect:/categories";
     }
     //单个查询
     @GetMapping("/categories/{id}")
     public String get(@PathVariable("id") int id, Model model){
    	 Category c = mapper.get(id);
    	 model.addAttribute("c",c);
    	 return "edit";
     }
     
}

package cn.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	private static final Logger log=Logger.getLogger(UploadController.class);
	/**
	 * 展示上传文件的页面
	 * @return
	 */
	@RequestMapping("/uploadPage")
	public String uploadController(){
		return "uploadPage";
	}
	/**
	 * 上传文件功能
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(Model m,HttpServletRequest req, 
			@RequestParam("file")
			MultipartFile file){
		//获取源文件名加时间搓
		String fileName=System.currentTimeMillis()+file.getOriginalFilename();
		// 通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
		String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;
		
		log.info(req.getServletContext().getRealPath(""));
		log.info("File.separator:"+File.separator);// "/"
		
		File destFile = new File(destFileName);
		destFile.getParentFile().mkdirs();
		try {
			file.transferTo(destFile);
			m.addAttribute("fileName", fileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "上传失败"+e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "上传失败"+e.getMessage();
		}
		return  "showImg";
	}
	
	
}

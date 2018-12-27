package cn.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dao.GetSource_Excell;

@Service
public class Handler_Excell {
	
    /**
     * 1.拿到文件流
     * 2.对文件流解析成字符串
     */
	@Autowired
	private GetSource_Excell dao;
	public List handle(){
		InputStream in = dao.getUrl();
		 Workbook xlsx = null; //Excell对象
		try {
			xlsx = new  XSSFWorkbook(new BufferedInputStream(in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = xlsx.getSheetAt(0); //读取sheet0
		int firstRowNum = sheet.getFirstRowNum();//第一行
		int lastRowNum = sheet.getLastRowNum();//最后一行
		String result=null;
		List<String> list=new ArrayList();
		for (int i = firstRowNum; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);//一行一行的数据
			if(row!=null){
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				for (int j = firstCellNum; j <= lastCellNum; j++) {
					Cell cell = row.getCell(j);//一列一列的对像
					if(cell != null){
						 result = cell.toString();//数据是拿到了
						 list.add(result);
					}
				}
			}
		}
		return list;//最后一个cell的数据
	}
}

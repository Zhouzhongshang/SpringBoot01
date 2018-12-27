package cn.dao;

import java.io.InputStream;

import org.springframework.stereotype.Repository;
@Repository
public class GetSource_Excell {
     public InputStream getUrl(){
    	 String url="001.xlsx";
    	 InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
    	 return in;
     }
}

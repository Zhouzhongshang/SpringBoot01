package cn.Test.Socket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.Test.Socket.pojo.dictionary;

public class DictionaryDao {
       public DictionaryDao(){
    	   //构造方法 获取驱动
    	   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
       }
       
       
       public Connection getConnection() throws SQLException{
    	   return DriverManager.getConnection(
    			   "jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8", 
    			   "root", "root");
       }
       
       public List<dictionary> query(String receive){
    	   List<dictionary> arrayList = new ArrayList();
    	   String sql ="select * from dictionary where receive = ?" ;
    	   try {
    		   /**
    		    * 获取连接
    		    * 拿到传输器
    		    * 执行sql
    		    * 遍历结果集
    		    */
			Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, receive);//设置第一个参数代码的变量
			ResultSet executeQuery = ps.executeQuery();
			while(executeQuery.next()){
				dictionary dictionary = new dictionary();
				//可以通过索引或者列明来查询的
				int int1 = executeQuery.getInt(1); //等价于getInt("id") 列明
				String rece = executeQuery.getString("receive");  //
				String response = executeQuery.getString("response");
				dictionary.setId(int1);
				dictionary.setReceive(rece);
				dictionary.setResponse(response);
				arrayList.add(dictionary);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
       }
}

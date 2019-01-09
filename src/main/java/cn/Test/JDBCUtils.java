package cn.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class JDBCUtils {

	//只有一个这个对象但是可以改变值
    private static	JDBCPool pool=new JDBCPool();
    
    public static Connection getConnection() throws SQLException{
    	
		return pool.getConnection();
    }
    
    
    public static void release(Connection conn,Statement st,ResultSet rs){
    	/**
    	 * 关闭执行sql的
    	 */
    	if(st!=null){
    		try {
    			st.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    		st =null;
    	}
    	/**
    	 * 结果集
    	 */
    	if(rs!=null){
    		try {
    			rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    		rs =null;
    	}
    	/**
    	 * 关闭连接
    	 */
    	if(conn!=null){
    		try {
    			conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	}
    }
    
    @Test
    public void test(){
    	/**
    	 * 查询数据库
    	 */
    	Connection conn=null;
    	PreparedStatement st=null;
    	ResultSet rs=null;
    	try {
    		/**
    		 * 1.获取连接
    		 * 2.拿到传输器
    		 * 3.执行sql
    		 * 4.遍历结果集
    		 */
    		conn = JDBCUtils.getConnection();
    		String sql="select * from category_";
    		st = conn.prepareStatement(sql);
    		rs= st.executeQuery();
    		if(rs.next()){
    			System.out.println(rs.getInt(1));
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, st, rs);
		}
    }
}

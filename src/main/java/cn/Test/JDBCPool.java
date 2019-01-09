package cn.Test;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.junit.Test;

/**
 * 编写数据库连接池：实现dataSource接口
 * 
 * @author 007
 *
 */
public class JDBCPool implements DataSource {

	/**
	 * listConnetions存放数据库连接
	 */
	private static LinkedList<Connection> listConnections = new LinkedList<>();
	/**
	 * 在静态代码块中加载属性文件： 静态代码块：加载类时候就会执行
	 */
	static {
		InputStream in = JDBCPool.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			// 数据库连接池的初始化连接数大小:初始化的大小
			int jdbcPoolInitSize = Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));
			/**
			 * 1.加载驱动
			 * 2.获取初始化的连接数量
			 * 3.加载到连接池LinkedList中
			 */
			Class.forName(driver);
			for (int i = 0; i < jdbcPoolInitSize; i++) {
				Connection connection = DriverManager.getConnection(url, username, password);//这里是接口？
				System.out.println("获取到连接："+connection);
				listConnections.add(connection);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 获取数据库连接：通过动态代理的机制来实现得到conn对象。
	 * 原本Connection是接口
	 * @see javax.sql.DataSource#getConnection()
	 */
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * 1.如果连接池的对象连接大于0，则从中取出一个连接：并化成为对象
		 */
		if(listConnections.size()>0){
		final	Connection conn = listConnections.removeFirst();
		System.out.println(listConnections.size());
		/**
		 * 返回conn的动态代理对象
		 *       类加载器
		 *       conn接口名
		 *       InvocationHandler接口
		 */
		return (Connection) Proxy.newProxyInstance(JDBCPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
			
			/**
			 * 自动执行这个invoke（）方法
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				if(!method.getName().equals("close")){
					return method.invoke(conn, args);
				}else{
					//如果是close（）方法
					listConnections.addFirst(conn);
					System.out.println(conn+"已经还回来了");
					System.out.println("连接池的大小为"+listConnections.size());
				}
				return null;
			}
		});
		}else {
			throw new RuntimeException("数据库忙");
		}
		
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Test
	public void test(){
		*//**
		 * 对编写的池进行测试
		 *//*
		JDBCPool pool=new JDBCPool();
		
		public Connection getConnection(){
			
		}
	}*/

}

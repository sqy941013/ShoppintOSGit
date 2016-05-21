package shopping.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @see [数据库连接管理类]
 * @class ConnectionManager.java
 * @package shopping.dbhelper
 * @project shopping
 *
 * @author jackflynn
 * @time 上午10:10:10
 * @description [打开或关闭数据库连接]
 */
public class ConnectionManager {
	//注册驱动
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("警告，数据库驱动包没有导入到项目中或者没有发布到WEB-INF/lib目录下，请检查。");
		}
	}
	/**
	 * 打开数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3307/shopping","root","Sqy1994779");
	}
	/**
	 * 关闭数据库连接，释放资源
	 * @param conn
	 */
	public static void free(Connection conn){
		//关闭数据库连接时，判断数据库连接是否已经关闭
		try {
			if (conn !=null && !conn.isClosed()){
				//如果没有关闭 关闭该数据库连接
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public  static void main(String[] args) throws SQLException{
		//测试数据哭连接
		Connection conn =  ConnectionManager.getConnection();
		ConnectionManager.free(conn);
	}*/
}

package shopping.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shopping.mapper.*;

import com.mysql.jdbc.Statement;

/**
 * 
 * @see [SQL语句执行类]
 * @class DBHelper.java
 * @package shopping.dbhelper
 * @project shopping
 *
 * @author jackflynn
 * @time 上午10:48:45
 * @description [执行不同类型的对象的增删改操作]
 * @param <T>
 */
public class DBHelper<T> {
	
	private PreparedStatement pstat;
	private ResultSet rs;
	private T t;
	private List<T> tlist;
	/**
	 * 
	 * @param conn 数据库连接
	 * @param sql 要执行的sql语句
	 * @param objects 执行sql语句中的参数
	 * @return 返回执行的记录数
	 */
	//删、改操作
	public int excuteSQL(Connection conn,String sql, Object ...objects) throws SQLException{
		//获取预编译对象
		pstat = conn.prepareStatement(sql);
		//设置参数
		setParameter(objects);
		//执行
		int rows = pstat.executeUpdate();
		//返回结果
		return rows;
	}
	//增加返回新生成的主键
	/**
	 * 增加一条记录并且返回新生成的主键
	 * @param conn 数据库连接
	 * @param sql	sql语句
	 * @param objects 参数
	 * @return 返回新生成的主键
	 * @throws SQLException
	 */
	public int excuteInsert(Connection conn,String sql,Object ...objects) throws SQLException{
		//获取能返回主键的预编译对象
		pstat=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		//设置参数
		setParameter(objects);
		//执行
		pstat.execute();
		//获取主键
		rs=pstat.getGeneratedKeys();
		//返回主键
		while(rs.next()){
			return rs.getInt(1);
		}
		
		return -1;
	}
	
	//查询操作
	public List<T> executeQuery(Connection conn,String sql,IRowMapper<T> mapper,Object ...objects) throws SQLException{
		//获取预编译对象
		pstat=conn.prepareStatement(sql);
		
		//设置参数 
		setParameter(objects);
		
		//执行查询，返回结果集
		rs=pstat.executeQuery();
		
		//将结果集中的数据还原成java对象
		tlist=new ArrayList<T>();
		while(rs.next()){
			T t=mapper.mapper(conn,rs);
			tlist.add(t);
		}
		
		//返回查询到的java对象的集合
		return tlist;
	}
	
	/*
	 * 给preparedStatement设置参数
	 */
	private void setParameter(Object ...objects) throws SQLException{
		if(objects !=null && objects.length >0){
			for(int i=0;i<objects.length;i++){
				pstat.setObject(i+1, objects[i]);
			}
		}
	}
	
	//测试
	/*public static void main(String[] args) throws SQLException{
		//String sql = "insert into test(username,password) values(?,?)";
		String sql = "delete from test where testid=?";
		DBHelper dh = new DBHelper();
		Connection conn=ConnectionManager.getConnection();
		//int id = dh.excuteInsert(conn, sql, "admin","admin");
		//System.out.println("------>"+id);
		dh.excuteSQL(conn, sql, 1);
		ConnectionManager.free(conn);
		
	}*/
}

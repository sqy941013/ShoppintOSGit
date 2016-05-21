package shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.utils.DeleteType;
import shopping.utils.FindType;

/**
 * 
 * @see [数据访问对象超级接口]
 * @class IDAO.java
 * @package shopping.dao
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:25:40
 * @description [用来规范所有的DAO中应该出现哪些方法，增、删、改、查]
 * @param <T>
 */
public interface IDAO<T> {
	/**
	 * 增加一条记录
	 * @param conn 数据库连接
	 * @param t 要增加的对象
	 * @return 返回增加的新生成的主键
	 * @throws SQLException
	 */
	int add (Connection conn,T t) throws SQLException;
	/**
	 * 根据编号删除数据
	 * @param conn 数据库连接 
	 * @param id 要删除的数据的编号
	 * @return 返回删除的记录数
	 * @throws SQLException
	 */
	int delete(Connection conn,int id) throws SQLException;
	/**
	 * 修改对象
	 * @param conn 数据库连接
	 * @param t 要修改的对象
	 * @return 返回修改的记录数
	 * @throws SQLException
	 */
	int update(Connection conn,T t) throws SQLException;
	/**
	 * 根据Id编号查询对象
	 * @param conn 数据库连接
	 * @param id 要查询的对象的编号
	 * @return 返回查询到的对象
	 * @throws SQLException
	 */
	T findById(Connection conn,int id) throws SQLException;
	/**
	 * 查询全部数据
	 * @param conn 数据库连接
	 * @return 查询到的Java对象的集合
	 * @throws SQLException
	 */
	List<T> findAll(Connection conn) throws SQLException;
	/**
	 * 根据条件查询数据
	 * @param conn 数据库连接
	 * @param type 查询类型
	 * @param objects 查询时的参数
	 * @return 返回结果，java对象的集合
	 * @throws SQLException
	 */
	List<T> findByCondition(Connection conn,FindType type,Object ...objects) throws SQLException;
	/**
	 * 根据条件删除数据
	 * @param conn 数据库连接
	 * @param type 删除类型
	 * @param objects 删除时的参数
	 * @return 返回删除的记录数
	 * @throws SQLException
	 */
	int deleteByCondition(Connection conn,DeleteType type,Object ...objects) throws SQLException;
}

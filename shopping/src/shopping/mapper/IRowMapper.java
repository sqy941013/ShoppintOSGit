package shopping.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @see [数据库记录还原成java对象的类]
 * @class RowMapper.java
 * @package shopping.mapper
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:07:07
 * @description [将数据库中的数据记录，映射还原成java对象]
 * @param <T>
 */
public interface IRowMapper<T> {
	/**
	 * 将数据库中的查询到的结果集还原成java对象
	 * @param rs查询到的数据库结果集 conn数据库连接
	 * @return
	 * @throws SQLException
	 */
	T mapper(Connection conn,ResultSet rs) throws SQLException;
}

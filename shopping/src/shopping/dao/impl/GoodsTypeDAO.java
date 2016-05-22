package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.dbhelper.DBHelper;
import shopping.mapper.impl.GoodsTypeMapper;
import shopping.model.GoodsType;
import shopping.utils.DeleteType;
import shopping.utils.FindType;

/**
 * 
 * @see [商品类型的数据访问对象]
 * @class GoodsTypeDAO.java
 * @package shopping.dao.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 下午7:39:34
 * @description [主要生成商品类型访问对象的增删改查语句]
 */
public class GoodsTypeDAO implements IDAO<GoodsType>{
	private String sql;
	private DBHelper<GoodsType> dh=new DBHelper<GoodsType>();
	@Override
	public int add(Connection conn, GoodsType t) throws SQLException {
		// TODO Auto-generated method stub
		sql="insert into GOODSTYPE(GOODSTYPEID,GOODSTYPE)"+
				"values(?,?)";
						dh.excuteInsert(conn, sql,t.getGoodsTypeId(),t.getGoodsType());
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from GOODSTYPE where GOODSTYPEID=?";
		dh.excuteSQL(conn, sql, id);
		
		return 0;
	}

	@Override
	public int update(Connection conn, GoodsType t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update GOODSTYPE set GOODSTYPE=? where GOODSTYPEID="+t.getGoodsTypeId();
				dh.excuteSQL(conn, sql,t.getGoodsType());
				
		return 0;
	}

	@Override
	public GoodsType findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from GOODSTYPE where GOODSTYPEID="+id;
		GoodsType goodsType= (GoodsType) dh.executeQuery(conn, sql, new GoodsTypeMapper());
		
		return goodsType;
	}

	@Override
	public List<GoodsType> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from GOODSTYPE";
		
		return dh.executeQuery(conn, sql, new GoodsTypeMapper());
	}

	@Override
	public List<GoodsType> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

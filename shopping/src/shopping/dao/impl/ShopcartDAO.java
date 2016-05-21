package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.dbhelper.DBHelper;
import shopping.mapper.impl.ShopcartMapper;
import shopping.model.Shopcart;
import shopping.utils.DeleteType;
import shopping.utils.FindType;

public class ShopcartDAO implements IDAO<Shopcart>{
	private String sql;
	private DBHelper<Shopcart> dh=new DBHelper<Shopcart>();
	@Override
	public int add(Connection conn, Shopcart t) throws SQLException {
		// TODO Auto-generated method stub
		sql="insert into SHOPCART(SHOPCARTID,GOODSID,BUYCOUNT,"+
				"SUBTOTAL) values(?,?,?,?)";
		dh.excuteInsert(conn, sql, t.getShopcartId(),t.getGoods().getGoodId(),
				t.getBuyCount(),t.getSubTotal());
				
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from SHOPCART where SHOPCARTID =?";
		dh.excuteSQL(conn, sql, id);
		
		return 0;
	}

	@Override
	public int update(Connection conn, Shopcart t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update SHOPCART set GOODSID=?, BUYCOUNT=?, SUBTOTAL=? "+
				"where SHOPCARTID="+t.getShopcartId();
		dh.excuteSQL(conn, sql, t.getGoods().getGoodId(),t.getBuyCount(),
				t.getSubTotal());
		
		return 0;
	}

	@Override
	public Shopcart findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from SHOPCART where SHOPCARTID=?";
		
		return (Shopcart) dh.executeQuery(conn, sql, new ShopcartMapper(), id);
	}

	@Override
	public List<Shopcart> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from SHOPCART";
		
		return dh.executeQuery(conn, sql, new ShopcartMapper());
	}

	@Override
	public List<Shopcart> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.dbhelper.DBHelper;
import shopping.mapper.impl.GoodsMapper;
import shopping.mapper.impl.MemberMapper;
import shopping.model.Goods;
import shopping.utils.DeleteType;
import shopping.utils.FindType;

/**
 * 
 * @see [商品的数据访问对象]
 * @class GoodsDAO.java
 * @package shopping.dao.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:46:54
 * @description [主要生成商品访问对象的增删改查语句]
 */
public class GoodsDAO implements IDAO<Goods>{
	private String sql;
	private DBHelper<Goods> dh= new DBHelper<Goods>();
	@Override
	public int add(Connection conn, Goods t) throws SQLException {
		// TODO Auto-generated method stub
		sql="insert into GOODS(GOODSID,GOODSNAME,SUBPRICE,STOCKCOUNT,ISVALIBLE,GOODSDESC,GOODSTYPEID)"+
		"values(?,?,?,?,?,?,?)";
				dh.excuteInsert(conn, sql,t.getGoodId(),t.getGoodName(),
						t.getSubPrice(),t.getStockCount(),t.getIsValible(),t.getGoodsTypeId());		
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from GOODS where GOODSID=?";
		dh.excuteSQL(conn, sql, id);
		return 0;
	}

	@Override
	public int update(Connection conn, Goods t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update GOODS set GOODSNAME=?, SUBPRICE=?,"+
				"STOCKCOUNT=?, ISVALIBLE=?, GOODSDESC=?, GOODSTYPEID=? where GOODSID="+t.getGoodId();
				dh.excuteSQL(conn, sql,t.getGoodName(),t.getSubPrice(),
						t.getStockCount(),t.getIsValible(),t.getGoodDesc(),t.getGoodsTypeId());
				
		return 0;
	}

	@Override
	public Goods findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from GOODS where GOODSID="+id;
		Goods goods= (Goods) dh.executeQuery(conn, sql, new GoodsMapper());
		return goods;
	}

	@Override
	public List<Goods> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from GOODS";
		
		return dh.executeQuery(conn, sql, new GoodsMapper());
	}

	@Override
	public List<Goods> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		if(type==FindType.GOODSTYPE){
			return this.findByGoodsTypeId(conn,FindType.GOODSTYPE,objects);
		}
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private List<Goods> findByGoodsTypeId(Connection conn, FindType type, Object... objects) throws SQLException{
		sql="select * from GOODS where GOODSTYPEID=?";
		return dh.executeQuery(conn, sql, new GoodsMapper(), objects);
	}

}

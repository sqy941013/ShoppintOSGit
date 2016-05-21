package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.dao.impl.GoodsDAO;
import shopping.mapper.IRowMapper;
import shopping.model.Shopcart;

public class ShopcartMapper implements IRowMapper<Shopcart>{
	private GoodsDAO goodsDAO=new GoodsDAO();
	@Override
	public Shopcart mapper(Connection conn, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Shopcart shopcart = new Shopcart();
		shopcart.setBuyCount(rs.getInt("SHOPCARTID"));
		shopcart.setGoods(goodsDAO.findById(conn, rs.getInt("GOODSID")));;
		shopcart.setShopcartId(rs.getInt("SHOPCARTID"));
		shopcart.setSubTotal(rs.getDouble("SUBTOTAL"));
		
		return null;
	}

}

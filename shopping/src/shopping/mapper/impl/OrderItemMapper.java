package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.dao.impl.GoodsDAO;
import shopping.mapper.IRowMapper;
import shopping.model.OrderItem;

public class OrderItemMapper implements IRowMapper<OrderItem>{
	private GoodsDAO goods=new GoodsDAO();
	@Override
	public OrderItem mapper(Connection conn, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		OrderItem orderItem=new OrderItem();
		
		orderItem.setGoods(goods.findById(conn, rs.getInt("GOODSID")));
		orderItem.setBuyCount(rs.getInt("BUYCOUNT"));
		orderItem.setDealPrice(rs.getDouble("DEALPRICE"));
		orderItem.setOrderitemId(rs.getInt("ORDERITEMID"));
		orderItem.setSubTotal(rs.getDouble("SUBTOTAL"));
		
		return orderItem;
	}

}

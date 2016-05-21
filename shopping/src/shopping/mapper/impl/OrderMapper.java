package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.dao.impl.OrderItemDAO;
import shopping.mapper.IRowMapper;
import shopping.model.Order;
import shopping.utils.FindType;

public class OrderMapper implements IRowMapper<Order>{
	private OrderItemDAO orderItemDAO = new OrderItemDAO();
	@Override
	public Order mapper(Connection conn, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Order order=new Order();
		
		order.setOrderId(rs.getInt("ORDERID"));
		order.setOrderTime(rs.getTime("ORDERITEM"));
		order.setTotalPrice(rs.getDouble("TOTALPRICE"));
		order.setOrderItemList(orderItemDAO.findByCondition(conn, FindType.ITEM_ORDERID, rs.getInt("ORDERID")));
		
		return null;
	}

}

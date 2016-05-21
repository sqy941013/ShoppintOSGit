package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.dbhelper.DBHelper;
import shopping.mapper.impl.OrderMapper;
import shopping.model.Order;
import shopping.utils.DeleteType;
import shopping.utils.FindType;

public class OrderDAO implements IDAO<Order>{
	private String sql;
	private DBHelper<Order> dh=new DBHelper<Order>();
	@Override
	public int add(Connection conn, Order t) throws SQLException {
		// TODO Auto-generated method stub
		sql="insert into ORDER(ORDERID,ORDERTIME,TOTALPRICE) values(?,?,?)";
				dh.excuteInsert(conn, sql, t.getOrderId(),t.getOrderTime(),
						t.getTotalPrice());	
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from ORDER where ORDERID=?";
		dh.excuteSQL(conn, sql, id);
		
		return 0;
	}

	@Override
	public int update(Connection conn, Order t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update ORDER set ORDERTIME=?, TOTALPRICE=?"+
				" where ORDERID="+t.getOrderId();
				dh.excuteSQL(conn, sql,t.getOrderTime(),t.getTotalPrice());
				
		return 0;
	}

	@Override
	public Order findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from ORDER where ORDERID="+id;
		Order order= (Order) dh.executeQuery(conn, sql, new OrderMapper());
		
		return order;
	}

	@Override
	public List<Order> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from ORDER";
		
		return dh.executeQuery(conn, sql, new OrderMapper());
	}

	@Override
	public List<Order> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

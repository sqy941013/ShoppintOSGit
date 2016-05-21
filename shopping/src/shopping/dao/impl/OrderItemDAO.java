package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.dbhelper.DBHelper;
import shopping.mapper.impl.OrderItemMapper;
import shopping.model.OrderItem;
import shopping.utils.DeleteType;
import shopping.utils.FindType;

public class OrderItemDAO implements IDAO<OrderItem>{
	private String sql;
	private DBHelper<OrderItem> dh=new DBHelper<OrderItem>();
	@Override
	public int add(Connection conn, OrderItem t) throws SQLException {
		// TODO Auto-generated method stub
		sql="insert into ORDERITEM(ORDERITEMID,GOODSID,BUYCOUNT,"+
				"SUBTOTAL,DEALPRICE) values(?,?,?,?,?)";
		dh.excuteInsert(conn, sql, t.getOrderitemId(),t.getGoods().getGoodId(),
				t.getBuyCount(),t.getSubTotal(),t.getDealPrice());
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from ORDERITEM where ORDERITEMID=?";
		dh.excuteSQL(conn, sql, id);
		return 0;
	}

	@Override
	public int update(Connection conn, OrderItem t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update ORDERITEM set GOODSID=?, BUYCOUNT=?, SUBTOTAL=?,"+
				"DEALPRICE=? where ORDERITEMID="+t.getOrderitemId();
		dh.excuteSQL(conn, sql, t.getGoods().getGoodId(),t.getBuyCount(),
				t.getSubTotal(),t.getDealPrice());
		
		return 0;
	}

	@Override
	public OrderItem findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from ORDERITEM where ORDERITEMID="+id;
		OrderItem orderItem= (OrderItem) dh.executeQuery(conn, sql, new OrderItemMapper());
		
		return orderItem;
	}

	@Override
	public List<OrderItem> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from ORDERITEM";
		dh.executeQuery(conn, sql, new OrderItemMapper());
		return null;
	}

	@Override
	public List<OrderItem> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		if(type==FindType.ITEM_ORDERID)
			return findByOrderId(conn, type, objects);
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private List<OrderItem> findByOrderId(Connection conn,FindType type,Object ...objects) throws SQLException{
		sql="select * from ORDIERITEM where ORDERITEMID in("+
	"select * from ORDERVSITEM where ORDERID=?)";
		
		return dh.executeQuery(conn, sql, new OrderItemMapper(), objects);
	}

}

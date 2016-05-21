package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.model.Address;
import shopping.utils.DeleteType;
import shopping.utils.FindType;
import shopping.dbhelper.*;
import shopping.mapper.impl.AddressMapper;
/**
 * 
 * @see []
 * @class AddressDAO.java
 * @package shopping.dao.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:27:20
 * @description []
 */
public class AddressDAO implements IDAO<Address>{
	private String sql;
	private DBHelper<Address> dh= new DBHelper<Address>();
	@Override
	public int add(Connection conn, Address t) throws SQLException {
		// TODO Auto-generated method stub
		sql="insert into Address(ADDRESSID,CONSIGNEE,CONSIGNEEPHONE,"+
		"PROVINCE,CITY,COUNTRY,DESC) values(?,?,?,?,?,?,?)";
		dh.excuteInsert(conn, sql, t.getAddressId(),t.getConsignee(),
				t.getConsigneePhone(),t.getProvince(),t.getCity(),
				t.getCity(),t.getCountry(),t.getDesc());		
		
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from ADDRESS where ADDRESSID=?";
		dh.excuteSQL(conn, sql, id);
		
		return 0;
	}

	@Override
	public int update(Connection conn, Address t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update ADDRESS set CONSIGNEE=?, CONSIGNEEPHONE=?, PROVINCE=?,"+
		"CITY=?, COUNTRY=?, DESC=? where ADDRESSID="+t.getAddressId();
		dh.excuteSQL(conn, sql, t.getConsignee(),t.getConsigneePhone(),t.getProvince(),
				t.getCity(),t.getCountry(),t.getDesc());
		
		return 0;
	}

	@Override
	public Address findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from ADDRESS where ADDRESSID="+id;
		Address address= (Address) dh.executeQuery(conn, sql, new AddressMapper());
		//??????WTF?????
		return address;
	}

	@Override
	public List<Address> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from ADDRESS";
		
		return dh.executeQuery(conn, sql, new AddressMapper());
	}
	
	@Override
	public List<Address> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		if(type == FindType.ADDRESS_MEMBERID){
			return this.findByMemberId(conn,type,objects);
		}
		
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		if(type==DeleteType.ADDRESS_MEMBERID){
			return this.deleteByMemberId(conn, type, objects);
		}
		return 0;
	}

	private int deleteByMemberId(Connection conn,DeleteType type,Object ...objects) throws SQLException{
		sql="delete from ADDRESS where ADDRESSID in("+
	"select ADDRESSID from MEMBERVSADDRESS where MEMBERID=?)";
		
		return dh.excuteSQL(conn, sql, objects);
	}
	private List<Address> findByMemberId(Connection conn,FindType type,Object ...objects) throws SQLException{
		sql = "select * from ADDRESS where ADDRESSID in ("+
	"select ADDRESSID from MEMBERVSADDRESS where MEMBERID = ?)";
		
		return dh.executeQuery(conn, sql, new AddressMapper(), objects);
	}
}

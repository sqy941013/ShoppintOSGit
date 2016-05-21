package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.mapper.IRowMapper;
import shopping.model.Address;

/**
 * 
 * @see []
 * @class AddressMapper.java
 * @package shopping.mapper.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:51:54
 * @description []
 */
public class AddressMapper implements IRowMapper<Address>{

	@Override
	public Address mapper(Connection conn,ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Address address=new Address();
		
		address.setAddressId(rs.getInt("ADDRESSID"));
		address.setConsignee(rs.getString("CONSIGNEE"));
		address.setConsigneePhone(rs.getString("CONSIGNEEPHONE"));
		address.setProvince(rs.getString("PROVINCE"));
		address.setCity(rs.getString("CITY"));
		address.setCountry(rs.getString("COUNTRY"));
		address.setDesc(rs.getString("DESC")); //DESC在db中是text类型？
		
		return address;
	}

}

package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.dao.impl.AddressDAO;
import shopping.mapper.IRowMapper;
import shopping.model.Member;
import shopping.utils.FindType;

/**
 * 
 * @see []
 * @class MemberMapper.java
 * @package shopping.mapper.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:57:19
 * @description []
 */
public class MemberMapper implements IRowMapper<Member>{
	//在MemberMapper中创建了AddressDAO对象
	private AddressDAO addressDAO = new AddressDAO();
	@Override
	public Member mapper(Connection conn,ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setMemberId(rs.getInt("MEMBERID"));
		member.setUsername(rs.getString("USERNAME"));
		member.setPassword(rs.getString("PASSWORD"));
		member.setRealName(rs.getString("REALNAME"));
		member.setPhone(rs.getString("PHONE"));
		member.setHeaderimg(rs.getString("HEADERIMG"));
		member.setRegNo(rs.getString("REGNO"));
		member.setGender(rs.getString("GENDER"));
		member.setAge(rs.getInt("AGE"));
		member.setRegistTime(rs.getTimestamp("REGISTTIME"));
		
		member.setAddressList(addressDAO.findByCondition(conn, FindType.ADDRESS_MEMBERID, rs.getInt("MEMBERID")));
		return member;
	}

}

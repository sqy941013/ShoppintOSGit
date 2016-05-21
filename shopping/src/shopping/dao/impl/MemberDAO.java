package shopping.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.IDAO;
import shopping.dbhelper.DBHelper;
import shopping.mapper.impl.MemberMapper;
import shopping.model.Member;
import shopping.utils.DeleteType;
import shopping.utils.FindType;

public class MemberDAO implements IDAO<Member>{
	private String sql;
	private DBHelper<Member> dh=new DBHelper<Member>();
	@Override
	public int add(Connection conn, Member t) throws SQLException {
		sql = "insert into MEMBER(USERNAME, PASSWORD, REALNAME,HEADERIMG) values(?,?,?,?)";
				
		return dh.excuteInsert(conn, sql, t.getUsername(),t.getPassword(),t.getRealName(),"headerImg/25.png");
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql="delete from MEMBER where MEMBERID=?";
		dh.excuteSQL(conn, sql, id);
		
		return 0;
	}

	@Override
	public int update(Connection conn, Member t) throws SQLException {
		// TODO Auto-generated method stub
		sql="update MEMBER set USERNAME=?, PASSWORD=?,"+
				"REALNAME=?, PHONE=?, HEADERIMG=?, REGNO=?, GENDER=?,"+
				"AGE=?, REGISTTIME=? where MEMBERID="+t.getMemberId();
		dh.excuteSQL(conn, sql, t.getUsername(),
				t.getPassword(),t.getRealName(),t.getPhone(),
				t.getHeaderimg(),t.getRegNo(),t.getGender(),
				t.getAge(),t.getRegistTime());
				
		return 0;
	}

	@Override
	public Member findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		sql ="select * from MEMBER where MEMBERID=?";
		Member member= (Member) dh.executeQuery(conn, sql, new MemberMapper());
		
		return member;
	}

	@Override
	public List<Member> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from MEMBER";
		
		return dh.executeQuery(conn, sql, new MemberMapper());
	}

	@Override
	public List<Member> findByCondition(Connection conn, FindType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		if(type==FindType.MEMBER_USERNAME_PASSWORD)
			return this.findByUsernameAndPassword(conn, type, objects);
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 根据账号+密码查询用户数据
	 * @param conn
	 * @param type
	 * @param objects
	 * @return
	 * @throws SQLException
	 */
	private List<Member> findByUsernameAndPassword(Connection conn, FindType type, Object... objects) throws SQLException{
		sql="select * from MEMBER where USERNAME=? and PASSWORD =?";
		return dh.executeQuery(conn, sql, new MemberMapper(), objects);
	}

}

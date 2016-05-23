package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.impl.MemberDAO;
import shopping.dbhelper.ConnectionManager;
import shopping.model.Member;
import shopping.utils.FindType;



/**
 * 
 * @see [会员数据业务处理类]
 * @class MemberService.java
 * @package shopping.service
 * @project shopping
 *
 * @author jackflynn
 * @time 下午5:58:02
 * @description [跟会员数据相关的业务处理类]
 */
public class MemberService {
	private MemberDAO memberDAO=new MemberDAO();
	private List<Member> memberList;
	private Member member;
	private Connection conn;
	/**
	 * 用户登录的方法
	 * @param member 要登录的用户
	 * @return 返回登录的用户
	 */
	public List<Member> login(Member member){
		//获取数据库连接
		//查询用户数据
		try {
			conn=ConnectionManager.getConnection();
			memberList=memberDAO.findByCondition(conn, FindType.MEMBER_USERNAME_PASSWORD, member.getUsername(),member.getPassword());
			//System.out.println(memberList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			//关闭数据库连接释放资源
			ConnectionManager.free(conn);
		}
		//返货查询到的数据
		//System.out.println("Logged IN");
		return memberList;
	}
	
	public Member modPwd(Member member,String pwd){
		try {
			conn=ConnectionManager.getConnection();
			System.out.println(member);
			memberDAO.update(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			//关闭数据库连接释放资源
			ConnectionManager.free(conn);
		}
		//返货查询到的数据
		//System.out.println("PWD changed");
		return member;
	}
	/**
	 * 用户注册的方法
	 * @param member 要注册的用户
	 * @return
	 */
	public int regist(Member member){
		int id=-1;
		try {
			//1.获取数据库连接 
			conn = ConnectionManager.getConnection();
			//2.调用DAO的方法保存用户
			memberList=memberDAO.findAll(conn);
			System.out.print(memberList);
			for(int i=0;i<memberList.size();i++){
				if(member.getUsername().trim().equals(memberList.get(i).getUsername().trim())){
					
					System.out.println("用户名已存在");
					return -2;//-2代表用户名已存在
				}
			}
			id=memberDAO.add(conn, member);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//3.关闭数据库连接 释放资源
			ConnectionManager.free(conn);
		}
		
		//4.返回处理结果
		return id;
	}
	
	
}

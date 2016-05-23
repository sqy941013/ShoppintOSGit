<%@page import="java.util.List"%>
<%@page import="shopping.service.MemberService"%>
<%@page import="shopping.model.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1、获取数据
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	//2、获取的数据封装成Member对象
	Member member = new Member(username,password);
	
	//3、调用MemberService的Login方法进行登录
	MemberService memberService=new MemberService();
	List<Member> memberList=memberService.login(member);
	
	//4、根据登录的结果判断登录是否成功
	if(memberList!=null&&memberList.size( ) > 0){
		//登录成功
		//4.1记录登录用户
		session.setAttribute("loginuser",memberList.get(0).getUsername());
		session.setAttribute("loginuserid", memberList.get(0).getMemberId());
		//4.2跳转到会员主页(请求重定向跳转)
		response.sendRedirect("../front/index.jsp");
	} else {
		//登录失败
		//4.1记录失败信息
		request.setAttribute("loginerror", "用户名或者密码有误，请重新登录...");
		//4.2跳转到登录页面 展示错误信息 并重新登录（请求转发跳转）
		//保存在request中的数据，在请求重定向时，数据会丢失，请求转发到下一个页面时不会丢失
		request.getRequestDispatcher("../login.jsp").forward(request, response);
	}
%>
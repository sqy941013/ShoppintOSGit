<%@page import="shopping.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="shopping.model.Member" %>
<%
	//0.做接受数据的编码过滤
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	//1.获取用户注册信息
	String username=request.getParameter("username");
	String pwd1=request.getParameter("pwd1");
	String pwd2=request.getParameter("pwd2");
	String realname=request.getParameter("realname");
	
	//2.进行简单数据验证 其实这里也可以用JS写
	if("".equals(username.trim())){
		request.setAttribute("regerror", "账号不能为空");
		request.getRequestDispatcher("../regist.jsp").forward(request,response);
		return ;
	}
	if("".equals(pwd1.trim())){
		request.setAttribute("regerror", "密码不能为空");
		request.getRequestDispatcher("../regist.jsp").forward(request,response);
		return ;
	}
	if("".equals(pwd2.trim())){
		request.setAttribute("regerror", "确认密码不能为空");
		request.getRequestDispatcher("../regist.jsp").forward(request,response);
		return ;
	}
	if(!pwd1.trim().equals(pwd2.trim())){
		request.setAttribute("regerror", "两次输入密码不同");
		request.getRequestDispatcher("../regist.jsp").forward(request,response);
		return ;
	}
	if("".equals(realname.trim())){
		request.setAttribute("regerror", "真实姓名不能为空");
		request.getRequestDispatcher("../regist.jsp").forward(request,response);
		return ;
	}
	
	//3.调用底层业务处理类进行注册
	//3.1 根据用户输入的注册信息创建一个Member对象
	Member member=new Member(username,pwd1,realname);
	//3.2调用Service的方法进行注册
	MemberService memberService=new MemberService();
	int id=memberService.regist(member);
	if(id>0){
		//注册成功 跳转到注册成功页面
		response.sendRedirect("../registsucc.jsp");
	}else{
		//注册失败 跳转回注册页面  TDOO 原因未写
		if(id==-2){
			request.setAttribute("regerror", "用户名已存在");
			request.getRequestDispatcher("../regist.jsp").forward(request,response);
		}
		
	}
	//4.根据注册结果跳转到不同页面
%>
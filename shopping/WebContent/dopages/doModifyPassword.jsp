<%@page import="java.util.List"%>
<%@page import="shopping.service.MemberService"%>
<%@page import="shopping.model.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1、获取数据
	String oldpassword=request.getParameter("oldpwd");
	String newpassword=request.getParameter("newpwd1");
	String confNewPassword=request.getParameter("newpwd2");
	//2、获取的数据封装成Member对象
	Member member=new Member(session.getAttribute("loginuser").toString().trim(),oldpassword);
		//System.out.print(member);
	//3、调用MemberService的Login方法进行登录
	MemberService memberService=new MemberService();
	List<Member> memberList=memberService.login(member);
	
	//System.out.print(memberList);
	//4、根据登录的结果判断登录是否成功
	if(memberList!=null&&memberList.size( ) > 0){
		//登录成功
		//System.out.print("doModifyPassword.jsp if(memberList!=null&&memberList.size( ) > 0)" );
		//4.1记录登录用户
		session.setAttribute("loginuser",memberList.get(0).getUsername());
		if(newpassword.trim().equals(confNewPassword.trim())){
			if(request.getAttribute("pwdChangeError")!=null)
			{
				request.removeAttribute("pwdChangeError");
			}
			memberList.get(0).setPassword(newpassword);
			memberService.modPwd(memberList.get(0), newpassword);
			System.out.print("密码修改为"+memberList.get(0).getPassword());
			//4.2跳转到密码修改成功页面(请求重定向跳转)
			response.sendRedirect("../userPwdChanged.jsp");
		}else{
			request.setAttribute("pwdChangeError", "密码与确认密码不同");
			request.getRequestDispatcher("../userModInfo.jsp").forward(request, response);
		}
	} else {
		//登录失败
		//4.1记录失败信息
		request.setAttribute("oldpwdError", "旧密码错误");
		//4.2跳转到登录页面 展示错误信息 并重新登录（请求转发跳转）
		//保存在request中的数据，在请求重定向时，数据会丢失，请求转发到下一个页面时不会丢失
		request.getRequestDispatcher("../userModInfo.jsp").forward(request, response);
	}
%>
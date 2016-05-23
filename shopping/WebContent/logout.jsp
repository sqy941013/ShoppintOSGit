<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("loginuser");

	session.invalidate();
	
	response.sendRedirect("front/index.jsp");
%>
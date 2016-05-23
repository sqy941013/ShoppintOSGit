<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="shopping.model.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>会员注册页面</h1>
<hr />
<%=request.getAttribute("regerror") %>>
<form method="post" action="${pageContext.request.contextPath }/dopages/doregist.jsp">
	username:<input type="text" name="username"/><br />
	password:<input type="text" name ="pwd1" /><br />
	confirm password:<input type="text" name ="pwd2" /><br />
	realname:<input type="text" name="realname"/><br />
	<input type="submit" value="注册" />
</form>
</body>
</html>
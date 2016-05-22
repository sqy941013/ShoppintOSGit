<%@page import="shopping.service.GoodsTypeService"%>
<%@page import="shopping.model.GoodsType" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div class="container_12">
    <div id="top">
      <div class="grid_3">
      </div><!-- .grid_3 -->

      <div class="grid_6">
        <div class="welcome">
        <%
        	if(session.getAttribute("loginuser")!=null){
        		out.print("欢迎您"+session.getAttribute("loginuser"));
        	} else {
        		out.print("欢迎您访客，请 <a href=\"../login.jsp\">登录</a> 或 <a href=\"../regist.jsp\">注册用户</a>.");
        	}
        %>
          
        </div><!-- .welcome -->
      </div><!-- .grid_6 -->

      <div class="grid_3">

      </div><!-- .grid_3 -->
    </div><!-- #top -->

    <div class="clear"></div>

    <header id="branding">
      <div class="grid_3">
        <hgroup>
          <h1 id="site_logo" ><a href="${pageContext.request.contextPath}/front/index.jsp" title=""><img src="${pageContext.request.contextPath}/images/logo.png" alt="Online Store Theme Logo"/></a></h1>
          <h2 id="site_description">在线购物系统</h2>
        </hgroup>
      </div><!-- .grid_3 -->

      <div class="grid_3">
        <form class="search">
          <input type="text" name="search" class="entry_form" value="" placeholder="Search entire store here..."/>
	</form>
      </div><!-- .grid_3 -->

      <div class="grid_6">
        
        <nav class="private">
          <ul>
            <li><a href="#">我的账户</a></li>
		<li class="separator">|</li>
            <li><a href="#">购物车</a></li>
		<li class="separator">|</li>
            <li><a href="login.html">登录</a></li>
		<li class="separator">|</li>
            <li><a href="login.html">注册</a></li>
          </ul>
        </nav><!-- .private -->
      </div><!-- .grid_6 -->
    </header><!-- #branding -->
  </div><!-- .container_12 -->

  <div class="clear"></div>

  <div id="block_nav_primary">
    <div class="container_12">
      <div class="grid_12">
        <nav class="primary">
          <ul>
            <li class="curent"><a href="${pageContext.request.contextPath}/front/index.jsp">首页</a></li>
            <%
            	GoodsTypeService goodsTypeService=new GoodsTypeService();
        		List<GoodsType> goodsTypes;
        		
        		goodsTypes=goodsTypeService.getTypes();
        		
        		for(int i=0;i<goodsTypes.size();i++){
        			out.print("<li><a href=\"catalog_grid.html\">"+goodsTypes.get(i).getGoodsType()+"</a></li>");
        		}
            %>
            <!--li><a href="catalog_grid.html">手机</a></li-->
            
            
          </ul>
        </nav><!-- .primary -->
      </div><!-- .grid_12 -->
    </div><!-- .container_12 -->
  </div><!-- .block_nav_primary -->
</body>
</html>
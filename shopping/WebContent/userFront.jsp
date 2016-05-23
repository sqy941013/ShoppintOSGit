<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="shopping.model.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>Home</title>

  <link rel="shortcut icon" href="favicon.ico">
  <link href="${pageContext.request.contextPath}/css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/grid.css" media="screen" rel="stylesheet" type="text/css">

  <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js" ></script>
  <script src="${pageContext.request.contextPath}/js/html5.js" ></script>
  <script src="${pageContext.request.contextPath}/js/jflow.plus.js" ></script>
  <script src="${pageContext.request.contextPath}/js/jquery.carouFredSel-5.2.2-packed.js"></script>
  
  <script src="${pageContext.request.contextPath}/js/checkbox.js"></script>
  <script src="${pageContext.request.contextPath}/js/radio.js"></script>
  <script src="${pageContext.request.contextPath}/js/selectBox.js"></script>

  <script>
	$(document).ready(function(){
	    $("#myController").jFlow({
			controller: ".control", // must be class, use . sign
			slideWrapper : "#jFlowSlider", // must be id, use # sign
			slides: "#slider",  // the div where all your sliding divs are nested in
			selectedWrapper: "jFlowSelected",  // just pure text, no sign
			width: "984px",  // this is the width for the content-slider
			height: "480px",  // this is the height for the content-slider
			duration: 400,  // time in miliseconds to transition one slide
			prev: ".slidprev", // must be class, use . sign
			next: ".slidnext", // must be class, use . sign
			auto: true
    });
  });
  </script>
  <script>
	$(function() {
	  $('#list_product').carouFredSel({
		prev: '#prev_c1',
		next: '#next_c1',
		auto: false
	  });
          $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
		auto: false
	  });
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>
</head>
<body>
<jsp:include page="/front/header.jsp"></jsp:include>
<%if(session.getAttribute("loginuser")==null){ %>
 <div class="clear"></div>
  
  <div class="clear"></div>
  
  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3"><!-- #categories_nav --><!-- #categories_nav --><!-- #tags --><!-- #newsletter_signup --><!-- #banners -->
	      
       </div><!-- .sidebar -->
      
       <div id="content" class="grid_9">
		<h1 class="page_title">请登录</h1>
		<article class="post">
		  <h2 class="title_article"><a href="blog_post.html"></a></h2>
			<div class="content_article">
				<p>如果您已拥有账号请<a href="${pageContext.request.contextPath}/login.jsp">登录</a>，如果您还没有创建一个账号请<a href="${pageContext.request.contextPath}/refist.jsp">注册</a></p>
			</div><!-- .content_article -->
			<div class="footer_article">
			</div>
		</article>
      </div><!-- #content -->
       
      <div class="clear"></div>
      
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>
<%} else {%>

  <div class="clear"></div>
  
  <div class="clear"></div>
  
  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3>我的账户</h3>
		     
		     <nav class="left_menu">
			    <ul>
				   <li><a href="${pageContext.request.contextPath}/myOrder.jsp">我的订单</a></li>
				   <li><a href="${pageContext.request.contextPath}/addressManage.jsp">地址管理</a></li>
				   <li><a href="${pageContext.request.contextPath}/userModInfo.jsp">修改信息</a></li>
				   
			    </ul>
		     </nav><!-- .left_menu -->
	      </aside><!-- #categories_nav --><!-- #categories_nav --><!-- #tags --><!-- #newsletter_signup --><!-- #banners -->
	      
       </div><!-- .sidebar -->
      
       <div id="content" class="grid_9">
		<h1 class="page_title">我的账户</h1>
		<article class="post">
		  <h2 class="title_article">欢迎您，<%=session.getAttribute("loginuser")%></h2>
			<div class="content_article">
				<p>Blah Blah Blah Blah</p>
			</div><!-- .content_article -->
			<div class="footer_article">
			</div>
		</article>
      </div><!-- #content -->
       
      <div class="clear"></div>
      
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>

<%} %>
<jsp:include page="/front/footer.jsp"></jsp:include>
</body>
</html>
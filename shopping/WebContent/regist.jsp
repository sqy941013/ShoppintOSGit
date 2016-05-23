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

<section id="main" class="entire_width">
    <div class="container_12">      
       <div id="content">
		<div class="grid_12">
			<h1 class="page_title">注册一个账号</h1>
		</div><!-- .grid_12 -->
		
		<div class="grid_6 new_customers">
			<h2>注册账号</h2>
			<p>当您创建一个商城新用户的时候，你可以更快速地支付，存储多个邮寄地址，设置头像等更多的功能。<br>
			注册账号需要您提供用户名、密码、真实姓名等信息。<br>
			注册完成之后您可以在我的账户里面增加或修改您的信息。 </p>
			<div class="clear"></div>
			<!--button class="account">创建新用户</button-->
                </div><!-- .grid_6 -->
		
		<div class="grid_6">
			<form class="registed" method="post" 
				action="${pageContext.request.contextPath }/dopages/doregist.jsp">
				<h2>注册账户</h2>
							
				<p>如果您已注册过请登录</p>
				<p>
				<%
					if(request.getAttribute("regerror")!=null){
						out.print(request.getAttribute("regerror"));
					}
				%>
				</p>
							
				<div class="email">
					<strong>用户名</strong><sup class="surely">*</sup><br/>
					<input type="text" name="username" class="" value="" />
				</div><!-- .email -->
							
				<div class="password">
					<strong>密码:</strong><sup class="surely">*</sup><br/>
					<input type="text" name="pwd1" class="" value="" />
				</div><!-- .password -->
				
				<div class="password">
					<strong>确认密码:</strong><sup class="surely">*</sup><br/>
					<input type="text" name="pwd2" class="" value="" />
				</div><!-- .password -->
				
				<div class="realname">
					<strong>真实姓名:</strong><sup class="surely">*</sup><br/>
					<input type="text" name="realname" class="" value="" />
				</div><!-- .password -->
				
				<div class="submit">										
					<input type="submit" value="注册" />
					<sup class="surely">*</sup><span>必填信息</span>
				</div><!-- .submit -->
			</form><!-- .registed -->
                </div><!-- .grid_6 -->
       </div><!-- #content -->
       
      <div class="clear"></div>
    </div><!-- .container_12 -->
  </section><!-- #main -->


<jsp:include page="/front/footer.jsp"></jsp:include>
</body>
</html>
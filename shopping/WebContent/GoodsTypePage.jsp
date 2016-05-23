<%@page import="shopping.service.GoodsService"%>
<%@page import="shopping.model.Goods"%>
<%@page import="shopping.model.GoodsType"%>
<%@page import="shopping.service.GoodsTypeService"%>
<%@page import="java.util.List" %>
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

<div class="clear"></div>
  
  <div class="container_12">
    <div class="grid_12">
       <div class="breadcrumbs">
	      <a href="index.html">首页</a><span>&#8250;</span><a href="#">商品类型</a><span>&#8250;</span><span class="current"><%=request.getParameter("goodsType") %></span>
       </div><!-- .breadcrumbs -->
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->
  
  <div class="clear"></div>
  
  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3>商品类型</h3>
		     
		     <nav class="left_menu">
			    <ul>
				    <%
            	GoodsTypeService goodsTypeService=new GoodsTypeService();
        		List<GoodsType> goodsTypes;
        		
        		goodsTypes=goodsTypeService.getTypes();
        		
        		for(int i=0;i<goodsTypes.size();i++){
        			%>
        				<li><a href="${pageContext.request.contextPath}/GoodsTypePage.jsp?goodsType=<%=goodsTypes.get(i).getGoodsType()%>"><%=goodsTypes.get(i).getGoodsType()%><!--span>(21)</span--></a></li>
        			<%
        		}
            %>
			    </ul>
		     </nav><!-- .left_menu -->
	      </aside><!-- #categories_nav --><!-- #shop_by --><!-- #specials --><!-- #newsletter_signup -->
       </div><!-- .sidebar -->
      
       <div id="content" class="grid_9">
	      <h1 class="page_title"><%=request.getParameter("goodsType") %></h1><!-- .options -->
	      <div class="grid_product">
	      <%
	      	List<Goods> goodsList;
	      	GoodsType goodsType;
	      	int goodsTypeId;
	      	GoodsService goodsService=new GoodsService();
	      	
	      	goodsTypeId=goodsTypeService.getTypeByName(request.getParameter("goodsType").toString().trim()).getGoodsTypeId();
	      	
	      	goodsList=goodsService.findGoodsByTypeId(goodsTypeId);
	      	
	      	for(int i=0;i<goodsList.size();i++){
	      		%>
		     <div class="grid_3 product">
			    <div class="prev">
				   <a href="product_page.html"><img src="image/goods/<%=goodsTypeId%>/<%=goodsList.get(i).getGoodId()%>.jpg" alt="" title="" /></a>
			    </div><!-- .prev -->
			    <h3 class="title"><%=goodsList.get(i).getGoodName() %></h3>
			    <div class="cart">
				   <div class="price">
					  <div class="vert">
						 <div class="price_new">￥<%=goodsList.get(i).getSubPrice() %></div>
						 <!--div class="price_old">￥1000</div-->
					  </div>
				   </div>
				   <a href="#" class="like"></a>
				   <a href="#" class="bay"></a>
			    </div><!-- .cart -->
		     </div><!-- .grid_3商品的div -->
	      		
	      		<%
	      	}
	      	%>
                
                
	      <div class="clear"></div>
	      </div><!-- .grid_product -->
	      
	      <div class="clear"></div>
	      
	      <div class="pagination">
		     <ul>
			    <li class="prev"><span>&#8592;</span></li>
			    <li class="curent"><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><span>...</span></li>
			    <li><a href="#">100</a></li>
			    <li class="next"><a href="#">&#8594;</a></li>
		     </ul>
	      </div><!-- .pagination -->
	      <!--p class="pagination_info">Displaying 1 to 12 (of 100 products)</p-->
       </div><!-- #content -->
       
      <div class="clear"></div>
      
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>

<jsp:include page="/front/footer.jsp"></jsp:include>
</body>
</html>
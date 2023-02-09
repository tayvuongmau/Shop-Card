<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="position: fixed; z-index: 1; width: 100%;">
    <div class="container px-4 px-lg-5">
    	<c:if test="${empty account}">
        	<a style="margin: 0%; padding: 0%; text-transform: uppercase; text-align: center;" class="navbar-brand" href='<c:url value="/home"/>'>
        	<img src='<c:url value="/common/logo/logo1.png"/>' width="15%"/>
        	<h4>Defense of the Ancients</h4></a>
        </c:if>
        <c:if test="${not empty account}">	
        	<a style="margin: 0%; padding: 0%; text-transform: uppercase; text-align: center;" class="navbar-brand" href='<c:url value="/user/home"/>'>
        	<img src='<c:url value="/common/logo/logo1.png"/>' width="15%"/>
        	<h4>Defense of the Ancients</h4></a>
        </c:if>	
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" style="margin-top: 2%;">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="text-transform: uppercase; font-weight: bold;">Danh mục</a>
                   	<c:if test="${empty account}">
                   	 	<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      	 	 <li><a class="dropdown-item" href='<c:url value="/streng"/>'>Card Hero Streng</a></li> 
                      	 	 <li><a class="dropdown-item" href='<c:url value="/intelligent"/>'>Card Hero Intelligent</a></li> 
                      		  <li><a class="dropdown-item" href='<c:url value="/agility"/>'>Card Hero Agility</a></li> 
                   		 </ul>
                    </c:if>
                    <c:if test="${not empty account}">
                    	<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      	 	 <li><a class="dropdown-item" href='<c:url value="/user/streng"/>'>Card Hero Streng</a></li> 
                      	 	 <li><a class="dropdown-item" href='<c:url value="/user/intelligent"/>'>Card Hero Intelligent</a></li> 
                      		 <li><a class="dropdown-item" href='<c:url value="/user/agility"/>'>Card Hero Agility</a></li> 
                   		 </ul>
                    </c:if>   
                </li>             
                <c:if test="${empty account}">
                	<li class="nav-item">
                		<form action='<c:url value="/search"/>' class="d-flex" >
                			<input type="text" name="productName"/><input type="submit" value="Tìm kiếm"/>
                		</form>
             	   </li>
                </c:if>
                <c:if test="${not empty account}">
                	<li class="nav-item">
                		<form action='<c:url value="/user/search"/>' class="d-flex" >
                			<input type="text" name="productName"/><input type="submit" value="Tìm kiếm"/>
                		</form>
             	   </li>
                </c:if>    
            </ul>
            
            <c:if test="${empty account}">
            	<form class="d-flex">
         	       <div class="btn btn-outline-dark" style="padding: 3px 6px 3px 6px;">
        	            <a href='<c:url value="/MyCart" />' style="text-decoration: none;"><i class="fa fa-shopping-cart"></i>Cart</a>  
        	            <span class="badge bg-dark text-white ms-1 rounded-pill">${cart.size()}</span>
        	        </div>
        	    </form>
            </c:if>
            
            <c:if test="${not empty account}">
            	<form class="d-flex">
         	       <div class="btn btn-outline-dark" style="padding: 3px 6px 3px 6px;">
          	          <a href='<c:url value="/user/MyCart" />' style="text-decoration: none;"><i class="fa fa-shopping-cart"></i>Cart</a>  
       	             <span class="badge bg-dark text-white ms-1 rounded-pill">${cart.size()}</span>
       	         </div>
      	      </form>
            </c:if>
             
            <c:if test="${empty account}">
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href='<c:url value="/login"/>' style="border: none;">
	                    <i>Đăng nhập</i>
	                </a>
	            </form>
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href='<c:url value="/signin"/>' style="border: none;">
	                    <i>Đăng ký</i>
	                </a>
	            </form>
            </c:if>
            <c:if test="${not empty account}">
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href="#" style="border: none;">
	                	<i class="fas fa-user fa-fw"></i><br/>${account.username}
	                    
	                </a>
	            </form>
	            <form action="<c:url value="/j_spring_security_logout" />" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" value="Đăng xuất" />
				</form>
            </c:if>
        </div>
    </div>
</nav>
<header style="width: 70%; margin: auto;">
		<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src='<c:url value="/common/logo/anhbia1.JPG"/>' class="d-block w-100">
				</div>
				<div class="carousel-item">
					<img src='<c:url value="/common/logo/anhbia2.JPG"/>' class="d-block w-100">
				</div>
				<div class="carousel-item">
					<img src='<c:url value="/common/logo/anhbia3.JPG"/>' class="d-block w-100">
				</div>
			</div>
		</div>
</header>
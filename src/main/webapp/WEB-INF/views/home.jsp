<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/taglist/taglist.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>

<link rel="icon" type="image/x-icon" href='<c:url value="/common/web/homepage/favicon.ico"/>' />
<link rel="stylesheet" href='<c:url value="/common/web/homepage/styles.css"/>'/>
<link rel="stylesheet" href='<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>'/>
<script type="text/javascript" src='<c:url value="/common/admin/js/all.js"/>'></script>
<link rel="stylesheet" href='<c:url value="/common/web/homepage/font-awesome.min.css"/>'/>
</head>
<body>
	<!-- Header -->
	<%@include file="/include/web/header.jsp" %>
	<!-- End Header -->

	<!-- Body -->
	<!-- Baner-->
	

	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach items="${list}" var="e">
					<c:set scope="page" var="img" value="${e.product_src}.${e.product_type}"></c:set>
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<c:if test="${empty account}">
								<a href='<c:url value="/detail?detailProduct=${e.product_id}"/>'><img class="card-img-top" src='<c:url value="/common/image/${img}"/>'/></a>
							</c:if>
                			<c:if test="${not empty account}">
                				<a href='<c:url value="/user/detail?detailProduct=${e.product_id}"/>'><img class="card-img-top" src='<c:url value="/common/image/${img}"/>'/></a>
                			</c:if>
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${e.product_name}</h5>
									<!-- Product price-->
									${e.product_price}($)
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto" href='<c:url value="/BuyProduct?product_id=${e.product_id}"/>' ><i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="pagination" >
					<c:forEach begin="1" end="${endPage}" var="i">
						<div  class="page-item">
						<a class="page-link" href="home?page=${i}">${i}</a>
						</div>
					</c:forEach>
			</div>
		</div>
	</section>
	<!-- End Body -->

	<!-- Footer -->
	<%@include file="/include/web/footer.jsp" %>
	<!-- End Footer -->
	<script type="text/javascript" src='<c:url value="/common/web/homepage/bootstrap.bundle.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/common/web/homepage/scripts.js"/>'></script>
</body>
</html>
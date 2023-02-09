<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp"%> 
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
	<%@include file="/include/web/header.jsp"%>	
	<!-- End Header -->

	<!-- Main -->

	<div class="container-fluid px-4" style="margin: 0.2%;">
		<div class="card mb-4">
			<div class="card-header" style="text-align: center;">
				<h3 class="fas fa-table me-1">Danh sách chi tiết sản phẩm trong giỏ hàng</h3>
			</div>
			<div>
				<table style="border: 1px solid; margin: auto; width: 60%;">
					<tr style="border: 1px solid; text-align: center;">
						<th style="border: 1px solid;">Số thứ tự</th>
						<th style="border: 1px solid;">Tên thẻ Card</th>
						<th style="border: 1px solid;">Số lượng</th>
						<th style="border: 1px solid;">Giá bán</th>
						<th style="border: 1px solid;">Thành tiền</th>
						<th style="border: 1px solid;">Xoá sản phẩm</th>
					</tr>
					<c:set var="stt" value="0" />
					<c:forEach items="${items}" var="i">
						<c:set var="stt" value="${stt+1}" />
						<tr style="border: 1px solid; text-align: center;">
							<td style="border: 1px solid;">${stt}</td>
							<td style="border: 1px solid;">${i.value.products.product_name }</td>
							<td style="border: 1px solid;">
								<button><a style="text-decoration: none;" href='<c:url value="/EditCart?process=-1&product_id=${i.value.products.product_id}"/> '>-</a></button> 
								${i.value.quantity}
								<button><a style="text-decoration: none;" href='<c:url value="/EditCart?process=+1&product_id=${i.value.products.product_id}"/> '>+</a></button>
							</td>
							<td style="border: 1px solid;">${i.value.products.product_price}($)</td>
							<td style="border: 1px solid;">${i.value.totalPrice} ($)</td>
							<td style="border: 1px solid;">
							<form action="<c:url value="/DeleteCart" />" method="post">
								<input type="hidden" name="product_id" value="${i.value.products.product_id}" />
								<input type="submit" value="Xoá sản phẩm">
							</form>
							</td>
						</tr>
					</c:forEach>
						<tr style="text-align: center;">
							<td style="border: 1px solid;" colspan="5"><b>Tổng tiền :</b></td>
							<td style="border: 1px solid;"><b>${totalMoney} ($)</b></td>
						</tr>
				</table>
				
				<c:if test="${empty account}">
					<form style="text-align: center; margin: 0.5%;" action='<c:url value="/CheckOut" />' >
						<input type="submit" value="Thanh toán" >
					</form>
				</c:if>
				
				<c:if test="${not empty account}">
					<form style="text-align: center; margin: 0.5%;" action='<c:url value="/user/CheckOut" />' >
						<input type="submit" value="Thanh toán" >
					</form>
				</c:if>
			</div>
		</div>
	</div>
	<!-- End Main -->

	<!-- Footer -->
	<%@include file="/include/web/footer.jsp"%>	
	<!-- End Footer -->

	<script type="text/javascript" src='<c:url value="/common/web/homepage/bootstrap.bundle.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/common/web/homepage/scripts.js"/>'></script>
</body>
</html>


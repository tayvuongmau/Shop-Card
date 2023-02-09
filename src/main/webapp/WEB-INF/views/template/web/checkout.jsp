<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/taglist/taglist.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thanh toán</title>
	<link rel="stylesheet" href='<c:url value="/common/web/login/bootstrap.min.css"/>'/>
	<link rel="stylesheet" href='<c:url value="/common/web/login/font-awesome.min.css"/>'/>
	<link rel="stylesheet" href='<c:url value="/common/web/login/login.css"/>'/>
</head>
<body>

	<div class="container-fluid">
		<div class="row no-gutter">
			<!-- The image half -->
			<div class="col-md-6 d-none d-md-flex bg-image"></div>


			<!-- The content half -->
			<div class="col-md-6 bg-light">
				<div class="login d-flex align-items-center py-5">

					<!-- Demo content-->
					<div class="container">
						<div class="row">
							<div class="col-lg-10 col-xl-7 mx-auto">
								<h1>
									<b>Thanh toán đơn hàng</b>
								</h1>
								<br />
								<form:form action='/PRJ321x_Assignment4/user/Pay' method="post" modelAttribute="bills">
									<table>
									<tr class="form-group mb-3" >
										<td>
											<form:input style="width: 200%" path="username" value="${bills.username}" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" path="telephone" value="${bills.telephone}" class="form-control rounded-pill border-0 shadow-sm px-4 text-primary" /><p/>
											
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:textarea style="width: 200%"  placeholder="Địa chỉ nhận hàng" path="address" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" type="number"  path="bills_quanty"  class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" type="number" path="bills_total" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:textarea style="width: 200%" placeholder="Ghi chú" path="note" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											
										</td>
									</tr>
									<tr>
										<td><button style="width: 200%" type="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Thanh toán</button></td>
									</tr>
									</table>
									<div class="text-center d-flex justify-content-between mt-4"> <a href='<c:url value="/home"/>' class="font-italic text-muted">					
												<i>Trở lại trang chủ</i>						
										</a>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<!-- End -->

				</div>
			</div>
			</div>
			</div>
			<!-- End -->
			<script type="text/javascript" src='<c:url value="/common/web/login/bootstrap.bundle.min.js"/>'></script>
    		<script type="text/javascript" src='<c:url value="/common/web/login/jquery-3.3.1.slim.min.js"/>'></script>
</body>
</html>
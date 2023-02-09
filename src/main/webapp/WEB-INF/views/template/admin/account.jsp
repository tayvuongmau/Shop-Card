<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/include/taglist/taglist.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Bảng danh sách tài khoản người dùng</title>

<link rel="stylesheet" href='<c:url value="/common/admin/css/styles.css"/>'/>
<link rel="stylesheet" href='<c:url value="/common/admin/css/styles.css"/>'/>
<script type="text/javascript" src='<c:url value="/common/admin/js/all.js"/>'></script>
</head>

<body class="sb-nav-fixed">
	<!-- header -->
	<%@include file="/include/admin/header.jsp"%>
	<!-- header -->

	<!-- big main -->
	<div id="layoutSidenav">
	<%@include file="/include/admin/menu.jsp"%>
		<!-- main -->
		<div id="layoutSidenav_content">
			<!-- main -->
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Bảng danh sách tài khoản người dùng</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
						<li class="breadcrumb-item active">Bảng danh sách tài khoản người dùng</li>
					</ol>
					<div class="card mb-4">
						<table style="text-align: center;">
							<tr>
								<th style="border-width: 1px; text-align: center;">Username</th>
								<th style="border-width: 1px; text-align: center;">Password</th>
								<th style="border-width: 1px; text-align: center;">Email</th>
								<th style="border-width: 1px; text-align: center;">Telephone</th>
								<th style="border-width: 1px; text-align: center;">Birthday</th>
							</tr>
							<c:forEach items="${account}" var="i">
							<tr>
								<td style="border-width: 1px; text-align: center;">${i.userName}</td>
								<td style="border-width: 1px; text-align: center;">${i.passWord}</td>
								<td style="border-width: 1px; text-align: center;">${i.email}</td>
								<td style="border-width: 1px; text-align: center;">${i.telephone}</td>
								<td style="border-width: 1px; text-align: center;"><fmt:formatDate value="${i.birthday}" pattern="dd/MM/yyy"/></td>
							</tr>
							</c:forEach>
						</table>
						<p/>
						
						<div class="pagination" >
							<c:forEach begin="1" end="${endPage}" var="i">
								<div  class="page-item">
								<a class="page-link" href='<c:url value="/admin/account?page=${i}"/>'>${i}</a>
								</div>
							</c:forEach>
						</div>
						
						<p/>	
					</div>
				</div>
			</main>
			<!-- main -->
	<%@include file="/include/admin/footer.jsp"%>			
		</div>
		<!-- main -->
	</div>
	<!-- big main -->
	<script type="text/javascript" src='<c:url value="/common/admin/js/bundle.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/common/admin/js/scripts.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/common/admin/js/Chart.min.js"/>'></script>
</body>
</html>
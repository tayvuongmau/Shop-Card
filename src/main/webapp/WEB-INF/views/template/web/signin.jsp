<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/taglist/taglist.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign in</title>
<style>
	.err{
		color: red;
	}
	.sucess{
		color: green;
	}
</style>
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
								<h3 class="display-4">
									<b>Đăng ký tài khoản</b>
								</h3>
								<br />
								<form:form action='/PRJ321x_Assignment4/CreateUser' method="post" modelAttribute="user" >
									<table>
									<tr class="form-group mb-3" >
										<td>
											<form:input style="width: 200%" type="text" placeholder="Tên đăng nhập" path="userName" value="${user.userName}" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											<form:errors path="userName" cssClass="err"/>
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" type="password" placeholder="Mật khẩu" path="passWord" value="${user.passWord}" class="form-control rounded-pill border-0 shadow-sm px-4 text-primary" /><p/>
											<form:errors path="passWord" cssClass="err"/>
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" type="email" placeholder="E-mail" path="email" value="${user.email}" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											<form:errors path="email" cssClass="err"/>
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" type="date" placeholder="Ngày sinh" path="birthday" value='<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>' class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											<form:errors path="birthday" cssClass="err"/>
										</td>
									</tr>
									<tr class="form-group mb-3">
										<td>
											<form:input style="width: 200%" type="tel" placeholder="Số điện thoại" path="telephone" value="${user.telephone}" class="form-control rounded-pill border-0 shadow-sm px-4" /><p/>
											<form:errors path="telephone" cssClass="err"/>
												<p class="err">${exists}</p>
												<p class="sucess">${create}</p>
										</td>
									</tr>
									<tr>
										<td><button type="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Đăng ký</button></td>
										<td><button style="width: 400%" type="reset" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Xoá</button></td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@include file="/include/taglist/taglist.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
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
                                <h3 class="display-4"><b>Đăng nhập</b></h3>
                                <br/>
                                <form name='loginForm' action="<c:url value='j_spring_security_login'/>" method="post">
                                    <div class="form-group mb-3">
                                        <input type="text" placeholder="Tên đăng nhập" name="username"  class="form-control rounded-pill border-0 shadow-sm px-4">
                                    </div>
                                    <div class="form-group mb-3">
                                        <input type="password" placeholder="Mật khẩu" name="password"  class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
                                    </div>
                                    <p style="color: red; text-align: center;" >${err}</p>
                                    <p style="color: red; text-align: center;" >${accessDenied}</p>
                                    <p style="color: red; text-align: center;" >${NeedLogin}</p>
                                    <div class="custom-control custom-checkbox mb-3">
                                        <input id="customCheck1" type="checkbox" name="savepass" value="save" class="custom-control-input">
                                        <label for="customCheck1" class="custom-control-label">Nhớ mật khẩu</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Đăng nhập</button>
                                    <button type="reset" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Xoá</button> 
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
                                </form>
                                <div class="text-center d-flex justify-content-between mt-4"><a href='<c:url value="/home"/>' class="font-italic text-muted"> 
                                        <i>Trở lại trang chủ</i></a></div>
                            </div>
                        </div>
                    </div><!-- End -->
                </div>
            </div><!-- End -->
    
        </div>
    </div>
    <script type="text/javascript" src='<c:url value="/common/web/login/bootstrap.bundle.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/common/web/login/jquery-3.3.1.slim.min.js"/>'></script>
</body>
</html>
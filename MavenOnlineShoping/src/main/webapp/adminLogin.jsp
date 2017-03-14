
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="homeUrl" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
	<title>Please login to YourSiteName</title>
	<!-- Custom CSS -->
	<link rel="stylesheet" type="text/css" href="${homeUrl}/Resources/css/adminStyle.css" />
	<!-- Google Font -->
	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
    <!-- Bootstrap Core CSS -->
	<link type="text/css" rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<!-- jQuery Library -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
    <!-- Bootstrap Core JS -->
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	
	<section class="container">
	    <section class="login-form">
		<div class="panel panel-default">
		  	<div class="panel-heading"><b>Admin</b> sign in</div>
		  	<div class="panel-body">
		    	<form action="j_security_check" method="post" name="loginForm" role="login">
					<p>The page you have selected requires that you login to proceed.</p>
					<div class="row">
						<div class="col-xs-12">
							<input type="text" name="j_username"  placeholder="User Name" required class="form-control" />
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<div class="col-xs-12">
							<input type="password" name="j_password" placeholder="Password" required class="form-control" />
							<span class="glyphicon glyphicon-lock"></span>
						</div>
					</div>
					<button type="submit" name="go" class="btn btn-block btn-info">SIGN IN</button>
				</form>
			</div>
		</div>
		</section>
	</section>
	
</body>
</html>
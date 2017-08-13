<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<div class='login'>
		<h2>Sign in</h2>
		<input id="username" name='username' placeholder='Username'
			type='text' /> <input id='password' name='password'
			placeholder='Password' type='password' />
		<div class='remember'>
			<input checked='' id='remember' name='remember' type='checkbox' /> <label
				for='remember'></label>Remember me
		</div>
		<input id="clickSignIn" type='submit' value='Sign in' /> <a
			class='forgot'>Forgot your password?</a>
	</div>


	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.js"></script>

	<!-- Bootstrap Js -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/materialize/js/materialize.min.js"></script>

	<!-- Metis Menu Js -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/morris/raphael-2.1.0.min.js"></script>
	<%--     <script src="${pageContext.request.contextPath}/resources/assets/js/morris/morris.js"></script> --%>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/easypiechart.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/easypiechart-data.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/Lightweight-Chart/jquery.chart.js"></script>

	<!-- Custom Js -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/custom-scripts.js"></script>
	<script class="cssdeck"
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>

</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		inicializarVariables();
	});

	function inicializarVariables() {
		username = $('#username');
		password = $('#password');
	}
	
	$("#clickSignIn").click(function(event) {
		$.ajax({
			type : "post",
			url : "./iniciarSesion",
			cache : false,
			data : {
				username : username.val(),
				password : password.val()
			},
// 			success : function(response) {
// 				console.log("success");
// 				if (response == 1) {
// 					alert("Bienvenido a SYSPHARMA" + username + "!!!");
// 				} else {
// 					alert("Error al Ingresar su Usuario o Password!");
// 				}
// 			},
// 			error : function() {
// 				console.log("error");
// 			}
		});
	});
</script>
</html>
<style>
body {
	background: #2f313d;
	color: #46485c;
	font-family: sans-serif;
}

h2 {
	color: #46485c;
	font-size: 15px;
	font-weight: 600;
	text-align: center;
	margin-bottom: 10px;
}

a {
	color: #46485c;
	text-decoration: none;
}

.login {
	width: 250px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -184px 0px 0px -155px;
	background: rgba(0, 0, 0, 0.2);
	padding: 20px 30px;
	border-radius: 5px;
	box-shadow: 0px 1px 0px rgba(0, 0, 0, 0.3), inset 0px 1px 0px
		rgba(255, 255, 255, 0.07)
}

input[type="text"], input[type="password"] {
	width: 250px;
	padding: 25px 0px;
	background: transparent;
	border: 0;
	border-bottom: 1px solid rgba(255, 255, 255, 0.04);
	outline: none;
	color: white;
	font-size: 12px;
}

input[type=checkbox] {
	display: none;
}

label {
	display: block;
	position: absolute;
	margin-right: 10px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: transparent;
	content: "";
	transition: all 0.3s ease-in-out;
	cursor: pointer;
	border: 3px solid #46485c;
}

#remember:checked ~ label[for=remember] {
	background: #b5cd60;
}

input[type="submit"] {
	background: #b5cd60;
	border: 0;
	width: 250px;
	height: 40px;
	border-radius: 3px;
	color: white;
	cursor: pointer;
	transition: background 0.3s ease-in-out;
}

input[type="submit"]:hover {
	background: #16aa56;
}

.forgot {
	margin-top: 30px;
	display: block;
	font-size: 11px;
	text-align: center;
	font-weight: bold;
}

.forgot:hover {
	margin-top: 30px;
	display: block;
	font-size: 11px;
	text-align: center;
	font-weight: bold;
	color: #6d7781;
}

.remember {
	padding: 30px 0px;
	font-size: 12px;
	text-indent: 25px;
	line-height: 15px;
}

::-webkit-input-placeholder {
	color: #46485c;
}

[placeholder]:focus::-webkit-input-placeholder {
	transition: all 0.2s linear;
	transform: translate(10px, 0);
	opacity: 0;
}
</style>
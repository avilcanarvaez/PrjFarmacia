<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>| SISPHARMA- Sistema control farmacia |</title>
	
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath}/resources/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/js/Lightweight-Chart/cssCharts.css"> 
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href="index.html"><i class="large material-icons">insert_chart</i> <strong>SISPHARMA</strong></a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right"> 				
				  <li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>El Alex</b> <i class="material-icons right">arrow_drop_down</i></a></li>
            </ul>
        </nav>
		<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">
<li><a href="#"><i class="fa fa-user fa-fw"></i> My Perfil</a>
</li>
</li> 
<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a>
</li>
</ul>

	   <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <!-- <a href="ingresaUsuario.html" class="waves-effect waves-dark"><i class="fa fa-edit"></i> Clientes</a> -->
                        <li class="${param.opcion.equals('crear')?'active':''}"><a href="administrarCliente" ><i class="fa fa-edit"></i> Clientes</a></li>
                    </li>
                    <li>
                        <li class="${param.opcion.equals('crear')?'active':''}"><a href="bandejaProducto" class="waves-effect waves-dark"><i class="fa fa-table"></i> Productos</a>
                    </li>
                    <li>
                        <li class="${param.opcion.equals('crear')?'active':''}"><a href="cargarVentanaVentas" ><i class="fa fa-edit"></i> Ventas</a></li>
                    </li>
					<li>
                        <a href="chart.html" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> Reportes</a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Ventas por usuario</a>
                            </li>
                            <li>
                                <a href="#">Ventas por producto</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
		<div id="page-wrapper">
		  <div class="header"> 
<!--                         <h1 class="page-header">
                            Dashboard
                        </h1> -->
						<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
<!-- 					  <li><a href="#">Dashboard</a></li>
					  <li class="active">Data</li> -->
					</ol> 
									
		</div>
           
		<div class="footer"> 
		<footer><p>Todos los derechos reservados.</p>
				</footer>
		</div>
				
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/assets/materialize/js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/morris/raphael-2.1.0.min.js"></script>
<%--     <script src="${pageContext.request.contextPath}/resources/assets/js/morris/morris.js"></script> --%>
	
	<script src="${pageContext.request.contextPath}/resources/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/easypiechart-data.js"></script>
	
	 <script src="${pageContext.request.contextPath}/resources/assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/custom-scripts.js"></script> 
</body>
</html>
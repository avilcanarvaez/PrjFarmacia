<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>| SISPHARMA- Sistema control farmacia |</title>
    
    <c:url var="home" value="/" scope="request" />
	
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-table.css" rel="stylesheet" />
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
				  <li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>Usuario</b> <i class="material-icons right">arrow_drop_down</i></a></li>
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
                        <a href="table.html" class="waves-effect waves-dark"><i class="fa fa-table"></i> Productos</a>
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
					  <li><a href="#">Cliente</a></li>
 					  <li><a href="#">Administrar Cliente</a></li>
					  <!-- <li class="active">Data</li>  -->
					</ol> 
									
		</div>
             
        <form id ="formRegistrarVenta"  >
               
		 <div class="col-lg-12"> 		
			<div class="row">
				 <div class="input-field col s3">
	       			 <label> Vendedor: </label>
	                    <input disabled=""  id="txtNombreVendedor" name="vendedor" type="text" class="form-control">
	              </div>
	              
	             <div class="pull-right">
       				 <div class="input-field col s7">
	       			 	<label> Fecha: </label>
	                    <input disabled="" value="07/08/2017"  id="fecha" name="fecha" type="text" class="form-control">
	              	  </div>
		        </div>
	              
			</div>
		
		<!-- Contenedor Cliente -->
		  <div class="panel panel-default">
	      <div class="panel-heading">Datos del Cliente</div>
	      <div class="panel-body">
	            <div class="row">
	             	<div class="input-field col s1">
				          <input id="documento" name="documento"  type="text" class="validate">
          			      <label for="documento" class="">Nro Documento</label>
		        	</div>
		        	<div class="input-field col s3">
				          <input id="cliente"  name="cliente" type="text" class="validate">
          			      <label for="cliente" class="">Cliente</label>
		        	</div>
		        	
		        	<div class="input-field col s2">
				          <input id="direccion"  name="direccion" type="text" class="validate">
          			      <label for="direccion" class="">Direccion</label>
		        	</div>
		        	
		        	<div class="input-field col s1">
				          <input id="telefono" name="telefono"  type="text" class="validate">
          			      <label for="telefono" class="">Telefono</label>
		        	</div>
		        	
		        	<div class="input-field col s2">
				          <input id="correo" name="correo"  type="text" class="validate">
          			      <label for="correo" class="">E-Mail</label>
		        	</div>
		        	
      			</div>
	      </div>	 
          </div>
          <!-- Contenedor Cliente -->
          
          <!-- Contenedor Producto -->
          <div class="panel panel-default">
	      <div class="panel-heading">Datos de Producto</div>
	      <div class="panel-body">

	      <div class="row">
	         	<div class="input-field col s4">
	         	<label>STOCK: 50</label>
		        </div>
	      </div>
	            <div class="row">
	             	<div class="input-field col s2">
				          <input id="txtArticulo" name="articulo" type="text" class="validate">
          			      <label for="articulo" class="">Articulo</label>
		        	</div>
		        	<div class="input-field col s1">
				          <input id="txtPrecio"  name="precio" type="text" class="validate">
          			      <label for="precio" class="">Precio</label>
		        	</div>
		        	
		        	<div class="input-field col s1">
				          <input id="txtCantidad"  name="cantidad" type="text" class="validate">
          			      <label for="cantidad" class="">Cantidad</label>
		        	</div>
		        	
		       	<div class="pull-right">
					<button type="button" id="btnAgregar" class="btn btn-add"> Agregar </button>
					<button type="button" id="btnFinalizar" class="btn btn-add"> Finalizar Compra </button>
					
		        </div>
		        	
		        	
      			</div>
	      </div>	 
          </div>
          <!-- Contenedor Producto -->
          
          
          <table id="tblProductos" class="table table-condensed">
		    <thead>
		      <tr>
		        <th>Producto</th>
		        <th>Cantidad</th>
		        <th>Precio</th>
		      </tr>
		    </thead>
		    <tbody>	
  		</table>
          
          
          
          
          
      </div> 
      </form>
          
           
   <!--  <div class="card">
                        <div class="card-action">
                            Basic Form Elements
                        </div>
                        <div class="card-content">
    <form id ="formRegistrarVenta"  >
      <div class="row">
        <div class="input-field col s6">
          <input placeholder="Placeholder" id="first_name" type="text" class="validate">
          <label for="first_name" class="active">First Name</label>
        </div>
        <div class="input-field col s6">
          <input id="last_name" type="text" class="validate">
          <label for="last_name" class="">Last Name</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input disabled="" value="I am not editable" id="disabled" type="text" class="validate">
          <label for="disabled">Disabled</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" class="validate">
          <label for="password" class="">Password</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate">
          <label for="email" class="">Email</label>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          This is an inline input field:
          <div class="input-field inline">
            <input id="email" type="email" class="validate">
            <label for="email" data-error="wrong" data-success="right">Email</label>
          </div>
        </div>
      </div>
 </form>
	<div class="clearBoth"></div>
  </div>
    </div>  -->

        
           
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
    <script type="text/JavaScript" src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.js"></script>
    <script type="text/JavaScript" src="${pageContext.request.contextPath}/resources/assets/js/jquery.serializejson.js"></script>
	
	<!-- Bootstrap Js -->
    <script type="text/JavaScript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-table.js"></script>
			<!-- Bootstrap Pagination Table -->
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/resources/assets/js/jquery.dataTables.min.js"></script>
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/resources/assets/js/dataTables.bootstrap.min.js"></script>
	
	
	
	<script src="${pageContext.request.contextPath}/resources/assets/materialize/js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/morris/raphael-2.1.0.min.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/resources/assets/js/morris/morris.js"></script> --%>
	
	<script src="${pageContext.request.contextPath}/resources/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/easypiechart-data.js"></script>
	
	 <script src="${pageContext.request.contextPath}/resources/assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/custom-scripts.js"></script>
    
    
     <script type="text/javascript">
      $(document).ready(function() {
	      inicializarVariables();
	   	  cargarComponentes();
     });
     
     var tblProductos  = null;
     var btnAgregar  = null;
     var txtArticulo  = null;
     var txtPrecio  = null;
     var txtCantidad  = null;
     var btnFinalizar = null;
     var txtNombreCliente= null;
     var txtNumDocumento=null;
     var txtDireccion=null;
     
     function inicializarVariables(){
    	 tblProductos  = $('#tblProductos');
    	 btnAgregar  = $('#btnAgregar');
    	 txtArticulo  = $('#txtArticulo');
    	 txtPrecio  = $('#txtPrecio');
    	 txtCantidad  = $('#txtCantidad');
    	 btnFinalizar  = $('#btnFinalizar');
    	 txtNombreCliente = $('#cliente'); 
    	 txtNumDocumento = $('#documento');
    	 txtDireccion =  $('#direccion');
     }
     
     function cargarComponentes(){
    	 
         txtNumDocumento.on('keyup', function (e) {
     	    if (e.keyCode == 13) {
       			$.ajax({
      				type: "post",
      				url: "./accionObtenerClienteXDni",
      				cache: false,				
      				data:
      				{
      					numDocumento: txtNumDocumento.val()
      	              },
      	            dataType: "json",
      				success: function(response){
      					//console.log("cliente"+ response.nombre);
      					txtNombreCliente.val(response.nombre);
      					txtNombreCliente.focus();
      					txtDireccion.val(response.direccion);
      					txtDireccion.focus();
      				},
      				error: function(){						
      					console.log("error");
      				}
      			});
     	    }
     	});
    	 
    	 
    	 btnAgregar.click(function(event){
        	 var row = $("<tr><td>"+txtArticulo.val()+ "</td><td>" + txtCantidad.val() +"</td><td>"+ txtPrecio.val()   + "</td></tr>");
             $("#tblProductos > tbody").append(row);
             limpiar();
 		});
         
    	 
    	 btnFinalizar.click(function(event){
    		 var prodElegidos='';
    		 var i=0;
    		 //Inicio - Recorrer grilla
    		    $("#tblProductos tbody tr").each(function (index) {
    		    	i++;
    		                var campo1, campo2, campo3;
    		                $(this).children("td").each(function (index2) 
    		                {
    		                    switch (index2) 
    		                    {
    		                        case 0: campo1 = $(this).text();
    		                                break;
    		                        case 1: campo2 = $(this).text();
    		                                break;
    		                        case 2: campo3 = $(this).text();
    		                                break;
    		                    }
    		                //    $(this).css("background-color", "#ECF8E0");
    		                
    		                })
    		                prodElegidos+=(campo1 + '-' + campo2 + '-' + campo3+'/');
    		            })
    		            //alert(prodElegidos);
    		 //Fin - Recorrer grilla
    		 
  			$.ajax({
 				type: "post",
 				url: "./finalizarVenta",
 				cache: false,				
 				data:
 				{
 					productos : prodElegidos,
 					idCliente: txtNombreCliente.val()
 	              },
 				success: function(response){
 					console.log("success");
 					   if(response==1){
                            alert("Se Registro Correctamente!");
                       }else{
                     	  alert("Error al Registrar!");
                       }
 				},
 				error: function(){						
 					console.log("error");
 				}
 			});
 		});
    	 
     function limpiar(){
    	 txtArticulo.val('');
    	 txtPrecio.val('');
    	 txtCantidad.val('');
     }
     
     

     
     //$('#tblProductos tr').length;
       

     } 
     </script>
</body>
</html>
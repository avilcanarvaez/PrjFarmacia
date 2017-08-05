<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Usuario</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

        <jsp:include page="navbar.jsp">
            <jsp:param name="opcion" value="crear" />
        </jsp:include>

        <form action="crearUsuario" method="post">
            <input type="hidden" name="operacion" value="crear">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese Nombre">
            </div>
            <div class="form-group">
                <label for="apePaterno">Apellido Paterno</label>
                <input type="text" class="form-control" id="apePaterno" name="apePaterno" placeholder="Ingrese Apellido Paterno">
            </div>
            <div class="form-group">
                <label for="apeMaterno">Apellido Materno</label>
                <input type="text" class="form-control" id="apeMaterno" name="apeMaterno" placeholder="Ingrese Apellido Materno">
            </div>
            <div class="form-group">
                <label for="clave">Clave</label>
                <input type="password" class="form-control" id="clave" name="clave" placeholder="Ingrese Clave">
            </div>
            <div class="form-group">
                <label for="nacimiento">Fec.Nac. (dd-mm-aaaa)</label>
                <input type="text" class="form-control" id="nacimiento" name="nacimiento" placeholder="Ingrese Fec.Nacimiento">
            </div>
            <br />
            <button type="submit" class="btn btn-primary">Grabar</button>
        </form>
    </div>
</body>
</html>
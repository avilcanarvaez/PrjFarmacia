<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sistema de Farmacia</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
        <jsp:include page="navbar.jsp" >
            <jsp:param name="opcion" value="inicio" />
        </jsp:include>
        <div class="jumbotron" style="text-align:center; background-color:#f8f8f8; border-color:#e7e7e7; ">
            <h1>Sistema de Farmacia</h1>
        </div>
    </div>

</body>
</html>

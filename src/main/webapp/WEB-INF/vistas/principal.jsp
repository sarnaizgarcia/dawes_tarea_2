<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarea 2 - DAWES</title>
</head>
<body>
	<p><img alt="logo" src="main/resources/static/logo.png"></p>
	${eventos }
	
	<div>Eventos</div>
	
	<div class="menu-item">
		<div class="sub-item">Destacados</div>
		<div class="sub-item">Activos</div>
	</div>
	<div class="menu-item">Tipo de evento</div>
	<div class="menu-item">Mis reservas</div>
	<div class="menu-item">Login</div>
	<div class="menu-item">Registro</div>
	<div class="menu-item">Salir</div>	
</body>
</html>
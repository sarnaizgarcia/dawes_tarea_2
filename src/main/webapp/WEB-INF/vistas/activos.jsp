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
	
	<div>Eventos Activos</div>
	
	<div class="menu-item">
		<div class="sub-item"><a href="destacados">Destacados</a></div>
		<div class="sub-item">Activos</div>
	</div>
	<div class="menu-item">Tipo de evento</div>
	<div class="menu-item">Mis reservas</div>
	<div class="menu-item">Login</div>
	<div class="menu-item">Registro</div>
	<div class="menu-item"><a href="cerrarSesion">Salir</a></div>
	
	<p>Bienvenido ${usuario.getNombreUsuario() }</p>
	
	<h3>Listado de eventos activos</h3>
	
	<table border="2">
		<tr>
			<th>Nombre</th>
			<th>Aforo</th>
			<th>Fecha incio</th>
			<th>Opciones</th>
		</tr>
		<c:forEach var="ele" items="${eventos }">
			<c:if test="${ele.getEstadoEvento().equals('Activo') }">
				<tr>
					<td>${ele.nombreEvento}</td>
					<td>${ele.aforoMaximo}</td>
					<td>${ele.fechaEvento}</td>
					<td><a href="detalle/${ele.getIdEvento() }">Detalle</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>
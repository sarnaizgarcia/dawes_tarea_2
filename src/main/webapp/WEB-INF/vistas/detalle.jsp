<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarea 2 - DAWES</title>
</head>
<body>
	<div>
		<img alt="logo" src="main/resources/static/logo.png">
	</div>
	
	<p>Bienvenido ${usuario.getNombreUsuario() }</p>
	
	<h3>Detalle del Evento Seleccionado</h3>
	
	<table>
		<tr>
			<td>Nombre</td>
			<th>${evento.getNombreEvento() }</th>
		</tr>
		<tr>
			<td>Descripción</td>
			<th>${evento.getDescripcionEvento() }</th>
		</tr>
		<tr>
			<td>Dirección</td>
			<th>${evento.getDireccionEvento() }</th>
		</tr>
		<tr>
			<td>Fecha inicio</td>
			<th><fmt:formatDate pattern="dd-MM-yyyy" value="${evento.getFechaEvento()}" /></th>
		</tr>
		<tr>
			<td>Duración</td>
			<th>${evento.getDuracionEvento() }</th>
		</tr>
		<tr>
			<td>Aforo máximo</td>
			<th>${evento.getAforoMaximo() }</th>
		</tr>
		<tr>
			<td>Asistencia mínima</td>
			<th>${evento.getMinimoAsistencia() }</th>
		</tr>
		<tr>
			<td>Precio unitario</td>
			<th><fmt:formatNumber type="number" maxFractionDigits="2" value="${evento.getPrecio() }" /></th>
		</tr>
	</table>
	
	<div>Quedan ${evento.getPlazasDisponibles() } entradas</div>
	
	<div>
		<img alt="${evento.getNombreEvento() }" src="main/resources/static/logo.png">
	</div>
	
	<form action="reserva" method="post">
		<p>Cantidad<input type="number" max="10" min="1" name="emailUsuario" ></p>
		<p><input type="submit" value="Reservar"></p>
	</form>		
	
	
	
</body>
</html>
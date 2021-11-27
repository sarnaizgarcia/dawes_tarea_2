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
	<p><img alt="logo" src="main/resources/static/logo.png"></p>
	
	<p>Bienvenido ${usuario.getNombreUsuario() }</p>
	
	<h3>Detalle del Evento Seleccionado</h3>
	
	<table>
		<tr>
			<td>Nombre</td>
			<th>${evento.getNombreEvento() }</th>
		</tr>
		<tr>
			<td>Descripci�n</td>
			<th>${evento.getDescripcionEvento() }</th>
		</tr>
		<tr>
			<td>Direcci�n</td>
			<th>${evento.getDireccionEvento() }</th>
		</tr>
		<tr>
			<td>Fecha inicio</td>
			<th><fmt:formatDate pattern="dd-MM-yyyy" value="${evento.getFechaEvento()}" /></th>
		</tr>
		<tr>
			<td>Duraci�n</td>
			<th>${evento.getDuracionEvento() }</th>
		</tr>
		<tr>
			<td>Aforo m�ximo</td>
			<th>${evento.getAforoMaximo() }</th>
		</tr>
		<tr>
			<td>M�nima asistencia</td>
			<th>${evento.getMinimoAsistencia() }</th>
		</tr>
	</table>
	
	<div>Quedan ${evento.getPlazasDisponibles() }</div>
	
	<form action="reserva" method="post">
		<p>Cantidad<input type="number" max="10" min="1" name="emailUsuario" ></p>
		<p><input type="submit" value="Reservar"></p>
	</form>		
	
	
	
</body>
</html>
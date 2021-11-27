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
	
	<p>Gracias por tu reserva, ${usuario.getNombreUsuario() }.</p>
	
	<p>Los datos son los siguientes:</p>
	
		<table>
		<tr>
			<td>Nombre del evento</td>
			<th>${evento.getNombreEvento() }</th>
		</tr>
		<tr>
			<td>Precio total de la reserva</td>
			<th>${reserva.getPrecioReserva() }</th>
		</tr>
		<tr>
			<td>Cantidad de entradas</td>
			<th>${reserva.getCantidad() }</th>
		</tr>
		<tr>
			<td>Fecha inicio</td>
			<th><fmt:formatDate pattern="dd-MM-yyyy" value="${evento.getFechaEvento()}" /></th>
		</tr>
	</table>
	
	<p>Por favor, vuelve a acceder al listado de eventos activos <a href="/clientes/activos">aquí.</a></p>
			
</body>
</html>